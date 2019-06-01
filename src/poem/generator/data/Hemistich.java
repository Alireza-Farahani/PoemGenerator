package poem.generator.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Elyas-Dolatabadi
 */
public class Hemistich {

    private final List<Word> words;

    public Hemistich() {
        this.words = new ArrayList<>();
    }

    @Override
    public String toString() {
        return words.stream().map(Word::getText).collect(Collectors.joining(" "));
    }

    public void addWordToBeginning(Word word) {
        words.add(0, word);
    }
}
