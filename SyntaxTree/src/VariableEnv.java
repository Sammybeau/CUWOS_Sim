public class VariableEnv 
{
	private Variable[] variableArray;
	
	
	public VariableEnv(Variable theVariable)
	{
		Variable[] variableArray = new Variable[1];
		this.variableArray = variableArray;
		this.variableArray[0] = theVariable;
	}

	public Variable[] getVariableArray() 
	{
		return variableArray;
	}
}