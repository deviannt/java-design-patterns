package GameCommandProject;

public class MoveForwardCommand implements Command {
    private GameCharacter character;

    public MoveForwardCommand(GameCharacter character) {
        this.character = character;
    }

    public void execute() {
        character.moveForward();
    }

    public void undo() {
        character.moveBackward(); // отмена - шаг назад
    }
}
