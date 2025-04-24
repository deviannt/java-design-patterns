package GameLauncherProject;

public class CloudGame extends GameLauncher {

    @Override
    public void setupControls() {
        System.out.println("Настройка ввода через потоковую передачу");
    }

    @Override
    public void launchEngine() {
        System.out.println("Запуск игрового движка с потоковой передачей из облака");
    }

    @Override
    public void runPerformanceTest() {
        double latency = 20.5; // миллисекунд
        double bandwidth = 150; //мегабит в секунду
        System.out.println("Тест облачной производительности:");
        System.out.println("Пропускная способность x надёжность: " + (bandwidth / latency));
    }
}
