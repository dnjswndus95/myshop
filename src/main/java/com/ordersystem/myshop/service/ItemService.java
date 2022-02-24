package com.ordersystem.myshop.service;

import com.ordersystem.myshop.entity.Item;
import com.ordersystem.myshop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Long save(Item item){
        itemRepository.save(item);
        return item.getId();
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }

    public Item findById(Long itemId){
        Optional<Item> items = itemRepository.findById(itemId);
        Item item = items.orElse(null);
        return item;
    }

    public void updateItem(Long id, String name, int price, int stockQuantity){
        Optional<Item> findItem = itemRepository.findById(id);
        Item item = findItem.orElse(null);
        item.updateItem(name, price, stockQuantity);
    }

    public void delete(Item item){
        itemRepository.delete(item);
    }


}
