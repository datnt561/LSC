package naiveBayes;

import data.Document;
import launch.DataSets;

public class NaiveBayesClassification {
	private DataSets data;
	private Label posLabel;
	private Label negLabel;
	
	
	public NaiveBayesClassification(DataSets data){
		this.data = data;
	}
	
	// tinh so lop tu du lieu
	public void computeProbabilityPOS(){
		posLabel.label = "POS";
		negLabel.label = "NEG";
		
		int lengthDocumentPOS = data.fiterByLabelPOS().size();
		int lengthDocumentNEG = data.fiterByLabelNEG().size();
		
		posLabel.probability = (double)lengthDocumentPOS/data.length();
		negLabel.probability = (double)lengthDocumentNEG/data.length();
		
	}
	
	public double computeProbabilityWord(double lamda, int sizeVoca, String word, String label){
		
		double probabiWord;
		probabiWord = (lamda + data.countWordInClass(word, label))/(lamda*sizeVoca );
		return probabiWord;
	}

}
