package RestaurantMenu;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class MenuIterator implements Iterator<MenuComponent> {
    private Stack<Iterator<MenuComponent>> stack = new Stack<>();

    public MenuIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) return false;

        Iterator<MenuComponent> iterator = stack.peek();
        if (!iterator.hasNext()) {
            stack.pop();
            return hasNext();
        }
        return true;
    }

    @Override
    public MenuComponent next() {
        if (!hasNext()) throw new NoSuchElementException();

        Iterator<MenuComponent> iterator = stack.peek();
        MenuComponent component = iterator.next();

        if (component instanceof Menu) {
            stack.push(component.iterator());
        }

        return component;
    }
}