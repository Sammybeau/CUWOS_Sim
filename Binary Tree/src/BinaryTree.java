
public class BinaryTree 
{
	private Node root;
	private Node currNode;
	
	public BinaryTree()
	{
		this.root = null;
		currNode = null;
	}
	
	public void displayInOrder()
	{
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			if(currNode.getVisited() == false)
			{
				System.out.print(currNode.getPayload() + ", ");
				currNode.setVisited(true);
			}

			if(currNode.getLeftNode() != null)
			{
				currNode = currNode.getLeftNode();
				displayInOrder();
			}
			
			if(currNode.getRightNode() != null)
			{
				currNode = currNode.getRightNode();
				displayInOrder();
			}
			
			if(currNode.getLeftNode() == null && currNode.getRightNode() == null)
			{
				if(currNode.getParentNode().getLeftNode() != null)
				{
					currNode.getParentNode().setLeftNode(null);
					currNode = root;
					displayInOrder();
				}
				
				else
				{
					currNode.getParentNode().setRightNode(null);
					currNode = root;
					displayInOrder();
				}
			}
		}	
	}
	
	public void displayPostOrder()
	{
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		
		else
		{
			if(currNode.getLeftNode() != null)
			{
				currNode = currNode.getLeftNode();
				displayPostOrder();
			}
			else
			{
				if(currNode.getVisited() == false)
				{
					System.out.print(currNode.getPayload() + ", ");
					currNode.setVisited(true);
					currNode = root;
					displayPostOrder();
				}
				else
				{
					if(currNode.getRightNode() != null)
					{
						currNode = currNode.getRightNode();
						displayPostOrder();
					}
					else
					{
						currNode = currNode.getParentNode();
						if(currNode.getLeftNode() != null)
						{
							currNode.setLeftNode(null);
							currNode = root;
							displayPostOrder();
						}
						else
						{
							currNode.setRightNode(null);
							currNode = root;
							displayPostOrder();
						}
					}
				}
			}
		}
	}
	
	public void add(int value)
	{
		Node theNode = new Node(value);
		if(this.root == null)
		{
			this.root = theNode;
			currNode = this.root;
		}
		else
		{
			this.root.addNode(theNode);
		}
	}
}