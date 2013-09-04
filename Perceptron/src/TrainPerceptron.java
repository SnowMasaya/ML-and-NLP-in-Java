import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TrainPerceptron {

	public void getLabelePair(PerceptronData data) throws FileNotFoundException {
		
		for(int i = 0; i < 10; i++) {
			train(data);
		}
	}
	
	void train(PerceptronData data) throws FileNotFoundException{
	
		//ファイル読み込みの準備
		String fileName = data.getInputFileName();
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		//１行ごとに読み取るための前処理
		String line;
		InputFile input = new InputFile();
		
		//ファイル読み込み処理 
		try {
			while((line = br.readLine()) != null) {
					String[] labelAndData = input.splitLabel(line); 
					String[] Textdata = input.replaceMethod(labelAndData[1]);
					data.setLabel(labelAndData[0]);
					data.setWords(Textdata);
					upDate(data);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
		//String型に変換して返す
	}
	
	private static void upDate(PerceptronData data) throws FileNotFoundException {
		
		String[] words = data.getWords();
		Boolean predictLabel = new Boolean(false);
		Boolean dataLabel = new Boolean(false);
		Predict predict = new Predict();
		
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
		String label = data.getLabel();
		Double labelValue = Double.valueOf(label);
		Double value = labelValue * unigramPro.get(words[i]);
		weight.put(words[i], value);
	}
	
}

