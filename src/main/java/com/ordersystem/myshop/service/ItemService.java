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
@Transactional(readOnly = true)
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

    public Optional<Item> findOne(Long itemId){
        return itemRepository.findById(itemId);
    }

    public void delete(Item item){
        itemRepository.delete(item);
    }


}
