package GameCommandProject;

public class AttackCommand implements Command {
    private Weapon weapon;

    public AttackCommand(Weapon weapon) {
        this.weapon = weapon;
    }

    public void execute() {
        weapon.attack();
    }

    public void undo() {
        System.out.println("Отмена атаки: персонаж отступает");
    }
}

