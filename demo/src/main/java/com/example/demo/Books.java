package com.example.demo;

public class Books {

	private String Bookname;
	private Integer price;
	private Integer edition;
	
	public Books(String bookname, Integer price, Integer edition) {
		super();
		Bookname = bookname;
		this.price = price;
		this.edition = edition;
	}
	
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String bookname) {
		Bookname = bookname;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getEdition() {
		return edition;
	}
	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "Books [Bookname=" + Bookname + ", price=" + price + ", edition=" + edition + "]";
	}
	
	
	
}
