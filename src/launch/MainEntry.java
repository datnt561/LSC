package launch;

import java.util.HashSet;

import data.BinaryDataSets;
import data.DataSets;

public class MainEntry {

	public static void main(String[] args) {
		
		DataSets dataSets = new BinaryDataSets("ACL2015-Chen-Datasets/");
		
		HashSet<String> setWords = dataSets.createVocaByLabel("AlarmClock.txt", "POS");
		System.out.println(setWords);
		System.out.println(setWords.size());
		
		for(String s : setWords){
			System.out.println(s);
		}
		
		System.out.println(setWords);
	}

}
