package poem.generator.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elyas-Dolatabadi
 */
public class Distich {

    private final List<Word> words;

    public Distich() {
        this.words = new ArrayList<>();
    }

    public String getTitle() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.words.size(); i++) {
            sb.append(this.words.get(i).getTitle());
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
