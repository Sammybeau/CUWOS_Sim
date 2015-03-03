public class Node 
{
	private Node nextNode;
	private Node prevNode;
	private int payload;

	public Node getPrevNode() 
	{
		return prevNode;
	}

	public void setPrevNode(Node prevNode)
	{
		this.prevNode = prevNode;
	}

	public Node(int payload)
	{
		this.payload = payload;
		this.nextNode = null;
		this.prevNode = null;
	}
 
	public Node getNextNode() 
	{
		return this.nextNode;
	}
 
	public void setNextNode(Node nextNode) 
	{
		this.nextNode = nextNode;
	}
 
	public int getPayload()
	{
		return payload;
	}
}

//please work 2
