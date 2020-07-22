package com.order.item.orderitem.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.order.item.orderitem.dtos.ItemDto;
import com.order.item.orderitem.dtos.OrderItemRequestDto;
import com.order.item.orderitem.entity.OrderItemEntity;
import com.order.item.orderitem.entity.OrderItemKey;
import com.order.item.orderitem.repository.OrderItemRepository;
import com.order.item.orderitem.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService{
	
	@Autowired
	OrderItemRepository orderItemRepository;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public String insertOrderItemDetails(OrderItemRequestDto orderItemRequestDto) throws Exception {
		try {
			List<OrderItemEntity> orderItems=new LinkedList<>();
			for(ItemDto i:orderItemRequestDto.getItems()) {
				OrderItemKey orderItemKey=new OrderItemKey();
				orderItemKey.setOrderId(orderItemRequestDto.getOrderId());
				orderItemKey.setProductCode(i.getProductCode());
				
				OrderItemEntity orderItemEntity=new OrderItemEntity(orderItemKey,i.getProductName(),i.getQuantity());
				orderItems.add(orderItemEntity);
			}
			orderItemRepository.saveAll(orderItems);
		}catch(Exception e) {
			throw e;
		}
		return "success";
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public OrderItemRequestDto getOrderItemDetails(int orderId) throws Exception {
		OrderItemRequestDto orderItemResponseDto=new OrderItemRequestDto();
		try {
			
			 List<OrderItemEntity> result=orderItemRepository.findByOrderItemKeyOrderId(orderId);
			 List<ItemDto> items=result.stream().map(i->{
				 ItemDto itm=new ItemDto();
				 itm.setProductCode(i.getId().getProductCode());
				 itm.setProductName(i.getProductName());
				 itm.setQuantity(i.getQuantity());
				 return itm;
			 }).collect(Collectors.toList());
			 
			 orderItemResponseDto.setItems(items);
			 orderItemResponseDto.setOrderId(result.get(0).getId().getOrderId());
		}
		catch(Exception e) {
			throw e;
		}
		
		
		return orderItemResponseDto;
	}

}
