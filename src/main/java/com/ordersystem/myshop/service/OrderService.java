package com.ordersystem.myshop.service;

import com.ordersystem.myshop.entity.*;
import com.ordersystem.myshop.entity.form.OrderSearch;
import com.ordersystem.myshop.repository.ItemRepository;
import com.ordersystem.myshop.repository.MemberRepository;
import com.ordersystem.myshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    public Long order(Long memberId, Long itemId, int count){

        Optional<Member> findMember = memberRepository.findById(memberId);
        Member member = findMember.orElse(null);

        Optional<Item> findItem = itemRepository.findById(itemId);
        Item item = findItem.orElse(null);

        Delivery delivery = new Delivery(member.getAddress(), DeliveryStatus.READY);

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public void deleteOrder(Order order){
        orderRepository.delete(order);
    }

    public Order findOneById(Long orderId){
        Optional<Order> findOrder = orderRepository.findById(orderId);
        return findOrder.orElse(null);
    }

    public void cancel(Long orderId){
        Optional<Order> findOrder = orderRepository.findById(orderId);
        Order order = findOrder.orElse(null);
        order.cancel();
    }

    public List<Order> findOrders(OrderSearch orderSearch){
        return orderRepository.findAll(orderSearch);
    }

}
