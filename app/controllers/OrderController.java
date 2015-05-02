package controllers;

import model.Order;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import service.OrderManager;

public class OrderController extends Controller {

	private static OrderManager orderManager=new OrderManager();
	
    public static Result getOrderInfo(long id) {
    	Order order=orderManager.getOrder(id);
    	return ok(Json.toJson(order));
    }

}
