import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InputFile {

	String[] read(UnigramData data) throws FileNotFoundException{
	
		//ファイル読み込みの準備
		String fileName = data.getfName();
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		//１行ごとに読み取るための前処理
		StringBuffer text = new StringBuffer(1024);
		String line;
		String lineSeparator = System.getProperty("line.separator");
		
		//ファイル読み込み処理
		try {
			while((line = br.readLine()) != null) {
				text.append(line);
				text.append(lineSeparator);
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
		//String型に変換して返す
		String[] words = replaceMethod(new String(text));
		return words;
	}
	
	private static String[] replaceMethod(String replaceText) {
		Pattern pattern = Pattern.compile("\n$");
		Matcher matcher = pattern.matcher(replaceText);
		String strResult = matcher.replaceAll("");
		String[] words = strResult.split(" ");
		return words;
	}
}
