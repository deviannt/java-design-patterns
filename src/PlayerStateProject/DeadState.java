package PlayerStateProject;

public class DeadState implements PlayerState {
    @Override
    public void handleAction(Player player) {
        System.out.println("Игрок мертв. Game Over.");
        // Не меняем состояние, он остаётся мертвым
    }

    @Override
    public String getStateName() {
        return "Dead";
    }
}