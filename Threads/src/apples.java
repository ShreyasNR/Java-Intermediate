
public class apples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new tuna("one"));
		Thread t2 = new Thread(new tuna("two"));
		Thread t3 = new Thread(new tuna("three"));
		Thread t4 = new Thread(new tuna("four"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
