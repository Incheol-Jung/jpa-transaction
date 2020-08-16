package com.example.jpatransaction.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Incheol Jung
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {
    @Id
    private int id;
    private String name;
    private String color;

    @OneToOne
    private Inventory inventory;
}
