class Document {
    void displayContent() {
        System.out.println("Printing Document Content...");
    }
}

class Printer {
    void print(Document doc) {
        doc.displayContent();
    }
}

// Main class to test dependency
public class Dependency {
    public static void main(String[] args) {
        Document doc = new Document();
        Printer printer = new Printer();
        printer.print(doc);
    }
}
