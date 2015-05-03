package service;

import java.util.List;

import model.Item;
import model.Order;

public interface OrderManager {
	public Order createOrder(List<Item> items,String address);
	public Order getOrder(long id);
}
