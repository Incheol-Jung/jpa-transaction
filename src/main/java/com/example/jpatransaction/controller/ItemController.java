package com.example.jpatransaction.controller;

import com.example.jpatransaction.entity.Item;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Incheol Jung
 */
@RestController
public class ItemController {
    @GetMapping()
    public List<Item> get() {
        return new ArrayList<Item>();
    }
}
