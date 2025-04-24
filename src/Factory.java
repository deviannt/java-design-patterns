import java.util.Scanner;

// абстрактный класс оружия
abstract class Weapon {
    public abstract String getName();
    public abstract int getDamage();
    public abstract void attack();
}

// конкретные виды оружия
class Sword extends Weapon {
    public String getName() {
        return "Меч\uD83D\uDDE1";
    }

    public int getDamage() {
        return 50;
    }

    public void attack() {
        System.out.println("Вы размахиваете мечом и наносите " + getDamage() + " урона!");
    }
}

class Bow extends Weapon {
    public String getName() {
        return "Лук\uD83C\uDFF9";
    }

    public int getDamage() {
        return 35;
    }

    public void attack() {
        System.out.println("Вы выпускаете стрелу и наносите " + getDamage() + " урона!");
    }
}

// абстрактная фабрика оружия
abstract class WeaponFactory {
    public abstract Weapon createWeapon();
}

// фабрики оружия
class MeleeWeaponFactory extends WeaponFactory {
    public Weapon createWeapon() {
        return new Sword();
    }
}

class RangedWeaponFactory extends WeaponFactory {
    public Weapon createWeapon() {
        return new Bow();
    }
}

public class Factory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeaponFactory factory;

        while (true) {
            System.out.println("Выберите оружие:");
            System.out.println("1. Меч (Ближний бой)");
            System.out.println("2. Лук (Дальний бой)");
            System.out.println("3. Выход");
            int choice = scanner.nextInt();

            if (choice == 1) {
                factory = new MeleeWeaponFactory();
            } else if (choice == 2) {
                factory = new RangedWeaponFactory();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Некорректный ввод.");
                continue;
            }

            Weapon weapon = factory.createWeapon();
            System.out.println("Вы выбрали: " + weapon.getName() + " (Урон: " + weapon.getDamage() + ")");
            weapon.attack();
        }

        scanner.close();
        System.out.println("Выбор оружия завершен!");
    }
}