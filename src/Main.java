import poem.generator.data.Hemistich;
import poem.generator.data.InputParser;
import poem.generator.data.Poet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Elyas-Dolatabadi
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("./in/poem1.txt"), StandardCharsets.UTF_8);
        InputParser parser = new InputParser(lines);
        Poet myPoet = new Poet(
                parser.extractHemistichMeter(),
                parser.extractWordsTextAndHemistich());
        myPoet.printFirstInformation();

        List<Hemistich> hemistichList = myPoet.generateHemistiches();
        myPoet.printDistichList(hemistichList);
    }
}
