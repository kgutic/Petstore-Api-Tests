package com.kgutic.api.config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestUtils {
    public static long getRandomPetId() {
        long randomPetId = (long) (Math.random() * 1000);
        log.info("The random petId is {}", randomPetId);
        return randomPetId;
    }

    public static long getRandomOrderId() {
        long randomOrderId = (long) (Math.random() * 1000);
        log.info("The random orderID is {}", randomOrderId);
        return randomOrderId;
    }
}
