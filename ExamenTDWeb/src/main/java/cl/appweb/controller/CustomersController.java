package cl.appweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.appweb.model.dto.CustomersDTO;
import cl.appweb.service.CustomersService;

@RestController
@RequestMapping(value="/customers")
public class CustomersController {

	@Autowired
	CustomersService customersService;
	
	@RequestMapping(value="/list")
	public @ResponseBody List<CustomersDTO> ajaxList(HttpServletRequest req, HttpServletResponse res){
		List<CustomersDTO> list = customersService.list();
		return list;
	}
	
}
