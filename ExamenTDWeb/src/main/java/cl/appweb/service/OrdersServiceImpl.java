package cl.appweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.appweb.model.dao.OrdersDAO;
import cl.appweb.model.dto.OrdersDTO;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersDAO orderDAO;
	
	@Override
	public List<OrdersDTO> list() {
		return orderDAO.list();
	}

	@Override
	public List<OrdersDTO> listStatus() {
		return orderDAO.listStatus();
	}
	
	@Override
	public List<OrdersDTO> listByStatusCustomerDate(String status, String customernumber, String desde, String hasta) {
		return orderDAO.listByStatusCustomerDate(status, customernumber, desde, hasta);
	}
	
	@Override
	public OrdersDTO get(int ordernumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(OrdersDTO ordersDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(OrdersDTO ordersDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int ordernumber) {
		// TODO Auto-generated method stub
		return 0;
	}
}
