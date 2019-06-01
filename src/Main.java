import poem.generator.data.Hemistich;
import poem.generator.data.Poet;

import java.util.ArrayList;

/**
 * @author Elyas-Dolatabadi
 */
public class Main {

    public static void main(String[] args) {
        Poet myPoet = new Poet();
        myPoet.parseInput("./in/poem1.txt");
        ArrayList<Hemistich> hemistichList = myPoet.generateHemistiches();
        myPoet.printFirstInformation();
        myPoet.printDistichList(hemistichList);
    }
}
