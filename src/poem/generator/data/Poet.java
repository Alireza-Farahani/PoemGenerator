package poem.generator.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Elyas-Dolatabadi
 */
public class Poet {

    private String hemistichMeter;
    private final List<Word> words;

    public Poet() {
        this.words = new ArrayList<>();
    }

    public void parseInput(String fileName) {
        FileReader reader = new FileReader();

        List<String> linesList = reader.readLines(fileName);
        Iterator<String> itr = linesList.iterator();
        this.hemistichMeter = itr.next();

        while (itr.hasNext()) {
            String wordTextAndWordMeter = itr.next();
            if (wordTextAndWordMeter != null && !wordTextAndWordMeter.isEmpty()) {
                Word word = extractWord(wordTextAndWordMeter);
                words.add(word);
            }
        }
    }

    public void printFirstInformation() {
        System.out.println("Main Meter:");
        System.out.println("(" + this.hemistichMeter + ")");
        System.out.println("Words:");

        for (Word word : words) {
            System.out.println("(" + word.getText() + ")-(" + word.getMeter() + ")");
        }
    }

    public ArrayList<Hemistich> generateHemistiches() {
        return generateHemistiches(hemistichMeter);
    }

    private ArrayList<Hemistich> generateHemistiches(String meter) {
        ArrayList<Hemistich> result = new ArrayList<>();

        if (meter.isEmpty()) {
            Hemistich hemistich = new Hemistich();
            result.add(hemistich);
            return result;
        }

        for (Word word : words) {
            if (meter.startsWith(word.getMeter())) {
                ArrayList<Hemistich> tempHemistiches = generateHemistiches(meter.replaceFirst(word.getMeter(), "").trim());
                for (Hemistich tempHemistich : tempHemistiches) {
                    tempHemistich.addWordToBeginning(word);
                }
                result.addAll(tempHemistiches);
            }
        }
        return result;
    }

    public void printDistichList(ArrayList<Hemistich> hemistiches) {
        System.out.println("Generated Poet:");
        for (Hemistich hemistich : hemistiches) {
            System.out.println(hemistich.toString());
        }
    }

    private Word extractWord(String hemistich) {
        String title = hemistich.substring(0, hemistich.indexOf(" "));
        String meter = hemistich.substring(hemistich.indexOf(" ") + 1);
        return new Word(title, meter);
    }
}
