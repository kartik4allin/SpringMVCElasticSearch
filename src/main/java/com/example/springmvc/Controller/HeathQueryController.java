package com.example.springmvc.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.springmvc.Service.QueryDSLService;
import com.example.springmvc.model.HealthData;
import com.example.springmvc.model.Products;

@Controller
public class HeathQueryController {
	
	@Autowired
	private QueryDSLService service;

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "heathSearch";
	}
	
	@RequestMapping(value = "/searchHealthQuery", method = RequestMethod.POST)
	public ModelAndView searchQuery(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SearchQuery text is  $$$ "+request.getParameter("query"));
		String searchQuery = request.getParameter("query");
		List<HealthData> healthData = service.multiMatchHealthQuery(searchQuery);
		healthData.forEach(data->System.out.println(data));
		return new ModelAndView("heathSearch", "healthData", healthData);
	} 
	
	
	
	
	
}