package processData;

public class Data {
	private String domain;
	private boolean label;
	private String document;
	private int rating;
	
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public boolean isLabel() {
		return label;
	}
	public void setLabel(boolean label) {
		this.label = label;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	
	public void printData(){
		System.out.println(this.domain + ", " + this.label + ", " + this.rating + ", " + this.document);
	}
	
	
}
