package com.sengmean.demo.config.provider;

import com.sun.tracing.ProviderName;
import org.apache.ibatis.jdbc.SQL;

/**
 * Create by Sengmean 5 Nov 2019
 */
@ProviderName("UserProvider")
public class UserProvider {

    /**
     * Get all user name
     * @return
     */
    public String findAll(){
        return new SQL(){{
            SELECT("id, username, email, password, create_At");
            FROM("users");
            ORDER_BY("id ASC");
        }}.toString();
    }

    /**
     * Get User by Id
     * @return
     */
    public String findById(){
        return new SQL(){{
            SELECT("id, username, email, password, create_At");
            FROM("users");
            WHERE("id like #{id}");
            ORDER_BY("id ASC");
        }}.toString();
    }

    /**
     * Get User by Id
     * @return
     */
    public String findByUsername(){
        return new SQL(){{
            SELECT("id, username, email, password, create_At");
            FROM("users");
            WHERE("username = #{username}");
            ORDER_BY("id ASC");
        }}.toString();
    }
}
