package com.kgutic.PetstoreApiTests.datatables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private long id;
    private String name;
    private long categoryId;
    private String categoryName;
    private String photoUrls;
    private long tagId;
    private String tagName;
    private String status;
}
