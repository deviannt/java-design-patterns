package PlayerStateProject;

public class AttackingState implements PlayerState {
    @Override
    public void handleAction(Player player) {
        System.out.println("Игрок атакует. Переход в режим 'Dead'.");
        player.setState(new DeadState());
    }

    @Override
    public String getStateName() {
        return "Attacking";
    }
}