package spelling;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class NearbyWordsTester {
	
	private String word = "wrd";
	String emptyWord = "";
	String nullWord = null;
	List<String> currentList = new ArrayList<String>();
	Dictionary d;
	

	@Before
	public void setUp() throws Exception {
		d = new DictionaryHashSet();
	    DictionaryLoader.loadDictionary(d, "test_cases/dict.txt");
	    NearbyWords nw = new NearbyWords(d);
	    
	    //nw.substitution(word, currentList, true);
	    //nw.insertions(word, currentList, true);
	    //nw.deletions(word, currentList, true);
	    currentList = nw.suggestions(word,4);
	}

//	@Test
//	public void testSubstitution() {
//		//System.out.println(currentList);
//	}
//	
//	@Test
//	public void testInsertions() {
//		//System.out.println(currentList);
//	}
//	
//	@Test
//	public void testDeletion() {
//		//System.out.println(currentList);
//	}
	
	@Test
	public void testSuggestions() {
		System.out.println(currentList);
	}

}
