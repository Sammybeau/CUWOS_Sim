
public class Stack 
{
	private Node top;
	
	public Stack()
	{
		this.top = null;
	}
	
	public void push(int payload)
	{
		Node n = new Node(payload);
		if(this.top == null)
		{
			this.top = n;
		}
		else
		{
			n.setNextNode(this.top);
			this.top = n;
		}
	}
	
	public int pop()
	{
		int poppedInt = this.top.getPayload();
		this.top = this.top.getNextNode();
		return poppedInt;
	}
	
	public int peek()
	{
		return this.top.getPayload();
	}

}
