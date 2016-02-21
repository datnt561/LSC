package data;

public class Document {
	private String label;
	private String review;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public void printData() {
		System.out.println(this.label + ", " + this.review);
	}

}
