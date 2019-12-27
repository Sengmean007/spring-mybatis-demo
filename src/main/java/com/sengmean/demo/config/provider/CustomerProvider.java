package com.sengmean.demo.config.provider;

import com.sun.tracing.ProviderName;
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
}
