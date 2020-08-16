package com.example.jpatransaction.service;

import com.example.jpatransaction.dao.InventoryRepository;
import com.example.jpatransaction.entity.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
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
        inventory.setCount(20);
        return inventoryRepository.save(inventory);
    }

    @Transactional
    public int update(int inventoryId, Integer count) throws InterruptedException {
        Inventory inventory = inventoryRepository.findOneForUpdate(inventoryId);
        System.out.println("JPA TRANSACTION TEST REFRESH BEFORE --> " + inventory.toString());
        entityManager.refresh(inventory);
        System.out.println("JPA TRANSACTION TEST REFRESH AFTER --> " + inventory.toString());
        int updatedCount = inventory.getCount() - count;
        if (updatedCount >= 0) {
            Thread.sleep(5000);
            inventory.setCount(updatedCount);
        } else {
            return 0;
        }

        return 1;
    }
}
