package com.rays.ctl;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.ProductDTO;
import com.rays.form.ProductForm;
import com.rays.service.ProductServiceInt;

@RestController
@RequestMapping(value  = "Product")
public class ProductCtl extends BaseCtl<ProductForm, ProductDTO, ProductServiceInt> {

	@Autowired
	ProductServiceInt productservice;
	
	
	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload Rahul");
		ORSResponse res = new ORSResponse(true);
		ProductDTO dto = new ProductDTO();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Patanjali");
		map.put(2, "MDH");
		map.put(3, "Haldiram");
		
		res.addResult("brandlist", map);
		return res;
	}
	
	
}
