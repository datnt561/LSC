package naiveBayes;

public class Word {
	private String word;
	private double proPOS;
	private double proNEG;
	private int timeInPOS;
	private int timeInNEG;
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public double getProPOS() {
		return proPOS;
	}

	public void setProPOS(double proPOS) {
		this.proPOS = proPOS;
	}

	public double getProNEG() {
		return proNEG;
	}

	public void setProNEG(double proNEG) {
		this.proNEG = proNEG;
	}

	public int getTimeInPOS() {
		return timeInPOS;
	}

	public void setTimeInPOS(int timeInPOS) {
		this.timeInPOS = timeInPOS;
	}

	public int getTimeInNEG() {
		return timeInNEG;
	}

	public void setTimeInNEG(int timeInNEG) {
		this.timeInNEG = timeInNEG;
	}

	public int countWordInLabel(String domain, String label){
		return 0;
	}
	
	public double computeProPOS(String domain){
		return 0;
	}
	
	public double computeProNEG(String domain){
		return 0;
	}
}
