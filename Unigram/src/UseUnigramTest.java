import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;


public class UseUnigramTest {

	@Test
	public void test() throws FileNotFoundException {
		
		UseUnigramInterface use = new UseUnigram();
		use.useUnigram();
	}

}
