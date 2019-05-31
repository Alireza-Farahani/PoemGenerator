import java.util.ArrayList;

import poem.generator.data.Distich;
import poem.generator.data.Poem;

/**
 * @author Elyas-Dolatabadi
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Poem myPoem = new Poem();
		myPoem.init("./in/poem1.txt");
		ArrayList<Distich> distichList = myPoem.generateDistichList();
		myPoem.printFirstInformation();
		myPoem.printDistichList(distichList);
	}
}
