package com.sengmean.demo.config.provider;

import com.sun.tracing.ProviderName;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Sengmean 25 Nov 2019
 */
@ProviderName("CustomerProvider")
public class CustomerProvider {

    /**
     * To get all customers
     * @return
     */
    public String findAll() {
        return new SQL(){{
            SELECT("id, name, gender, address, phone");
            FROM("customer");
            ORDER_BY("id ASC");
        }}.toString();
    }

    public String findById(){
        return new SQL(){{
            SELECT("id, name, gender, address, phone");
            FROM("customer");
            WHERE("id = #{id}");
            ORDER_BY("id ASC");
        }}.toString();
    }

    /**
     * Get User by Id
     * @return
     */
    public String findByUsername(){
        return new SQL(){{
            SELECT("id, name, gender, address, phone");
            FROM("customer");
            WHERE("name = #{name}");
            ORDER_BY("id ASC");
        }}.toString();
    }

    /**
     * To remove customer
     * @return
     */
    public String remove(){
        return new SQL(){{
            DELETE_FROM("customer");
            WHERE("id = #{id}");
        }}.toString();
    }
}
