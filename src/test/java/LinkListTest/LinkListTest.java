package LinkListTest;

import com.ds.list.LinkList;

//Double ended
public class LinkListTest {

	public static void main(String[] args) {

		LinkList linkList = new LinkList();
		linkList.insertFirst("A");
		linkList.insertFirst("B");
		linkList.insertFirst("C");
		linkList.insertFirst("D");

		linkList.displayList();

		System.out.println("link --> " + linkList.find("C").getData());

		if (linkList.find("G") != null) {
			System.out.println("link --> " + linkList.find("G").getData());
		}
		linkList.delete("C");
		linkList.displayList();
		linkList.deleteFirst();
		linkList.deleteFirst();

		linkList.displayList();
	}
}
