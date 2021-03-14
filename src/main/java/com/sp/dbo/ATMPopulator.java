package com.sp.dbo;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.model.INGAtmLocation;
@Component
public class ATMPopulator {
	 private Logger atmDataPopulatorLogger = LoggerFactory.getLogger(ATMPopulator.class);

	    @Autowired
	    private RestTemplate restTemplate;

	    public List<INGAtmLocation> getDataFromInG() throws Exception {


	        String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);

	        atmDataPopulatorLogger.debug("GARBAGE IN RESPONSE:" + "\n\n" + response.substring(0, 5) + "\n\n");
	        String toBeParsed = response.substring(6, response.length());
	        atmDataPopulatorLogger.debug("TO BE PARSED RESPONSE:" + "\n\n" + toBeParsed + "\n\n");
	        ObjectMapper objectMapper = new ObjectMapper();
	        INGAtmLocation[] ingAtmLocations = objectMapper.readValue(toBeParsed, INGAtmLocation[].class);
	        atmDataPopulatorLogger.debug("PARSED RESPONSE:" + "\n\n" + ingAtmLocations.toString() + "\n\n");

	        return Arrays.asList(ingAtmLocations);
	    }
}
