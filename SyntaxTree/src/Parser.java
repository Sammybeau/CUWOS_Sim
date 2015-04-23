public class Parser
{
	private String theStmt;
	private int pos;
	
	public Parser(String theStmt)
	{
		this.theStmt = theStmt;
		this.pos = 0;
	}
	
	void parse()
	{
		this.parse_stmt();
	}
	
	private void parse_stmt()
	{
		theStmt = theStmt.replaceAll("\\s+","");
		pos = theStmt.indexOf('=');
		System.out.println("Read: VarName = " + theStmt.substring(0,pos));
		System.out.println("------Reading: Math-Expr because of: " + theStmt.charAt(pos));
		pos++;
		parse_math_expr();		
	}
	
	private void parse_math_expr()
	{
		System.out.println("------Reading Left at: "+pos);
		if(theStmt.charAt(pos) == '(')
		{
			System.out.println("------Reading: NEW Math-Expr because of: " + theStmt.charAt(pos));
			pos = pos+1;
			parse_math_expr();
		}
		else
		{
			int op = pos;			
			while("+-*/".indexOf(theStmt.charAt(op)) == -1)
			{
				op++;
			}			
			System.out.println("Read Left: " + theStmt.substring(pos,op));
			pos = op;						
		}		
		
		
		System.out.println("------Reading Op at: "+pos);
		System.out.println("Read Op: " + theStmt.charAt(pos));
		pos++;		
		
		
		System.out.println("------Reading Right at: "+pos);
		if(theStmt.charAt(pos) == '(')
		{
			System.out.println("------Reading: NEW Math-Expr because of: " + theStmt.charAt(pos));
			pos = pos+1;
			parse_math_expr();
		}
		else
		{
			int end = pos;
			while(");".indexOf(theStmt.charAt(end)) == -1)
			{
				end++;
			}
			System.out.println("Read Right: " + theStmt.substring(pos,end));
			if(end+1 < theStmt.length())
			{
				while(theStmt.charAt(end+1) == ')')
				{
					end++;
				}
			}
			pos = end+1;
		}		
	}
}