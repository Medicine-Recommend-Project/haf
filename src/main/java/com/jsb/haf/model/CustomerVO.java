package com.jsb.haf.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CustomerVO {

    private String cId;
    private String cPw;
    private String cGrade;
    private String cName;
    private String cEmail;
    private int cPh;
    private String cAddress;
    private String cAddressDetail;
    private String cJoinDate;

}
