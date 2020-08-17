package com.example.jpatransaction.controller;

import com.example.jpatransaction.entity.Item;
import com.example.jpatransaction.service.ItemService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Incheol Jung
 */
@RestController
@RequestMapping(value = "/items", produces = "application/json")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {this.itemService = itemService;}

    @GetMapping
    public List<Item> get() {
        return itemService.get();
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Item item) {
        Item addedItem = itemService.add(item);
        return ResponseEntity.status(HttpStatus.OK).body(addedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody Item item) {
        itemService.update(id, item);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/inventory/{count}/lock")
    public ResponseEntity updateInventoryWithLock(@PathVariable int id, @PathVariable Integer count) {
        try {
            itemService.updateInventoryWithLock(id, count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/inventory/{count}/jpql")
    public ResponseEntity updateInventoryWithJpql(@PathVariable int id, @PathVariable Integer count) {
        try {
            itemService.updateInventoryWithJpql(id, count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        itemService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
