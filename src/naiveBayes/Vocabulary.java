package naiveBayes;

import java.util.ArrayList;

import data.DataSets;
import data.Document;

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
		ArrayList<Document> reviewsPOS = dataSets.fiterDocumentByLabel(domain, "POS");
		ArrayList<Document> reviewsNEG = dataSets.fiterDocumentByLabel(domain, "NEG");
		
	}

}
