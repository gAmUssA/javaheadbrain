package com.javaheadbrain.experiments.spring.mapper;

import com.javaheadbrain.experiments.spring.entity.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * TODO
 *
 * @author Viktor Gamov (http://log.javaheadbrain.com)
 * @since 5/2/12
 */
public interface AccountMapper {

    @Insert("insert into account(id, balance) values ( #{id}, #{balance})")
    int createAccount(Account account);

    @Select("select * from account where id=#{id}")
    Account findAccountById(int id);

    @Select("select * from account")
    List<Account> findAllAccounts();

    @Update("update account set balance=#{balance} where id=#{id}")
    void updateAccount(Account account);

    @Delete("delete from account where id=#{id}")
    void deleteAccount(int id);
}
