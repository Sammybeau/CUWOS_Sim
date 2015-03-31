public class Node extends BinaryTree
{
	private int payload;
	private Node leftNode;
	private Node rightNode;
	private boolean visited;
	private Node parentNode;
	
	
	public Node(int payload)
	{
		this.payload = payload;
		this.leftNode = null;
		this.rightNode = null;
		this.visited = false;
		this.parentNode = null;
		
	}

	public void addNode(Node n)
	{
		if(n.getPayload() <= this.payload)
		{
			if(this.leftNode == null)
			{
				this.leftNode = n;
				n.parentNode = this;
				
			}
			else
			{
				this.leftNode.addNode(n);
			}
		}
		else
		{
			if(this.rightNode == null)
			{
				this.rightNode = n;
				n.parentNode = this;
				
			}
			else
			{
				this.rightNode.addNode(n);
			}
		}
	}
	
	public void trueVisited(Node n)
	{
		this.visited = true;
	}
	
	public Node getLeftNode() 
	{
		return leftNode;
	}

	public void setLeftNode(Node leftNode) 
	{
		this.leftNode = leftNode;
	}

	public Node getRightNode()
	{
		return rightNode;
	}

	public void setRightNode(Node rightNode)
	{
		this.rightNode = rightNode;
	}

	public int getPayload() 
	{
		return payload;
	}

	public boolean getVisited()
	{
		return visited;
	}

	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}

	public Node getParentNode() 
	{
		return parentNode;
	}

	public void setParentNode(Node parentNode) 
	{
		this.parentNode = parentNode;
	}		
}