package naiveBayes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import Util.Utility;
import data.DataSets;

public class Vocabulary {
	private HashSet<Word> vocabulary;
	
	private Label pos;
	private Label neg;

	public HashSet<Word> getVocabulary() {
		return vocabulary;
	}

	public Label getPos() {
		return pos;
	}

	public Label getNeg() {
		return neg;
	}

	public Vocabulary(DataSets dataSets, String domain) {
		ArrayList<String> wordInReviewsPOS = dataSets.listWordsByLabel(domain, "POS");
		ArrayList<String> wordInReviewsNEG = dataSets.listWordsByLabel(domain, "NEG");
		double numberDocumentPOS = dataSets.fiterDocumentByLabel(domain, "POS").size();
		double numberDocumentNEG = dataSets.fiterDocumentByLabel(domain, "NEG").size();
		
		this.pos = new Label("POS");
		this.pos.setProbability(numberDocumentPOS/(numberDocumentPOS + numberDocumentNEG));
		this.pos = new Label("NEG");
		this.pos.setProbability(numberDocumentNEG/(numberDocumentPOS + numberDocumentNEG));
		
		vocabulary = new HashSet<Word>();
		HashSet<String> setWords = new HashSet<String>(wordInReviewsPOS);
		HashSet<String> setWordsNEG = new HashSet<String>(wordInReviewsNEG);
		setWords.addAll(setWordsNEG);

		Word w;
		int numberWordInListPOS;
		int numberWordInListNEG;
		for (String s : setWords) {
			w = new Word();
			w.setWord(s);
			numberWordInListPOS = Utility.countWordInList(s, wordInReviewsPOS);
			numberWordInListNEG = Utility.countWordInList(s, wordInReviewsNEG);
			w.setTimeInPOS(numberWordInListPOS);
			w.setTimeInNEG(numberWordInListNEG);
			vocabulary.add(w);
		}
	}

	public void printVoca() {
		for (Word d : vocabulary)
			System.out.println(d.getWord() + " : POS : " + d.getTimeInPOS() + " NEG : " + d.getProNEG());
	}

	public void writeVocaToFile(String nameFile) {
		FileWriter writer;
		try {
			writer = new FileWriter(nameFile);

			writer.write("Word\tPOS\tNEG\n");
			for (Word w : vocabulary) {
				// Ten chu
				writer.write(w.getWord());
				writer.write("\t");
				// so lan xuat hien trong POS
				writer.write(String.valueOf(w.getTimeInPOS()));
				writer.write("\t");
				// so lan xuat hien trong NEG
				writer.write(String.valueOf(w.getTimeInNEG()));
				writer.write("\t");
				// xac suat de tu w xuat hien trong POS
				writer.write(String.valueOf(w.getProPOS()));
				writer.write("\t");
				// xac suat de tu w xuat hien trong NEG
				writer.write(String.valueOf(w.getProNEG()));
				writer.write("\n");
			}

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void computeProbabilityVoca(double lamda) {
		double probabi;
		int sumWordPOS = 0;
		int sumWordNEG = 0;
		for (Word w : vocabulary) {
			sumWordPOS += w.getTimeInPOS();
			sumWordNEG += w.getTimeInNEG();
		}
		for (Word w : vocabulary) {
			probabi = (double)(lamda + w.getTimeInPOS()) / (lamda * vocabulary.size() + sumWordPOS);
			probabi = Utility.decimalFormat(probabi, 9);
			w.setProPOS(probabi);
			probabi = (double)(lamda + w.getTimeInNEG()) / (lamda * vocabulary.size() + sumWordNEG);
			probabi = Utility.decimalFormat(probabi, 9);
			w.setProNEG(probabi);

		}
	}

	public Word searchWord(String w) {
		Word result = null;
		for (Word w1 : vocabulary) {
			if (w1.getWord().equalsIgnoreCase(w))
				result = w1;
		}
		return result;
	}

}
