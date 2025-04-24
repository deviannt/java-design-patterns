abstract class BaseVehicle {
    String brand;
    int speed;

    BaseVehicle(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    abstract void start();
    abstract void stop();

    void Information() {
        System.out.println("Brand: " + brand + ", Speed: " + speed + " km/h");
    }
}

class FastCar extends BaseVehicle {
    FastCar(String brand, int speed) {
        super(brand, speed);
    }

    @Override
    void start() {
        System.out.println("The car " + brand + " is starting...");
    }

    @Override
    void stop() {
        System.out.println("The car " + brand + " is stopping.");
    }
}

class SpeedBike extends BaseVehicle {
    SpeedBike(String brand, int speed) {
        super(brand, speed);
    }

    @Override
    void start() {
        System.out.println("The bike " + brand + " is starting to move.");
    }

    @Override
    void stop() {
        System.out.println("The bike " + brand + " is stopping.");
    }
}

public class AbstractExample {
    public static void main(String[] args) {
        BaseVehicle car = new FastCar("Audi", 300);
        BaseVehicle bike = new SpeedBike("Cervélo", 30);

        car.Information();
        car.start();
        car.stop();

        System.out.println();

        bike.Information();
        bike.start();
        bike.stop();
    }
}
