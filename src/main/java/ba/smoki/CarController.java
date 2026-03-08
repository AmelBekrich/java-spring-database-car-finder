package ba.smoki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String displayCars() {
        return "cars";
    }

    @GetMapping("/brand")
    public String showCarsByBrand(@RequestParam String brand, Model model) {
        List<Car> carList = carService.showCarsByBrand(brand);
        model.addAttribute("cars", carList);
        return  "car-list";
    }

    @GetMapping("/year")
    public String showCarsByYear(@RequestParam int startingYear,@RequestParam int endingYear, Model model) {
        List<Car> carList = carService.showCarsByYear(startingYear, endingYear);
        model.addAttribute("cars", carList);
        return "car-list";
    }

    @GetMapping("/consumption")
    public String showCarsByFuel(@RequestParam(required = false) Double lowestConsumption,@RequestParam(required = false)
            Double highestConsumption,@RequestParam(required = false)
            String fuelType, Model model) {
        List<Car> carList = carService.showCarsByFuel(lowestConsumption, highestConsumption, fuelType);
        model.addAttribute("cars", carList);
        return "car-list";
    }
}
