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

    private long reservationID;
    private float amount;
    private LocalDateTime pickupDate;
    private LocalDateTime returnDate;
    private long carID;
    private long customerID;
    @Transient
    private float totalAmount;

    public Reservation() {
    }

    public Reservation(long reservationID, float amount, LocalDateTime pickupDate, LocalDateTime returnDate, long carID, long customerID) {
        this.reservationID = reservationID;
        this.amount = amount;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.carID = carID;
        this.customerID = customerID;
    }

    public Reservation(float amount, LocalDateTime pickupDate, LocalDateTime returnDate, long carID, long customerID) {
        this.amount = amount;
        this.pickupDate = pickupDate;
        this.returnDate = returnDate;
        this.carID = carID;
        this.customerID = customerID;
    }

    public long getReservationID() {
        return reservationID;
    }

    public void setReservationID(long reservationID) {
        this.reservationID = reservationID;
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

    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
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
                "reservationID=" + reservationID +
                ", amount=" + amount +
                ", pickupDate=" + pickupDate +
                ", returnDate=" + returnDate +
                ", carID=" + carID +
                ", customerID=" + customerID +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
