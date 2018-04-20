import java.util.*;
public class apples {

	public static void main(String[] args) {
		
		System.out.println(max(15,5,8));
		System.out.println(max('z', 'c', 'd'));
		System.out.println(max("tots", "tor", "tyre"));

	}
	
	public static <T extends Comparable<T>> T max(T a, T b, T c){
		T m = a;
		
		if(b.compareTo(a)>0)
			m = b;
		
		if(c.compareTo(m)>0)
			m = c;
			
		return m;
	}

}
