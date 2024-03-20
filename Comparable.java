// Interfaz Comparable para definir el orden natural entre objetos de una clase
public interface Comparable<T> {
    /**
     * Método para comparar este objeto con otro objeto de la misma clase.
     * @param other 
     * @return 
     */
    int compareTo(T other);
}
