package com.xbl.ecommerce.index;

import com.xbl.ecommerce.index.entity.Index;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface IndexRepository {

    @Select("SELECT * FROM `index` WHERE ID= #{id}")
    Index get(@Param("id") Integer id);
}
