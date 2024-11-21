package com.kgutic.api.datatables;

import io.cucumber.java.DataTableType;

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
}
