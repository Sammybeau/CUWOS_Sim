public class OpExpression extends Expression 
{
	private String theOp;
	
	public OpExpression(String theOp)
	{
		this.theOp = theOp;
	}
	
	public String toString()
	{
		return theOp;
	}
}