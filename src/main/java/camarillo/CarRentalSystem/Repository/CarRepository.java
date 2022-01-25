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

    @Query(value = "select distinct * from car having (not exists (select * from reservation as r having r.car_id=car.car_id and ((r.reservation_status='Active' and (r.pickup_date<=:pickupDate and r.return_date>=:pickupDate)) or r.reservation_status='Missing')))", nativeQuery = true)
    List<Car> getAllAvailableCars(@Param("pickupDate") String pickupDate);

    @Query(value = "select distinct * from car having (not exists (select * from reservation as r having r.car_id=car.car_id and ((r.reservation_status='Active' and (r.pickup_date<=:pickupDate and r.return_date>=:pickupDate)) or r.reservation_status='Missing'))) and car.car_class=:carClass", nativeQuery = true)
    List<Car> getAvailableCars(@Param("pickupDate") String pickupDate,
                               @Param("carClass") String carClass);

    @Query(value = "select distinct * from car having (not exists (select * from reservation as r having r.car_id=car.car_id and ((r.reservation_status='Active' and (r.pickup_date<=:pickupDate and r.return_date>=:pickupDate)) or r.reservation_status='Missing'))) and car.car_class=:carClass order by car.price_per_day", nativeQuery = true)
    List<Car> getAvailableCarsByPrice(@Param("pickupDate") String pickupDate,
                               @Param("carClass") String carClass);

}
