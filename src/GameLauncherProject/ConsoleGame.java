package GameLauncherProject;

public class ConsoleGame extends GameLauncher {

    @Override
    public void setupControls() {
        System.out.println("Настройка управления: геймпад");
    }

    @Override
    public void launchEngine() {
        System.out.println("Запуск игрового движка для консоли");
    }

    @Override
    public void runPerformanceTest() {
        int fps = 60;
        int resolution = 1080;
        System.out.println("Тест консоли:");
        System.out.println("Индекс качества: " + (fps * resolution));
    }
}
