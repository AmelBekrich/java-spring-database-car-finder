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
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String displayCars(@RequestParam(required = false) String brand,
                              @RequestParam(required = false) Integer startYear,
                              @RequestParam(required = false) Integer endYear,
                              @RequestParam(required = false) String fuelType,
                              Model model) {
        List<Car> cars = carService.filterCars(brand, startYear, endYear, fuelType);
        model.addAttribute("cars", cars);
        return "car-list";
    }
}
