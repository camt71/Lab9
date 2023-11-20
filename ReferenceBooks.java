package lab9;

import java.util.List;

public class ReferenceBooks extends BookStore {
	private String information;
	private List<Chapter> chapters;

	public ReferenceBooks(String title, String author, int yearofpublication, double price, int pagenumber,
			String information, List<Chapter> chapters) {
		super(title, author, yearofpublication, price, pagenumber);
		this.information = information;
		this.chapters = chapters;
	}

	public String getInformation() {
		return information;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

//	@Override
//	public String toString() {
//		return "information=" + information + ", chapters=" + chapters;
//	}

	@Override
	public String isType() {
		return "ReferenceBooks";
	}

	@Override
	public boolean isMagazineAndTenYear() {
		return false;
	}

	public Chapter mostPage() {
		int count = 0;
		Chapter books = null;
		for (Chapter chapter : chapters) {
			if (chapter.getPagenum() > count) {
				books = chapter;
				count = chapter.getPagenum();
			}
			count++;
		}
		return books;
	}

}
