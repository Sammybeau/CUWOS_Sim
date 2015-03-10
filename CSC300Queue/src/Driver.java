public class Driver 
{
	public static void main(String[] args) throws Exception
	{
		Queue q= new Queue();
		for(int i = 1; i < 101; i++)
		{
			Person p = new Person("Person " + i);
			q.enqueue(p);
		}
		for (int j = 1; j <101; j++)
		{
			q.dequeue().display();
		}
		q.dequeue().display();
	}
}