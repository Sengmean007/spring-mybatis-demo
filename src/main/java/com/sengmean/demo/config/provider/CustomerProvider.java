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
        return new SQL() {{
            SELECT("id, name, gender, address, phone");
            FROM("customer");
            ORDER_BY("id ASC");
        }}.toString();
    }

    /**
     * To get customer by id
     * @return
     */
    public String findById() {
        return new SQL() {{
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
    public String findByUsername() {
        return new SQL() {{
            SELECT("id, name, gender, address, phone");
            FROM("customer");
            WHERE("name like #{name}");
            ORDER_BY("id ASC");
        }}.toString();
    }

    /**
     * To remove customer
     * @return
     */
    public String remove() {
        return new SQL() {{
            DELETE_FROM("customer");
            WHERE("id = #{id}");
        }}.toString();
    }

    /**
     * To update customers
     * @return
     */
    public String update() {
        return new SQL() {
            {
                UPDATE("customer");
                SET("name = #{name}",
                        "gender = #{gender}",
                        "address = #{address}",
                        "phone = #{phone}");
                WHERE("id = #{id}");
                ORDER_BY("id ASC");
            }

            private void VALUES(String name, String gender, String address, String phone) {
            }
        }.toString();
    }

    /**
     * To add customers
     * @return
     */
    public String save() {
        return new SQL(){{
            INSERT_INTO("customer");
            VALUES("name, gender, address, phone" , "#{name}, #{gender},  #{address}, #{phone}");
            ORDER_BY("id ASC");
        }
        }.toString();
    }
}