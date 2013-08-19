import java.io.FileNotFoundException;
import java.util.HashMap;


public class UseUnigram implements UseUnigramInterface {
	
	public void useUnigram() throws FileNotFoundException{
		
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
		
		System.out.println("Coverage " + data.getCoverage());
		System.out.println("Coverage " + data.getEntropy());
	}

}
