import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;


public class PredictTest {

	@Test
	public void test() throws FileNotFoundException {
		Predict p = new Predict();
		PerceptronData data = new PerceptronData();
		data.setModelFileName("model.txt");
		p.loadWeight(data);
		HashMap<String, Double> actual = new HashMap<String, Double>(){{
			put("Test",-2.0);
			put("hogehoge",1.0);
		}};
		assertThat(actual, is(data.getWeight()));
	}

	@Test
	public void predictTest() throws FileNotFoundException {
		Predict p = new Predict();
		PerceptronData data = new PerceptronData();
		data.setModelFileName("model.txt");
		p.loadWeight(data);
		data.setInputFileName("hoge.txt");
		
		InputFile input = new InputFile();
		data.setWords(input.read(data));
		
		Boolean expected = p.predict(data);
		
		Boolean actual = new Boolean(true);
		assertThat(actual, is(expected));
	}

}
