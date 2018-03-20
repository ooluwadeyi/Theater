
public class Order {
	
	private String name;
	private int request;
	private int index;
	private Position position;
	private Status status;  

	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Order(int index, String name, int request) {
		
		this.name = name;
		this.request = request;
		this.index = index;
		
	}

	public int getIndex() {
		return this.index;
	}

	public  void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRequest() {
		return request;
	}

	public void setRequest(int request) {
		this.request = request;
	}
	
	public void setPosition(Position position) {
		
		this.position = position;
	}
	
	public Position getPosition() {
		
		return position;
	}

	
	public String toString() {
		return "Order [name=" + name + ", request=" + request + "]";
	}

}
