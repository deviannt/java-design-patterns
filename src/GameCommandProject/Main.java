package GameCommandProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameCharacter character = new GameCharacter();
        Weapon weapon = new Weapon();
        GameInvoker invoker = new GameInvoker();

        // Настройка команд
        invoker.setCommand(0, new MoveForwardCommand(character));
        invoker.setCommand(1, new MoveBackwardCommand(character));
        invoker.setCommand(2, new JumpCommand(character));
        invoker.setCommand(3, new AttackCommand(weapon));
        invoker.setCommand(4, new ChangeWeaponCommand(weapon));
        invoker.setCommand(5, new UseSkillCommand(character));

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 9) {
            System.out.println("\nМеню:");
            System.out.println("0 - Идти вперёд");
            System.out.println("1 - Назад");
            System.out.println("2 - Прыжок");
            System.out.println("3 - Атака");
            System.out.println("4 - См  енить оружие");
            System.out.println("5 - Использовать навык");
            System.out.println("6 - Отменить");
            System.out.println("9 - Выход");

            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();

            if (choice >= 0 && choice <= 5) {
                invoker.pressButton(choice);
            } else if (choice == 6) {
                invoker.pressUndo();
            } else if (choice != 9) {
                System.out.println("Неверный выбор");
            }
        }

        scanner.close();
        invoker.shutdown();
        System.out.println("Игра завершена.");
    }
}
