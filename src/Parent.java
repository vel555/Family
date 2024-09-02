import java.util.List;

public class Parent {
    String name;
    List<Child> children;

    Parent(String name, List<Child> children) {
        this.name = name;
        this.children = children;
    }
}