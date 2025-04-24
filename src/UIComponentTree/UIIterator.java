package UIComponentTree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import java.util.Collections;


public class UIIterator implements Iterator<UIComponent> {
    private Stack<Iterator<UIComponent>> stack = new Stack<>();

    public UIIterator(UIComponent component) {
        if (component instanceof Container) {
            stack.push(((Container) component).getChildren().iterator());
        } else {
            stack.push(Collections.singleton(component).iterator());
        }
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<UIComponent> current = stack.peek();
            if (!current.hasNext()) {
                stack.pop();
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public UIComponent next() {
        if (!hasNext()) throw new NoSuchElementException();
        Iterator<UIComponent> current = stack.peek();
        UIComponent component = current.next();
        if (component instanceof Container) {
            stack.push(((Container) component).getChildren().iterator());
        }
        return component;
    }
}