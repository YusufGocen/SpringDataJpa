package com.YusufGocen.services;

import com.YusufGocen.Dto.DtoCustomer;

public interface ICustomerService {

	public DtoCustomer findCustomerById(Long id);
}
