package com.example.jpatransaction.entity;

import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Incheol Jung
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
//@OptimisticLocking(type = OptimisticLockType.VERSION)
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int count;

//    @Version
//    private int version;
}
