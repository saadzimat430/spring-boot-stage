package com.ecommerce.ecommerce.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmailInfo {

    private String firstName;

    private String email;

    private String orderStatus;

}
