package PlayerStateProject;

public class Player {
    private PlayerState state;

    public Player() {
        this.state = new IdleState();
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void action() {
        System.out.println("Текущее состояние: " + state.getStateName());
        state.handleAction(this);
    }
}