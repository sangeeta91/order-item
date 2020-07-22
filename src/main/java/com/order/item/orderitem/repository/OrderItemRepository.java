package com.order.item.orderitem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.item.orderitem.entity.OrderItemEntity;
import com.order.item.orderitem.entity.OrderItemKey;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemKey>{
	
	@Query(value="select order_id,product_code,product_name,quantity from order_items where order_id=?1",nativeQuery=true)
	List<OrderItemEntity> findByOrderItemKeyOrderId(int orderId);
	

}
