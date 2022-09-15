package com.abhishek.microservice.currency_conversion.client;

import com.abhishek.microservice.currency_conversion.entity.CurrencyConversionEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange", url="localhost:8100")
@FeignClient(name = "currency-exchange") //Upon adding API gateway this annotation will automatically talk to eureka server to fetch currency-exchange running instances
public interface CurrencyExchangeProxy {

    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyConversionEntity> getCurrencyExchangeDetails(@PathVariable String from, @PathVariable String to);
}
