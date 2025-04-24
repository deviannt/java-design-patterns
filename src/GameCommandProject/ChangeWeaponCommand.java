package GameCommandProject;

public class ChangeWeaponCommand implements Command {
    private Weapon weapon;

    public ChangeWeaponCommand(Weapon weapon) {
        this.weapon = weapon;
    }

    public void execute() {
        weapon.changeWeapon();
    }

    public void undo() {
        System.out.println("Оружие возвращено на прежнее место");
    }
}
