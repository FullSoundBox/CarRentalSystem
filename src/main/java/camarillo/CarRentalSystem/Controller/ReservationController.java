package camarillo.CarRentalSystem.Controller;

import camarillo.CarRentalSystem.Entities.Reservation;
import camarillo.CarRentalSystem.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/reservation")
public class ReservationController {

    @Autowired
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(path = "/all")
    public List<Reservation> getReservations(){
        return reservationService.getReservations();
    }

    @PostMapping(path = "/add/{reservationID}")
    public void createNewReservation(@RequestBody Reservation reservation){
        reservationService.addNewReservation(reservation);
    }

    @DeleteMapping(path = "{reservationID}")
    public void deleteReservation(@PathVariable("reservationID") Long reservationID){
        reservationService.deleteReservation(reservationID);
    }

    @PutMapping(path = "{reservationID}")
    public void updateReservation(
            @PathVariable("reservationID") Long reservationID,
            @RequestParam(required = false) LocalDateTime pickupDate,
            @RequestParam(required = false) LocalDateTime returnDate,
            @RequestParam(required = false) Long carID)
    {
        reservationService.updateReservation(reservationID,pickupDate,returnDate,carID);
    }

}
