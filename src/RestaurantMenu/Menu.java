package RestaurantMenu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {
    private String name;
    private String description;
    private List<MenuComponent> components = new ArrayList<>();

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        components.add(menuComponent);
    }

    @Override
    public Iterator<MenuComponent> iterator() {
        return new MenuIterator(components.iterator());
    }

    @Override
    public void print() {
        System.out.println("\n" + name.toUpperCase() + " — " + description);
        System.out.println("----------------------------");
        for (MenuComponent component : components) {
            component.print();
        }
    }
}