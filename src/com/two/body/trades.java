package com.two.body;

import java.sql.Timestamp;

public class trades {
		private String tradeNo=null;
		private String acc=null;
		private Timestamp time=null;
		private String ID=null;
		private String name=null;
		private String No=null;
		
		public String getNo() {
			return No;
		}
		public void setNo(String no) {
			No = no;
		}
		
		public String getTradeNo() {
			return tradeNo;
		}
		public void setTradeNo(String tradeNo) {
			this.tradeNo = tradeNo;
		}
		public String getAcc() {
			return acc;
		}
		public void setAcc(String acc) {
			this.acc = acc;
		}
		public Timestamp getTime() {
			return time;
		}
		public void setTime( Timestamp time) {
			this.time = time;
		}
		public String getID() {
			return ID;
		}
		public void setID(String iD) {
			ID = iD;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		

}
