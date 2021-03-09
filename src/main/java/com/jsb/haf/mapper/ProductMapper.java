package com.jsb.haf.mapper;

import com.jsb.haf.model.ProductVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {
    List<ProductVO> getProduct();
}
