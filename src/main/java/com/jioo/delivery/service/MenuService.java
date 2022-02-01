package com.jioo.delivery.service;

import com.jioo.delivery.controller.request.MenuRequest;
import com.jioo.delivery.domain.Menu;
import com.jioo.delivery.domain.Restaurant;
import com.jioo.delivery.domain.User;
import com.jioo.delivery.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private  RestaurantService restaurantService;

    public Menu create(MenuRequest menuParameter) throws Exception {
        final Restaurant restaurant = restaurantService.read(menuParameter.getRestaurantId());
        final Menu menu = new Menu(menuParameter.getName(),menuParameter.getDescription(),menuParameter.getPrice(),restaurant);
        return menuRepository.save(menu);

    }

    public Menu read(Long id){
        return menuRepository.findById(id).orElseThrow(NullPointerException::new);
    }

}
