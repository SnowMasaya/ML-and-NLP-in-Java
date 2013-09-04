import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Unigram {

	void UnigramPro(PerceptronData data) throws FileNotFoundException{
		
		String[] words = read(data);
		HashMap<String, Double> weight = data.getWeight(); 
		double weightValue = 1.0;
		
		//�d�݂ɒl��������Ώ�����
		for(int i = 0; i < words.length; i++) {
			if(!(weight.containsKey(words[i]))){
				weight.put(words[i], weightValue);
				data.setWeight(weight);
			}
		}
		
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
		
		data.setUnigrmProbablity(probablity);
	}
	
	String[] read(PerceptronData data) throws FileNotFoundException{
	
		//�t�@�C���ǂݍ��݂̏���
		String fileName = data.getInputFileName();
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		//�P�s���Ƃɓǂݎ�邽�߂̑O����
		StringBuffer text = new StringBuffer(1024);
		String line;
		String lineSeparator = System.getProperty("line.separator");
		
		//�t�@�C���ǂݍ��ݏ���
		try {
			while((line = br.readLine()) != null) {
				String[] tmpText = splitLabel(line);
				text.append(tmpText[1]);
				text.append(lineSeparator);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
		//String�^�ɕϊ����ĕԂ�
		String[] words = splitData(new String(text));
		return words;
	}
	
	private static String[] splitLabel(String text) {
		Pattern pattern = Pattern.compile("\n$");
		Matcher matcher = pattern.matcher(text);
		String strResult = matcher.replaceAll("");
		String[] words = strResult.split("\t");
		return words;
	}
	
	private static String[] splitData(String text) {
		Pattern pattern = Pattern.compile("\n$");
		Matcher matcher = pattern.matcher(text);
		String strResult = matcher.replaceAll("");
		String[] words = strResult.split(" ");
		return words;
	}
	
}
