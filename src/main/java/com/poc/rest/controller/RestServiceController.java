package com.poc.rest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.rest.bo.GenericResponse;

@RestController
public class RestServiceController {


	private static final Logger logger= LoggerFactory.getLogger(RestServiceController.class);
	
	/**
	 * This is the controller for the number range. Then converts the number falls under the range based on the logic.
	 * @param minimum
	 * @param maximum
	 * @return
	 */
    @RequestMapping(value="/api/v1.0/number/range",method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<GenericResponse> greeting(@RequestParam(value="min") String minimum,@RequestParam(value="max") String maximum) {
    	GenericResponse response = new GenericResponse();
    	response.setStatus("success");
    	try {
    		int min = Integer.parseInt(minimum);
    		int max = Integer.parseInt(maximum);
    		
    		if(! (min > 0 && max <= 200)) {
    			response.setMessage("Input should be minimum '0' and maximum '200'. ");
    			return new ResponseEntity<GenericResponse>(response, getHeaders(), HttpStatus.OK);
    		}
    		
    		response.setData(rangeNumberConvertAlgorithm(min, max));
    		
    	} catch(NumberFormatException ex) {
    		response.setStatus("failure");
    		response.setMessage("Please give valid number input.");
    		logger.error("The given input may not be the valid Integer:"+ex.getMessage());
    	}catch(Exception ex) {
    		response.setStatus("failure");
    		response.setMessage("Some thing went wrong, please try again.");
    		logger.error("Exception occurred while processing the request due to:"+ex.getMessage());
    	}
    	return new ResponseEntity<GenericResponse>(response, getHeaders(), HttpStatus.OK);
    }
    
    
    /**
     * This is method handles algorithmic logic chnages if any number divisible 
     * by 3 only then'ME' ,
     * by 7 only then 'MS3' ,
     * by both 3 & 7 then 'MS3 and ME' 
     * @param min
     * @param max
     * @return
     */
    private List<String> rangeNumberConvertAlgorithm (int min , int max) {
    	List<String> numbers = new ArrayList<>();
    	for (int i = min; i <= max ; i++) {
    		String value = null;
    		if (i%3 == 0 )  value = "ME";
    		if (i%7 == 0 )  value = ( value == null) ? "MS3" : "MS3 and ME";
    		if (value == null) value = new String(Integer.toString(i));
    		numbers.add(value);
    	}
    	
    	return numbers;
    }
    
    /*
     * Common headers
     */
    public static HttpHeaders getHeaders() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setAccessControlAllowOrigin("*");
    	headers.setAccessControlMaxAge(1000*60*30);
    	headers.setAccessControlAllowMethods((Arrays.asList(HttpMethod.GET,HttpMethod.POST,
    			HttpMethod.PUT,HttpMethod.OPTIONS,HttpMethod.DELETE,HttpMethod.TRACE)));
    	return headers;
    }
}