package com.kgutic.api.datatables;

import io.cucumber.java.DataTableType;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class DataTableTransformer {
    @DataTableType
    public Pet petTransformer(Map<String, String> row) {
        return new Pet(
                row.get("name"),
                Long.parseLong(row.get("categoryId")),
                row.get("categoryName"),
                List.of(row.get("photoUrls")),
                Long.parseLong(row.get("tagId")),
                row.get("tagName"),
                row.get("status"));
    }

    @DataTableType
    public Order orderTransformer(Map<String, String> row) {
        return new Order(
                Integer.parseInt(row.get("quantity")),
                OffsetDateTime.parse(row.get("shipDate")),
                row.get("status"),
                Boolean.parseBoolean(row.get("complete"))
        );
    }

    @DataTableType
    public User userTransformer(Map<String, String> row) {
        return new User(
                row.get("username"),
                row.get("firstName"),
                row.get("lastName"),
                row.get("email"),
                row.get("phone"),
                Integer.parseInt(row.get("status")));
    }
}
