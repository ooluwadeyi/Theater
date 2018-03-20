

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainControl {	
	private static  List<Position> layoutList = new ArrayList<Position>();
	private static List<Order> orderList = new ArrayList<Order>();
	private static Layout layout = new Layout();
	private static List<Order> delOrder = new ArrayList<Order>();
	private static List<Position> delPosition = new ArrayList<Position>();	
	


	public static void main(String[] args) throws IOException {		
		// Write the functionalities to read data in 	
		
		System.out.println(" Please Enter the theater layout and ticket requests ");
		
		
		Scanner sc = new Scanner(System.in);
		int row = 1;		
		while(sc.hasNextInt()) {
			
			String[] line = sc.nextLine().split(" ");
			for (int i =0; i < line.length; i++) {
				
				Position pos = new Position(row, i+1, Integer.parseInt(line[i]));
				layoutList.add(pos);
				layout.addCapacity(Integer.parseInt(line[i]));				
			}	
			row++;
		}
		
		System.out.println();	
		
		int index = 1;		
		while(sc.hasNextLine()) {		
			
			String[] str = sc.nextLine().split(" ");
			
			
			if(str.length > 1) {
				
				if(str[0].equals("end") && Integer.parseInt(str[1]) == 0){
					break;
				}
				
				Order order = new Order(index, str[0], Integer.parseInt(str[1]));
				orderList.add(order);
				index++;
				
			}			
			
	}	
		sc.close();		
		
		processRequest();
		
	}
		
	// iterate through the layoutArray to find if there is any row that can fit the requests
			// 
	// if request is equal to availability, remove position from layout, if request is less than availability, decrease availability by request.  
	// find a way of adding all availability and decrease them as they are assigned
	
	// find a way of reducing availability dynamically
	
	public static void processRequest() {
	
		outer:		
		for (Order order : orderList) {			
			for (Position position: layoutList) {					
				int temp1 = order.getRequest();
				int temp2 = position.getAvailability();				
				
				if(temp1 == temp2 && temp1 < layout.getCapacity()){	
					
					order.setPosition(position);
					order.setStatus(Status.HANDLE);
					position.setAvailability(temp2-temp1);
					//System.out.println(position.getAvailability());
					layout.addTreatedOrders(order);					
					layout.decreaseCapacity(temp1);
					// if the number of order request equals the postion availability, remove position and order from their respective arrays
					delPosition.add(position);
					delOrder.add(order);
					
					
					//System.out.println(layout.getCapacity());					
					//System.out.println(ord.getName() + " Row "+ position.getRow() + " Section " + position.getSection());
					continue outer;
				}
											
			}				
		}
		
	orderList.removeAll(delOrder);
	layoutList.removeAll(delPosition);
	delOrder.clear();
	delPosition.clear();
	
	
	outer2:
	for(Order order : orderList) {
		//System.out.println(ord.getIndex());			
		for (Position position: layoutList) {				
			int temp1 = order.getRequest();
			int temp2 = position.getAvailability();	
				
			if(temp1 < temp2) {					
				order.setPosition(position);
				order.setStatus(Status.HANDLE);
				position.setAvailability(temp2-temp1);
				layout.addTreatedOrders(order);
				layout.decreaseCapacity(temp1);
				delOrder.add(order);	
				continue outer2;
			}					
		}
	}
		
	orderList.removeAll(delOrder);
	delOrder.clear();

	for (Order order: orderList) {			
		int temp1 = order.getRequest();		
				
		//if the request is greater than available capacity set Status to OVER
		if(temp1 > layout.getCapacity()) {							
			order.setStatus(Status.OVER);
			layout.addTreatedOrders(order);					
			delOrder.add(order);						
		}
					
	}
	orderList.removeAll(delOrder);
	delOrder.clear();
	
	for (Order order : orderList) {
		
		order.setStatus(Status.SPLIT);
		layout.addTreatedOrders(order);		
	}		
		
	for (Order item : layout.getTreatedOrders()) {
		
		if (item.getStatus().equals(Status.HANDLE)) {
				
			System.out.println(item.getName() + " " + item.getPosition());
		}
		
		if(item.getStatus().equals(Status.SPLIT)) {
			System.out.println(item.getName() + " Call to split party.");
				
		}
		if(item.getStatus().equals(Status.OVER)) {
				
			System.out.println(item.getName() + " Sorry, we can't handle your party.");
		}			
	}
}
	
}

