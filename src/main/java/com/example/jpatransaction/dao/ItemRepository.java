package com.example.jpatransaction.dao;

import com.example.jpatransaction.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Incheol Jung
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {}
