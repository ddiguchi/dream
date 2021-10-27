package com.example.demo.form;

import java.util.ArrayList;
import java.util.List;


public class Form {
	private int total=0;
	private int num=0;
	
	public int getNum1(){
	    return num;
	  }

	  public void setNum1(int num){
	    this.num = num;
	  }
	public int getTotal(){
	    return total;
	  }
	public void setTotal(int total){
	    this.total = total;
	  }

  public void sumTotal() {
	  List<Integer> list = new ArrayList<>();
	  int[] num = new int[list.size()];
        for (int i  =0 ; i < list.size() ; i++ ) {
    	total += num[i];
       }  
       setTotal(total); 
  	}
}



