package ba.smoki.rest.api;

import ba.smoki.Car;

public class CarDTO {
    private String brand;
    private String model;
    private int year;
    private int power;
    private double consumption;
    private String fuelType;
    private int price;

    public CarDTO() {}

    public CarDTO(Car car) {
       this.brand = car.getBrand();
       this.model = car.getModel();
       this.year = car.getYear();
       this.consumption = car.getConsumption();
       this.fuelType = car.getFuelType();
       this.power = car.getPower();
       this.price = car.getPrice();
   }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getConsumption() {
        return consumption;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getPrice() {
        return price;
    }

    public int getPower() {
        return power;
    }
}
