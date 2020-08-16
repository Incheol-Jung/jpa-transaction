package com.example.jpatransaction.service;

import com.example.jpatransaction.dao.InventoryRepository;
import com.example.jpatransaction.dao.ItemRepository;
import com.example.jpatransaction.entity.Inventory;
import com.example.jpatransaction.entity.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

/**
 * @author Incheol Jung
 */
@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private InventoryService inventoryService;

    public List<Item> get() {
        return itemRepository.findAll();
    }

    public Item add(Item item) {
        Inventory inventory = inventoryService.save();
        item.setInventory(inventory);
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
