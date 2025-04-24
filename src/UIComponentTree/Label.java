package UIComponentTree;

import java.util.Collections;
import java.util.Iterator;

public class Label extends UIComponent {

    public Label(String name) {
        super(name);
    }

    @Override
    public void add(UIComponent component) {
        throw new UnsupportedOperationException("Label is a leaf node and can't contain children.");
    }

    @Override
    public Iterator<UIComponent> iterator() {
        return Collections.<UIComponent>singleton(this).iterator();
    }
}
