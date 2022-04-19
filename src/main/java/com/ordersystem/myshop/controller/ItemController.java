package com.ordersystem.myshop.controller;

import com.ordersystem.myshop.entity.DTO.ItemDto;
import com.ordersystem.myshop.entity.Item;
import com.ordersystem.myshop.entity.form.ItemForm;
import com.ordersystem.myshop.repository.ItemRepository;
import com.ordersystem.myshop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final ItemRepository itemRepository;

    @PostMapping("/items/new")
    public String createItem(ItemForm form){
        Item item = new Item(form.getName(), form.getPrice(), form.getStockQuantity());
        itemService.save(item);
        return "redirect:/items";
    }

    @GetMapping("/items/new")
    public String createItemForm(Model model){
        model.addAttribute("itemForm", new ItemForm());
        return "items/createItemForm";
    }

    @GetMapping("/items")
    public String list(Model model){
        List<Item> items = itemService.findAll();
        List<ItemDto> collect = items.stream()
                                .map(i -> new ItemDto(i.getId(), i.getName(), i.getPrice(), i.getStockQuantity()))
                                .collect(Collectors.toList());

        model.addAttribute("items", collect);

        return "items/itemList";
    }

    @GetMapping("/items/{id}/edit")
    public String editItemForm(@PathVariable("id") Long itemId, Model model){
        Item item = itemService.findById(itemId);

        ItemForm itemForm = new ItemForm(item.getId(), item.getName(), item.getPrice(), item.getStockQuantity());
        model.addAttribute("itemForm", itemForm);

        return "items/updateItemForm";
    }

    @PostMapping("/items/{id}/edit")
    public String updateItem(@ModelAttribute("itemForm") ItemForm form){
        itemService.updateItem(form.getId(), form.getName(), form.getPrice(), form.getStockQuantity());
        return "redirect:/items";
    }
}
