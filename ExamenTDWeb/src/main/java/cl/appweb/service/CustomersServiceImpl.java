package cl.appweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.appweb.model.dao.CustomersDAO;
import cl.appweb.model.dto.CustomersDTO;

@Service
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	CustomersDAO customersDAO;
	
	@Override
	public List<CustomersDTO> list() {
		return customersDAO.list();
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
