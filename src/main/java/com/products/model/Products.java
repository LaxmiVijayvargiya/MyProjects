package com.products.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Products {

    @Id
    @GeneratedValue
    @Column(name = "productid")
    private Integer productid;

    @Column(name = "productname")
    private String productname;

    @Override
    public String toString() {
        return "Products{" +
                "productid=" + productid +
                ", productname='" + productname + '\'' +
                '}';
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
}
