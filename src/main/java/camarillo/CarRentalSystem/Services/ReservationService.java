package camarillo.CarRentalSystem.Services;

import camarillo.CarRentalSystem.Entities.Reservation;
import camarillo.CarRentalSystem.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    public final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservations(){
        return reservationRepository.findAll();

//        List<Reservation> reservationList = new ArrayList<>();
//        reservationList.add(
//        return reservationList;
    }

    public void addNewReservation(Reservation reservation) {
        Optional<Reservation> reservationByCar =
                reservationRepository.findReservationByCar(reservation.getCarId());

        if (reservationByCar.isPresent()) {
            throw new IllegalArgumentException("Car already in use");
        }
        reservationRepository.save(reservation);
    }

    public void deleteReservation(Long reservationId) {
        boolean exists = reservationRepository.existsById(reservationId);
        if (!exists)
            throw new IllegalStateException("Reservation with Id " + reservationId + " does not exists");
        else
            reservationRepository.deleteById(reservationId);
    }

    @Transactional
    public void updateReservation(Long reservationId, LocalDateTime pickupDate, LocalDateTime returnDate, Long carId) {
        Reservation reservation = reservationRepository
                .findById(reservationId).
                orElseThrow(() -> new IllegalStateException("Reservation with ID" + reservationId + " does not exists"));
        if (pickupDate.isBefore(returnDate)){
            reservation.setPickupDate(pickupDate);
            reservation.setReturnDate(returnDate);
        }
        reservation.setCarId(carId);
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.getById(id);
    }
}
