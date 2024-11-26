package com.YusufGocen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.YusufGocen.entites.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long>{

}
