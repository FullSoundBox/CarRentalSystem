package camarillo.CarRentalSystem.Controller;

import camarillo.CarRentalSystem.Entities.Customer;
import camarillo.CarRentalSystem.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {
    public final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomer() {return customerService.getAllCustomers();}

    @PostMapping
    public void addNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId){
        customerService.deleteCustomer(customerId);
    }

    @PostMapping(path = "{customerId}")
    public void updateCustomer(@PathVariable("customerId")Long customerId,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String mobile,
                               @RequestParam(required = false) String email){
        customerService.updateCustomer(customerId,name,mobile,email);
    }

}
