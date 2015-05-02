package model;

import java.util.List;

public class Order {
	private long id;
	private List<Item> items;
	private Carton carton;
	private Van van;
	private Slot slot;
	private double aggregateHeight, aggregateWidth, aggregateBreadth;
	private boolean isDelivered;
	private String address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Item> getItems() {
		return items;
	}

	public Carton getCarton() {
		return carton;
	}

	public void setCarton(Carton carton) {
		this.carton = carton;
	}

	public Van getVan() {
		return van;
	}

	public void setVan(Van van) {
		this.van = van;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public double getAggregateHeight() {
		return aggregateHeight;
	}

	public void setAggregateHeight(double aggregateHeight) {
		this.aggregateHeight = aggregateHeight;
	}

	public double getAggregateWidth() {
		return aggregateWidth;
	}

	public void setAggregateWidth(double aggregateWidth) {
		this.aggregateWidth = aggregateWidth;
	}

	public double getAggregateBreadth() {
		return aggregateBreadth;
	}

	public void setAggregateBreadth(double aggregateBreadth) {
		this.aggregateBreadth = aggregateBreadth;
	}

	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void addItem(Item item) {

		double tempHeight = aggregateHeight + item.getHeight();
		double tempWidth = aggregateWidth + item.getWidth();
		double tempBreadth = aggregateBreadth + item.getBreadth();

		if (tempHeight > Carton.MAX_HEIGHT || tempWidth > Carton.MAX_WIDTH
				|| tempBreadth > Carton.MAX_BREADTH) {

			items.add(item);
			aggregateHeight += item.getHeight();
			aggregateWidth += item.getWidth();
			aggregateBreadth += item.getBreadth();

		} else {
			// throw too bigitem exception
		}
	}

	
}
