package com.abhishek.microservice.currency_conversion.dao;

import com.abhishek.microservice.currency_conversion.entity.CurrencyConversionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConversionDao extends JpaRepository<CurrencyConversionEntity, Long> {
}
