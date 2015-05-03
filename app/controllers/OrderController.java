package controllers;

import model.Order;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import service.OrderManagerImpl;

public class OrderController extends Controller {

	private static OrderManagerImpl orderManager=new OrderManagerImpl();
	
    public static Result getOrderInfo(long id) {
    	Order order=orderManager.getOrder(id);
    	return ok(Json.toJson(order));
    }

}
