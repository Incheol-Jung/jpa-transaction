package com.example.jpatransaction.service;

import com.example.jpatransaction.dao.InventoryRepository;
import com.example.jpatransaction.entity.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

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
        inventory.setCount(20);
        return inventoryRepository.save(inventory);
    }

    @Transactional
    public int update(int inventoryId, Integer count) throws Exception {
        AtomicInteger resultCount = new AtomicInteger(1);
        Optional<Inventory> inventory = inventoryRepository.findById(inventoryId);
        inventory.orElseThrow(Exception::new);

        inventory.ifPresent(i -> {
            int updatedCount = i.getCount() - count;
            if(updatedCount >= 0){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i.setCount(updatedCount);

                resultCount.set(updatedCount);
            }
        });

        return resultCount.get();
    }
}
