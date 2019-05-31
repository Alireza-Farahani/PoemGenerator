package poem.generator.data;
/**
 * @author Elyas-Dolatabadi
 * 
 */
public class Word {

	private String meter;
	private String title;

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
