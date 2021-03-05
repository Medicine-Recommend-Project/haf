package com.jsb.haf.model;

import lombok.Data;

@Data
public class OrderDetailVO {
    String ocode;
    String id;
    String pcode;
    int quantity;
    int totalPrice;
    String odate;

}
