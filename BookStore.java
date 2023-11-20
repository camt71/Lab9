package lab9;

public abstract class BookStore {
	private String title, author;
	private double price;
	private int pagenumber, yearofpublication;

	public BookStore(String title, String author, int yearofpublication, double price, int pagenumber) {
		this.title = title;
		this.author = author;
		this.yearofpublication = yearofpublication;
		this.price = price;
		this.pagenumber = pagenumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYearofpublication() {
		return yearofpublication;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPagenumber() {
		return pagenumber;
	}

	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}

	public abstract String isType();

	public abstract boolean isMagazineAndTenYear();

	public boolean isSame(BookStore other) {
		return this.author.equalsIgnoreCase(other.author) && this.isType().equalsIgnoreCase(other.isType());
	}

	@Override
	public String toString() {
		return "title=" + title + ", author=" + author + ", price=" + price + ", pagenumber=" + pagenumber
				+ ", yearofpublication=" + yearofpublication;
	}

}
