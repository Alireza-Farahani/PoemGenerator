package poem.generator.data;

import java.util.ArrayList;
import java.util.List;

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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.words.size(); i++) {
            sb.append(this.words.get(i).getText());
            if (i != this.words.size() - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public void addWordToBeginning(Word word) {
        words.add(0, word);
    }
}
