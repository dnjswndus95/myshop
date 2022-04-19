package com.ordersystem.myshop.service;

import com.ordersystem.myshop.entity.*;
import com.ordersystem.myshop.exception.NotEnoughStockException;
import com.ordersystem.myshop.repository.ItemRepository;
import com.ordersystem.myshop.repository.MemberRepository;
import com.ordersystem.myshop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class OrderServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired OrderService orderService;
    @Autowired OrderRepository orderRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired ItemRepository itemRepository;
    
    @Test
    public void 상품주문() throws Exception{
        Member member = new Member("원주연", new Address("인천시", "송도문화로", "105동"));
        memberRepository.save(member);

        Item item = new Item("TestItem", 10000, 10);
        itemRepository.save(item);

        Long orderId = orderService.order(member.getId(), item.getId(), 5);

        Order findOrder = orderRepository.findById(orderId).get();

        assertEquals(OrderStatus.ORDER, findOrder.getOrderStatus());
        assertEquals(1, findOrder.getOrderItems().size());
        assertEquals(50000, findOrder.getTotalPrice());
        assertEquals(5, item.getStockQuantity());
    }

    @Test
    public void 상품주문_재고수량초과() throws Exception{
        Member member = new Member("원주연", new Address("인천시", "송도문화로", "105동"));
        memberRepository.save(member);

        Item item = new Item("TestItem", 10000, 10);
        itemRepository.save(item);

        int orderCount = 11;

        NotEnoughStockException thrown = assertThrows(NotEnoughStockException.class, () -> orderService.order(member.getId(), item.getId(), orderCount));
        assertEquals("재고가 부족합니다.", thrown.getMessage());
    }


}