package com.example.jpatransaction.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Incheol Jung
 */
@Entity
@Getter
@NoArgsConstructor
public class Inventory {
    @Id
    private int id;
    private int count;
}
