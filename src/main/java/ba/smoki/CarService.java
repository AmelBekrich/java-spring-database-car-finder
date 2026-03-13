package ba.smoki;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> showCarsBrand(String brand) {
        List<Car> cars = carRepository.findAll();
        if (brand == null || brand.isBlank()) {
            return cars;
        }
        return cars.stream()
                .filter(c -> c.getBrand().equalsIgnoreCase(brand))
                .toList();
    }

    public List<Car> showCarsYear(int startYear, int endYear) {
        return carRepository.findAll().stream()
                .filter(c -> c.getYear() >= startYear && c.getYear() <= endYear)
                .toList();
    }

    public List<Car> showCarsFuelType(String fuelType) {
        return carRepository.findAll().stream()
                .filter(c -> c.getFuelType().equalsIgnoreCase(fuelType))
                .toList();
    }

    // Adding cars into the database

    public void saveCar(Car car) {
        carRepository.save(car);
    }
}
