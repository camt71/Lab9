package lab9;

public class Magazine extends BookStore {
	private String name;

	public Magazine(String title, String author, int yearofpublication, double price, int pagenumber, String name) {
		super(title, author, yearofpublication, price, pagenumber);
		this.name = name;
	}

	@Override
	public String isType() {
		return "Magazine";
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean isMagazineAndTenYear() {
		return this.getYearofpublication() == 2021;
	}

//	@Override
//	public String toString() {
//		return "name=" + name;
//	}

}
