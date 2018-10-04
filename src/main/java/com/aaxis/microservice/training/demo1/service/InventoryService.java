package com.aaxis.microservice.training.demo1.service;


import com.aaxis.microservice.training.demo1.dao.InventoryDAO;
import com.aaxis.microservice.training.demo1.domain.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class InventoryService {

    @Autowired
    private InventoryDAO mInventoryDAO;

    public void initData(){
        List<String> ids = mInventoryDAO.findAllProductIds();

        for(String productId : ids){
            Inventory Inventory = new Inventory();
            Inventory.setId(productId);
            Inventory.setStock(new Random().nextInt(100));
            mInventoryDAO.save(Inventory);
        }
    }

    public Inventory findInventoryById(String pProductId){
        Optional<Inventory> optionalInventory = mInventoryDAO.findById(pProductId);
        if(optionalInventory.isPresent()){
            return optionalInventory.get();
        }
        return null;
    }
}
