package com.ordersystem.myshop.service;


import com.ordersystem.myshop.entity.Item;
import com.ordersystem.myshop.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;

    @Test
    public void saveTest(){
        Item item = new Item("JPA", 20000, 10);
        Long itemId = itemService.save(item);

    }
}