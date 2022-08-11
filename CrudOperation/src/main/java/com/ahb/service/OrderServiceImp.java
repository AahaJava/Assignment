package com.ahb.service;

import com.ahb.dto.OrderDto;
import com.ahb.entity.OrderEntity;
import com.ahb.exception.InvalidOrderIdException;
import com.ahb.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    OrderRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public OrderDto createNewOrder(OrderDto orderDto) {

        OrderEntity orderEntity = repository.save(getOrderEntityFromDto(orderDto));
        return getOrderDtoFromEntity(orderEntity);
    }

    @Override
    public OrderDto getOrderById(int orderId) {
        Optional<OrderEntity> orderEntityOptional = repository.findById(orderId);
        if(orderEntityOptional.isPresent()){
            OrderEntity orderEntity = orderEntityOptional.get();
            return getOrderDtoFromEntity(orderEntity);
        }else {
            throw new InvalidOrderIdException("Invalid Order Id "+orderId);
        }
    }

    @Override
    public OrderDto updateOrderById(int orderId, OrderDto orderDto) {
        Optional<OrderEntity> orderEntityOptional = repository.findById(orderId);
        if(orderEntityOptional.isPresent()){
            OrderEntity orderEntity = orderEntityOptional.get();

            orderEntity.setOrderAmount(orderDto.getOrderAmount());
            orderEntity.setOrderBy(orderDto.getOrderBy());
            orderEntity.setCity(orderDto.getCity());
            orderEntity.setItemName(orderDto.getItemName());
            orderEntity.setOrderDate(orderDto.getOrderDate());

            orderEntity = repository.save(orderEntity);

            return getOrderDtoFromEntity(orderEntity);
        }else {
            throw new InvalidOrderIdException("Invalid Order Id "+orderId);
        }
    }

    @Override
    public Boolean removeOrderById(int orderId) {

        Optional<OrderEntity> orderEntityOptional = repository.findById(orderId);

        if(orderEntityOptional.isPresent()){
            //repository.delete(orderEntityOptional.get());
            repository.deleteById(orderId);
            return true;
        }
        return false;
    }

    private OrderDto getOrderDtoFromEntity(OrderEntity orderEntity) {

        OrderDto OrderDto = this.modelMapper.map(orderEntity, OrderDto.class);
        return OrderDto;
    }

    private OrderEntity getOrderEntityFromDto(OrderDto orderDto) {

        OrderEntity orderEntity = this.modelMapper.map(orderDto, OrderEntity.class);
        return orderEntity;
    }
}
