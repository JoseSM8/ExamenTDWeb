package cl.appweb.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.appweb.model.dto.OrdersDTO;

@Repository
@Transactional
public class OrdersDAOImpl implements OrdersDAO {
	
	private String list   =	"Select ORDERNUMBER, ORDERDATE, REQUIREDDATE, SHIPPEDDATE, STATUS, CUSTOMERNUMBER \r\n" + 
							"FROM ORDERS\r\n";
	private String listSC =	"Select ORDERNUMBER, ORDERDATE, REQUIREDDATE, SHIPPEDDATE, STATUS, CUSTOMERNUMBER \r\n" + 
							"FROM ORDERS\r\n" + 
							"WHERE status like ? and customernumber like ? and orderdate between ? and ?";
	private String all    = "%";
	private String inicio = "01/01/2000";
	private String fin    = "01/01/2020";
	private String status = "Select DISTINCT STATUS FROM ORDERS";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<OrdersDTO> list() {
		List<OrdersDTO> listOrders = jdbcTemplate.query(list, BeanPropertyRowMapper.newInstance(OrdersDTO.class));
		return listOrders;
	}

	@Override
	public List<OrdersDTO> listStatus() {
		List<OrdersDTO> listStatus= jdbcTemplate.query(status, BeanPropertyRowMapper.newInstance(OrdersDTO.class));
		return listStatus;
	}
	
	@Override
	public List<OrdersDTO> listByStatusCustomerDate(String status, String customernumber, String desde, String hasta) {
		if(status.equals("Seleccione Estado")) {status = all;}
		if(customernumber.equals("Seleccione Cliente")) {customernumber = all;}
		if(desde.isEmpty()) {desde = inicio;}
		if(hasta.isEmpty()) {hasta = fin;}
		
		System.out.println(status + " " + customernumber + " " + desde + " " + hasta);
		
		Object args[] = {status, customernumber, desde, hasta};
		List<OrdersDTO> liststcu= jdbcTemplate.query(listSC, args, BeanPropertyRowMapper.newInstance(OrdersDTO.class));
		return liststcu;
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
