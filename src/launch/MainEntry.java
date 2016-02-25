package launch;

import java.util.HashSet;

import data.BinaryDataSets;
import data.DataSets;
import data.NameDomains;

public class MainEntry {

	public static void main(String[] args) {
		
		DataSets dataSets = new BinaryDataSets("ACL2015-Chen-Datasets/");
		
		//dataSets.printDataSets();
		
		//dataSets.printDataSetsByDomain("AlarmClock.txt");
		
//		NameDomains domains = new NameDomains("ACL2015-Chen-Datasets/");
//		System.out.println(domains.getDomains());
		
		HashSet<String> setWords = dataSets.createVoca("AlarmClock.txt");
		System.out.println(setWords);
		System.out.println(setWords.size());
		
		for(String s : setWords){
			System.out.println(s);
		}
		
		System.out.println(setWords);
	}

}
