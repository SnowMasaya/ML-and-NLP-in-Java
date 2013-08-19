import java.util.HashMap;


public class UnigramData {

	private String[] words;
	
	private HashMap<String, Double> probablity = new HashMap<String, Double>();

	private double Entropy;
	
	private double coverage;
	
	private String fName;
	
	public UnigramData() {
		super();
	}
	
	public UnigramData(String[] words, HashMap<String, Double> probablity) {
		super();
		this.words = words;
		this.probablity = probablity;
	}

	public UnigramData(HashMap<String, Double> probablity,
			double entropy, double coverage) {
		super();
		this.probablity = probablity;
		Entropy = entropy;
		this.coverage = coverage;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public double getEntropy() {
		return Entropy;
	}

	public void setEntropy(double entropy) {
		Entropy = entropy;
	}

	public double getCoverage() {
		return coverage;
	}

	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}

	public String[] getWords() {
		return words;
	}

	public void setWords(String[] words) {
		this.words = words;
	}

	public HashMap<String, Double> getProbablity() {
		return probablity;
	}

	public void setProbablity(HashMap<String, Double> probablity) {
		this.probablity = probablity;
	}
	
}
