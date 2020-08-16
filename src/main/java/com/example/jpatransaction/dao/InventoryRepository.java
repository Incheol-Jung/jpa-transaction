package com.example.jpatransaction.dao;

import com.example.jpatransaction.entity.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Incheol Jung
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {}
