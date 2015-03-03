
public class Driver
{
	public static void main(String[] args)
	{
		Stack a = new Stack();
		a.push(1);
		a.push(2);
		a.push(3);
		a.push(4);
		a.push(5);
		a.pop();
		System.out.println(a.peek());
		a.pop();
		System.out.println(a.pop());
	}
}
