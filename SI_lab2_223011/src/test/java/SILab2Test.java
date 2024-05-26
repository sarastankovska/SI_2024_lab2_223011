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
        RuntimeException exception;
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 1));
        assertTrue(exception.getMessage().contains("allItems e null!"));
        assertTrue(SILab2.checkCart(new ArrayList<Item>(), 0));
        assertFalse(SILab2.checkCart(new ArrayList<Item>(), -1));
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items(new Item("", null, 20, 0.5f)), 1));
        assertTrue(exception.getMessage().contains("Nema barkod!"));
        assertFalse(SILab2.checkCart(items(new Item("", "02345", 500, 0.4f)), 2));
        exception = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items(new Item("Item1", "01234", 500, 0.2f)), 1));
        assertTrue(exception.getMessage().contains("Greska vo barkodot!"));
        assertFalse(SILab2.checkCart(items(new Item("Item1", "12345", 100, -1)), 100));
    }
    @Test
    void MultipleConditions(){
        assertFalse(SILab2.checkCart(items(new Item("","12345",250,15)),2));
        assertFalse(SILab2.checkCart(items(new Item("","12345",350,0)),2));
        assertFalse(SILab2.checkCart(items(new Item("","12345",400,15)),2));
        assertFalse(SILab2.checkCart(items(new Item("","012345",400,15)),2));
    }

}