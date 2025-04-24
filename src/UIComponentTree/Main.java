package UIComponentTree;

public class    Main {
    public static void main(String[] args) {
        Container form = new Container("Main Form");

        Label titleLabel = new Label("Title Label");
        form.add(titleLabel);

        Container panel = new Container("Main Panel");
        panel.add(new Label("Username Label"));
        panel.add(new Label("Password Label"));

        Container subPanel = new Container("Sub Panel");
        subPanel.add(new Label("Submit Label"));
        panel.add(subPanel);

        form.add(panel);

        System.out.println("Recursive label traversal:");
        for (UIComponent component : form) {
            if (component instanceof Label) {
                System.out.println("Found label: " + component.getName());
            }
        }
    }
}