package ba.smoki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String mainPage() {
        return "car-filters";
    }

    @GetMapping("/cars/brand")
    public String showCarsBrand(@RequestParam String brand, Model model) {
        List<Car> cars = carService.showCarsBrand(brand);
        model.addAttribute("cars", cars);
        return "car-list";
    }

    @GetMapping("/cars/year")
    public String showCarsYear(@RequestParam int startingYear, @RequestParam int endingYear, Model model) {
        List<Car> cars = carService.showCarsYear(startingYear, endingYear);
        model.addAttribute("cars", cars);
        return "car-list";
    }

    @GetMapping("/cars/consumption")
    public String showCarsConsumption(@RequestParam String fuelType, Model model) {
        List<Car> cars = carService.showCarsFuelType(fuelType);
        model.addAttribute("cars", cars);
        return "car-list";
    }

}
