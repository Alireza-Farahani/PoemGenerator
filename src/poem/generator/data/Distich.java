package poem.generator.data;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Elyas-Dolatabadi
 * 
 */
public class Distich {

	private String mainMeter;
	private List<Word> words;

	public Distich(String mainMeter) {
		this.mainMeter = mainMeter;
		this.words = new ArrayList<Word>();
	}

	public boolean isMatchWithMainMeter() {
		return this.mainMeter.startsWith(this.getMeter());
	}

	public String getMeter() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.words.size(); i++) {
			sb.append(this.words.get(i).getMeter());
			if (i != this.words.size() - 1) {
				sb.append(" ");
			}
		}
		return sb.toString();
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

	public void addWord(Word word) {
		this.words.add(word);
	}

	public void clearLastItem() {
		this.words.remove(this.words.size() - 1);
	}
}
