import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class CodeTest {
        private BinarySearchTree<Association> tree;

    @Test
    public void testGetters() {
        Association Association = new Association("House", "Casa");

        assertEquals("House", Association.getEnglishWord());
        assertEquals("Casa", Association.getSpanishTranslation());
    }

    @Test
    public void testToString() {
        Association Association = new Association("Dog", "Perro");

        assertEquals("(Dog, Perro)", Association.toString());
    }

    @Before
    public void setUp() {
        tree = new BinarySearchTree<>();
    }

    @Test
    public void testInsertAndSearch() {
        Association association1 = new Association("House", "Casa");
        Association association2 = new Association("Car", "Coche");
        Association association3 = new Association("Dog", "Perro");

        tree.insert(association1);
        tree.insert(association2);
        tree.insert(association3);

        Association found1 = tree.search(new Association("House", ""));
        Association found2 = tree.search(new Association("Car", ""));
        Association notFound = tree.search(new Association("Cat", ""));

        if (found1 != null) {
            assertEquals("Casa", found1.getSpanishTranslation());
        } else {
            assertNull("Association 'House' not found in the tree.", found1);
        }

        if (found2 != null) {
            assertEquals("Coche", found2.getSpanishTranslation());
        } else {
            assertNull("Association 'Car' not found in the tree.", found2);
        }

        assertNull(notFound); 
    }


    @Test
    public void testEmptyTree() {
        Association notFound = tree.search(new Association("House", ""));

        assertNull(notFound); 
    }


}
