package lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ListPublications {
	private List<BookStore> stores;

	public ListPublications(List<BookStore> stores) {
		this.stores = stores;
	}

	public double totalCost() {
		int total = 0;
		for (BookStore bookStore : stores) {
			total += bookStore.getPrice();
		}
		return total;
	}

	public boolean findSameTitle(String name) {
		for (BookStore bookStore : stores) {
			if (bookStore.isType().equalsIgnoreCase("Magazine") && bookStore.getTitle().equalsIgnoreCase(name))
				return true;

		}
		return false;
	}

	public List<Magazine> publishedOneYear(int year) {
		List<Magazine> resultMagazines = new ArrayList<>();
		for (BookStore bookStore : stores) {
			if (bookStore.isType().equalsIgnoreCase("Magazine") && bookStore.getYearofpublication() == year) {
				resultMagazines.add((Magazine) bookStore);

			}
		}
		return resultMagazines;
	}

	public void sort() {
		Set<BookStore> set = new TreeSet<>(new Comparator<BookStore>() {

			@Override
			public int compare(BookStore o1, BookStore o2) {
				int sortTitle = o1.getTitle().compareTo(o2.getTitle());
				if (sortTitle == 0) {
					return o1.getYearofpublication() - o2.getYearofpublication();
				} else {
					return sortTitle;
				}
			}

		});
		set.addAll(stores);
		System.out.println(set.toString());
	}

	public Map<Integer, Integer> filterYear() {
		int tmp = 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (BookStore store : stores) {
			if (!map.containsKey(store.getYearofpublication())) {
				map.put(store.getYearofpublication(), tmp);
			} else {
				map.put(store.getYearofpublication(), tmp + 1);
			}
		}
		return map;
	}

	@Override
	public String toString() {
		return "" + stores;
	}

	public static void main(String[] args) {
		Chapter c1 = new Chapter("A", 100);
		Chapter c2 = new Chapter("C", 110);
		Chapter c3 = new Chapter("B", 230);
		Chapter c4 = new Chapter("D", 130);

		List<Chapter> list1 = new ArrayList<>();
		list1.add(c1);
		list1.add(c3);

		List<Chapter> list2 = new ArrayList<>();
		list2.add(c1);
		list2.add(c2);
		list2.add(c3);

		List<Chapter> list3 = new ArrayList<>();
		list3.add(c4);
		list3.add(c2);

		List<Chapter> list4 = new ArrayList<>();
		list4.add(c2);
		list4.add(c3);
		
		ReferenceBooks books= new ReferenceBooks(null, null, 0, 0, 0, null, list1);
		
		BookStore tapChi1 = new Magazine("Tap Chi Giao Duc", "Tran Thi Binh", 2022, 51000, 50, "GT");
		BookStore tapChi2 = new Magazine("Tap Chi TS", "Tran Thi C", 2020, 530000, 70, "TS");
		BookStore tapChi3 = new Magazine("Tap Chi CT", "Tran Thi D", 2021, 25000, 30, "CT");
		BookStore tapChi4 = new Magazine("Tap Chi CT", "Tran Thi Binh", 2021, 10000, 25, "KH");
		BookStore sach1 = new ReferenceBooks("Sach Y Hoc", "Tran Thi D", 2021, 155000, 300, "Y Hoc", list1);
		BookStore sach2 = new ReferenceBooks("CTDL", "Nguyen Van B", 2010, 75000, 140, "CNTT", list3);
		BookStore sach3 = new ReferenceBooks("Sach Y Hoc3", "Nguyen Van H", 2011, 315000, 50, "Y Hoc3", list4);
		BookStore sach4 = new ReferenceBooks("Sach Y Hoc4", "Nguyen Van K", 2023, 743000, 25, "Y Hoc4", list2);

		List<BookStore> listPublication = new ArrayList<>();
		listPublication.add(tapChi1);
		listPublication.add(tapChi2);
		listPublication.add(tapChi3);
		listPublication.add(tapChi4);

		listPublication.add(sach1);
		listPublication.add(sach2);
		listPublication.add(sach3);
		listPublication.add(sach4);

		ListPublications listPublications = new ListPublications(listPublication);

//		System.out.println(listPublications);
//		System.out.println(tapChi1.isType());
//		System.out.println(sach1.isType());
//		System.out.println(tapChi4.isMagazineAndTenYear());
//		System.out.println(tapChi3.isSame(sach1));
//		System.out.println(listPublications.totalCost());
//		System.out.println(listPublications.findSameTitle("Tap Chi Giao Duc"));
//		System.out.println(listPublications.publishedOneYear(2021));
//		listPublications.sort();
//		System.out.println(listPublications);
		System.out.println(books.mostPage());
//		System.out.println(listPublications.filterYear());
	}
}
