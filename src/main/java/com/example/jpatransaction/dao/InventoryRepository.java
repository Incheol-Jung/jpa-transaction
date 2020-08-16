package com.example.jpatransaction.dao;

import com.example.jpatransaction.entity.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;

/**
 * @author Incheol Jung
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select i from Inventory i where i.id = :id")
    Inventory findOneForUpdate(Integer id);
}
