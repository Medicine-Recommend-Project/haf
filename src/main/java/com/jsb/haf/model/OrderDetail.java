package com.jsb.haf.model;

import lombok.Data;

@Data
public class OrderDetail {
    String ocode;
    String id;
    String pcode;
    int quantity;
    int totalPrice;
    String odate;

}
