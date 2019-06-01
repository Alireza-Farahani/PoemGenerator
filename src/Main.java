import poem.generator.data.Hemistich;
import poem.generator.data.Poet;

import java.io.IOException;
import java.util.List;

/**
 * @author Elyas-Dolatabadi
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Poet myPoet = new Poet();
        myPoet.parseInput("./in/poem1.txt");
        List<Hemistich> hemistichList = myPoet.generateHemistiches();
        myPoet.printFirstInformation();
        myPoet.printDistichList(hemistichList);
    }
}
