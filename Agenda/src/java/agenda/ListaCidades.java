package agenda;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaCidades {

    private static final List<String> cidades = new ArrayList<String>();
    static {
        ClassLoader loader = ListaCidades.class.getClassLoader();
            InputStream in = loader.getResourceAsStream("cidades.txt");
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                cidades.add(scanner.next());
            }
    }
}