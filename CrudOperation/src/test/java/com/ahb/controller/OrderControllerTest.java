package com.ahb.controller;

import com.ahb.dto.OrderDto;
import com.ahb.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import javax.xml.ws.Response;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testCreateOrder() throws Exception {

        OrderDto orderDto = new OrderDto();
        orderDto.setItemName("Pepsi");
        orderDto.setOrderAmount(95);
        orderDto.setOrderBy("Hammad");
        orderDto.setOrderDate("11-08-2022");
        orderDto.setCity("Pilkhuwa");

        String request = mapper.writeValueAsString(orderDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/order/new").content(request)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }

    @Test
    public void testUpdateOrder() throws Exception {

        OrderDto orderDto = new OrderDto();
        orderDto.setItemName("Pepsi");
        orderDto.setOrderAmount(95);
        orderDto.setOrderBy("Hammad");
        orderDto.setOrderDate("11-08-2022");
        orderDto.setCity("Pilkhuwa");

        String request = mapper.writeValueAsString(orderDto);
        mockMvc.perform(MockMvcRequestBuilders.put("/order/update").param("orderId", String.valueOf(2)).content(request)
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }

    @Test
    public void testGetOrder() throws Exception {

        int orderId = 2;
        mockMvc.perform(MockMvcRequestBuilders.get("/order/get/{orderId}", orderId).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());

    }


    @Test
    public void testRemoveOrder() throws Exception {

        int orderId = 2;
        Mockito.when(orderService.removeOrderById(orderId)).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/order/delete").param("orderId", String.valueOf(orderId)))
                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());
    }

}
