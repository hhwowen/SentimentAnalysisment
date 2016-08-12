package com.owen.mongogo;

import com.opensymphony.xwork2.Action;

public class Paint implements Action{
	private String path;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String execute() throws Exception {
		String url = this.getClass().getResource("").getPath().replaceAll("%20", " "); 
		path =  url.substring(0, url.indexOf("WEB-INF"))                           //然后读到subString WEB—INF的地址  然后加到想要的model处 
                + "WEB-INF/json/test.json";
		// TODO Auto-generated method stub
		return SUCCESS; 
	}

}
