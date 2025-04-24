package GameLauncherProject;

public class PCGame extends GameLauncher {

    @Override
    public void setupControls() {
        System.out.println("Настройка управления: клавиатура и мышь");
    }

    @Override
    public void launchEngine() {
        System.out.println("Запуск игрового движка для ПК");
    }

    @Override
    public void runPerformanceTest() {
        int cpuSpeed = 3200; // MHz !!
        int threads = 8; // количество ядер в процессоре
        System.out.println("Тест производительности ПК:");
        System.out.println("Общая вычислительная мощность: " + (cpuSpeed * threads) + " MHz");
    }
}
