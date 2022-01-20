package camarillo.CarRentalSystem.Controller;

import camarillo.CarRentalSystem.Entities.Car;
import camarillo.CarRentalSystem.Services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() { return carService.getAllCars(); }

    @PostMapping
    public void addNewCar(@RequestBody Car car){
        carService.addNewCar(car);
    }

    @DeleteMapping(path = "{carId}")
    public void deleteCarById(@PathVariable("carId") Long carId){
        carService.deleteCar(carId);
    }

    @PutMapping(path = "{carId}")
    public void updateCar(@PathVariable("carId")Long carId,
                          @RequestParam(required = false) String color,
                          @RequestParam(required = false) String brand,
                          @RequestParam(required = false) String model,
                          @RequestParam(required = false) String carClass,
                          @RequestParam(required = false) String pricePerDay){
        carService.updateCar(color,brand,model,carClass,pricePerDay,carId);
    }
}
