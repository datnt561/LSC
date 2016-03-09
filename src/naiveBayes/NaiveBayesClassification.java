package naiveBayes;

import java.util.ArrayList;

import data.DataSets;
import data.DocumentPridict;

public class NaiveBayesClassification {
	Vocabulary voca;
	
	ArrayList<DocumentPridict> listDocumentPridict;

	public double probabilitiReview(String label, String review) {
		ArrayList<String> listWords = Util.Utility.splitReviewtoWords(review);
		double probabi = 1;
		Word w;
		for (String s : listWords) {
			w = voca.searchWord(s);

			if (label.equals("POS")) {
				probabi *= w.getProPOS();
			} else {
				probabi *= w.getProNEG();
			}
		}
		if (label.equals("POS"))
			probabi *= voca.getPos().getProbability();
		else
			probabi *= voca.getNeg().getProbability();
		return probabi;
	}
	
	public void buildModel(ArrayList<Document> dataSets, String domain, double lamda) {
		voca = new Vocabulary(dataSets, domain);
		voca.computeProbabilityVoca(lamda);

	}

	public boolean isLableOfDocument(String review) {
		boolean lable = false;
		double proPos = probabilitiReview("POS", review);
		double proNeg = probabilitiReview("NEG", review);
		if (proPos > proNeg)
			lable = true;
		return lable;
	}

}
