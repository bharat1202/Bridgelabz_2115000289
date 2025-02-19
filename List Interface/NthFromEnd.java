import java.util.*;

public class NthFromEnd {
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        int slowIndex = 0, fastIndex = 0;
        while (fastIndex < n) {
            fastIndex++;
        }
        while (fastIndex < list.size()) {
            slowIndex++;
            fastIndex++;
        }
        return list.get(slowIndex);
    }

    public static void main(String[] args) {
        LinkedList<String> strLinkedList = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println(findNthFromEnd(strLinkedList, 2));
    }
}
