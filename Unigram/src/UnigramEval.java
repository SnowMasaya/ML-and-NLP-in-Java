import java.io.FileNotFoundException;
import java.util.HashMap;


public class UnigramEval {
	
	static double lambda = 0.95;
	static double lambdaUnk = 1 - lambda;
	static double vocabubly = 1000000;

	void evalUnigram(UnigramData data) throws FileNotFoundException{
		
		InputFile input = new InputFile();
		
		String[] testWords = input.read(data);
		HashMap<String, Double> probablity = data.getProbablity(); 
		int total = 0;
		double totalProbablity = lambdaUnk / vocabubly;
		int unkWordNumber = 0;
		double H = 0;
		
		for(int i = 0; i < testWords.length; i++){
			total++;
			
			if(probablity.containsKey(testWords[i])) {
				totalProbablity += lambda * probablity.get(testWords[i]); 
			} else {
				unkWordNumber++;
			}
			H -= Math.log(totalProbablity) / Math.log(2.0);
		}
		
		data.setEntropy(H/total);
		double tmp = (total - unkWordNumber); 
		double coverage = tmp / total; 
		data.setCoverage(coverage);
	}
}
