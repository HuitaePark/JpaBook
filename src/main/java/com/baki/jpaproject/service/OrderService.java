package com.baki.jpaproject.service;

import com.baki.jpaproject.domain.Delivery;
import com.baki.jpaproject.domain.Member;
import com.baki.jpaproject.domain.Order;
import com.baki.jpaproject.domain.OrderItem;
import com.baki.jpaproject.domain.OrderSearch;
import com.baki.jpaproject.domain.item.Item;
import com.baki.jpaproject.repository.MemberRepository;
import com.baki.jpaproject.repository.OrderRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemService itemService;

    public OrderService(MemberRepository memberRepository,
                        OrderRepository orderRepository, ItemService itemService) {
        this.memberRepository = memberRepository;
        this.orderRepository = orderRepository;
        this.itemService = itemService;
    }

    public Long Order(Long memberId, Long itemId, int count){

        Member member = memberRepository.findOne(memberId);
        Item item = itemService.findOne(itemId);

        Delivery delivery = new Delivery(member.getAddress());

        OrderItem orderItem = OrderItem.createOrderItem(item,item.getPrice(),count);

        Order order = Order.createOder(member,delivery,orderItem);
        orderRepository.save(order);
        return order.getId();
    }

    public List<Order> findOrders(OrderSearch orderSearch){
        return orderRepository.findAll(orderSearch);
    }
}
