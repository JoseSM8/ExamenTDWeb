package cl.appweb.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.appweb.model.dto.OrdersDTO;
import cl.appweb.service.OrdersService;

@RestController
@RequestMapping(value="/orders")
public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@RequestMapping(value="/list")
	public @ResponseBody List<OrdersDTO> ajaxList(HttpServletRequest req, HttpServletResponse res){
		List<OrdersDTO> list = ordersService.list();
		return list;
	}
	
	@RequestMapping(value="/listStatus")
	public @ResponseBody List<OrdersDTO> ajaxListStatus(HttpServletRequest req, HttpServletResponse res){
		List<OrdersDTO> list = ordersService.listStatus();
		return list;
	}
	
	@RequestMapping(value="/listByStatusCustomer")
	public @ResponseBody List<OrdersDTO> ajaxListByStatusCustomer(HttpServletRequest req, HttpServletResponse res) throws ParseException{
		
		List<OrdersDTO> list = ordersService.listByStatusCustomerDate(req.getParameter("status"),
				req.getParameter("customernumber"),
				req.getParameter("desde"),
				req.getParameter("hasta"));
		return list;
	}
}
