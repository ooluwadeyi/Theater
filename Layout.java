import java.util.ArrayList;
import java.util.List;


public class Layout {
	private static int capacity = 0;
	private List<Order> treatedOrders = new ArrayList<Order>();
	
	public Layout() {			
		
	}
	
	
	public void addCapacity(int capacity) {
		
		Layout.capacity = Layout.capacity + capacity;
	}
	
	
	public void decreaseCapacity(int request) {
		if( request <= capacity) {
			Layout.capacity = Layout.capacity - request;			
		}
		
	}
	public int getCapacity() {
		return capacity;
	}
	
	public void addTreatedOrders(Order order) {
		if(!treatedOrders.contains(order)) {
			
			treatedOrders.add(order);			
		}
		
		
	}

	public List<Order> getTreatedOrders() {
		
		return treatedOrders;
	}
}
 