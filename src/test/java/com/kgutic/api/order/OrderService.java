package com.kgutic.api.order;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.kgutic.pss.generated.model.OrderDTO;
import io.restassured.http.ContentType;
import io.restassured.internal.mapping.Jackson2Mapper;
import io.restassured.mapper.ObjectMapper;

import java.lang.reflect.Type;

import static net.serenitybdd.rest.SerenityRest.given;

public class OrderService {
    public static final String ORDER_PATH = "api/v3/store/order";

    public void createOrder(OrderDTO orderDTO) {
        ObjectMapper objectMapper = new Jackson2Mapper((Type cls, String charset) -> {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper().findAndRegisterModules();
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            return mapper;
        });
        given()
                .basePath(ORDER_PATH)
                .body(orderDTO, objectMapper)
                .contentType(ContentType.JSON)
                .post();
    }
}
