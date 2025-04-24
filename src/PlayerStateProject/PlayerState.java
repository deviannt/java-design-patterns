package PlayerStateProject;

public interface PlayerState {
    void handleAction(Player player);
    String getStateName();
}