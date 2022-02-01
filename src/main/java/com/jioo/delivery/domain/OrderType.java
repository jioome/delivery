package com.jioo.delivery.domain;

import java.util.Arrays;

import javax.persistence.AttributeConverter;

public enum OrderType {
    FINISH(100), READY(0);

    private final int value;

    OrderType(int value) {
        this.value = value;
    }

    public static class Converter implements AttributeConverter<OrderType, Integer> {

        @Override
        public Integer convertToDatabaseColumn(OrderType attribute) {
            return attribute.value;
        }

        @Override
        public OrderType convertToEntityAttribute(Integer dbData) {
            return Arrays.stream(OrderType.values())
                    .filter(value -> value.value == dbData)
                    .findFirst()
                    .orElse(null);
        }
    }
}
