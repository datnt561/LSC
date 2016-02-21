package data;

import java.util.ArrayList;

public interface DataSets {
	
	public void readFilesDataSets(String path);
	
	public ArrayList<Document> fiterDocumentByLabel(String domain, String label);

	public void printDataSets();
	
}
