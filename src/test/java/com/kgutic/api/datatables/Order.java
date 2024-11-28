package com.kgutic.api.datatables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int quantity;
    private OffsetDateTime shipDate;
    private String status;
    private boolean complete;
}
