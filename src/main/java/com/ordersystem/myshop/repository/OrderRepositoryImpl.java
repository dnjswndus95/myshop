package com.ordersystem.myshop.repository;

import com.ordersystem.myshop.entity.Order;
import com.ordersystem.myshop.entity.OrderStatus;
import com.ordersystem.myshop.entity.QMember;
import com.ordersystem.myshop.entity.QOrder;
import com.ordersystem.myshop.entity.form.OrderSearch;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.ordersystem.myshop.entity.QMember.member;
import static com.ordersystem.myshop.entity.QOrder.order;

public class OrderRepositoryImpl implements OrderRepositoryCustom{

    @Autowired
    EntityManager em;

    @Override
    public List<Order> findAll(OrderSearch orderSearch) {

        JPAQueryFactory query = new JPAQueryFactory(em);

        QOrder order = QOrder.order;
        QMember member = QMember.member;

        return query.select(order)
                .from(order)
                .join(order.member, member)
                .where(statusEq(orderSearch.getOrderStatus()),
                        nameLike(orderSearch.getMemberName()))
                .fetch();
       
    }

    private BooleanExpression nameLike(String nameCond) {
        if(!StringUtils.hasText(nameCond))
            return null;

        return member.username.like(nameCond);
    }

    private BooleanExpression statusEq(OrderStatus statusCond) {
        if(statusCond == null)
            return null;

        return order.orderStatus.eq(statusCond);
    }
}
