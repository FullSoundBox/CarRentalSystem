package camarillo.CarRentalSystem.Entities;

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
    private LocalDateTime pickupDate;
    private LocalDateTime returnDate;
    private String reservationStatus;
    private long carId;
    private long customerId;
    @Transient
    private float totalAmount;

    public Reservation(){
    }

    public Reservation(long reservationId, float amount, LocalDateTime pickupDate, LocalDateTime returnDate, long carId, long customerId, String reservationStatus, float totalAmount) {
        this.reservationId = reservationId;
        this.amount = amount;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.carId = carId;
        this.customerId = customerId;
        this.reservationStatus = reservationStatus;
        this.totalAmount = totalAmount;
    }

    //    public Reservation(float amount, LocalDateTime pickupDate, LocalDateTime returnDate, long carId, long customerId) {
//        this.amount = amount;
//        this.pickupDate = pickupDate;
//        this.returnDate = returnDate;
//        this.carId = carId;
//        this.customerId = customerId;
//    }

    public long getReservationID() {
        return reservationId;
    }

    public void setReservationID(long reservationId) {
        this.reservationId = reservationId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDateTime getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDateTime pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
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

    public float getTotalAmount(){
        //Use this to calculate the total
        LocalDateTime tempDateTime = LocalDateTime.from(this.pickupDate);
        long days = tempDateTime.until(this.returnDate, ChronoUnit.DAYS);
        return days*this.amount;
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
                ", totalAmount=" + totalAmount +
                '}';
    }
}
