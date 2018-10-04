package com.aaxis.microservice.training.demo1.dao;

import com.aaxis.microservice.training.demo1.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryDAO extends JpaRepository<Inventory,String> {

    @Query(value = "select id from Product", nativeQuery = true )
    public List<String> findAllProductIds();
}
