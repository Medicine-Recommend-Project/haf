package com.jsb.haf.mapper;

import com.jsb.haf.model.CustomerVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomerMapper {

    int selectId(String cId);
}
