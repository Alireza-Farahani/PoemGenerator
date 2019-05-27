package poem.generator.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * @author Elyas-Dolatabadi
 * 
 */
public class Poem {

	private String mainMeter;
	private List<Word> words;

	public Poem() {
		this.words = new ArrayList<Word>();
	}

	public void init(String fileName) {
		ReadFileIntoList reader = new ReadFileIntoList();

		List<String> linesList = reader.ReadFile(fileName);
		Iterator<String> itr = linesList.iterator();
		String firstLine = itr.next();
		this.mainMeter = firstLine.substring(1, firstLine.length());

		while (itr.hasNext()) {
			String hemistich = itr.next();
			if (hemistich != null && !hemistich.isEmpty()) {
				Word word = wordDelimiter(hemistich);
				words.add(word);
			}
		}
	}

	public void printFirstInformation() {
		System.out.println("Main Meter:");
		System.out.println("("+this.mainMeter+")");
		System.out.println("Words:");
		
		for (int i = 0; i < words.size(); i++) {
			System.out.println("("+ words.get(i).getTitle() + ")-(" + words.get(i).getMeter()+ ")");
		}
	}

	public ArrayList<Distich> generateDistichList() {
		ArrayList<Distich> res = new ArrayList<Distich>();

		int numberOfMainMeterWords = this.mainMeter.split(" ").length;

		for (int i = 0; i < numberOfMainMeterWords; i++) {
			Distich distich = new Distich(this.mainMeter);
			for (int j = 0; j < numberOfMainMeterWords; j++) {
				for (Word word : this.words) {
					distich.addWord(word);
					if (distich.isMatchWithMainMeter()) {
						if ( distich.getMeter().length()== mainMeter.length()&& !listHasThisDistich(res, distich.getTitle())) {
							res.add(distich);
						}
					} else {
						distich.clearLastItem();
					}
				}
			}
		}

		return res;
	}

	public void printDistichList(ArrayList<Distich> list) {
		System.out.println("Generated Poem:");
		for (Distich distich : list) {
			System.out.println(distich.getTitle());
		}
	}

	private Word wordDelimiter(String hemistich) {

		String title = hemistich.substring(0, hemistich.indexOf(" "));
		String meter = hemistich.substring(hemistich.indexOf(" ") + 1,
				hemistich.length());

		return new Word(title, meter);
	}

	private Boolean listHasThisDistich(final List<Distich> list,final String distichTitle) {
		for (Distich item : list) {
			String itemTitle = item.getTitle();
			if (distichTitle.equals(itemTitle)) {
				return true;
			}
		}
		return false;
	}

}
