package naiveBayes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import Util.Utility;
import data.DataSets;
import data.Document;

public class Vocabulary {
	HashSet<Word> vocabulary;
	
	public HashSet<Word> getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(HashSet<Word> vocabulary) {
		this.vocabulary = vocabulary;
	}


	public Vocabulary(DataSets dataSets, String domain){
		ArrayList<String> wordInReviewsPOS = dataSets.listWordsByLabel(domain, "POS");
		ArrayList<String> wordInReviewsNEG = dataSets.listWordsByLabel(domain, "NEG");
		
		Utility.writerListWordToFile(wordInReviewsPOS, "POS.txt");
		Utility.writerListWordToFile(wordInReviewsNEG, "NEG.txt");
//		System.out.println(wordInReviewsNEG);
//		System.out.println(wordInReviewsPOS);
		vocabulary = new HashSet<Word>();
		
		Word w ;
		int numberWordInListPOS;
		int numberWordInListNEG;
		for(String s : wordInReviewsPOS ){
			w = new Word();
			w.setWord(s);
			numberWordInListPOS = Utility.countWordInList(s, wordInReviewsPOS);
			numberWordInListNEG = Utility.countWordInList(s, wordInReviewsNEG);
//			System.out.println("POS :" + numberWordInListPOS);
//			System.out.println("NEG :" + numberWordInListNEG);
			w.setTimeInPOS(numberWordInListPOS);
			w.setTimeInNEG(numberWordInListNEG);
			//w.printWord();
			wordInReviewsNEG.remove(s);
			vocabulary.add(w);
		}
		
		for(String s : wordInReviewsNEG){
			w = new Word();
			w.setWord(s);
			numberWordInListPOS = 0;
			numberWordInListNEG = Utility.countWordInList(s, wordInReviewsNEG);
			w.setTimeInPOS(numberWordInListPOS);
			w.setTimeInNEG(numberWordInListNEG);
			vocabulary.add(w);
		}
		
	}
	
	public void printVoca(){
		for(Word d : vocabulary)
			System.out.println(d.getWord() + " : POS : " + d.getTimeInPOS() + " NEG : " + d.getProNEG() );
	}
	
	public void writeVocaToFile(String nameFile){
		FileWriter writer;
		try {
			writer = new FileWriter(nameFile);
			
			writer.write("Word\tPOS\tNEG\n");
			for(Word w: vocabulary) {
				  writer.write(w.getWord());
				//  System.out.println(w.getWord());
				  writer.write("\t");
				  writer.write(String.valueOf(w.getTimeInPOS()));
				//  System.out.println(w.getTimeInPOS());
				  writer.write("\t");
				  writer.write(String.valueOf(w.getTimeInNEG()));
				//  System.out.println(w.getTimeInNEG());
				  writer.write("\n");
				}
			
				writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	

}
