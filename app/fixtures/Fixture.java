package fixtures;

import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.Order;

public class Fixture {

	public List<Item> itemsList=new ArrayList<Item>();
	public Order order;
	
	public Fixture() {
		createOrder(createItemlist());
		
	}

	private void createOrder(List<Item> itemlist) {
		//Call ordermanager
	}

	private List<Item> createItemlist() {
		Item item1=new Item();
		item1.setId(0);
		item1.setName("Tomato");
		item1.setHeight(2.0);
		item1.setWidth(2.0);
		item1.setBreadth(2.0);
		
		Item item2=new Item();
		item2.setId(1);
		item2.setName("Potato");
		item2.setHeight(2.0);
		item2.setWidth(3.0);
		item2.setBreadth(2.0);
		
		Item item3=new Item();
		item3.setId(2);
		item3.setName("Gelato");
		item3.setHeight(4.0);
		item3.setWidth(3.0);
		item3.setBreadth(2.0);
		
		itemsList.add(item1);
		itemsList.add(item2);
		itemsList.add(item3);
		return itemsList;
		
	}
	
	
}
