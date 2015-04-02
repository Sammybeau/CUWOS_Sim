public class BinaryTree
{
	//private Node root;
	private boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	private int depth = -1;
	
	private BinaryTree(int depth)
	{
		this.isEmpty = true;		
		this.leftTree = null;
		this.rightTree = null;
		this.depth = depth;
	}
	public BinaryTree()
	{
		this(0);
	}
	
	public boolean search(int value)
	{		
		if(isEmpty == true)
		{
			return false;
		}		
		else
		{
			if(value == this.payload)
			{
				return true;
			}
			else if (value < this.payload)
			{
				if(this.leftTree == null)
				{
					return false;
				}
				else
				{
					return this.leftTree.search(value);
				}
			}
			else if (value > this.payload)
			{
				if(this.rightTree == null)
				{
					return false;
				}
				else
				{
					return this.rightTree.search(value);
				}
			}
		}
		return false;
	}
	
	public void visitInOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitInOrder(); 
		}
		System.out.println(this.payload + "+" + this.depth);
		if(this.rightTree != null)
		{
			this.rightTree.visitInOrder();
		}
	}

	public void displayInOrder()
	{
		System.out.println("**** In Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitInOrder();
		}
	}
	
	private void visitPreOrder()
	{
		System.out.println(this.payload + "+" + this.depth);
		if(this.leftTree != null)
		{
			this.leftTree.visitPreOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPreOrder();
		}
	}
	
	public void displayPreOrder()
	{
		System.out.println("**** Pre Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitPreOrder();
		}
	}
	
	private void visitPostOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitPostOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPostOrder();
		}
		System.out.println(this.payload);
	}
	
	public void displayPostOrder()

	{
		System.out.println("**** Post Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitPostOrder();
		}
	}

	public int getMaxDepth()
	{
		if(this.leftTree == null && this.rightTree == null)
		{
			return this.depth;
		}
		else if(this.leftTree == null)
		{
			return this.rightTree.getMaxDepth();
		}
		else if(this.rightTree == null)
		{
			return this.leftTree.getMaxDepth();
		}
		else
		{
			return Math.max(this.leftTree.getMaxDepth(), this.rightTree.getMaxDepth());
		}
	}
	
	public boolean isBalanced()
	{
		if(this.isEmpty)
		{
			return true;
		}
		else
		{
			int currMaxLeftDepth = this.leftTree == null?this.depth:this.leftTree.getMaxDepth();
			int currMaxRightDepth = this.rightTree == null?this.depth:this.rightTree.getMaxDepth();
			System.out.println("Max Left = " + currMaxLeftDepth );
			System.out.println("Max Right = " + currMaxRightDepth );
			return Math.abs(currMaxLeftDepth - currMaxRightDepth) <= 1;
		}
	}
	
	public BinaryTree rotateRight(BinaryTree parent)
	{
		System.out.println("rotating right");
		BinaryTree child = parent.leftTree;
		child.rightTree = parent;
		parent.leftTree = null;
		this.leftTree = child;		
		return child;
	}
	
	public BinaryTree rotateLeft(BinaryTree parent)
	{
		System.out.println("rotating left");
		BinaryTree child = parent.rightTree;
		child.leftTree = parent;
		parent.rightTree = null;
		this.rightTree = child;
		return child;
	}
	
	public void reBalance()
	{
		System.out.println("rebalancing");
		if(this.rightTree == null)
		{
			rotateRight(this.leftTree);
		}
		if(this.leftTree == null)
		{
			rotateLeft(this.rightTree);
		}
	}
	
	public void add(int value)
	{
		if(this.isEmpty)
		{
			this.payload = value;
			this.isEmpty = false;
		}
		else
		{
			if(value <= this.payload)
			{
				if(this.leftTree == null)
				{
					this.leftTree = new BinaryTree(this.depth+1);	
				}
				this.leftTree.add(value);
			}
			else
			{
				if(this.rightTree == null)
				{
					this.rightTree = new BinaryTree(this.depth+1);
				}
				this.rightTree.add(value);
			}
		}
		if(!this.isBalanced())
		{
			//it's not balanced, we need to fix it so run our reBalance program
			System.out.println("HERE");
			this.reBalance();
		}
		
	}
}