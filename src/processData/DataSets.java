package processData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataSets {
	private ArrayList<Data> dataSets;

	// Loc theo nhan positive
	public ArrayList<Data> fiterByLabelPOS() {
		ArrayList<Data> positives = new ArrayList<Data>();

		for (Data d : dataSets) {
			if (d.isLabel()) {
				positives.add(d);
			}
		}
		return positives;
	}

	public ArrayList<Data> fiterByLabelNEU() {
		ArrayList<Data> negatives = new ArrayList<Data>();

		for (Data d : dataSets) {
			if (d.isLabel()) {
				negatives.add(d);
			}
		}
		return negatives;
	}

	public void readFileDataSet(String name) {
		String line = null;
		dataSets = new ArrayList<Data>();

		try {
			FileReader fileReader = new FileReader(name);

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			Data data = null;
			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				if (line.contains("Domain") && line.contains("Label")) {
				} else {
					data = splitLineData(line);
					dataSets.add(data);
				}

			}
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + name + " '");
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public Data splitLineData(String lineData) {
		String[] review = new String[4];
		int j = 0;
//		int index = 0;
//		for (int i = 0; i < lineData.length(); i++) {
//			if (lineData.charAt(i) == '\t') {
//				//review[j] = new String();
//				review[j] = lineData.substring(index, i );
//				index = i;
//				j++;
//			}
//			if(j == 3)
//				break;
//
//		}
//		review[3] = lineData.substring(index);
		for(String s : lineData.split("\t")){
			review[j] = s;
			j++;
		}
			
		System.out.println();
		for(String s : review)
			System.out.println(s);
		boolean label;
		if (review[1].equals("POS"))
			label = true;
		else
			label = false;
		review[2] = review[2].replaceAll(" ", "");
		int rating = Integer.parseInt(review[2]);
		Data data = new Data();
		data.setDomain(review[0]);
		data.setLabel(label);
		data.setRating(rating);
		data.setDocument(review[3]);

		return data;
	}

	public int countWordInClass(String word, String label) {
		return 0;
	}

	// in ra tap du lieu huan luyen
	public void printDataSets() {
		for (Data d : dataSets) {
			d.printData();
		}
	}
	
	public int length(){
		return dataSets.size();
	}
}
