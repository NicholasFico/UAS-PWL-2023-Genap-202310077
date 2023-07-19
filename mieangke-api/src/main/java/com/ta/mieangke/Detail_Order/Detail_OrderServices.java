package com.ta.mieangke.Detail_Order;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class Detail_OrderServices {
    
    @Autowired
    private Detail_OrderRepo detail_OrderRepo;

    public Detail_Order save(Detail_Order detail_Order){
        return detail_OrderRepo.save(detail_Order); //insert & update Query
    }

    public Iterable<Detail_Order> findAll(){
        return detail_OrderRepo.findAll(); //select * from detail_Order
    }

    public Detail_Order findOne(int id){
        return detail_OrderRepo.findById(id).get();
        //select * from detail_Order where id =1
    }

    public void removeOne(int id){
        detail_OrderRepo.deleteById(id);
    }
}



