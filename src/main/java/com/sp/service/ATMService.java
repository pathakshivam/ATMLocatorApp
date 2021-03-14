package com.sp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.dbo.ATMPopulator;
import com.sp.model.*;

@Service
public class ATMService {
	  @Autowired
	    private ATMPopulator atmDataPopulator;

	    public List<INGAtmLocation> getAtmLocationsfromING() throws Exception {

	        return atmDataPopulator.getDataFromInG();
	    }

	    public List<INGAtmLocation> getAtmLocationsfromINGByCity(String city) throws Exception {

	        List<INGAtmLocation> locations = new ArrayList<>();
	        List<INGAtmLocation> atmLocationsfromING = getAtmLocationsfromING();
	        for (INGAtmLocation location : atmLocationsfromING) {
	            if (city.equalsIgnoreCase(location.getAddress().getCity())) {
	                locations.add(location);
	            }
	        }
	        return locations;
	    }

}
