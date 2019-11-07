package com.sengmean.demo.config.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * Create by Sengmean 5 Nov 2019
 */
public class UserProvider {

    /**
     *
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
     *
     * @return
     */
    public String findById(){
        return new SQL(){{
            SELECT("id, username, email, password, create_At");
            FROM("users");
            WHERE("id = #{id}");
            ORDER_BY("id ASC");
        }}.toString();
    }
}
