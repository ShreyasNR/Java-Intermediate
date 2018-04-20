import java.util.*;

public class apples {

	public static void main(String[] args) {
		String[] breakfast = {"idli", "vada", "dosa", "puri"};
		List<String> list = new ArrayList<String>();
		
		for (String x : breakfast)
			list.add(x);
			
		String[] breakfast2 = {"idli", "vada"};
		List<String> list2 = new ArrayList<String>();
		
		for (String y : breakfast2)
			list2.add(y);
		
		for  (int i = 0; i<list.size(); i++)
			System.out.printf("%s ", list.get(i));
			
		editlist(list, list2);
		System.out.println();
		
		for  (int i = 0; i<list.size(); i++)
			System.out.printf("%s ", list.get(i));
		
	}
	
	public static void editlist(Collection<String> l1, Collection<String> l2){
		Iterator<String> it = l1.iterator();
		while(it.hasNext()){
			if(l2.contains(it.next()))
				it.remove();
		}
			
	}
}


