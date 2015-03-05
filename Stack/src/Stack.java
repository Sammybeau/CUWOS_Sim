public class Stack 
{
	private Node top;
	
	public Stack()
	{
		this.top = null;
	}
	
	public boolean isEmpty()
	{
		return this.top == null;
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
	
	public int pop() throws Exception
	{
		if(this.top == null)
		{
			throw new Exception("Emtpy Stack!!!  Cry More");
		}
		else
		{
			int valToReturn = this.top.getPayload();
			this.top = this.top.getNextNode();
			return valToReturn;
		}
	}
	
	public int peek() throws Exception
	{
		if(this.top == null)
		{
			throw new Exception("Emtpy Stack!!!  Cry More");
		}
		else
		{
			return this.top.getPayload();
		}
	}
}