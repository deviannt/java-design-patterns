import java.util.*;

interface Observer {
    void update(String location, double magnitude);
}

//мониторинг землетрясений
class SeismicMonitor {
    private final List<City> cities = new ArrayList<>();

    public void addCity(City city) {
        cities.add(city);
    }

//рандомный город, с землетрясением
    public void detectEarthquake(double magnitude) {
        Random random = new Random();
        City affectedCity = cities.get(random.nextInt(cities.size()));

        System.out.println("🌍⚠️ ВНИМАНИЕ! Землетрясение в " + affectedCity.getName() + ", магнитуда: " + magnitude);
        affectedCity.notifyObservers(magnitude);
    }
}

//класс город с жителями
class City {
    private final String name;
    private final List<Observer> observers = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(double magnitude) {
        for (Observer observer : observers) {
            observer.update(name, magnitude);
        }
    }
}

//SMS оповещения, которые получают люди
class Citizen implements Observer {
    private final String name;

    public Citizen(String name) {
        this.name = name;
    }

    @Override
    public void update(String location, double magnitude) {
        System.out.println("📩 " + name + " из " + location + ": \uD83D\uDD34 ВАЖНОЕ ОПОВЕЩЕНИЕ: ЗЕМЛЕТРЯСЕНИЕ! \uD83D\uDD34" +
                "⚠ Действия при землетрясении:\n" +
                "➡ Если вы внутри здания – укройтесь под прочной мебелью, держитесь подальше от окон и тяжелых предметов.\n" +
                "➡ Если вы на улице – отойдите от зданий, деревьев и линий электропередач.\n" +
                "➡ Если вы в машине – остановитесь в безопасном месте, избегая мостов и туннелей.\n"
                + "\uD83D\uDCE2 Ожидаются возможные афтершоки. Будьте осторожны! Следите за официальными источниками информации.\n"
                + "\uD83D\uDEA8 Берегите себя и своих близких! \uD83D\uDEA8" +
                " Магнитуда: " + magnitude + "\n");
    }
}

//мсчники начинают свою работу
class KazakhstanEmergencyService implements Observer {
    

    @Override
    public void update(String location, double magnitude) {
        System.out.println("🚑 МЧС РК: Срочная эвакуация и помощь населению в " + location + "!");
    }
}

//акимат делают свою работу
// Акимат реагирует на землетрясения
class CityAkimat implements Observer {
    private final String city;
    private String status;

    public CityAkimat(String city) {
        this.city = city;
        this.status = "Все в порядке";
    }

    @Override
    public void update(String location, double magnitude) {
        if (location.equals(city)) {
            if (magnitude > 5.0) {
                status = "ЧС! Срочная эвакуация!";
            } else if (magnitude < 3.0) {
                status = "Все в порядке, угрозы нет.";
            } else {
                status = "Ожидаем афтершоки.";
            }

            System.out.println("🏛️ Акимат " + city + ": Проверяем инфраструктуру, мосты и здания.");
            System.out.println("📢 Статус города: " + status);
        }
    }

    public String getStatus() {
        return status;
    }
}



public class KazakhstanEarthquakeAlert {
    public static void main(String[] args) {
        SeismicMonitor monitor = new SeismicMonitor();

        City almaty = new City("Алматы");
        City shymkent = new City("Шымкент");
        City taraz = new City("Тараз");

        //города в мониторинге
        monitor.addCity(almaty);
        monitor.addCity(shymkent);
        monitor.addCity(taraz);

        //жители
        almaty.addObserver(new Citizen("Темирлан"));
        almaty.addObserver(new Citizen("Елжан"));
        almaty.addObserver(new Citizen("Арсен"));

        shymkent.addObserver(new Citizen("Нурай"));
        shymkent.addObserver(new Citizen("Жанат"));

        taraz.addObserver(new Citizen("Сания"));
        taraz.addObserver(new Citizen("Ербол"));

        //экстренные службы
        almaty.addObserver(new KazakhstanEmergencyService());
        shymkent.addObserver(new KazakhstanEmergencyService());
        taraz.addObserver(new KazakhstanEmergencyService());

        //акиматы
        almaty.addObserver(new CityAkimat("Алматы"));
        shymkent.addObserver(new CityAkimat("Шымкент"));
        taraz.addObserver(new CityAkimat("Тараз"));

        monitor.detectEarthquake(6);
    }
}
