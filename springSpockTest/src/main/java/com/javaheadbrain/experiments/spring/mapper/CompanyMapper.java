package com.javaheadbrain.experiments.spring.mapper;

import com.javaheadbrain.experiments.spring.entity.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * TODO
 *
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 * @since 5/2/12
 */
public interface CompanyMapper {
    @Select("SELECT * FROM company")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "companyName", column = "company")
    })
    List<Company> getCompanies();

    @Insert("INSERT INTO company (company) VALUES (#{companyName})")
    @SelectKey(statement = "call identity()", keyProperty = "id", before = false, resultType = int.class)
    Integer create(Company company);

    @Update("UPDATE company SET company = #{companyName} WHERE id = #{id}")
    Integer update(Company company);

    @Delete("DELETE FROM company WHERE id = #{id}")
    Integer delete(Company company);

    @Delete("DELETE FROM company")
    Integer deleteAll();


}
