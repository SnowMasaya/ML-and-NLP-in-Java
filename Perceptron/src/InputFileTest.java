import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;



public class InputFileTest {

	@Test
	public void test() throws FileNotFoundException {
		String[] actual = {"Test", "hogehoge"};
		InputFile input  = new InputFile();
		PerceptronData data = new PerceptronData();
		data.setInputFileName("titles-en-train.labeled");
		String[] matcher = input.read(data); 
		assertThat(actual, is(matcher));
	}

}
