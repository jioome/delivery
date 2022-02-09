package com.jioo.delivery.controller;

import com.jioo.delivery.controller.request.MenuRequest;
import com.jioo.delivery.domain.Menu;
import com.jioo.delivery.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/menu")
    public Menu createMenu(@RequestBody MenuRequest menuRequest) throws Exception {
        return menuService.create(menuRequest);
    }

    @GetMapping("/menu/{id}")
    public Menu readMenu(@PathVariable Long id) {
        return menuService.read(id);
    }

}