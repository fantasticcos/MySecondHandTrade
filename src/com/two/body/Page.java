package com.two.body;

import java.io.Serializable;

public class Page implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int from=0;
	private int to=0;
	private String type=null;
	private String search=null;
	private String [] list= {"衣服","鞋","家电","手机","珠宝","箱包","手表","乐器","器械","学习","书本","桌椅"};
	private String [] ck= {"clothes","shoes","jiadian","shouji","zhubao","box","watch","instrument","tools","study","books","desk"};
	public Page(int i,String t) {
		switch(i)
		{
		case 1: from=0;to=10;break;
		default:to=i*10;from=to-10;;break;
		}
		
		for(int m=0;m<list.length;m++)
		{
			if(t.equals(ck[m]))
			{
				type=list[m];
			}
		}
	}
	public Page(int i,String search,int a) {
		switch(i)
		{
		case 1: from=0;to=10;break;
		default:to=i*10;from=to-10;;break;
		}
		
		this.search=search;
	}
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	
	

}
