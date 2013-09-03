import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.hamcrest.Matcher;


public class Predict {

	public Boolean predict(PerceptronData data) {
		// TODO Auto-generated method stub
		HashMap<String, Double> unigramPro = data.getUnigrmProbablity();
		HashMap<String, Double> weight = data.getWeight(); 
		
		// ハッシュのキーを順に取得する
		Set<String> keys = unigramPro.keySet();
		Set<String> sortedKeys = new TreeSet<String>(keys); 
		java.util.Iterator<String> ite = sortedKeys.iterator();
		
		double value = 0;
		
		while(ite.hasNext()){
			String key = (String)ite.next();
			value += (double)unigramPro.get(key) * (double)weight.get(key);
		}
		
		if(value >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void loadWeight(PerceptronData data) throws FileNotFoundException {
		
		HashMap<String, Double> model = data.getWeight();
		
		//ファイル読み込みの準備
		String fileName = data.getModelFileName();
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		//１行ごとに読み取るための前処理
		String line;
		
		//ファイル読み込み処理
		try {
			while((line = br.readLine()) != null) {
				//String型に変換して返す
				String[] words = replaceMethod(line);
				if(model.containsKey(words[0])){
					System.out.println("model is duplicate");
				}else{
					model.put(words[0], Double.valueOf(words[1]));
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.err.println(e);
		}

	}

	private static String[] replaceMethod(String replaceText) {
		Pattern pattern = Pattern.compile("\n$");
		java.util.regex.Matcher matcher = pattern.matcher(replaceText);
		String strResult = matcher.replaceAll("");
		String[] words = strResult.split(" ");
		return words;
	}
}
