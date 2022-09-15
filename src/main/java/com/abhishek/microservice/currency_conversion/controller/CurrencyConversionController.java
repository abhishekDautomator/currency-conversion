package com.abhishek.microservice.currency_conversion.controller;

import com.abhishek.microservice.currency_conversion.entity.CurrencyConversionEntity;
import com.abhishek.microservice.currency_conversion.service.CurrencyConversionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
    @Autowired
    CurrencyConversionImpl currencyConversionImpl;

    @GetMapping(value = "currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<Object> getCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable Long quantity){
        CurrencyConversionEntity currencyConversionEntity = currencyConversionImpl.getCurrencyConversion(from, to, quantity);
        if(currencyConversionEntity.getConversionMultiple()==null){
            return new ResponseEntity("This is a dummy service, please enter 'from' as USD and 'to' as INR", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currencyConversionEntity,HttpStatus.OK);
    }
}
