package naiveBayes;

import java.util.ArrayList;

import data.DataSets;

public class Vocabulary {
	ArrayList<Word> vocaPOS;
	ArrayList<Word> vocaNEG;
	
	public ArrayList<Word> getVocaPOS() {
		return vocaPOS;
	}

	public void setVocaPOS(ArrayList<Word> vocaPOS) {
		this.vocaPOS = vocaPOS;
	}

	public ArrayList<Word> getVocaNEG() {
		return vocaNEG;
	}

	public void setVocaNEG(ArrayList<Word> vocaNEG) {
		this.vocaNEG = vocaNEG;
	}

	public Vocabulary(DataSets dataSets, String domain){
		
	}

}
