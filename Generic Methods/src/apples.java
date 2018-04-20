import java.util.*;

public class apples {

	public static void main(String[] args) {
		
		Integer[] iray = {1, 2, 3, 4, 5, 6, 7};
		Character[] cray = {'s', 'h', 'r', 'e', 'y', 'a', 's'};
		
		printMe(iray);
		printMe(cray);
		
	}
	
	public static <T> void printMe(T[] i){
		for(T x : i)
			System.out.printf("%s ", x);
		System.out.println();
	}

}
