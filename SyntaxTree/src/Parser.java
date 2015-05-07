public class Parser 
{
	private String theStmt;
	private int pos;
	private static final String legalVariableCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ "; 
	private static final String legalLiteralCharacter = "0123456789 ";
	private static final String legalSymbolCharacters = Parser.legalVariableCharacters + Parser.legalLiteralCharacter;
	private static final String legalOpCharacters = "+-*/% ";
	private VarDefStatement theSyntaxTree;
	private VarDefStatement secondSyntaxTree;
	private Variable theVariable;

	public Parser(String theStmt)
	{
		this.theStmt = theStmt;
		this.theSyntaxTree = null;
		this.secondSyntaxTree = null;
		this.theVariable = null;
		this.pos = 0;
	}

	public VarDefStatement getTheSyntaxTree() {
		return theSyntaxTree;
	}

	public VarDefStatement getSecondSyntaxTree() {
		return secondSyntaxTree;
	}

	void parse()
	{
		this.theSyntaxTree = this.parse_stmt();
		if(this.theSyntaxTree != null && this.pos != this.theStmt.length())
		{
			this.secondSyntaxTree = this.parse_stmt();
		}
	}

	private String getNextToken(char c)
	{
		while(pos < this.theStmt.length())
		{
			if(this.theStmt.charAt(pos) == c)
			{
				pos++;
				break;
			}
			pos++;
		}
		return "" + c;
	}

	private String getNextToken(String legalChars)
	{
		String token = "";
		while(pos < this.theStmt.length())
		{
			if(legalChars.indexOf(this.theStmt.charAt(pos)) != -1)
			{
				token += this.theStmt.charAt(pos);
			}
			else
			{
				break;
			}
			pos++;
		}
		return token.trim();
	}

	private VarDefStatement parse_stmt()
	{
		String varName = this.getNextToken(Parser.legalVariableCharacters);
		System.out.println("Read VarName: " + varName);
		VarExpression theVE = new VarExpression(varName);

		this.getNextToken('=');
		System.out.println("Burned =");
		
		if (theSyntaxTree == null)
		{
			String varNum = this.getNextToken(Parser.legalLiteralCharacter);
			varNum.trim();

			if(isVariable(varNum))
			{
				int variableNum = Integer.parseInt(varNum);
				System.out.println("Variable Number: " + variableNum);
				theVariable = new Variable(varName, variableNum);

				pos++;
				pos++;
				return new VarDefStatement(theVariable);
			}
		}

		MathExpression theME = this.parse_math_expr();
		
		System.out.println("The Right Side Math is: " + theME.doMath(theVariable));

		this.getNextToken(';');
		System.out.println("Burned ;");

		return new VarDefStatement(theVE, theME);
	}

	private boolean isVariable(String symbol)
	{
		symbol = symbol.trim();
		for(int i = 0; i < symbol.length(); i++)
		{
			if(Parser.legalLiteralCharacter.indexOf(symbol.charAt(i)) == -1 )
			{
				return false;
			}
		}
		return true;
	}

	private boolean isVarExpression(String symbol)
	{
		for(int i = 0; i < symbol.length(); i++)
		{
			if(Parser.legalVariableCharacters.indexOf(symbol.charAt(i)) == -1 || symbol.charAt(i) == ' ')
			{
				return false;
			}
		}
		return true;
	}

	private MathExpression parse_math_expr()
	{
		String symbol = this.getNextToken(Parser.legalSymbolCharacters);
		Expression leftOperand = null;
		Expression rightOperand = null;
		OpExpression theOpExpression = null;

		if(symbol.length() == 0)
		{
			this.getNextToken('(');
			System.out.println("Burned (");
			leftOperand = this.parse_math_expr();
			this.getNextToken(')');
			System.out.println("Burned )");
		}
		else
		{
			if(this.isVarExpression(symbol))
			{
				System.out.println("Read VarExpression: " + symbol);
				leftOperand = new VarExpression(symbol);
			}
			else
			{
				System.out.println("Read LitExpression: " + symbol);
				leftOperand = new LitExpression(Integer.parseInt(symbol));
			}
		}
		String op = this.getNextToken(Parser.legalOpCharacters);
		System.out.println("Read Op: " + op);
		theOpExpression = new OpExpression(op.charAt(0));

		symbol = this.getNextToken(Parser.legalSymbolCharacters);
		if(symbol.length() == 0)
		{
			this.getNextToken('(');
			rightOperand = this.parse_math_expr();
			this.getNextToken(')');
		}
		else
		{
			if(this.isVarExpression(symbol))
			{
				System.out.println("Read VarExpression: " + symbol);
				rightOperand = new VarExpression(symbol);
			}
			else
			{
				System.out.println("Read LitExpression: " + symbol);
				rightOperand = new LitExpression(Integer.parseInt(symbol));
			}
		}
		return new MathExpression(leftOperand, rightOperand, theOpExpression);
	}
}