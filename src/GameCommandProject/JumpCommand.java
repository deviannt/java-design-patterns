package GameCommandProject;

public class JumpCommand implements Command {
    private GameCharacter character;

    public JumpCommand(GameCharacter character) {
        this.character = character;
    }

    public void execute() {
        character.jump();
    }

    public void undo() {
        System.out.println("Невозможно отменить прыжок");
    }
}

