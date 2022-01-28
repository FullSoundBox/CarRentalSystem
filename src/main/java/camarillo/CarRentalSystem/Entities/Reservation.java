package camarillo.CarRentalSystem.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Entity
@Table
public class Reservation {
    @Id
    @SequenceGenerator(
            name = "reservation_sequence",
            sequenceName = "reservation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_sequence"
    )

    private long reservationId;
    private float amount;
//    private LocalDateTime pickupDate;
//    private LocalDateTime returnDate;
    private String pickupDate;
    private String returnDate;
    private String reservationStatus;
    private long carId;
    private long customerId;

    public Reservation(){
    }

    public Reservation(long reservationId, float amount, String pickupDate, String returnDate, String reservationStatus, long carId, long customerId) {
        this.reservationId = reservationId;
        this.amount = amount;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.reservationStatus = reservationStatus;
        this.carId = carId;
        this.customerId = customerId;
    }

    //    public Reservation(float amount, LocalDateTime pickupDate, LocalDateTime returnDate, long carId, long customerId) {
//        this.amount = amount;
//        this.pickupDate = pickupDate;
//        this.returnDate = returnDate;
//        this.carId = carId;
//        this.customerId = customerId;
//    }
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID=" + reservationId +
                ", amount=" + amount +
                ", pickupDate=" + pickupDate +
                ", returnDate=" + returnDate +
                ", carID=" + carId +
                ", customerID=" + customerId +
                '}';
    }
}
