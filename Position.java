
public class Position {
	
	private int row;
	private int section;
	
	private int availability;
	
	
	
	public Position(int row, int section, int availability) {
		this.row = row;		
		this.section = section;
		this.availability = availability;
		
		
	}
	
	public Position() {
		
		
	}

	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getSection() {
		return section;
	}


	public void setSection(int section) {
		this.section = section;
	}


	public int getAvailability() {
		return availability;
	}


	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	
	
	
	public String toString() {
		return " Row " + row + " Section " + section ;
	}	

}
