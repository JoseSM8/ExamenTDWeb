package cl.appweb.service;

import java.util.List;

import cl.appweb.model.dto.CustomersDTO;

public interface CustomersService {
	public List<CustomersDTO> list();
	public CustomersDTO get(int customernumber);
	public int insert(CustomersDTO customersDTO);
	public int update(CustomersDTO customersDTO);
	public int delete(int customernumber);
}
