import java.util.*;

public class apples {

	public static void main(String[] args) {
		
		String[] fruits1 = {"apple", "orange", "kiwi", "muskmelon", "banana"};
		List<String> list1 = new LinkedList<String>();
		
		for(String x : fruits1)
			list1.add(x);
		
		String[] fruits2 = {"muskmelon", "pineapple", "watermelon"};
		List<String> list2 = new LinkedList<String>();
		
		for(String y : fruits2)
			list2.add(y);
		
		list1.addAll(list2);
		list2.clear();
		
		printMe(list1);
		removeStuff(list1, 2, 5);
		printMe(list1);
		reverseMe(list1);
	}
	
	// printMe method
	public static void printMe(List<String> l){
		for(String b : l)
			System.out.printf("%s ", b);
		System.out.println();
	}
	
	// removeStuff method
	public static void removeStuff(List<String> l, int from, int to){
		l.subList(from,to).clear();
	}
	
	// reverseMe method
	public static void reverseMe(List<String> l){
		ListIterator<String> iterator = l.listIterator(l.size());
		while(iterator.hasPrevious())
			System.out.printf("%s ", iterator.previous());
	}

}
