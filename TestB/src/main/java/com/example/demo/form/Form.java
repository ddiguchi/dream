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
    List<String> stringList = new ArrayList<String>();
    int[] num = new int[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
    	total += num[i];
    }    
  }
}
