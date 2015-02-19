public class Node 
{
	private Node nextNode;
	private int payload;
	
	public Node(int payload)
	{
		this.payload = payload;
		this.nextNode = null;
	}
 
	public Node getNextNode() 
	{
		return this.nextNode;
	}
 
	public void setNextNode(Node nextNode) 
	{
		this.nextNode = nextNode;
	}
 
	public int getPayload() {
		return payload;
	}
	
	
	
}
