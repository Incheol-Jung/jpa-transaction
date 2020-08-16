package com.example.jpatransaction.service;

import com.example.jpatransaction.dao.ItemRepository;
import com.example.jpatransaction.entity.Item;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Incheol Jung
 */
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {this.itemRepository = itemRepository;}

    public List<Item> get() {
        return itemRepository.findAll();
    }

    public Item add(Item item) {
        return itemRepository.save(item);
    }

    public void update(int id, Item item) {
        Item updatedItem = itemRepository.getOne(id);
        updatedItem.setName(item.getName());
        updatedItem.setColor(item.getColor());

        itemRepository.save(updatedItem);
    }

    public void delete(int id) {
        itemRepository.deleteById(id);
    }
}
