package ba.smoki;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Page<Car> carsPagination(String brand, Integer startingYear, Integer endingYear, String fuelType, Double lowestConsumption, Double highestConsumption, int page) {
        List<Car> cars = carRepository.findAll();
        if (brand != null && !brand.isEmpty()) {
            cars = cars.stream()
                    .filter(c -> c.getBrand().equalsIgnoreCase(brand))
                    .toList();
        }
        if (startingYear != null && endingYear != null) {
            cars = cars.stream()
                    .filter(c -> c.getYear() >= startingYear && c.getYear() <= endingYear)
                    .toList();
        }
        if (fuelType != null && !fuelType.equalsIgnoreCase("All")) {
            cars = cars.stream()
                    .filter(c -> c.getFuelType().equalsIgnoreCase(fuelType))
                    .toList();
        }
        if (lowestConsumption != null && highestConsumption != null) {
            cars = cars.stream()
                    .filter(c -> c.getConsumption() >= lowestConsumption && c.getConsumption() <= highestConsumption)
                    .toList();
        }

        int pageSize = 10;
        int start = page * pageSize;
        int end = Math.min(start + pageSize, cars.size());

        List<Car> pageContent = cars.subList(start, end);
        return new org.springframework.data.domain.PageImpl<>(pageContent, PageRequest.of(page, pageSize), cars.size());
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

    public List<Car> getCarsByFuelType(String fuelType, Double lowestConsumption, Double highestConsumption) {
        List<Car> cars = carRepository.findAll();
        if (fuelType != null && !fuelType.equalsIgnoreCase("All")) {
            cars = cars.stream()
                    .filter(c -> c.getFuelType().equalsIgnoreCase(fuelType))
                    .toList();
        }

        if (lowestConsumption != null && highestConsumption != null) {
            cars = cars.stream()
                    .filter(c -> c.getConsumption() >= lowestConsumption && c.getConsumption() <= highestConsumption)
                    .toList();
        }
        return cars;
    }

    // Adding cars to the database

    public void saveCar(Car car) {
        carRepository.save(car);
    }
}
