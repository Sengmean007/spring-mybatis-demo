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

    public String getAllByUsername(){
        return new SQL(){{
            SELECT("id, username, email, password, create_At");
            FROM("users");
            WHERE("username LIKE #{username}");
            ORDER_BY("id ASC");
        }}.toString();
    }

    /**
     * To remove user
     * @return
     */
    public String remove(){
        return new SQL(){{
            DELETE_FROM("users");
            WHERE("id = #{id}");
        }}.toString();
    }

    /**
     * To add user
     * @return
     */
    public String save() {
        return new SQL(){{
            INSERT_INTO("users");
            VALUES("username, email, password, create_At", "#{username}, #{email}, #{password}, #{create_At}");
            ORDER_BY("id ASC");
        }
        }.toString();
    }

    /**
     * To update user
     * @return
     */
    public String update() {
        return new SQL() {{
                UPDATE("users");
                SET("username = #{username}",
                        "email = #{email}",
                        "password = #{password}",
                        "create_At = #{create_At}");
                WHERE("id = #{id}");
                ORDER_BY("id ASC");
            }
        }.toString();
    }
}
