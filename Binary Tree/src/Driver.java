public class Driver 
{
	public static void main(String[] args) 
	{
		BinaryTree b = new BinaryTree();
		b.add(6);		
		b.add(5);		
		b.add(7);
		b.add(8);
		b.add(9);
		b.add(10);
		b.displayInOrder();	
		System.out.println(b.isBalanced());
	}
}