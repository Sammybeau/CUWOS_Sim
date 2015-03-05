public class Driver 
{
	public static void main(String[] args) throws Exception
	{
		LinkedList ll = new LinkedList();
		ll.display();
		ll.addFront(3);
		ll.addFront(5);
		ll.addFront(11);
		ll.display();
		ll.displayInReverse();
	}
}

