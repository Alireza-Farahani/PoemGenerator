package poem.generator.data;

/**
 * @author Elyas-Dolatabadi
 */
public class Word {

    private final String meter;
    private final String title;

    public Word(String title, String meter) {
        this.title = title;
        this.meter = meter;
    }

    public String getMeter() {
        return meter;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + ": " + meter;
    }
}
