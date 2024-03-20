import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree<Association> dictionaryTree = Dictionary("diccionario.txt");

        System.out.println("¡Bienvenido al Diccionario!");
        System.out.println("1. Traducir texto");
        System.out.println("2. Mostrar diccionario ordenado");
        System.out.println("3. Salir");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("\nIngrese el nombre del archivo de texto:");
                scanner.nextLine(); 
                String textFile = scanner.nextLine();
                Traductor(dictionaryTree, textFile);
                break;
            case 2:
                System.out.println("\nDiccionario ordenado:");
                dictionaryTree.inorderTraversal();
                break;
            case 3:
                System.out.println("Gracias por usar el programa");
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                break;
        }

        scanner.close();
    }

    private static BinarySearchTree<Association> Dictionary(String filename) {
        BinarySearchTree<Association> dictionaryTree = new BinarySearchTree<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                String englishWord = parts[0].trim();
                String spanishWord = parts[1].trim();

                Association pair = new Association(englishWord, spanishWord);
                dictionaryTree.insert(pair);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + filename);
            e.printStackTrace();
        }

        return dictionaryTree;
    }

    private static void Traductor(BinarySearchTree<Association> dictionaryTree, String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                StringBuilder translatedLine = new StringBuilder();
                for (String word : words) {
                    String lowercaseWord = word.toLowerCase(Locale.ROOT);
                    Association searchPair = new Association(lowercaseWord, "");
                    Association translation = dictionaryTree.search(searchPair);
                    if (translation != null) {
                        translatedLine.append(translation.getSpanishTranslation()).append(" ");
                    } else {
                        translatedLine.append("*").append(word).append("* ");
                    }
                }
                System.out.println(translatedLine.toString().trim());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + filename);
            e.printStackTrace();
        }
    }
}
