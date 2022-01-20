package camarillo.CarRentalSystem.Repository;

import camarillo.CarRentalSystem.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    @Query("SELECT c FROM Car c WHERE c.available = ?1")
    Optional<Car> getAvailableCars(int i);

}
