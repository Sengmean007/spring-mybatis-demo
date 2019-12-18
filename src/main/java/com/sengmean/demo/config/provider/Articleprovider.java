package com.sengmean.demo.config.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Sengmean 25 Nov 2019
 */
public class Articleprovider {

    public String findAll() {
        return new SQL(){{
            SELECT("id, name, gender, address, phone");
            FROM("articles");
            ORDER_BY("id ASC");
        }}.toString();
    }
}
