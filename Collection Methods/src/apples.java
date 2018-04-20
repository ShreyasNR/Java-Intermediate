import java.util.*;

public class apples {

	public static void main(String[] args) {
		String[] crap = {"water", "lime", "curd", "melon", "cube"};
		List<String> l1 = Arrays.asList(crap);
		
		Collections.sort(l1);
		System.out.printf("%s\n", l1);
		
		Collections.sort(l1, Collections.reverseOrder());
		System.out.printf("%s\n", l1);
		

	}

}
