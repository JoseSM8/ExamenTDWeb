package cl.appweb.service;

import java.util.List;

import cl.appweb.model.dto.OrdersDTO;

public interface OrdersService {
    public List<OrdersDTO>list();
    public List<OrdersDTO>listStatus();
    public List<OrdersDTO> listByStatusCustomerDate(String status, String customernumber, String desde, String hasta);
    public OrdersDTO get(int ordernumber);
    public int insert(OrdersDTO ordersDTO);
    public int update(OrdersDTO ordersDTO);
    public int delete(int ordernumber);
}
