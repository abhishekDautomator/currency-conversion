package com.abhishek.microservice.currency_conversion.service;

import com.abhishek.microservice.currency_conversion.entity.CurrencyConversionEntity;

public interface CurrencyConversionService {
    CurrencyConversionEntity getCurrencyConversion(String from, String to, Long quantity);
}
