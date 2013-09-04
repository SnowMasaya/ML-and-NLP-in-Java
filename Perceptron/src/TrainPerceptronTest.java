import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.junit.Test;


public class TrainPerceptronTest {

	@Test
	public void test() throws FileNotFoundException {
		PerceptronData data = new PerceptronData();
//		data.setInputFileName("titles-en-train.labeled");
		data.setInputFileName("train.txt");
		
		Unigram unigram = new Unigram();
		unigram.UnigramPro(data);
		
		TrainPerceptron train = new TrainPerceptron();
		train.getLabelePair(data);
		
		System.out.println(data.getWeight());
	}

}
