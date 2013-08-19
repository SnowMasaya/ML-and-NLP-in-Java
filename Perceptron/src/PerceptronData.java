import java.util.HashMap;


public class PerceptronData {

	private HashMap<String, Double> weight = new HashMap<String, Double>();
	
	private double predictValue;
	
	private String modelFileName;
	
	private String inputFileName;

	public String getModelFileName() {
		return modelFileName;
	}

	public void setModelFileName(String modelFileName) {
		this.modelFileName = modelFileName;
	}

	public String getInputFileName() {
		return inputFileName;
	}

	public void setInputFileName(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public HashMap<String, Double> getWeight() {
		return weight;
	}

	public void setWeight(HashMap<String, Double> weight) {
		this.weight = weight;
	}

	public double getPredictValue() {
		return predictValue;
	}

	public void setPredictValue(double predictValue) {
		this.predictValue = predictValue;
	}
	
	
}
