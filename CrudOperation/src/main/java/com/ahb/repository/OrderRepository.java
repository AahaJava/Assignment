package com.ahb.repository;

import com.ahb.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {


}
