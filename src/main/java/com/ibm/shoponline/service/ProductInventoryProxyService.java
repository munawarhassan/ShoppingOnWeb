package com.ibm.shoponline.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.shoponline.model.Product;

@FeignClient(name = "productinventory" , fallback = ProductInventoryServiceFallback.class)
public interface ProductInventoryProxyService {	
	@GetMapping(path = "/inventory/allproducts", produces =  {"application/json"})
	public   Page<Product>  findAll(Pageable page);
}
