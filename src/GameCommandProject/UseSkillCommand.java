package GameCommandProject;

public class UseSkillCommand implements Command {
    private GameCharacter character;

    public UseSkillCommand(GameCharacter character) {
        this.character = character;
    }

    public void execute() {
        character.useSkill();
    }

    public void undo() {
        System.out.println("Отмена навыка невозможна");
    }
}

