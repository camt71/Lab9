package lab9;

public class Chapter {
	private String title;
	private int pagenum;

	public Chapter(String title, int pagenum) {
		this.title = title;
		this.pagenum = pagenum;
	}

	public String getTitle() {
		return title;
	}

	public int getPagenum() {
		return pagenum;
	}

	@Override
	public String toString() {
		return "title=" + title + ", pagenum=" + pagenum;
	}

}
