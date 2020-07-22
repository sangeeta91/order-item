package com.order.item.orderitem.controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.item.orderitem.dtos.ItemDto;
import com.order.item.orderitem.dtos.OrderItemRequestDto;
import com.order.item.orderitem.service.OrderItemService;

@RequestMapping("/order/items")
@RestController
public class OrderItemController {
	
	@Autowired
	OrderItemService orderItemService;
	
	@PutMapping(value="/insertOrderItems",produces="application/json;charset=UTF-8")
	public ResponseEntity<String> insertOrderItemDetails(@Valid @RequestBody OrderItemRequestDto orderItemRequestDto){
		try {
			String result=orderItemService.insertOrderItemDetails(orderItemRequestDto);
			return new ResponseEntity<>(result,HttpStatus.CREATED);

		}
		catch(Exception e) {
			return new ResponseEntity<>("insert_fail",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="/getOrderItems/{orderId}",produces="application/json;charset=UTF-8")
	public ResponseEntity<OrderItemRequestDto> getOrderItemDetails(@PathVariable ("orderId") int orderId){
		try {
			OrderItemRequestDto orderItemRequestDto=orderItemService.getOrderItemDetails(orderId);
			return new ResponseEntity<>(orderItemRequestDto,HttpStatus.OK);

		}
		catch(Exception e) {
			return new ResponseEntity<>(new OrderItemRequestDto(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
