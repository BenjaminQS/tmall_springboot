package com.how2java.tmall.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.util.Page4Navigator;

@RestController
public class PropertyController {
	
	@Autowired
	PropertyService propertyService;
	
	@GetMapping("/categories/{cid}/properties")
	public Page4Navigator<Property> list(@PathVariable("cid") int cid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
		start = start<0?0:start;
		Page4Navigator<Property> page = propertyService.list(cid, start, size, 5);
		
		return page;
	}
	
	@GetMapping("/properties/{id}")
	public Property get(@PathVariable("id") int id) throws Exception {
		Property bean = propertyService.get(id);
		return bean;
	}
	
	@PostMapping("/properties")
	public Object add(@RequestBody Property bean) throws Exception {
		propertyService.add(bean);
		return bean;
	}
	
	@DeleteMapping("/properties/{id}")
	public String delete(@PathVariable("id") int id, HttpServletRequest request) throws Exception {
		propertyService.delete(id);
		return null;
	}
	
	@PutMapping("/properties")
	public Object update(@RequestBody Property bean) throws Exception {
		propertyService.update(bean);
		return bean;
	}

}
