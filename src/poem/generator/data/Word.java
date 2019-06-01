package poem.generator.data;

/**
 * @author Elyas-Dolatabadi
 */
public class Word {

    private final String meter;
    private final String text;

    public Word(String text, String meter) {
        this.text = text;
        this.meter = meter;
    }

    public String getMeter() {
        return meter;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text + ": " + meter;
    }
}
