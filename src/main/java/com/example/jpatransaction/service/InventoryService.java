package com.example.jpatransaction.service;

import com.example.jpatransaction.dao.InventoryRepository;
import com.example.jpatransaction.entity.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * @author Incheol Jung
 */
@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private EntityManager entityManager;

    public Inventory save() {
        Inventory inventory = new Inventory();
        inventory.setCount(10);
        return inventoryRepository.save(inventory);
    }

    @Transactional
    public int updateWithLock(int inventoryId, Integer count) throws InterruptedException {
        Inventory inventory = inventoryRepository.findOneForUpdate(inventoryId);
        int updatedCount = inventory.getCount() - count;
        if (updatedCount >= 0) {
            Thread.sleep(5000);
            inventory.setCount(updatedCount);
            return 1;
        } else {
            return 0;
        }
    }

    @Transactional
    public int updateWithJpql(int inventoryId, Integer count) throws InterruptedException {
        return inventoryRepository.updateInventory(count, inventoryId);
    }
}
