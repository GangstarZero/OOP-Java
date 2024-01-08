package resto;

import java.util.ArrayList;

public class TheResto {
	public String location;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public ArrayList<Menu> m = new ArrayList<Menu>();
	public ArrayList<TableType> t = new ArrayList<TableType>();
}
