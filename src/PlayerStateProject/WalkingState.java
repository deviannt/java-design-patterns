package PlayerStateProject;

public class WalkingState implements PlayerState {
    @Override
    public void handleAction(Player player) {
        System.out.println("Игрок идет. Переход в режим 'Jumping'.");
        player.setState(new JumpingState());
    }

    @Override
    public String getStateName() {
        return "Walking";
    }
}