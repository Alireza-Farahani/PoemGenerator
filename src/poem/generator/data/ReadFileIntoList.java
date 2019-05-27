package poem.generator.data;

import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
/**
 * @author Elyas-Dolatabadi
 * 
 */
public class ReadFileIntoList {

	public List<String> ReadFile(String fileName) {

		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(fileName),
					StandardCharsets.UTF_8);
		} catch (IOException e) {

			// do something
			e.printStackTrace();
		}
		return lines;
	}
}