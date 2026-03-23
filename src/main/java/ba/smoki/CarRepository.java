package ba.smoki;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByBrandIgnoreCase(String brand);
    List<Car> findByYearBetween(int startYear, int endYear);
    List<Car> findByFuelTypeIgnoreCase(String fuelType);
    List<Car> findByModelIgnoreCase(String modelSearch);
}
