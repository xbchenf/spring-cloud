package com.xbchen.springboot.mybatis.mapper;

import com.xbchen.springboot.mybatis.model.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by xbchen on 2018/06/25.
 */
public interface TestMapper {

    String ADD_MONEY = "update test3 set money = money+#{1} where id = #{0}";

    String MINUS_MONEY = "update test3 set money = money-#{1} where id = #{0}";

    String INSERT_ACCOUT = "insert into test3 (name,money) values (#{name},#{money})";

    String FIND_ACCOUNT_BY_ID = "select " +
            " id as id," +
            " name as name," +
            " money as money" +
            " from test3 " +
            " where " +
            " id = #{id}";

    String FIND_ACCOUNTS_BY_ID = "select " +
            " id as id," +
            " name as name," +
            " money as money" +
            " from test3 " +
            " where " +
            " id >= #{id}";

    @Update(ADD_MONEY)
    public int addMoney(int userId,float money);

    @Update(MINUS_MONEY)
    public int minusMoney(int userId,float money);

    @Insert(INSERT_ACCOUT)
    //@CacheEvict(value = {"indexCache"},allEntries = true,beforeInvocation = true)
    public int insertAccount(Account account);

    @Select(FIND_ACCOUNT_BY_ID)
    //@Cacheable(value = "indexCache",key = "'getAccountById'+#id")
    public Account getAccountById(int id);

    @Select(FIND_ACCOUNTS_BY_ID)
    //@Cacheable(value = "indexCache",key = "'findAccountsById'+#id")
    public List<Account> findAccountsById(int id);


}
