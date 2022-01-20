package camarillo.CarRentalSystem.Services;

import camarillo.CarRentalSystem.Entities.Customer;
import camarillo.CarRentalSystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class CustomerService {
    public final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping
    public void addNewCustomer(Customer customer){
        boolean exists = customerRepository.existsById(customer.getCustomerId());
        if (exists)
            throw new IllegalStateException("Customer already exists");
        else
            customerRepository.save(customer);
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(Long customerId){
        boolean exists = customerRepository.existsById(customerId);
        if (!exists)
            throw new IllegalStateException("Customer doesn't exists");
        else
            customerRepository.deleteById(customerId);
    }

    @PutMapping(path = "{customerId}")
    public void updateCustomer(Long customerId, String name, String mobile, String email){
        Customer customer = customerRepository
                .findById(customerId)
                .orElseThrow(() -> new IllegalStateException("Customer doesn't exist"));

        customer.setName(name);
        customer.setMobile(mobile);
        customer.setEmail(email);
    }
}
