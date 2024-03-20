import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

public class CodeTest {
    private BinarySearchTree<Association> tree;

    @Before
    public void setUp() {
        tree = new BinarySearchTree<>();
    }

    /**
     * Prueba los métodos getter de la clase Association.
     * Verifica que los métodos getEnglishWord() y getSpanishTranslation() retornen los valores esperados.
     */
    @Test
    public void testGetters() {
        Association association = new Association("House", "Casa");

        assertEquals("House", association.getEnglishWord());
        assertEquals("Casa", association.getSpanishTranslation());
    }

    /**
     * Prueba el método toString de la clase Association.
     * Verifica que el método toString() retorne la representación adecuada de la asociación en forma de cadena.
     */
    @Test
    public void testToString() {
        Association association = new Association("Dog", "Perro");

        assertEquals("(Dog, Perro)", association.toString());
    }

    /**
     * Prueba la inserción y búsqueda de asociaciones en un árbol binario de búsqueda.
     * Inserta varias asociaciones en el árbol y luego busca estas asociaciones para verificar que se encuentren correctamente.
     */
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

        assertNull(notFound); // Cat should not be found
    }

    /**
     * Prueba la búsqueda en un árbol binario de búsqueda vacío.
     * Verifica que la búsqueda en un árbol vacío retorne null, ya que no debería encontrar ninguna asociación.
     */
    @Test
    public void testEmptyTree() {
        Association notFound = tree.search(new Association("House", ""));

        assertNull(notFound); // House should not be found in an empty tree
    }
}
