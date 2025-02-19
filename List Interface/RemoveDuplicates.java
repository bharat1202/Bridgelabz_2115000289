import java.util.*;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> uniqueList = new ArrayList<>();
        for (int num : list) {
            if (seen.add(num)) {
                uniqueList.add(num);
            }
        }
        return uniqueList;
    }

    public static void main(String[] args) {
        List<Integer> dupList = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println(removeDuplicates(dupList));
    }
}
