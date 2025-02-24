import java.util.ArrayList;

public class SuppressWarningExample {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList rawList = new ArrayList(); // Raw usage without generics
        rawList.add("Java");
        rawList.add(100); // No type safety, but warning is suppressed

        System.out.println(rawList);
    }
}
