package GameLauncherProject;

public class Main {
    public static void main(String[] args) {
        GameLauncher pc = new PCGame();
        GameLauncher console = new ConsoleGame();
        GameLauncher mobile = new MobileGame();
        GameLauncher cloud = new CloudGame();

        System.out.println("=== PC Game ===");
        pc.startGame();

        System.out.println("\n=== Console Game ===");
        console.startGame();

        System.out.println("\n=== Mobile Game ===");
        mobile.startGame();

        System.out.println("\n=== Cloud Game ===");
        cloud.startGame();
    }
}
