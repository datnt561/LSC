package data;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BinaryDataSets implements DataSets {
	private HashMap<String, ArrayList<Document>> dataSets;

	public BinaryDataSets(String path) {
		this.dataSets = new HashMap<String, ArrayList<Document>>();
		this.readFilesDataSets(path);
		// this.printDataSets();
		ArrayList<Document> data;
		for (String domain : dataSets.keySet()) {
			// System.out.println(domain);
			data = this.fiterDocumentByLabel(domain, "NEU");
			this.dataSets.put(domain, data);
		}

	}

	public void readFilesDataSets(String path) {
		String line = null;

		NameDomains domains = new NameDomains(path);

		ArrayList<String> listDomains = domains.getDomains();

		for (String s : listDomains) {
			// System.out.println("Domain is :" + s);
			try {
				FileReader fileReader = new FileReader("ACL2015-Chen-Datasets/" + s);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				Document document = null;
				ArrayList<Document> data;
				data = new ArrayList<Document>();
				while ((line = bufferedReader.readLine()) != null) {
					if (line.contains("Domain") && line.contains("Label")) {
					} else {
						document = this.splitLineData(line);
						// document.printData();
						data.add(document);
					}

					this.dataSets.put(s, data);
				}
			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + s);
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}

	}

	private Document splitLineData(String lineData) {
		String[] review = new String[4];
		int j = 0;
		for (String s : lineData.split("\t")) {
			review[j] = s;
			j++;
		}

		Document data = new Document();
		data.setLabel(review[1]);
		data.setReview(review[3]);

		return data;
	}

	public ArrayList<Document> fiterDocumentByLabel(String domain, String label) {
		ArrayList<Document> listDocument = new ArrayList<Document>();
		ArrayList<Document> listDocumentFiter = new ArrayList<Document>();
		listDocument = this.dataSets.get(domain);
		// System.out.println(listDocument);
		for (Document d : listDocument) {
			// d.printData();
			if (!(d.getLabel().equals(label)))
				listDocumentFiter.add(d);
		}

		return listDocumentFiter;
	}

	public void printDataSets() {
		for (Map.Entry<String, ArrayList<Document>> m : this.dataSets.entrySet()) {
			System.out.println("Domain : " + m.getKey());
			for (Document d : m.getValue()) {
				d.printData();
			}
		}
	}

	public void printDataSetsByDomain(String domain) {
		ArrayList<Document> data = this.dataSets.get(domain);
		System.out.println("Domain is " + domain);
		int i = 0;
		for (Document d : data) {
			System.out.println(i);
			i++;
			d.printData();
		}

	}

	public HashMap<String, ArrayList<Document>> getDataSets() {
		return dataSets;
	}

	public HashSet<String> createVoca(String domain){
		HashSet<String> voca = new HashSet<String>();
		ArrayList<Document> reviews = dataSets.get(domain);
		String[] words;
		for(Document d : reviews){
			words = d.getReview().split("[^.a-zA-Z\\d]");
			for(String w : words)
				if(!w.isEmpty()&& w.length() > 2 && !containsDigit(w))
						voca.add(w);
		}
		
		return voca;
		
		
	}
	
	public final boolean containsDigit(String s){  
	    boolean containsDigit = false;

	    if(s != null && !s.isEmpty()){
	        for(char c : s.toCharArray()){
	            if(containsDigit = Character.isDigit(c)){
	                break;
	            }
	        }
	    }

	    return containsDigit;
	}

}
