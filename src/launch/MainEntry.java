package launch;

import processData.DataSets;

public class MainEntry {

	public static void main(String[] args) {
		
		DataSets dataSets = new DataSets();
		dataSets.readFileDataSet("ACL2015-Chen-Datasets/AlarmClock.txt");
		dataSets.printDataSets();

	}

}
