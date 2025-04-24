package UIComponentTree;

import java.util.Iterator;

public abstract class UIComponent implements Iterable<UIComponent> {
    protected String name;

    public UIComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void add(UIComponent component);
    public abstract Iterator<UIComponent> iterator();
}