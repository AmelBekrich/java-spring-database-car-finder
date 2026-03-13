package ba.smoki;

import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service layer responsible for business logic.
 * Handles filtering operations and communication with the repository
 */

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Methods responsible for returning cars based on filters
     */

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> getCarsByBrand(String brand) {
        List<Car> cars = carRepository.findAll();
        if (brand == null || brand.isBlank()) {
            return cars;
        }
        return cars.stream()
                .filter(c -> c.getBrand().equalsIgnoreCase(brand))
                .toList();
    }

    public List<Car> getCarsByYear(int startYear, int endYear) {
        return carRepository.findAll().stream()
                .filter(c -> c.getYear() >= startYear && c.getYear() <= endYear)
                .toList();
    }

    public List<Car> getCarsByFuelType(String fuelType) {
        return carRepository.findAll().stream()
                .filter(c -> c.getFuelType().equalsIgnoreCase(fuelType))
                .toList();
    }

    // Adding cars to the database

    public void saveCar(Car car) {
        carRepository.save(car);
    }
}
