package com.kgutic.api.world;

import lombok.Data;

@Data
public class PetWorld {
    private Long petId;
    private Long orderId;
    private Long userId;
    private String password;
}
