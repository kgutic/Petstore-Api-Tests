package com.kgutic.api.datatables;

import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableTransformer {
    @DataTableType
    public Pet petTransformer(Map<String, String> row) {
        return new Pet(
                row.get("name"),
                Long.parseLong(row.get("categoryId")),
                row.get("categoryName"),
                row.get("photoUrls"),
                Long.parseLong(row.get("tagId")),
                row.get("tagName"),
                row.get("status"));
    }
}
