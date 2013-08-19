import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;


public class UnigramDataTest {

	@Test
	public void test() {
		String[] matcher = {"Test", "hogehoge"};
		HashMap<String, Double> matcherPro = new HashMap<String, Double>();
		
		matcherPro.put("hoge", 0.5);
		
		UnigramData unigramData = new UnigramData(matcher, matcherPro);
		
		String[] actual = unigramData.getWords();
		HashMap<String, Double> actualPro = unigramData.getProbablity();
		
		assertThat(actual, is(matcher));
		assertThat(actualPro, is(matcherPro));
	}

}
