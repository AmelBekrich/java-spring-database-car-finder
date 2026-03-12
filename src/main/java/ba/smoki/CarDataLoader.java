package ba.smoki;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarDataLoader implements CommandLineRunner {
    @Autowired
    private CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {
//        Car car = new Car();
//        car.setBrand("Peugeot");
//        car.setModel("208");
//        car.setYear(2022);
//        car.setFuelType("Gas");
//        car.setPower(55);
//        car.setConsumption(6.5);
//        car.setPrice(11800);
//
//        carRepository.save(car);

    }
}
