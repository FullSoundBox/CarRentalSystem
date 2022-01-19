package camarillo.CarRentalSystem.Services;

import camarillo.CarRentalSystem.Entities.Reservation;
import camarillo.CarRentalSystem.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
                reservationRepository.findReservationByCar(reservation.getCarID());

        if (reservationByCar.isPresent()) {
            throw new IllegalArgumentException("Car already in use");
        }
        reservationRepository.save(reservation);
    }

    public void deleteReservation(Long reservationID) {
        boolean exists = reservationRepository.existsById(reservationID);
        if (!exists)
            throw new IllegalStateException("Rservation with ID " + reservationID + " does not exists");
        else
            reservationRepository.deleteById(reservationID);
    }

    @Transactional
    public void updateReservation(Long reservationID, LocalDateTime pickupDate, LocalDateTime returnDate, Long carID) {
        Reservation reservation = reservationRepository
                .findById(reservationID).
                orElseThrow(() -> new IllegalStateException("Reservation with ID" + reservationID + " does not exists"));
        if (pickupDate.isBefore(returnDate)){
            reservation.setPickupDate(pickupDate);
            reservation.setReturnDate(returnDate);
        }
        reservation.setCarID(carID);
    }
}
