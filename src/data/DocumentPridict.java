package data;

public class DocumentPridict extends Document{
	String lablePridict;
	
	public DocumentPridict(Document d, String lablePridict){
		super.setLabel(d.getLabel());
		super.setReview(d.getReview());
		lablePridict = new String(lablePridict);
	}
	public String getLablePridict() {
		return lablePridict;
	}

	public void setLablePridict(String lablePridict) {
		this.lablePridict = lablePridict;
	}
	
	public void printData(){
		System.out.println("Lable : " + super.getLabel() + " Review : " + super.getReview() + " Pridict : " + lablePridict);
	}

}
