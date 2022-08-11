package com.ahb.controller;

import com.ahb.dto.OrderDto;
import com.ahb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/new")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
       return new ResponseEntity<OrderDto>(orderService.createNewOrder(orderDto), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{orderId}")
    public ResponseEntity<OrderDto>  getOrder(@PathVariable("orderId") int orderId){
        return new ResponseEntity<OrderDto>(orderService.getOrderById(orderId), HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<OrderDto> updateOrder(@RequestParam("orderId") int orderId, @RequestBody OrderDto orderDto){
        return new ResponseEntity<OrderDto>(orderService.updateOrderById(orderId, orderDto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Boolean> deleteOrder(@RequestParam("orderId") int orderId){
        return new ResponseEntity<Boolean>(orderService.removeOrderById(orderId), HttpStatus.OK);
    }

}
