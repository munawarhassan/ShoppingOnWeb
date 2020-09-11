package com.ibm.shoponline.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.ibm.shoponline.model.Product;

@Component
public class ProductInventoryServiceFallback implements ProductInventoryProxyService {

	
	public   Page<Product>  findAll(Pageable pageable){
		// TODO Auto-generated method stub
		return null;
	}

}
