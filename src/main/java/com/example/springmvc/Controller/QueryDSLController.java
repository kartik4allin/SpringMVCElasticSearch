package com.example.springmvc.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springmvc.Service.QueryDSLService;
import com.example.springmvc.model.HealthData;
import com.example.springmvc.model.Products;




@RestController
public class QueryDSLController {

	@Autowired
	private QueryDSLService service;

	@GetMapping("/serachMultiField/{name}/{price}")
	public List<Products> serachByMultiField(@PathVariable String name, @PathVariable int price) {
		return service.searchMultiField(name, price);
	}

	@GetMapping("/productSearch/{name}")
	public List<Products> getCustomerByField(@PathVariable String name) {
		return service.getProductSearchData(name);
	}

	@GetMapping("/search/{text}")
	public List<Products> doMultimatchQuery(@PathVariable String text) {
		return service.multiMatchQuery(text);
	}
	
	@GetMapping("/searchAgg/{text}")
	public void doMultimatchAggQuery(@PathVariable String text) {
		service.multiMatchQueryWithAggregation(text);
	}
	
	
	@GetMapping(value = "/rangeHealthQuery")
	public List<HealthData> rangeHealthQuery() {
		List<HealthData> healthData = service.rangeHealthQuery("age");
		healthData.forEach(data->System.out.println(data));
		return healthData;
		//return new ModelAndView("heathSearch", "healthData", healthData);
	} 
	
	@GetMapping(value = "/booleanHealthQuery/{searchText}")
	public List<HealthData> booleanHealthQuery(@PathVariable String searchText) {
		List<HealthData> healthData = service.booleanHealthQuery(searchText,"age");
		healthData.forEach(data->System.out.println(data));
		return healthData;
		//return new ModelAndView("heathSearch", "healthData", healthData);
	} 

}