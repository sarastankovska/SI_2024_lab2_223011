import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    private List<Item> items(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }
 @Test
    void EveryBranch() {
  RuntimeException exc;
       exc = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 1));
        assertTrue(exc.getMessage().contains("allItems e null"));
        assertTrue(SILab2.checkCart(new ArrayList<Item>(), 0));
        assertFalse(SILab2.checkCart(new ArrayList<Item>(), -1));
        exc = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items(new Item("", null, 100, 0.1f)), 100));
        assertTrue(exc.getMessage().contains("Nema barkod"));
        assertFalse(SILab2.checkCart(items(new Item("", "012345", 350, 0.1f)), 100));
        exc = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items(new Item("Item1", "12345a", 100, 0.1f)), 100));
        assertTrue(exc.getMessage().contains("Netocen barkod"));
        assertFalse(SILab2.checkCart(items(new Item("Item1", "12345", 100, -1))
    }
    @Test
    void MultipleCondition(){
        assertFalse(SILab2.checkCart(items(new Item("", "123", 350, 0.2f)),2));
        assertFalse(SILab2.checkCart(items(new Item("", "123", 350, 0)),2));
        assertTrue(SILab2.checkCart(items(new Item("", "012", 350, 0.2f)),300));
        assertFalse(SILab2.checkCart(items(new Item("", "012", 100, 0.2f)),2));
    }

}
