package camarillo.CarRentalSystem.Repository;

import camarillo.CarRentalSystem.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

//    @Query("SELECT c Customer c WHERE c.getName = ?name")
    @Query
    public Optional<Customer> getCustomerByName(String name);
}
