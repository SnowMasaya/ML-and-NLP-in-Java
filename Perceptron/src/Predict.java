import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.hamcrest.Matcher;


public class Predict {

	public void predict(PerceptronData data) {
		// TODO Auto-generated method stub
		String inputFileName = data.getInputFileName();

		
		
		
	}
	
	public void loadWeight(PerceptronData data) throws FileNotFoundException {
		
		HashMap<String, Double> model = data.getWeight();
		
		//�t�@�C���ǂݍ��݂̏���
		String fileName = data.getModelFileName();
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		//�P�s���Ƃɓǂݎ�邽�߂̑O����
		StringBuffer text = new StringBuffer(1024);
		String line;
		String lineSeparator = System.getProperty("line.separator");
		
		//�t�@�C���ǂݍ��ݏ���
		try {
			while((line = br.readLine()) != null) {
				//String�^�ɕϊ����ĕԂ�
				String[] words = replaceMethod(new String(text));
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
