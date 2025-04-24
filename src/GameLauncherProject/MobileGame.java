package GameLauncherProject;

public class MobileGame extends GameLauncher {

    @Override
    public void setupControls() {
        System.out.println("Настройка управления: сенсорный экран");
    }

    @Override
    public void launchEngine() {
        System.out.println("Запуск игрового движка для мобильной игры");
    }

    @Override
    public void runPerformanceTest() {
        double battery = 0.85;
        int load = 20;         // это нагрузка процессора
        System.out.println("Тест производительности мобильного устройства:");
        System.out.println("Оставшийся ресурс = " + (battery * 100 - load) + "%");
    }
}
