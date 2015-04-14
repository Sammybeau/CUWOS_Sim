public class BinaryTree 
{		
	private Boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	private BinaryTree parent;
	private int depth;

	public BinaryTree()
	{
		this(0);	
	}

	private BinaryTree(int depth)
	{
		this.isEmpty = true;
		this.leftTree = null;
		this.rightTree = null;
		this.depth = depth;
		this.parent = null; 
	}
	private void  updateDepths(int newDepth)
	{
		this.depth = newDepth;
		if(this.leftTree != null)
		{
			this.leftTree.updateDepths(this.depth+1);
		}
		if(this.rightTree != null)
		{
			this.rightTree.updateDepths(this.depth+1);
		}
	}

	public boolean search(int value)
	{
		if(this.isEmpty)
		{
			return false;
		}
		else
		{
			if(this.payload == value)
			{
				return true;
			}
			else
			{
				if(value < payload)
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
				else
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
		}
	}

	private void visitInOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitInOrder();
		}
		System.out.println(this.payload + " : " + this.depth);
		if(this.rightTree != null)
		{
			this.rightTree.visitInOrder();
		}
	}

	public void visitPreOrder()
	{
		System.out.println(this.payload + " : " + this.depth);
		if(this.leftTree != null)
		{
			this.leftTree.visitPreOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPreOrder();
		}
	}

	public void visitPostOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitPostOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPostOrder();
		}
		System.out.println(this.payload + " : " + this.depth);
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

	private int getMaxDepth()
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
			int currMaxLeftDepth = this.leftTree == null?0:this.leftTree.getMaxDepth();
			int currMaxRightDepth = this.rightTree == null?0:this.rightTree.getMaxDepth();
			System.out.println("Max Left = " + currMaxLeftDepth);
			System.out.println("Max Right = " + currMaxRightDepth);
			return Math.abs(currMaxLeftDepth - currMaxRightDepth) <= 1;
		}	
	}

	private void rotateRight(BinaryTree pivot)
	{
		BinaryTree pivRT = null;
		BinaryTree pivP = null;
		BinaryTree pivGP = null;

		if(pivot.rightTree != null)
		{
			pivRT = pivot.rightTree;
			pivot.rightTree = null;
		}
		pivP = pivot.parent;
		pivGP = (pivP == null?null:pivP.parent);
		if(pivGP != null)
		{
			if(pivGP.leftTree == pivP)
			{
				pivGP.leftTree = pivot;
			}
			else
			{
				pivGP.rightTree = pivot;
			}
			pivot.parent = pivGP;
		}
		else
		{
			pivot.parent = null;
		}
		if(pivP == null)
		{
			System.err.println("I have no parent...should I be calling rotate right?");
			return;
		}
		else
		{
			pivP.leftTree = pivRT;
		}
		pivot.rightTree = pivP;
		pivP.parent = pivot;

		pivot.updateDepths(pivot.depth-1);
	}

	private void rotateLeft(BinaryTree pivot)
	{
		BinaryTree pivLT = null;
		BinaryTree pivP = null;
		BinaryTree pivGP = null;

		if(pivot.leftTree != null)
		{
			pivLT = pivot.leftTree;
			pivot.leftTree = null;
		}
		pivP = pivot.parent;
		pivGP = (pivP == null?null:pivP.parent);
		if(pivGP != null)
		{
			if(pivGP.leftTree == pivP)
			{
				pivGP.leftTree = pivot;
			}
			else
			{
				pivGP.rightTree = pivot;
			}
			pivot.parent = pivGP;
		}
		else
		{
			pivot.parent = null;
		}
		if(pivP == null)
		{
			System.err.println("I have no parent...should I be calling rotate left?");
			return;
		}
		else
		{
			pivP.rightTree = pivLT;
		}
		pivot.leftTree = pivP;
		pivP.parent = pivot;		

		pivot.updateDepths(pivot.depth-1);
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
					this.leftTree.parent = this;
				}
				this.leftTree.add(value);
			}
			else
			{
				if(this.rightTree == null)
				{
					this.rightTree = new BinaryTree(this.depth+1);
					this.rightTree.parent = this;
				}
				this.rightTree.add(value);
			}
		}

		if(this.parent == null)
		{
			if(!this.isBalanced())
			{
				if(this.leftTree == null)
				{
					if (this.rightTree.leftTree == null)
					{
						this.rightTree.rotateLeft(this.rightTree);
					}
					else
					{
						this.rightTree.rotateRight(this.rightTree.leftTree);
						this.rightTree.rotateLeft(this.rightTree);
					}
				}
				else if(this.rightTree == null)
				{
					if (this.leftTree.rightTree == null)
					{
						this.rightTree.rotateLeft(this.leftTree);
					}
					else
					{
						this.leftTree.rotateLeft(this.leftTree.rightTree);
						this.leftTree.rotateRight(this.leftTree);
					}
				}
				else
				{
					if(this.leftTree.getMaxDepth() > this.rightTree.getMaxDepth())
					{
						if (this.leftTree.rightTree == null)
						{
							this.rightTree.rotateLeft(this.leftTree.leftTree);
						}
						else if(this.leftTree.rightTree != null && this.leftTree.leftTree != null)
						{
							this.leftTree.rotateRight(this.leftTree);
						}
						else
						{
							this.leftTree.rotateLeft(this.leftTree.rightTree);
							this.leftTree.rotateRight(this.leftTree);
						}
					}
					else
					{
						if (this.rightTree.leftTree == null)
						{
							this.rightTree.rotateLeft(this.rightTree.rightTree);
						}
						else if(this.rightTree.leftTree != null && this.rightTree.rightTree != null)
						{
							this.rightTree.rotateLeft(this.rightTree);
						}
						else
						{
							this.rightTree.rotateRight(this.rightTree.leftTree);
							this.rightTree.rotateLeft(this.rightTree);
						}
					}
				}
			}
		}
	}
}