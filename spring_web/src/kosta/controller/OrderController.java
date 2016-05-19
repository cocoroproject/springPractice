package kosta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kosta.model.Order;
import kosta.service.OrderService;

@Controller
public class OrderController {

	private OrderService orderService;
	
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping("/orderForm")
	public String orderForm(){
		return "transaction/orderForm.jsp";
	}
	
	@RequestMapping("/order")
	public String order_do(Order order){
		String view_name = "transaction/orderOk.jsp";
		try {
			orderService.orderAction(order);
		} catch (Exception e) {
			view_name = "transaction/orderForm.jsp";
		}
		
		return view_name;
	}	
}
