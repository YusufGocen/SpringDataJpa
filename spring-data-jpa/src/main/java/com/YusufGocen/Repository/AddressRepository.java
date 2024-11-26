package com.YusufGocen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.YusufGocen.entites.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
