package UIComponentTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Container extends UIComponent {
    private List<UIComponent> children = new ArrayList<>();

    public Container(String name) {
        super(name);
    }

    @Override
    public void add(UIComponent component) {
        children.add(component);
    }

    @Override
    public Iterator<UIComponent> iterator() {
        return new UIIterator(this);
    }

    public List<UIComponent> getChildren() {
        return children;
    }
}