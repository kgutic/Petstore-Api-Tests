package com.kgutic.api.config;

import lombok.extern.slf4j.Slf4j;
import java.util.UUID;

@Slf4j
public class TestUtils {
    public static long getRandomId(String randomIdType) {
        long randomId = (long) (Math.random() * 1000);
        log.info("The random {} is {}", randomIdType, randomId);
        return randomId;
    }

    public static long getRandomPetId() {
        return getRandomId("petId");
    }

    public static long getRandomOrderId() {
        return getRandomId("oderId");
    }

    public static Long getRandomUserId() {
        return getRandomId("userID");
    }

    public static String getRandomPassword() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
    }
}
