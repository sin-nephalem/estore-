package com.briup.app.estore.bean;

public class Orderline {
    private Integer id;

    private Integer num;

    private Order order;

    private Book book;

    public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

	@Override
	public String toString() {
		return "Orderline [id=" + id + ", num=" + num + ", order=" + order + ", book=" + book + "]";
	}

}