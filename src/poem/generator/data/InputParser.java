package poem.generator.data;

import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private final List<String> lines;

    public InputParser(List<String> lines) {
        this.lines = lines;
    }

    public String extractHemistichMeter() {
        return lines.get(0);
    }

    public List<Word> extractWordsTextAndHemistich() {
        return lines.stream()
                .skip(1)
                .filter(wordTextAndWordMeter -> wordTextAndWordMeter != null && !wordTextAndWordMeter.isEmpty())
                .map(this::extractWord)
                .collect(Collectors.toList());
    }

    private Word extractWord(String hemistich) {
        String title = hemistich.substring(0, hemistich.indexOf(" "));
        String meter = hemistich.substring(hemistich.indexOf(" ") + 1);
        return new Word(title, meter);
    }
}
