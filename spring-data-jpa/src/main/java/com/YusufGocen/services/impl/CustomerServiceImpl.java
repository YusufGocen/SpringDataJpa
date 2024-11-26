package com.YusufGocen.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YusufGocen.Dto.DtoAdress;
import com.YusufGocen.Dto.DtoCustomer;
import com.YusufGocen.Repository.CustomerRepository;
import com.YusufGocen.entites.Address;
import com.YusufGocen.entites.Customer;
import com.YusufGocen.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public DtoCustomer findCustomerById(Long id) {
		
		DtoCustomer dtoCustomer=new DtoCustomer();
		DtoAdress dtoAdress=new DtoAdress();
		
		Optional<Customer>optional=customerRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		
		Customer customer =optional.get();
		Address address=optional.get().getAddress(); 
		
		BeanUtils.copyProperties(customer, dtoCustomer);
		BeanUtils.copyProperties(address, dtoAdress);
		//DtoCustomer içindeki Addresi almadgı için ikinci defa adresi copyproperties yaptık.
		
		
		//Burada DtoCustomer içindeki adress yeri bos kaldıgı için adresi burada setliyoruz
		dtoCustomer.setAddress(dtoAdress);
		
		return dtoCustomer;
	}

	
	
	
	
	
}
