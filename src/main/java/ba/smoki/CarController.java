package ba.smoki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/cars/brand/results")
    public String getCarsByBrand(@RequestParam(required = false) String brand,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(required = false) String sort,
                                 Model model) {
        Page<Car> carPage = carService.carsPagination(brand, null, null, null, null, null,  page, sort);
        model.addAttribute("cars", carPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", carPage.getTotalPages());
        model.addAttribute("brand", brand);
        model.addAttribute("searchType", "cars/brand");
        model.addAttribute("sort", sort);
        return "car-list";
    }

    @GetMapping("/cars/year/results")
    public String getCarsByYear(@RequestParam int startingYear, @RequestParam int endingYear,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(required = false) String sort,
                                Model model) {
        Page<Car> carPage = carService.carsPagination(null, startingYear, endingYear, null, null, null, page, sort);
        model.addAttribute("cars", carPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", carPage.getTotalPages());
        model.addAttribute("startingYear", startingYear);
        model.addAttribute("endingYear", endingYear);
        model.addAttribute("searchType", "cars/year");
        model.addAttribute("sort", sort);
        return "car-list";
    }

    @GetMapping("/cars/consumption/results")
    public String getCarsByConsumption(@RequestParam String fuelType,
                                       @RequestParam(required = false) Double lowestConsumption,
                                       @RequestParam(required = false) Double highestConsumption,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(required = false) String sort,
                                       Model model) {
        Page<Car> carPage = carService.carsPagination(null, null, null, fuelType, lowestConsumption, highestConsumption, page, sort);
        model.addAttribute("cars", carPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", carPage.getTotalPages());
        model.addAttribute("fuelType", fuelType);
        model.addAttribute("lowestConsumption", lowestConsumption);
        model.addAttribute("highestConsumption", highestConsumption);
        model.addAttribute("searchType", "cars/consumption");
        model.addAttribute("sort", sort);
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
