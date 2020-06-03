package com.softserve.edu.greencity.rest.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import com.softserve.edu.greencity.rest.data.places.DiscountDto;

public class RestParameters {
    

    private Map<KeyParameters, String> parameters;
    private Map<KeyParameters, List<String>> listParameters;
    public List <String> listParameter;


    
    public RestParameters() {
        parameters = new HashMap<>();
        listParameters = new HashMap<>();
        listParameter = new  ArrayList<>();
    }

 
    
//  public RestParameters addParameter(String value) {
//      System.out.println("______________________________________________________1");
//      listParameter.add(0, value);
////        parameters.put(key, value);
//      return this;
//      
//  }
    
    public RestParameters addParameter(KeyParameters key, String value) {
        parameters.put(key, value);
        return this;
    }

    public RestParameters addListParameter(KeyParameters key, String value) {
        List<String> list = listParameters.get(key);
        if (list == null) {
            list = new ArrayList<>();
            list.add(value);
            listParameters.put(key, list);
        } else {
            list.add(value);
        }
        return this;
    }

    public String getParameter(KeyParameters key) {
        return parameters.get(key);
    }

    public List<String> getListParameter(KeyParameters key) {
        return listParameters.get(key);
    }

    public Map<KeyParameters, String> getAllParameters() {
        return parameters;
    }

    public Map<KeyParameters, List<String>> getAllListParameters() {
        return listParameters;
    }

    public Map<KeyParameters, String> getParameters() {
        return parameters;
    }

    public Map<KeyParameters, List<String>> getListParameters() {
        return listParameters;
    }

    public List<String> getListParameter() {
        return listParameter;
    }

    @Override
    public String toString() {
        return "RestParameters [parameters=" + parameters + ", listParameters=" + listParameters + ", listParameter="
                + listParameter + "]";
    }

    
}
