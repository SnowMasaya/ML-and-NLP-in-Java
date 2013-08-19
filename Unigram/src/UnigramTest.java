import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.junit.Test;


public class UnigramTest {

	@Test
	public void test() throws FileNotFoundException {
		
		double actual = 0.5;
		
		InputFile input  = new InputFile();
		UnigramData data = new UnigramData();
		data.setfName("hoge.txt");
		String[] words = input.read(data); 
		
		data.setWords(words);
		Unigram unigram = new Unigram();
		HashMap<String, Double> matcher = unigram.UnigramPro(data);
		assertThat(actual, is(matcher.get("Test")));
		assertThat(actual, is(matcher.get("hogehoge")));
	}

}
