package camarillo.CarRentalSystem.Services;

import camarillo.CarRentalSystem.Entities.Car;
import camarillo.CarRentalSystem.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarService {
    public final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public List<Car> getEconomy(boolean order, boolean sortClass) {
        if (sortClass){
            return carRepository.filterByPriceAndClass(
                    Sort.by(Sort.Direction.ASC, "pricePerDay"), "carClass");
        }
        if(order){
            return carRepository.sortByPrice(
                    Sort.by(Sort.Direction.ASC, "pricePerDay"));
        }
        else {
            return carRepository.sortByPrice(
                    Sort.by(Sort.Direction.DESC, "pricePerDay"));
        }
    }

//    public List<Car> getAllAvailableCars(){
//        return carRepository.getAllAvailableCars("2000-01-01");}

    public List<Car> getAllAvailableCars(String pickupDate, String returnDate, String carClass){
//        System.out.println(pickupDate);
//        System.out.println(returnDate);
//        System.out.println(carClass);
        if (carClass==null)
            return carRepository.getAllAvailableCars(pickupDate);
        return carRepository.getAvailableCars(pickupDate,carClass);}

    public List<Car> getAllAvailableCarsByPrice(String pickupDate, String returnDate, String carClass){
//        System.out.println(pickupDate);
//        System.out.println(returnDate);
//        System.out.println(carClass);

        return carRepository.getAvailableCarsByPrice(pickupDate,carClass);}

    public void addNewCar(Car car){
        boolean exists = carRepository.existsById(car.getCarId());
        if (exists)
            throw new IllegalStateException("Car with Id " + car.getCarId() + " already exists");
        else
            carRepository.save(car);
    }

    public void deleteCar(Long carId){
        boolean exists = carRepository.existsById(carId);
        if (!exists)
            throw new IllegalStateException("Car with Id " + carId + " does not exists");
        else
            carRepository.deleteById(carId);
    }

    @Transactional
    public void updateCar(String color, String brand, String model, String carClass, String pricePerDay,Long carId) {
        Car car = carRepository.
                findById(carId).
                orElseThrow(() -> new IllegalStateException("Reservation with ID" + carId + " does not exists"));
        car.setColor(color);
        car.setBrand(brand);
        car.setModel(model);
        car.setCarClass(carClass);
        car.setPricePerDay(pricePerDay);
    }
}
