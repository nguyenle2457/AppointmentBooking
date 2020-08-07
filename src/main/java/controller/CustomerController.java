package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CustomerService;

import java.util.List;

/**
 * Created by CoT on 7/29/18.
 */
@RestController
@RequestMapping(path = "/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(path = "customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping(path = "customers", method = RequestMethod.POST)
    public void saveTeacher(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }

    @RequestMapping(path = "customers/{id}", method = RequestMethod.DELETE)
    public void saveTeacher(@PathVariable int id){
        customerService.deleteCustomer(id);
    }
}
