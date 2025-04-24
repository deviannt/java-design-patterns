package PlayerStateProject;

public class JumpingState implements PlayerState {
    @Override
    public void handleAction(Player player) {
        System.out.println("Игрок прыгает. Переход в режим 'Attacking'.");
        player.setState(new AttackingState());
    }

    @Override
    public String getStateName() {
        return "Jumping";
    }
}