package com.kgutic.api.datatables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int status;
}