package naiveBayes;

import processData.Data;
import processData.DataSets;

public class NaiveBayesClassification {
	private DataSets data;
	private Label[] classLabel;
	
	public NaiveBayesClassification(DataSets data){
		this.data = data;
	}
	
	// tinh so lop tu du lieu
	public void computeProbabilityLabels(){
		try{
			double count = 0;
			for(Data d : data){
				if(d.isLabel())
					count++;
			}
			if(count == 0){
				count = 0.00001;
			}
			classLabel = new Label[2];
			classLabel[0].label = "true";
			classLabel[0].probability = count / data.length();
			
			
		}
	}

}
