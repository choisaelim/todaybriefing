package com.example.order.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.dto.OrderDto;
import com.example.order.dto.ResponseOrder;
import com.example.order.jpa.OrderEntity;
import com.example.order.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrder(@PathVariable("userId") String userId) {
        Iterable<OrderEntity> orderList = orderService.getOrderByUserId(userId);
        List<ResponseOrder> list = new ArrayList<>();

        orderList.forEach(t -> {
            list.add(new ModelMapper().map(t, ResponseOrder.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(@PathVariable("userId") String userId,
            @RequestBody ResponseOrder orderDetails) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        OrderDto orderDto = mapper.map(orderDetails, OrderDto.class);
        orderDto.setUserId(userId);
        OrderDto createDto = orderService.createOrder(orderDto);

        ResponseOrder res = mapper.map(createDto, ResponseOrder.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

}
