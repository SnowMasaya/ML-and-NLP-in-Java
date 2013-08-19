import java.util.HashMap;


public class Unigram {

	HashMap<String, Double> UnigramPro(UnigramData data){
		
		String[] words = data.getWords();
		
		HashMap<String, Double> probablity = new HashMap<String, Double>();
		double value = 1;
		double pro= 0.0;
		int total = 0;
		
		for(int i = 0; i < words.length; i++){
			if(probablity.containsKey(words[i])){
				value = probablity.get(words[i]);
				value++;
				probablity.put(words[i], value);
			}else{
				value = 1;
				probablity.put(words[i], value);
			}
			
			total++;
		}
		
		for(int i = 0; i < words.length; i++){
			pro = probablity.get(words[i]) / total;
			probablity.put(words[i], pro);
		}
		
		return probablity;
	}
}
