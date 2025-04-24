package RestaurantMenu;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MenuComponent breakfastMenu = new Menu("Завтрак", "Утренние блюда");
        MenuComponent lunchMenu = new Menu("Обед", "Основные блюда");
        MenuComponent drinksMenu = new Menu("Напитки", "Горячие и холодные напитки");

        breakfastMenu.add(new MenuItem("Каша", "Овсяная с фруктами", 950.0));
        breakfastMenu.add(new MenuItem("Блины", "С медом и сметаной", 1100.0));

        lunchMenu.add(new MenuItem("Борщ", "Сметана и чесночные гренки", 1350.0));
        lunchMenu.add(new MenuItem("Котлета с пюре", "Домашняя котлета и картофельное пюре", 1600.0));

        drinksMenu.add(new MenuItem("Чай", "Черный чай", 400.0));
        drinksMenu.add(new MenuItem("Кофе", "Эспрессо", 500.0));

        MenuComponent mainMenu = new Menu("Главное меню", "Все доступные блюда");
        mainMenu.add(breakfastMenu);
        mainMenu.add(lunchMenu);
        mainMenu.add(drinksMenu);

        System.out.println("=== ПОЛНОЕ МЕНЮ ===");
        mainMenu.print();

        System.out.println("\n=== БЛЮДА ДО 1000 ₸ ===");
        Iterator<MenuComponent> iterator = mainMenu.iterator();
        while (iterator.hasNext()) {
            MenuComponent item = iterator.next();
            try {
                if (item.getPrice() < 1000) {
                    item.print();
                }
            } catch (UnsupportedOperationException e) {
                // пропустить категории меню
            }
        }
    }
}