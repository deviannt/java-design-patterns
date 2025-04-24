package GameCommandProject;

public class MoveBackwardCommand implements Command {
    private GameCharacter character;

    public MoveBackwardCommand(GameCharacter character) {
        this.character = character;
    }

    public void execute() {
        character.moveBackward();
    }

    public void undo() {
        character.moveForward(); // отмена - шаг вперёд
    }
}

