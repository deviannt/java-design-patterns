import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class Coffee {
    String description = "Unknown Coffee";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}

// виды кофе
class Espresso extends Coffee {
    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 900.0;
    }
}

class Latte extends Coffee {
    public Latte() {
        description = "Latte";
    }

    public double cost() {
        return 1100.0;
    }
}

// декоратор для добавок
abstract class CoffeeDecorator extends Coffee {
    public abstract String getDescription();
}

class MilkDecorator extends CoffeeDecorator {
    Coffee coffee;

    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + ", Milk";
    }

    public double cost() {
        return coffee.cost() + 200.0;
    }
}

class SugarDecorator extends CoffeeDecorator {
    Coffee coffee;

    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    public double cost() {
        return coffee.cost() + 100.0;
    }
}

// стратегия оплаты
interface PaymentStrategy {
    void pay(double amount);
}

class CardPayment implements PaymentStrategy {
    public void pay(double amount) {
        JOptionPane.showMessageDialog(null, "Оплачено " + amount + " ₸ картой.");
    }
}

class CashPayment implements PaymentStrategy {
    public void pay(double amount) {
        JOptionPane.showMessageDialog(null, "Оплачено " + amount + " ₸ наличными.");
    }
}

public class CoffeeShop {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Coffee Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400); // Увеличен размер окна

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        String[] coffeeTypes = {"Espresso", "Latte"};
        JComboBox<String> coffeeList = new JComboBox<>(coffeeTypes);
        panel.add(new JLabel("Выберите ваш кофе:"));
        panel.add(coffeeList);

        JCheckBox milkBox = new JCheckBox("Добавить молоко");
        JCheckBox sugarBox = new JCheckBox("Добавить сахар");
        panel.add(milkBox);
        panel.add(sugarBox);

        JButton orderButton = new JButton("Заказать");
        JLabel resultLabel = new JLabel("Ваш заказ: ");
        panel.add(orderButton);
        panel.add(resultLabel);

        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Coffee coffee;
                if (coffeeList.getSelectedItem().equals("Espresso")) {
                    coffee = new Espresso();
                } else {
                    coffee = new Latte();
                }

                if (milkBox.isSelected()) {
                    coffee = new MilkDecorator(coffee);
                }
                if (sugarBox.isSelected()) {
                    coffee = new SugarDecorator(coffee);
                }

                PaymentStrategy payment = new CardPayment(); // По умолчанию карта
                payment.pay(coffee.cost());

                resultLabel.setText("Ваш заказ: " + coffee.getDescription() + " - " + coffee.cost() + " ₸");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
