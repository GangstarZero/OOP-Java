package resto;

public class TableType extends TheResto{
	public int people;
	public String status;

	public String tableType(int people)
	{
		if(people <= 2)
		{
			return "Romantic Table";
		}
		else if(people <= 4)
		{
			return "General Table";
		}
		else if(people > 4 && people <= 10)
		{
			return "Family Table";
		}
		else {
			return "Table not valid";
		}
		
	}
}
