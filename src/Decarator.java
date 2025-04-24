import java.util.Scanner;

// Абстрактный класс персонажа
abstract class Hero {
    public abstract String getDescription();
    public abstract int getPower();
}

// персонажи

class Warrior extends Hero {
    public String getDescription() {
        return "Воин";
    }

    public int getPower() {
        return 100;
    }
}

class Mage extends Hero {
    public String getDescription() {
        return "Маг";
    }

    public int getPower() {
        return 80;
    }
}

// абстрактный декоратор
abstract class HeroDecorator extends Hero {
    protected Hero hero;

    public HeroDecorator(Hero hero) {
        this.hero = hero;
    }
}

// декораторы (артефакты)
class ShieldBoost extends HeroDecorator {
    public ShieldBoost(Hero hero) {
        super(hero);
    }

    public String getDescription() {
        return hero.getDescription() + " с усиленным щитом";
    }

    public int getPower() {
        return hero.getPower() + 20;
    }
}

class MagicRing extends HeroDecorator {
    public MagicRing(Hero hero) {
        super(hero);
    }

    public String getDescription() {
        return hero.getDescription() + " с магическим кольцом";
    }

    public int getPower() {
        return hero.getPower() + 30;
    }
}

class SpeedBoots extends HeroDecorator {
    public SpeedBoots(Hero hero) {
        super(hero);
    }

    public String getDescription() {
        return hero.getDescription() + " с быстрыми ботинками";
    }

    public int getPower() {
        return hero.getPower() + 15;
    }
}


public class Decarator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero hero;

        System.out.println("Выберите персонажа:");
        System.out.println("1. Воин (Сила: 100)");
        System.out.println("2. Маг (Сила: 80)");
        int choice = scanner.nextInt();

        if (choice == 1) {
            hero = new Warrior();
        } else if (choice == 2) {
            hero = new Mage();
        } else {
            System.out.println("Некорректный ввод.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.println("Текущий герой: " + hero.getDescription() + " | Сила: " + hero.getPower());
            System.out.println("Добавить артефакт?");
            System.out.println("1. Усиленный щит (+20 силы)");
            System.out.println("2. Магическое кольцо (+30 силы)");
            System.out.println("3. Быстрые ботинки (+15 силы)");
            System.out.println("4. Завершить прокачку");
            int addChoice = scanner.nextInt();

            if (addChoice == 1) {
                hero = new ShieldBoost(hero);
            } else if (addChoice == 2) {
                hero = new MagicRing(hero);
            } else if (addChoice == 3) {
                hero = new SpeedBoots(hero);
            } else if (addChoice == 4) {
                break;
            } else {
                System.out.println("Некорректный ввод.");
            }
        }

        System.out.println("Ваш герой: " + hero.getDescription() + " | Итоговая сила: " + hero.getPower());
        scanner.close();
    }
}
