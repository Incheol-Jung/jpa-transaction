package com.example.jpatransaction.service;

import com.example.jpatransaction.dao.InventoryRepository;
import com.example.jpatransaction.entity.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;

/**
 * @author Incheol Jung
 */
@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory save(){
        Inventory inventory = new Inventory();
        inventory.setCount(0);
        return inventoryRepository.save(inventory);
    }

    @Transactional
    public void update(int inventoryId, Integer count){
        Optional<Inventory> inventory = inventoryRepository.findById(inventoryId);
        inventory.ifPresent(i -> i.setCount(count));
    }
}
