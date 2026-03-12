package ba.smoki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> filterCars(String brand, Integer startYear, Integer endYear, String fuelType) {
        if (brand == null && startYear == null && endYear == null && fuelType == null) {
            return carRepository.findAll();
        }

        List<Car> cars = carRepository.findAll();
        if (brand != null && !brand.isEmpty()) {
            cars = cars.stream()
                    .filter(c -> c.getBrand().equalsIgnoreCase(brand))
                    .toList();
        }

        if (startYear != null && endYear != null) {
            cars = cars.stream()
                    .filter(c -> c.getYear() >= startYear && c.getYear() <= endYear)
                    .toList();
        }

        if (fuelType != null && !fuelType.isEmpty()) {
            cars = cars.stream()
                    .filter(c -> c.getFuelType().equalsIgnoreCase(fuelType))
                    .toList();
        }
        return cars;
    }


}
