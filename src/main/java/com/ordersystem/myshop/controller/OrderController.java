package com.ordersystem.myshop.controller;

import com.ordersystem.myshop.entity.Item;
import com.ordersystem.myshop.entity.Member;
import com.ordersystem.myshop.entity.Order;
import com.ordersystem.myshop.entity.form.OrderSearch;
import com.ordersystem.myshop.service.ItemService;
import com.ordersystem.myshop.service.MemberService;
import com.ordersystem.myshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final ItemService itemService;
    private final MemberService memberService;
    private final OrderService orderService;

    @GetMapping("/order")
    public String createOrder(Model model){
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);

        List<Item> items = itemService.findAll();
        model.addAttribute("items", items);

        return "order/orderForm";
    }

    @PostMapping("/order")
    public String createOrder(@RequestParam("memberId") Long memberId,
                              @RequestParam("itemId") Long itemId,
                              @RequestParam("count") int count){

        orderService.order(memberId, itemId, count);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model){
        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);
        return "order/orderList";
    }

    @PostMapping("/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId){
        orderService.cancel(orderId);
        return "redirect:/orders";
    }


}
