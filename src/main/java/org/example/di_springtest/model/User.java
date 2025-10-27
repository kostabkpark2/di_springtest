package org.example.di_springtest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data // getter,setter,toString, RequiredArgsContructor
public class User {
    private String userId;
    private String password;
    private String userName;
}
