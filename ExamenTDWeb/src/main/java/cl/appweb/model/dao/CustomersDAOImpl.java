package cl.appweb.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.appweb.model.dto.CustomersDTO;

@Repository
@Transactional
public class CustomersDAOImpl implements CustomersDAO {

	private String list = "SELECT customerNumber,contactfirstname,contactlastname FROM CUSTOMERS";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CustomersDTO> list() {
		List<CustomersDTO> listCustomers = jdbcTemplate.query(list, BeanPropertyRowMapper.newInstance(CustomersDTO.class));
		return listCustomers;
	}

	@Override
	public CustomersDTO get(int customernumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(CustomersDTO customersDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CustomersDTO customersDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int customernumber) {
		// TODO Auto-generated method stub
		return 0;
	}

}
