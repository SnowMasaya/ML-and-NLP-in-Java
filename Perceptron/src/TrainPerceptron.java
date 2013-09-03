import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TrainPerceptron {

	public void getLabelePair(PerceptronData data) {
		
		HashMap<String, Double> weight = new HashMap<String, Double>(); 
		data.setWeight(weight);
		
		for(int i = 0; i < 10; i++) {
			
		}
	}
	
	void train(PerceptronData data) throws FileNotFoundException{
	
		//ファイル読み込みの準備
		String fileName = data.getInputFileName();
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		//１行ごとに読み取るための前処理
		String line;
		
		//ファイル読み込み処理 
		try {
			while((line = br.readLine()) != null) {
					String[] labelAndData = splitLabel(line); 
					String[] Textdata = splitData(labelAndData[1]);
					data.setLabel(labelAndData[0]);
					data.setWords(Textdata);
					upDate(data);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
		//String型に変換して返す
	}
	
	private static String[] splitLabel(String text) {
		Pattern pattern = Pattern.compile("\n$");
		Matcher matcher = pattern.matcher(text);
		String strResult = matcher.replaceAll("");
		String[] label = strResult.split("\t");
		return label;
	}
	
	private static String[] splitData(String text) {
		Pattern pattern = Pattern.compile("\n$");
		Matcher matcher = pattern.matcher(text);
		String strResult = matcher.replaceAll("");
		String[] data = strResult.split(" ");
		return data;
	}
	
	private static void upDate(PerceptronData data) {
		
		String[] words = data.getWords();
		HashMap<String, Double> weight = data.getWeight(); 
		double weightValue = 1.0;
		Boolean predictLabel = new Boolean(false);
		Boolean dataLabel = new Boolean(false);
		Predict predict = new Predict();
		
		//重みに値が無ければ初期化
		for(int i = 0; i < words.length; i++) {
			if(!(weight.containsKey(words[i]))){
				weight.put(words[i], weightValue);
				data.setWeight(weight);
			}
		}
		
		for(int i = 0; i < words.length; i++) {
			predictLabel = predict.predict(data);
			String label = data.getLabel();
			dataLabel = Boolean.valueOf(label);
			if(predictLabel != dataLabel){
				updateWeight(data,i);
			}
		}
	}
	
	private static void updateWeight(PerceptronData data,int i) {
		HashMap<String, Double> weight = data.getWeight(); 
		HashMap<String, Double> unigramPro = data.getUnigrmProbablity(); 
		String[] words = data.getWords();
		Double value = unigramPro.get(words[i]);
		weight.put(words[i], value);
	}
}

