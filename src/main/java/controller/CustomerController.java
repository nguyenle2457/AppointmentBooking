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
@CrossOrigin
@RequestMapping(path = "/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("customer")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("customer")
    public void saveCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
    }

    @DeleteMapping("customer/{id}")
    public void saveCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
    }

    @PutMapping("customer/{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
    }

}
