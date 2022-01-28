package camarillo.CarRentalSystem.Repository;

import camarillo.CarRentalSystem.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("SELECT r FROM Reservation r WHERE r.carId = :carId")
    Optional<Reservation> findReservationByCar(@Param("carId") long carId);

}
