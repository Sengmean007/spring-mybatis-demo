package com.sengmean.demo.config.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * Create by Sengmean 5 Nov 2019
 */
public class UserProvider {

    /**
     * Get all
     * @return user
     */
    public String findAll(){
        return new SQL(){{
            SELECT("id, username, email, password, status, create_time");
            FROM("user");
            ORDER_BY("id ASC");
        }}.toString();
    }

    /**
     * Get User by Id
     * @return id
     */
    public String findById(){
        return new SQL(){{
            SELECT("id, username, email, password,status, create_time");
            FROM("user");
            WHERE("id like #{id}");
            ORDER_BY("id ASC");
        }}.toString();
    }

    /**
     * Get User by Id
     * @return name
     */
    public String findByUsername(){
        return new SQL(){{
            SELECT("id, username, email, password,status, create_time");
            FROM("user");
            WHERE("username = #{username}");
            ORDER_BY("id ASC");
        }}.toString();
    }

    /**
     *
     * @return
     */
    public String getByUsername(){
        return new SQL(){{
            SELECT("id, username, email, password, status, create_time");
            FROM("user");
            WHERE("username LIKE #{username}");
            ORDER_BY("id ASC");
        }}.toString();
    }

    /**
     * To remove user
     * @return id
     */
    public String remove(){
        return new SQL(){{
            DELETE_FROM("user");
            WHERE("id = #{id}");
        }}.toString();
    }

    /**
     * To add user
     * @return null
     */
    public String save() {
        return new SQL(){{
            INSERT_INTO("user");
            VALUES("username, email, password, status, create_At", "#{username}, #{email}, #{password},#{status} #{create_time}");
            ORDER_BY("id ASC");
        }
        }.toString();
    }

    /**
     * To update user
     * @return null
     */
    public String update() {
        return new SQL() {{
                UPDATE("user");
                SET("username = #{username}",
                        "email = #{email}",
                        "password = #{password}",
                        "create_time = #{create_time}",
                		"status = #{status}");
                WHERE("id = #{id}");
                ORDER_BY("id ASC");
            }
        }.toString();
    }
}
