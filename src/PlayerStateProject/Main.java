package PlayerStateProject;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        player.action(); // Idle -> Walking
        player.action(); // Walking -> Jumping
        player.action(); // Jumping -> Attacking
        player.action(); // Attacking -> Dead
        player.action(); // Dead -> stays Dead
    }
}