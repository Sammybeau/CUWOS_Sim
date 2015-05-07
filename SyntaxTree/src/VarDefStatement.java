public class VarDefStatement
{
	private VarExpression theVarExpr;
	private MathExpression theMathExpr;
	private Variable theVariable;
	
	public VarDefStatement(VarExpression theVarExpr, MathExpression theMathExpr)
	{
		this.theVarExpr = theVarExpr;
		this.theMathExpr = theMathExpr;
	}
	
	public VarDefStatement(Variable theVariable)
	{
		this.theVariable = theVariable;
	}
	
	public String toString()
	{
		if(theMathExpr != null)
		{
			return "Original Statement: " + this.theVarExpr.toString() + " = " + this.theMathExpr.toString() + ";";
		}
		else
		{
			return this.theVariable.toString();
		}
	}
}