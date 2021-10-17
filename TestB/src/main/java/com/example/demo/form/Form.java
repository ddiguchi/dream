package com.example.demo.form;

public class Form {

	  private int point = 0;
	  private int total = 0;
	  

	  public int getPoint(){
	    return point;
	  }

	  public void setPoint(int num){
	    this.point = num;
	  }


	  public int getTotal(){
	    return total;
	  }

	  public void setTotal(int total){
	    this.total = total;
	  }
	  public void sumTotal(){
	    total = this.point;
	    setTotal(total);    
	  }
	}