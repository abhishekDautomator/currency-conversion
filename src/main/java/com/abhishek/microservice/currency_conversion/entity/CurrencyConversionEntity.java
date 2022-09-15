package com.abhishek.microservice.currency_conversion.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class CurrencyConversionEntity {
    @Id
    @SequenceGenerator(name = "CurrencyConversion_Id",initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CurrencyConversion_Id")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    private String from;
    @Column
    private String to;
    @Column
    private BigDecimal conversionMultiple;
    @Column
    private Long quantity;
    @Column
    private BigDecimal totalCalculatedAmount;
    @Column
    private String environment;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrencyConversionEntity(Long id, String from, String to, BigDecimal conversionMultiple, Long quantity, BigDecimal totalCalculatedAmount, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.environment = environment;
    }

    public CurrencyConversionEntity() {
    }

    @Override
    public String toString() {
        return "CurrencyConversionEntity{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", quantity=" + quantity +
                ", totalCalculatedAmount=" + totalCalculatedAmount +
                ", environment='" + environment + '\'' +
                '}';
    }
}
