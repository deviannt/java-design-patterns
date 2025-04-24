package PlayerStateProject;

public class IdleState implements PlayerState {
    @Override
    public void handleAction(Player player) {
        System.out.println("Игрок стоит на месте. Переход в режим 'Walking'.");
        player.setState(new WalkingState());
    }

    @Override
    public String getStateName() {
        return "Idle";
    }
}