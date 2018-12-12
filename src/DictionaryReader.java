import java.io.*;
import java.util.*;

public class DictionaryReader {
	
	public ArrayList<String> dict;
	
	public DictionaryReader() {
		dict = readDictionary();
	}
	
	public static ArrayList<String> readDictionary() {
		
		BufferedReader bf = null;
		FileReader fr = null;
		String word = null;
		ArrayList<String> wordList = new ArrayList<>();
		
		try {
			fr = new FileReader("src/dict.txt");
			bf = new BufferedReader(fr);
			
			while ((word = bf.readLine()) != null) {
				wordList.add(word);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bf != null) {
					bf.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				
			}
		}
		
		return wordList;
		
	}
}
