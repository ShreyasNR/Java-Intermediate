import java.util.*;

public class apples {

	public static void main(String[] args) {
		
		String[] food = {"dosa", "idli", "vada", "sambar"};
		List<String> list1 = Arrays.asList(food);
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("google");
		list2.add("youtube");
		list2.add("fmovies");
		
		for(String x : list2)
			System.out.printf("%s ", x);
		
		Collections.addAll(list2, food);
		
		System.out.println();
		for(String x : list2)
			System.out.printf("%s ", x);
		
		System.out.println();
		System.out.println(Collections.frequency(list2, "youtube"));
		
		boolean tof = Collections.disjoint(list1, list2);
		System.out.println(tof);
		
		if (tof)
			System.out.println("these lsits has no elements in common");
		else
			System.out.println("these lists has some thing in common!");
		
	}

}
