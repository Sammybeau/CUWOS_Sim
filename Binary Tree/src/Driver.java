public class Driver 
{
	public static void main(String[] args) 
	{
		//BinaryTreeLitman bt = new BinaryTreeLitman();
		BinaryTree b = new BinaryTree();
		b.add(9);
		System.out.println("-----after 9");
		b.add(5);
		System.out.println("----after 5");
		b.add(14);
		System.out.println("-----after 14");
		b.add(10);
		System.out.println("----after 10");
		b.add(16);
		System.out.println("----after 16");
		b.add(4);
		System.out.println("----after 4");
		//System.out.println(b.isBalanced());
		b.add(3);
		System.out.println("----after 3");		
		//System.out.println(bt.search(28));
		//b.add(2);
		//System.out.println("----after 2");
		//b.visitInOrder();
		System.out.println(b.isBalanced());
		b.displayPreOrder();	
	}
}