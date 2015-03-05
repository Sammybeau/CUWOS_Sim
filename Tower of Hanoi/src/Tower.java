import java.util.Scanner;

public class Tower 
{
	private Disc top;	
	
	public Tower()
	{
		top = null;		
	}
	
	public Disc peek()
	{
		return top;		
	}
	
	public int pop() throws Exception
	{
		if(this.top == null)
		{
			throw new Exception("Emtpy Stack!!!  Cry More");
		}
		else
		{
			int valToReturn = this.top.getSize();
			this.top = this.top.getNextDisc();
			return valToReturn;
		}
	}	
	
	public Disc removeDisc()
	{
		Disc nodeToReturn = top;
		if(this.top != null)
		{
			top = top.getNextDisc();
		}
		return nodeToReturn;
	} 
	
	public boolean addDisc(Disc d)
	{
		//if there's nothing here then automatically it's legal
		if(this.top == null)
		{
			top = d;
			return true;
		}
		//if it's a legal add, smaller one is on top, then add it to list
		else if(d.getSize() < this.peek().getSize())
		{
			d.setNextDisc(top);
			top = d;
			return true;
		}
		//not legal, don't do anything
		else
		{
			return false;
		}
	}		
	
	
	
	//MAIN CODE HERE 
	public void on() throws Exception
	{
		Scanner input = new Scanner(System.in);
		Tower[] towerArray = new Tower[3];
		towerArray[0] = new Tower();
		towerArray[1] = new Tower();
		towerArray[2] = new Tower();
		towerArray[0].addDisc(new Disc(3));
		towerArray[0].addDisc(new Disc(2));
		towerArray[0].addDisc(new Disc(1));		
		
		while(true)
		{
			//asking us to type something
			System.out.print("=> ");
			
			//goes to next line, gets rid of any spaces
			String val = input.nextLine().trim();
			
			//TYPED IN QUIT 
			//how to stop
			if(val.equalsIgnoreCase("quit"))
			{
				break;
			}
			
			//TYPED IN SHOW
			//our display method
			//should show the current state of the towers, you could show these one on top of another for simplicity
			else if(val.equalsIgnoreCase("show"))
			{
				for(int i = 0; i < towerArray.length; i++)
				{
					if(towerArray[i].top == null)
				
					{
						System.out.println("********");
						System.out.println("Empty Tower");
						System.out.println("****" + i + "****");
					}
					else
					{					
						System.out.println("********");
						Disc curr = towerArray[i].top;
						while(curr != null)
						{
							System.out.println(curr.getSize());
							curr = curr.getNextDisc();
						}
						
						System.out.println("****" + i + "****");						
					}
				}
			}
			
			//TYPED IN MOVE
			//this should prompt the user for the source tower index and the destination tower index and ATTEMPT to make that move. 
			//If the move was legal, output "SUCCESS", otherwise output "FAILURE" and place the disc back on the source tower
			else if(val.equalsIgnoreCase("move"))
			{
				//establishing where we want to move
				System.out.println("Move from?");	
				System.out.print("=> ");								
				int fromIndex = Integer.parseInt(input.nextLine().trim());
				
				System.out.println("Move to?");				
				System.out.print("=> ");								
				int toIndex = Integer.parseInt(input.nextLine().trim());
				
				//if it's an empty list					
				if(towerArray[toIndex].top == null)
				{
					int temp = towerArray[fromIndex].removeDisc().getSize();
					towerArray[toIndex].addDisc(new Disc(temp));	
					System.out.println("Successful Move");
				}
				else
				{
					//if it's a legal move
					if(towerArray[toIndex].top.getSize() > towerArray[fromIndex].top.getSize())
					{
						int temp = towerArray[fromIndex].removeDisc().getSize();
						towerArray[toIndex].addDisc(new Disc(temp));	
						System.out.println("Successful Move");
					}
					//if it's illegal move
					else
					{
						System.out.println("Failure");
					}
				}				
			}		
		}
	}
}