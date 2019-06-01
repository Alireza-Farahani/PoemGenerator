package poem.generator.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Elyas-Dolatabadi
 */
public class Poet {

    private String hemistichMeter;
    private List<Word> words;

    public Poet() {
        this.words = new ArrayList<>();
    }

    public void parseInput(String fileName) {
        FileReader reader = new FileReader();

        List<String> lines = reader.readLines(fileName);
        this.hemistichMeter = lines.get(0); //itr.next();

        words = lines.stream()
                .skip(1)
                .filter(wordTextAndWordMeter -> wordTextAndWordMeter != null && !wordTextAndWordMeter.isEmpty())
                .map(this::extractWord)
                .collect(Collectors.toList());
    }

    public void printFirstInformation() {
        System.out.println("Main Meter:");
        System.out.println("(" + this.hemistichMeter + ")");
        System.out.println("Words:");
        words.forEach(word ->
                System.out.println("(" + word.getText() + ")-(" + word.getMeter() + ")"));
    }

    public List<Hemistich> generateHemistiches() {
        return generateHemistiches(hemistichMeter).collect(Collectors.toList());
    }

    private Stream<Hemistich> generateHemistiches(String meter) {

        if (meter.isEmpty()) {
            return Stream.of(new Hemistich());
        }

        return words.stream()
                .filter(word -> meter.startsWith(word.getMeter()))
                .flatMap(word ->
                        generateHemistiches(meter.replaceFirst(word.getMeter(), "").trim())
                                .peek(tempHemistich -> tempHemistich.addWordToBeginning(word)));
    }

    public void printDistichList(List<Hemistich> hemistiches) {
        System.out.println("Generated Poet:");
        hemistiches.forEach(hemistich -> System.out.println(hemistich.toString()));
    }

    private Word extractWord(String hemistich) {
        String title = hemistich.substring(0, hemistich.indexOf(" "));
        String meter = hemistich.substring(hemistich.indexOf(" ") + 1);
        return new Word(title, meter);
    }
}
