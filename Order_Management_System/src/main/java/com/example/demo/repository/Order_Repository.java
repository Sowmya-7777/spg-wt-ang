package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Order;


public interface Order_Repository extends JpaRepository<Order, Integer>{

}