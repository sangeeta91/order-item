package com.order.item.orderitem.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.order.item.orderitem.dtos.ItemDto;
import com.order.item.orderitem.dtos.OrderItemRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderItemControllerTest {
	
	@Autowired
	OrderItemController orderItemController;
	
	@Test
	public void testController() {
		OrderItemRequestDto orderItemRequestDto=new OrderItemRequestDto();
		List<ItemDto> items=new LinkedList<ItemDto>();
		ItemDto i= new ItemDto();
		i.setProductCode(101);
		i.setProductName("amul");
		i.setQuantity(2);
		items.add(i);
		ItemDto i1= new ItemDto();
		i1.setProductCode(102);
		i1.setProductName("butter");
		i1.setQuantity(3);
		items.add(i1);
		orderItemRequestDto.setOrderId(1);
		orderItemRequestDto.setItems(items);
		ResponseEntity<String> result=orderItemController.insertOrderItemDetails(orderItemRequestDto);
		assertTrue(result.getStatusCode().equals(HttpStatus.OK));
		items.add(i1);
		
		
	}

}
