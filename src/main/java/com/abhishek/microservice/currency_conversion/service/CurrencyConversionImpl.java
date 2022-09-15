package com.abhishek.microservice.currency_conversion.service;

import com.abhishek.microservice.currency_conversion.client.CurrencyExchangeProxy;
import com.abhishek.microservice.currency_conversion.dao.CurrencyConversionDao;
import com.abhishek.microservice.currency_conversion.entity.CurrencyConversionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class CurrencyConversionImpl implements CurrencyConversionService{

    @Autowired
    CurrencyExchangeProxy currencyExchangeProxy;
    @Autowired
    Environment environment;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CurrencyConversionDao currencyConversionDao;

    @Override
    public CurrencyConversionEntity getCurrencyConversion(String from, String to, Long quantity) {
//        ResponseEntity<CurrencyConversionEntity> responseEntity =restTemplate.getForEntity("http://localhost:8100/currency-exchange/from/"+from+"/to/"+to,CurrencyConversionEntity.class);
        ResponseEntity<CurrencyConversionEntity> responseEntity =currencyExchangeProxy.getCurrencyExchangeDetails(from, to);
        BigDecimal conversionMultiple = responseEntity.getBody().getConversionMultiple();
        BigDecimal totalAmount = conversionMultiple.multiply(BigDecimal.valueOf(quantity));
        CurrencyConversionEntity currencyConversion = responseEntity.getBody();
        currencyConversion.setQuantity(quantity);
        currencyConversion.setTotalCalculatedAmount(totalAmount);
        return currencyConversionDao.save(currencyConversion);
    }
}
