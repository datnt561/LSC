package launch;

import java.util.ArrayList;

import Util.Utility;
import data.BinaryDataSets;
import data.DataSets;
import naiveBayes.Vocabulary;

public class MainEntry {

	public static void main(String[] args) {
		
		DataSets dataSets = new BinaryDataSets("ACL2015-Chen-Datasets/");
		
		ArrayList<String> setWords = dataSets.listWordsByLabel("AlarmClock.txt", "POS");
		//System.out.println(setWords);
		
		
//		for(String s : setWords){
//			System.out.println(s);
//		}
//		System.out.println(setWords.size());
		
		Vocabulary voca = new Vocabulary(dataSets, "AlarmClock.txt");
		voca.printVoca();
		voca.computeProbabilityVoca(0.5);
		//System.out.println(setWords);
		
		voca.writeVocaToFile("Voca123.txt");
		
		System.out.println(Utility.decimalFormat(034.3273234, 2));
	}

}
