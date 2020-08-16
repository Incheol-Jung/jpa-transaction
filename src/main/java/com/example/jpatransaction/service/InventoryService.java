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
        entityManager.refresh(inventory);
        System.out.println("0000 current count = " + inventory.getCount());

        int updatedCount = inventory.getCount() - count;
        System.out.println("1111 updatedCount = " + updatedCount);
        if (updatedCount >= 0) {
            Thread.sleep(5000);
            inventory.setCount(updatedCount);
            System.out.println("2222 update inventory = " + inventory.getCount());
            inventoryRepository.saveAndFlush(inventory);
        } else {
            System.out.println("can not update!!!!!!!!!!!!!!!!!!!!!!!! currentCount == " + inventory.getCount());
            return 0;
        }

        return 1;
    }
}
