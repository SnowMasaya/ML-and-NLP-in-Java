import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.junit.Test;


public class UnigramEvalTest {

	@Test
	public void test() throws FileNotFoundException {
		UnigramData data = new UnigramData();
		data.setfName("hoge.txt");
		InputFile input = new InputFile();
		String[] trainWords = input.read(data);
		Unigram unigram = new Unigram();
		data.setWords(trainWords);
		
		HashMap<String, Double> modelProbablity = unigram.UnigramPro(data);
		data.setProbablity(modelProbablity);
		
		UnigramEval eval = new UnigramEval();
		data.setfName("test.txt");
		eval.evalUnigram(data);
		
		double expectPro = 8.7776701536538;
		double coverage  = 0.8816298656954246;
		
		assertThat(expectPro, is(data.getEntropy()));
		assertThat(coverage, is(data.getCoverage()));
	}

}
