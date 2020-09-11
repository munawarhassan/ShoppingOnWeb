package com.ibm.shoponline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.support.PageJacksonModule;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.Module;
import com.ibm.shoponline.model.Product;

@Service
@Component
public class GroceryOnlineService {

	@Autowired
	private ProductInventoryProxyService  proxyservice;
	
	@Bean
	public Module pageJacksonModule() {
		return new PageJacksonModule();
	}
	
	
	    public Page<Product> findAllProductsPageable(Pageable pageable) {
	    	
	    	Page<Product>  products = proxyservice.findAll(pageable);
	        return products;//proxyservice.findAll(pageable);
	    }

}
