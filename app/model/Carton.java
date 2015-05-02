package model;

import java.util.List;

public class Carton {

	private long id;
	private double availableHeight, availableWidth, availableBreadth;
	private boolean isFull=false;
	private List<Order> orders;
	public static final double MAX_HEIGHT=15.0;
	public static final double MAX_WIDTH=30.0;
	public static final double MAX_BREADTH=15.0;
	
	
	public Carton(double availableHeight, double availableWidth,
			double availableBreadth) {
		super();
		this.availableHeight = MAX_HEIGHT;
		this.availableWidth = MAX_WIDTH;
		this.availableBreadth = MAX_BREADTH;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAvailableHeight() {
		return availableHeight;
	}

	public void setAvailableHeight(double availableHeight) {
		this.availableHeight = availableHeight;
	}

	public double getAvailableWidth() {
		return availableWidth;
	}

	public void setAvailableWidth(double availableWidth) {
		this.availableWidth = availableWidth;
	}

	public double getAvailableBreadth() {
		return availableBreadth;
	}

	public void setAvailableBreadth(double availableBreadth) {
		this.availableBreadth = availableBreadth;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public boolean addOrder(Order order){
		if (order.getAggregateHeight() < this.getAvailableHeight()
				&& order.getAggregateWidth() < this.getAvailableWidth()
				&& order.getAggregateBreadth() < this.getAvailableBreadth()) {
			this.orders.add(order);
			availableHeight-=order.getAggregateHeight();
			availableWidth-=order.getAggregateWidth();
			availableBreadth-=order.getAggregateBreadth();
			
			return  true;
		}
		return false;
	}

}
