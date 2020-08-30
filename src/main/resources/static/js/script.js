jsonToTable()
// getCustomers()

function jsonToTable() {
    // first parse JSON data
    fetch('http://localhost:8080/customer')
        .then(res => res.json())
        .then(customer => {
            console.log(customer)
            var grabTable = document.getElementById('table');

            // loop through each entry from json array
            customer.forEach(function (object) {
                // prepare row element to later add content to
                var tr = document.createElement('tr');

                // assigning ID to local variable from json data
                var id = object.id

                // creating delete and update buttons with attached ID to local variables
                var editLink = `<button class='refresher' onclick='updateCustomer(${id})' >Edit</button>`
                var deleteLink = `<button class='refresher' onclick='deleteCustomer(${id})' >Delete</button>`

                // adding content to table row
                tr.innerHTML = '<td>' + object.customerName + '</td>' +
                    '<td>' + object.customerPhone + '</td>' +
                    '<td>' + object.customerAddress + '</td>' +
                    '<td>' + editLink + '</td>' +
                    '<td>' + deleteLink + '</td>'
                grabTable.appendChild(tr)
            });
        })
}


function addCustomer() { //post
    var name = document.getElementById('customerName').value //get value from an html element
    var address = document.getElementById('customerAddress').value
    var phone = document.getElementById('customerPhone').value

    if (name != '' && address != '' && phone != '') {
        fetch('http://localhost:8080/customer', {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({customerName: name, customerAddress: address, customerPhone: phone})

        }).then(res => {
            jsonToTable()
        })
        document.forms['myForm'].reset()
        console.log('Added')
    }
}




function deleteCustomer(id) {
    fetch('http://localhost:8080/customer/' + id, {
        method: 'DELETE'
    })
        .then(res => {
            jsonToTable()
        })
}

function updateCustomer(id) {
    var name = document.getElementById('customerName').value //get value from an html element
    var address = document.getElementById('customerAddress').value
    var phone = document.getElementById('customerPhone').value
    fetch('http://localhost:8080/customer/' + id, {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'PUT',
        body: JSON.stringify({customerName: name, customerAddress: address, customerPhone: phone})
    })
        .then(res => {
            jsonToTable()
        })
}
