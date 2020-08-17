package com.example.jpatransaction.dao;

import com.example.jpatransaction.entity.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

/**
 * @author Incheol Jung
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("select i from Inventory i where i.id = :id")
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="10000")})
    Inventory findOneForUpdate(Integer id);

    @Modifying
    @Query("update Inventory i set i.count = i.count - :count where i.id = :id and (i.count - :count) >= 0")
    int updateInventory(@Param("count") Integer count, @Param("id") Integer id);
}
