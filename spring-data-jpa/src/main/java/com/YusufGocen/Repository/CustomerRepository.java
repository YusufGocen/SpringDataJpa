package com.YusufGocen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.YusufGocen.entites.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
