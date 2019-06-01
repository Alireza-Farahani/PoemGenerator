package poem.generator.data;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public void parseInput(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

        hemistichMeter = lines.get(0);

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
                .flatMap(word -> {
                    final String partialMeter = meter.replaceFirst(word.getMeter(), "").trim();
                    return generateHemistiches(partialMeter)
                            .peek(partialHemistich -> partialHemistich.addWordToBeginning(word));
                });
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
