package com.YusufGocen.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YusufGocen.Dto.DtoAdress;
import com.YusufGocen.Dto.DtoCustomer;
import com.YusufGocen.Repository.AddressRepository;
import com.YusufGocen.entites.Address;
import com.YusufGocen.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService{
	
	@Autowired
	private AddressRepository addressRepository ;

	@Override
	public DtoAdress findAddressById(Long id) {
		
		DtoAdress dtoAdress=new DtoAdress();
		DtoCustomer dtoCustomer=new DtoCustomer();
		
		Optional<Address>optinal= addressRepository.findById(id);
		
		if (optinal.isEmpty()) {
			return null;
		}
		
		Address address=optinal.get();
		BeanUtils.copyProperties(address, dtoAdress);
		
		dtoCustomer.setId(address.getCustomer().getId());
		dtoCustomer.setName(address.getCustomer().getName());
		

		 
		
		dtoAdress.setCustomer(dtoCustomer);
		
		
		return dtoAdress;
	}

}
