package com.Restaurant.service;

import com.Restaurant.model.Menu;
import com.Restaurant.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private final MenuRepository repository;

    public Menu addMenu(Menu menu) {
        return repository.save(menu);
    }
    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public List<Menu> getAllMenus(String s) {
        return repository.findAll();
    }


}
