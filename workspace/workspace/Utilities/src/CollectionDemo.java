import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class CollectionDemo {

	public static void main(String[] args) {
		ArrayList<String> lst = new ArrayList<>();
		lst.add("Apple");
		lst.add("Microsoft");
		lst.add("Oracle");
		lst.add("Google");
		lst.add(2, "Apache");
		System.out.println("-- Traversing over array list using index" );
		for (int a = 0; a < lst.size(); a++) {
			System.out.println(lst.get(a));
		}
		System.out.println("-- Traversing over array list using for-each");
		for (String node : lst) {
			System.out.println(node);
		}
		
		Iterator<String> itr = lst.iterator();
		System.out.println("-- Traversing over array list using Iterator");
		while(itr.hasNext())
			System.out.println(itr.next());
		
		
		LinkedList<String> link = new LinkedList(lst);
		link.add("Google");
		System.out.println("-- Traversing over Linked list using for-each");
		for (String node : link) {
			System.out.println(node);
		}
		
		HashSet<String> set = new HashSet(link);
		System.out.println("--Traversing over hash set using for-each");
		for (String node : set) {
			System.out.println(node);
		}
		
		TreeSet<String> tree = new TreeSet(set);
		System.out.println("-- Traversing over tree set");
		for (String node : tree) {
			System.out.println(node);
		}
		System.out.println("--Descending order");
		for (String node : tree.descendingSet()) {
			System.out.println(node);
		}
		itr = tree.descendingIterator();
		System.out.println("--Traversing over tree set using iterator");
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
		Queue<String> que = link;
		//que.addAll(lst);
		System.out.println("--Traversing over queue");
		for (String node : que) {
			System.out.println(node);
		}
		System.out.println("--peek: " + que.peek());
		
		Deque<String> deq = link;
		
		System.out.println("-- Traversing over dequeue");
		for (String node : deq) {
			System.out.println(node);
			
		}
		System.out.println("--peek: " + deq.peek());
		
	}
	

}
