import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FamilyExample {
    public static void main(String[] args) {
        Parent parent1;
        parent1 = new Parent("алиса" , Arrays.asList(
                new Child("аня","девочка"),
                new Child("лёша","мальчик")
        ));
        Parent parent2 = new Parent("борис",Arrays.asList(
                new Child("оля","девочка"),
                new Child("ваня","мальчик"),
                new Child("катя","девочка")
        ));
        Parent parent3 = new Parent("вика",Arrays.asList(
                new Child("света","девочка"),
                new Child("игорь","мальчик"),
                new Child("таня","девочка"),
                new Child("максим","мальчик")
        ));
        List<Parent> parents = Arrays.asList(parent1,parent2, parent3);

        System.out.println("родители с более чем 3 детьми: ");
        parents.stream()
                .filter(parent -> parent.children.size() >3)
                .forEach(parent -> System.out.println(parent.name));

        System.out.println("мальчики:");
        parents.stream()
                .flatMap(parent -> parent.children.stream())
                .filter(child -> child.gender.equals("мальчик"))
                .forEach(child -> System.out.println(child.name));

        System.out.println("имена детей большими буквами:");
        parents.stream()
                .flatMap(parent -> parent.children.stream())
                .map(child -> child.name.toUpperCase())
                .forEach(System.out::println);

        int totalChildren = parents.stream()
                .mapToInt(parent-> parent.children.size())
                .sum();
        System.out.println("общее количество детей: " + totalChildren);

        Map<String, Integer> parentChildCountMar = parents.stream()
                .collect(Collectors.toMap(
                   parent -> parent.name,
                   parent -> parent.children.size()
                ));
        System.out.println("количество детей у родителей: " + parentChildCountMar);
    }
}


