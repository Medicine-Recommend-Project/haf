package com.jsb.haf.model;

import lombok.Data;

@Data
public class OrderDetailVO {
    private String ocode;
    private String id;
    private String pcode;
    private int quantity;
    private int totalPrice;
    private String odate;

}
