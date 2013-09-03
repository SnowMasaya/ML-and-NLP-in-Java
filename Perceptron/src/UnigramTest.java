import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.junit.Test;


public class UnigramTest {

	@Test
	public void test() throws FileNotFoundException {
		
		double actual = 0.5;
		
		PerceptronData data = new PerceptronData();
		data.setInputFileName("hoge.txt");
		
		Unigram unigram = new Unigram();
		unigram.UnigramPro(data);
		HashMap<String, Double> matcher = data.getUnigrmProbablity();
		assertThat(actual, is(matcher.get("Test")));
		assertThat(actual, is(matcher.get("hogehoge")));
	}

}
