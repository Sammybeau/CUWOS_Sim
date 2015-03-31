
public class Driver 
{
	public static void main(String[] args) 
	{
		BinaryTree bt = new BinaryTree();
		bt.add(12);
		bt.add(6);
		bt.add(2);
		bt.add(18);
		bt.add(29);
		bt.add(4);
		bt.add(3);
		bt.add(5);
		bt.add(8);
		bt.add(7);
		bt.add(9);
		bt.add(20);
		bt.add(31);
		bt.displayInOrder();
		bt.search(6);
		bt.displayPreOrder();
	}
}
