package ba.smoki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Controller responsible for handling web requests.
 * Provides endpooint for filtering cars and adding new cars
 */

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String mainPage() {
        return "car-filters";
    }

    @GetMapping("/cars/brand")
    public String getCarsByBrand(@RequestParam String brand, Model model) {
        List<Car> cars = carService.getCarsByBrand(brand);
        model.addAttribute("cars", cars);
        return "car-list";
    }

    @GetMapping("/cars/year")
    public String getCarsByYear(@RequestParam int startingYear, @RequestParam int endingYear, Model model) {
        List<Car> cars = carService.getCarsByYear(startingYear, endingYear);
        model.addAttribute("cars", cars);
        return "car-list";
    }

    @GetMapping("/cars/consumption")
    public String getCarsByConsumption(@RequestParam String fuelType, Model model) {
        List<Car> cars;
        if (fuelType.equalsIgnoreCase("All")) {
            cars = carService.getAllCars();
        } else cars = carService.getCarsByFuelType(fuelType);
        model.addAttribute("cars", cars);
        return "car-list";
    }

    // Adding cars into the database

    @GetMapping("/cars/add")
    public String addCarsPage() {
        return "add-cars";
    }

    @PostMapping("cars/add")
    public String addCar(Car car) {
        carService.saveCar(car);
        return "redirect:/cars";
    }
}
