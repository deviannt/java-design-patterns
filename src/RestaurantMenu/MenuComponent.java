package RestaurantMenu;

import java.util.Iterator;

public abstract class MenuComponent {
    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public Iterator<MenuComponent> iterator() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}