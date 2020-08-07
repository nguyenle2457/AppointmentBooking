getStudents()


function addStudent() { //post

    var name = document.getElementById('student').value //get value from an html element

    fetch('http://localhost:8080/students', {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({studentName: name})

    }).then(res => getStudents())


    console.log('Added')
}

function getStudents() {

    var studentList = document.getElementById('studentList')

    studentList.innerHTML = ''

    fetch('http://localhost:8080/students')
        .then(res => res.json())
        .then(json => {

            for (i = 0; i < json.length; i++) {

                var id = json[i].id

                var deleteLink = `<button onclick='deleteStudent(${id})'>Delete</button>`

                studentList.innerHTML += '<div>' + json[i].studentName + deleteLink + '</div>'

            }

        })

}


function deleteStudent(id) {
    fetch('http://localhost:8080/students/' + id, {
        method: 'delete'
    })
        .then(res => getStudents())
}

getCustomers()

function addCustomer() { //post
    var name = document.getElementById('customerName').value //get value from an html element
    var address = document.getElementById('customerAddress').value
    var phone = document.getElementById('customerPhone').value

    if (name != '' && address != '' && phone != '') {
        fetch('http://localhost:8080/customers', {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({customerName: name, customerAddress: address, customerPhone: phone})

        }).then(res => getCustomers())


        console.log('Added')
    }
}

function getCustomers() {

    var customerList = document.getElementById('customerList')

    customerList.innerHTML = ''

    fetch('http://localhost:8080/customers')
        .then(res => res.json())
        .then(json => {

            for (i = 0; i < json.length; i++) {

                var id = json[i].id

                var deleteLink = `<button onclick='deleteCustomer(${id})'>Delete</button>`

                customerList.innerHTML += '<div>' + json[i].customerName + ' ' + json[i].customerAddress + ' ' + json[i].customerPhone + deleteLink + '</div>'

            }

        })

}


function deleteCustomer(id) {
    fetch('http://localhost:8080/customers/' + id, {
        method: 'delete'
    })
        .then(res => getCustomers())
}
