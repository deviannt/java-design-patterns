import java.util.Scanner;

interface MoveStrategy {
    void move();
}

class RunStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Робот бежит!");
    }
}

class WalkStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Робот идет.");
    }
}

class DanceStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Робот танцует!");
    }
}

class CrawlStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Робот ползет");
    }
}
class JumpStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("Робот прыгает");
    }
}

class Robot {
    private MoveStrategy moveStrategy;

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        moveStrategy.move();
    }
}

public class StrategyPattern {
    public static void main(String[] args) {

        Robot robot = new Robot();
        Scanner scan = new Scanner(System.in);

        while    (true) {
            System.out.println();
            System.out.println("Выберите стратегию передвижения:");
            System.out.println("1. Бег");
            System.out.println("2. Ходьба");
            System.out.println("3. Ползание");
            System.out.println("4. Танцевать");
            System.out.println("5. Прыгать");
            System.out.println("6. Выход");

            int pick = scan.nextInt();
            scan.nextLine();

            if (pick == 6) {
                System.out.println("Выход из программы...");
                break;
            }

            switch (pick) {
                case 1:
                    robot.setMoveStrategy(new RunStrategy());
                    break;
                case 2:
                    robot.setMoveStrategy(new WalkStrategy());
                    break;
                case 3:
                    robot.setMoveStrategy(new CrawlStrategy());
                    break;
                case 4:
                    robot.setMoveStrategy(new DanceStrategy());
                    break;
                case 5:
                    robot.setMoveStrategy(new JumpStrategy());
                    break;
                default:
                    System.out.println("Ты не правильно выбрал, попробуй еще раз.");
                    continue;
            }
            robot.move();
        }


    }
}
