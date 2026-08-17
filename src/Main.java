import java.util.*;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> original =
                new ArrayList<>(List.of("A", "B"));

        List<String> view =
                Collections.unmodifiableList(original);

        original.add("C");

        System.out.println(view);
        original.add("D");
        System.out.println(view);
        original.remove("D");
        System.out.println(view);
        System.out.println(original);

    }
}