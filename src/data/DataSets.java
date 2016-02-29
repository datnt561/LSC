package data;

import java.util.ArrayList;
import java.util.HashSet;

public interface DataSets {
	
	public void readFilesDataSets(String path);
	
	public ArrayList<Document> fiterDocumentByLabel(String domain, String label);

	public void printDataSets();

	public void printDataSetsByDomain(String string);

	public ArrayList<String> listWordsByLabel(String string, String string2);

	

	
	
}
