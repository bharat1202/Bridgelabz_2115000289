
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {
    ListManager listManager = new ListManager();

   
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 5);
        assertTrue(list.contains(5));
    }

  
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        listManager.removeElement(list, 5);
        assertFalse(list.contains(5));
    }

 
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, listManager.getSize(list));
        listManager.addElement(list, 5);
        assertEquals(1, listManager.getSize(list));
    }
}
