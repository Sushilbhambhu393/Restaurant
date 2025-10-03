package com.Restaurant.controller;

import com.Restaurant.model.Menu;
import com.Restaurant.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService service;

//    @PostMapping
//    public ResponseEntity<String> MenuService(@RequestBody Menu menu) {
//        service.addMenu(menu);
//        return ResponseEntity.status(201).body("Menu item added successfully");
//    }

//    @GetMapping("get")
//    public ResponseEntity<List<Menu>> getAllMenus(@RequestBody(required = false) Optional<String> id) {
//        if(id.isEmpty()) {
//            return new ResponseEntity<List<Menu>>(service.getAllMenus(id.get()), HttpStatus.ACCEPTED);
//        }
//        List<Menu> menu = service.getAllMenus(id.get()).stream().toList();
//        if (menu.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        }
//        return new ResponseEntity<List<Menu>>(menu, HttpStatus.OK);
//    }
//

    @GetMapping("/getall")
    public List<Menu> getAllMenus(@RequestParam(required = false) Optional<String> id) {
        log.error("hello") ;
        return service.getAllMenus(id.orElse(null));
    }
    @PostMapping("/add")
    public Menu addMenu(@RequestBody Menu menu) {
        return service.addMenu(menu);
    }
}
