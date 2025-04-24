package GameLauncherProject;

public abstract class GameLauncher {

    public final void startGame() {
        loadResources();
        setupControls();
        checkDevice();
        runPerformanceTest();
        launchEngine();
    }

    public void loadResources() {
        System.out.println("Загрузка игровых ресурсов");
    }

    public void checkDevice() {
        System.out.println("Проверка совместимости устройства");
    }

    public abstract void setupControls();
    public abstract void launchEngine();
    public abstract void runPerformanceTest();
}
