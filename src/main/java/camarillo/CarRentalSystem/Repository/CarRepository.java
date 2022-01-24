package camarillo.CarRentalSystem.Repository;

import camarillo.CarRentalSystem.Entities.Car;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {

    @Query("SELECT c FROM Car c WHERE c.available = ?1")
    Optional<Car> getAvailableCars(int i);

//    @Query(value = "SELECT * FROM Car HAVING car_class='Luxury' ORDER BY price_per_day ASC", nativeQuery = true)
    @Query(value = "SELECT c FROM Car c WHERE c.carClass='Luxury'")
    List<Car> sortByPrice(Sort sort);

//    @Query("SELECT c FROM Car c WHERE c.carClass = 'Luxury' ORDER BY :carClass")
    @Query("SELECT c FROM Car c ORDER BY :carClass")
    List<Car> filterByPriceAndClass(
            Sort sort,
            @Param("carClass") String carClass);

}
