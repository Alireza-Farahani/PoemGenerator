package poem.generator.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Elyas-Dolatabadi
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
        this.mainMeter = itr.next();

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
        System.out.println("(" + this.mainMeter + ")");
        System.out.println("Words:");

        for (int i = 0; i < words.size(); i++) {
            System.out.println("(" + words.get(i).getTitle() + ")-(" + words.get(i).getMeter() + ")");
        }
    }

    public ArrayList<Distich> generateDistichList() {
        return generateDistichList(mainMeter);
    }

    private ArrayList<Distich> generateDistichList(String meter) {
        ArrayList<Distich> res = new ArrayList<Distich>();

        if (meter.isEmpty()) {
            Distich distich = new Distich();
            res.add(distich);
            return res;
        }

        for (Word word : words) {
            if (meter.startsWith(word.getMeter())) {
                ArrayList<Distich> tempDistichs = generateDistichList(meter.replaceFirst(word.getMeter(), "").trim());
                for (Distich tempDistich : tempDistichs) {
                    tempDistich.addWordToBeginning(word);
                }
                res.addAll(tempDistichs);
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
}
