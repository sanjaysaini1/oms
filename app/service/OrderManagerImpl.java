package service;

import java.util.ArrayList;
import java.util.List;

import model.Carton;
import model.Item;
import model.Order;
import model.Slot;
import model.Van;

public class OrderManagerImpl implements OrderManager{

	private static List<Order> orderList = new ArrayList<Order>();

	public Order createOrder(List<Item> items,String address) {
		Order order = new Order();
		for (Item item : items) {
			order.addItem(item);
		}
		makeOrder(order);
		orderList.add(order);
		return order;
	}

	private void makeOrder(Order order) {
		// get a slot
		order.setSlot(SlotManager.getSlot(order.getSlot()));
		// if this slot is not null
		if (order.getSlot() != null) {
			// get an empty van
			order.setVan(getAvailableVan(order.getSlot(), order.getVan()));
			// if van is not null
			if (order.getVan() != null) {
				// get a carton
				order.setCarton(getAvailableCarton(order.getVan(),
						order.getCarton()));
				// if the order is added to the carton
				if (!(order.getCarton().addOrder(order))) {
					makeOrder(order);
				}

			}
			// if van is null get another slot
			else {
				makeOrder(order);
			}
		} else {
			// throw no resource for order exception
		}
	}

	private Carton getAvailableCarton(Van van, Carton carton) {
		for (Carton c : van.getCartonList()) {
			if (c == carton) {
				continue;
			}
			if (!c.isFull()) {
				return c;
			}
		}
		return null;
	}

	private Van getAvailableVan(Slot slot, Van v) {

		for (Van van : slot.getSlotVans()) {
			if (van == v) {
				continue;
			}
			if (!van.isFull())
				return van;
		}
		return null;
	}

	public Order getOrder(long id) {
		for (Order order : orderList) {
			if (order.getId() == id) {
				return order;
			}
		}
		return null;
	}

}
