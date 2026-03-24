package ba.smoki.rest.api;


import ba.smoki.Car;
import ba.smoki.CarService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/cars")
public class CarControllerAPI {
    private final CarService carService;

    public CarControllerAPI(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public Page<CarDTO> getCarPage(@RequestParam(required = false) String brand,
                             @RequestParam(required = false) String modelSearch,
                             @RequestParam(required = false) Integer startingYear,
                             @RequestParam(required = false) Integer endingYear,
                             @RequestParam(required = false) String fuelType,
                             @RequestParam(required = false) Double lowestConsumption,
                             @RequestParam(required = false) Double highestConsumption,
                             @RequestParam(defaultValue = "0") int page,
                             @RequestParam(required = false) String sort) {
        Page<Car> carPage = carService.carsPagination(brand, modelSearch, startingYear,
                endingYear, fuelType, lowestConsumption,
                highestConsumption, page, sort);

        return carPage.map(CarDTO::new);
    }

    @PostMapping
    public void addCar(@RequestBody CarDTO carDTO) {
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getYear());
        car.setFuelType(carDTO.getFuelType());
        car.setConsumption(carDTO.getConsumption());
        car.setPower(carDTO.getPower());
        car.setPrice(carDTO.getPrice());
        carService.saveCar(car);
    }
}
