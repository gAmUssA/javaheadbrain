package com.javaheadbrain.experiments.spring.mapper;

import com.javaheadbrain.experiments.spring.entity.Associate;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * TODO
 *
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 * @since 5/2/12
 */
public interface AssociateMapper {

    @Select("SELECT * FROM company_associate WHERE company_id = #{companyId}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "associateName", column = "associate"),
            @Result(property = "companyId", column = "company_id")
    })
    List<Associate> getAssociates(Integer company_id);

    @Insert("INSERT INTO company_associate (associate, company_id) VALUES (#{associateName}, #{companyId})")
    @SelectKey(statement = "call identity()", keyProperty = "id", before = false, resultType = int.class)
    Integer create(Associate dto);

    @Update("UPDATE company_associate SET associate = #{associateName}, company_id = #{companyId} WHERE id = #{id}")
    Integer update(Associate dto);

    @Delete("DELETE FROM company_associate WHERE id = #{id}")
    Integer delete(Associate dto);
}
