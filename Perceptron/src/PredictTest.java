import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.junit.Test;


public class PredictTest {

	@Test
	public void test() throws FileNotFoundException {
		Predict p = new Predict();
		PerceptronData data = new PerceptronData();
		data.setModelFileName("model.txt");
		p.loadWeight(data);
		HashMap<String, Double> actual = new HashMap<String, Double>(){{
			put("hoge",1.0);
		}};
		assertThat(actual, is(data.getWeight()));
	}

}
