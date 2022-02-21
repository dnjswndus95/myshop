package com.ordersystem.myshop;

import com.ordersystem.myshop.entity.Address;
import com.ordersystem.myshop.entity.Item;
import com.ordersystem.myshop.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@RequiredArgsConstructor
public class InitDB {
    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        @PersistenceContext
        private final EntityManager em;
        public void dbInit(){
            Member member = createMember("userA", "서울", "강남대로", "1111");
            em.persist(member);

            Member member1 = createMember("userB", "인천", "송도문화로", "81");
            em.persist(member1);

            Item book1 = createBook("JPA1 BOOK", 10000);
            em.persist(book1);

            Item book2 = createBook("JPA2 BOOK", 20000);
            em.persist(book2);

            Item book3 = createBook("SPRING1 BOOK", 15000);
            em.persist(book3);

            Item book4 = createBook("SPRING2 BOOK", 25000);
            em.persist(book4);

          /*  OrderItem orderItem1 = OrderItem.createOrderItem(book1, 10000, 5);
            OrderItem orderItem2 = OrderItem.createOrderItem(book2, 20000, 10);

            OrderItem orderItem3 = OrderItem.createOrderItem(book3, 15000, 5);
            OrderItem orderItem4 = OrderItem.createOrderItem(book4, 25000, 10);

            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            Order order1 = Order.createOrder(member, delivery, orderItem1, orderItem2);

            em.persist(order1);

            Delivery delivery1 = new Delivery();
            delivery1.setAddress(member1.getAddress());
            Order order2 = Order.createOrder(member1, delivery1, orderItem3, orderItem4);

            em.persist(order2);
*/

        }

        private Item createBook(String s, int i) {
            Item book1 = new Item(s, i, 20);
            return book1;
        }

        private Member createMember(String userA, String 서울, String 강남대로, String s) {
            Member member = new Member(userA, new Address(서울, 강남대로, s));
            return member;
        }
    }

}
