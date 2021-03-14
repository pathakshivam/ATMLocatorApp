package com.sp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.sp.model.ApiResponseObject;
import com.sp.model.INGAtmLocation;
import com.sp.service.ATMService;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "Shivam Home";
	}
	
	  @Autowired
	    private ATMService atmLocator;

	    @RequestMapping(value = "/atm", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public
	    @ResponseBody
	    ApiResponseObject getATMLocationsfromING() throws Exception {
	        ApiResponseObject<INGAtmLocation> responseObject= new ApiResponseObject<>();
	        responseObject.setList(atmLocator.getAtmLocationsfromING());
	        return responseObject;
	    }

	    @RequestMapping(value = "/atm/{city}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public
	    @ResponseBody
	    ApiResponseObject getATMLocationsfromINGByCity(@PathVariable("city") String city) throws Exception {
	        ApiResponseObject<INGAtmLocation> responseObject= new ApiResponseObject<>();
	        responseObject.setList(atmLocator.getAtmLocationsfromINGByCity(city));
	        return responseObject;
	    }
	
	
}
