package com.kgutic.api.datatables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private String name;
    private long categoryId;
    private String categoryName;
    private String photoUrls;
    private long tagId;
    private String tagName;
    private String status;
}
