package poem.generator.data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Elyas-Dolatabadi
 */
public class Poet {

    private final String hemistichMeter;
    private List<Word> words;

    public Poet(String hemistichMeter, List<Word> words) {
        this.hemistichMeter = hemistichMeter;
        this.words = words;
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

    public void printFirstInformation() {
        System.out.println("Main Meter:");
        System.out.println("(" + this.hemistichMeter + ")");
        System.out.println("Words:");
        words.forEach(word ->
                System.out.println("(" + word.getText() + ")-(" + word.getMeter() + ")"));
    }

    public void printDistichList(List<Hemistich> hemistiches) {
        System.out.println("Generated Poet:");
        hemistiches.forEach(hemistich -> System.out.println(hemistich.toString()));
    }
}
