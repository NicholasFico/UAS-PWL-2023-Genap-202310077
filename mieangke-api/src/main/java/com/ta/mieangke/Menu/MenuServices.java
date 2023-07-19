package com.ta.mieangke.Menu;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class MenuServices {
    
    @Autowired
    private MenuRepo menuRepo;

    public Menu save(Menu menu){
        return menuRepo.save(menu); //insert & update Query
    }

    public Iterable<Menu> findAll(){
        return menuRepo.findAll(); //select * from menu
    }

    public Menu findOne(int id){
        return menuRepo.findById(id).get();
        //select * from menu where id =1
    }

    public void removeOne(int id){
        menuRepo.deleteById(id);
    }
    
    public Iterable<Menu> findByName(String name){
    return menuRepo.findMenuByName(name);
  }
}



