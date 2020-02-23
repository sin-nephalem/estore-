package com.briup.app.estore.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Order {
    private Integer id;

    private Double cost;

    private Date orderdate;

    private Customer customer;
    
    private List<Orderline> orderlines;

    public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Orderline> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<Orderline> map) {
		this.orderlines = map;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }


}