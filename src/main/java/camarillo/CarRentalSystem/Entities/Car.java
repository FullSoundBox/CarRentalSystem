package camarillo.CarRentalSystem.Entities;

import javax.persistence.*;

@Entity
@Table
public class Car {
    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )

    long carId;
    String color;
    String brand;
    String model;
    String carClass;
    String pricePerDay;
    boolean available;
    String imgURL;

    public Car(){}

    public Car(long carId, String color, String brand, String model, String carClass,
               String pricePerDay, boolean available, String imgURL) {
        this.carId = carId;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.carClass = carClass;
        this.pricePerDay = pricePerDay;
        this.available = available;
        this.imgURL = imgURL;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public String getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(String pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() { return available; }

    public String getImgURL() { return imgURL; }

    public void setImgURL(String imgURL) { this.imgURL = imgURL; }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", carClass='" + carClass + '\'' +
                ", pricePerDay='" + pricePerDay + '\'' +
                ", available=" + available +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }
}
