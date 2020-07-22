package com.order.item.orderitem.service;

import com.order.item.orderitem.dtos.OrderItemRequestDto;

public interface OrderItemService {
	
    public String insertOrderItemDetails(OrderItemRequestDto orderItemRequestDto) throws Exception;
    
    public OrderItemRequestDto getOrderItemDetails(int orderId) throws Exception;
    
}
