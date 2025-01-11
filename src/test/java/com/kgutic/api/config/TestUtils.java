package com.kgutic.api.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

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
        return RandomStringUtils.secure().next(10);
    }
}
