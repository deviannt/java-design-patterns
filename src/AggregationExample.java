interface Engine {
    void start();
    void stop();
}

class PetrolEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Petrol Engine is starting...");
    }
    @Override
    public void stop() {
        System.out.println("Petrol Engine is stoping.");
    }
}

class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric Engine is starting...");
    }
    @Override
    public void stop() {
        System.out.println("Electric Engine is stoping.");
    }
}

class VehicleCar {
    private Engine engine;

    public VehicleCar(Engine engine) {
        this.engine = engine;
    }

    public void startCar() {
        engine.start();
        System.out.println("Vehicle is running..");
    }

    public void stopCar() {
        engine.stop();
        System.out.println("Vehicle is stalls..");
    }
}

// Главный класс
public class AggregationExample {
    public static void main(String[] args) {
        Engine petrolEngine = new PetrolEngine();
        VehicleCar petrolCar = new VehicleCar(petrolEngine);
        petrolCar.startCar();

        System.out.println();

        Engine electricEngine = new ElectricEngine();
        VehicleCar electricCar = new VehicleCar(electricEngine);
        electricCar.startCar();
        System.out.println();
        electricCar.stopCar();
    }
}
