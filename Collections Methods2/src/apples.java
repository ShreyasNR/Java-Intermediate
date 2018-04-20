import java.util.*;

public class apples {

	public static void main(String[] args) {
		
		Character[] Ch = {'r', 'a', 'w'};
		List<Character> l = Arrays.asList(Ch);
		System.out.println("List is : ");
		output(l);
		
		//reverse of a list
		Collections.reverse(l);
		System.out.println("reversed list is : ");
		output(l);
		
		//new array and the new list
		Character[] newCh = new Character[3];
		List<Character> listcopy = Arrays.asList(newCh);
		
		//copy
		Collections.copy(listcopy, l);
		System.out.println("The copy of the list : ");
		output(listcopy);
		
		//filling list with the Ch
		Collections.fill(l, 'X');
		System.out.println("After filling the list : ");
		output(l);
	}
	
	//output method
	private static void output(List<Character> thelist){
		for (Character thing : thelist)
			System.out.printf("%s ", thing);
		System.out.println();
	}

}
