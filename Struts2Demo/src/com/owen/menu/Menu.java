package com.owen.menu;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.opensymphony.xwork2.ActionSupport;
import com.owen.util.Data;
import com.owen.util.GetAnchorList;

public class Menu extends ActionSupport{
	public List<Data> listData;
	public String date;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Data> getListData() {
		return listData;
	}

	public void setListData(List<Data> listData) {
		this.listData = listData;
	}

	
	public String execute()throws Exception{
		date = DateFormat.getInstance().format(new Date());
		String s =ServletActionContext.getRequest().getParameter("url").toString();
//		System.out.println(s);
		String menuurl = getMenuUrl(s);
		GetAnchorList gta = new GetAnchorList();
		//HtmlPage firstPage = gta.getInitialPage("http://blog.sciencenet.cn/blog.php?mod=type&type=9");
		HtmlPage firstPage = gta.getInitialPage(menuurl);
		listData = gta.getAnchorList(firstPage);
		HttpServletRequest res = ServletActionContext.getRequest();
		res.setAttribute("listTR", listData);		
		return SUCCESS;		
	}

	public String getMenuUrl(String s) {
		// TODO Auto-generated method stub
		String url="";
		if(s.equals("1")){
			url= "http://blog.sciencenet.cn/blog.php?mod=recommend&type=list&op=1&ord=1";
		} else if(s.equals("2")){
			url= "http://blog.sciencenet.cn/blog.php?mod=recommend&type=list&op=2&ord=1";
		}  else if(s.equals("3")){
			url= "http://blog.sciencenet.cn/blog.php?mod=recommend&type=list&op=3&ord=1";
		}  else if(s.equals("4")){
			url= "http://blog.sciencenet.cn/blog.php?mod=type&type=1";
		}  else if(s.equals("5")){
			url= "http://blog.sciencenet.cn/blog.php?mod=type&type=9";
		}  else if(s.equals("6")){
			url= "http://blog.sciencenet.cn/blog.php?mod=type&type=11";
		}  else if(s.equals("7")){
			url= "http://blog.sciencenet.cn/blog.php?mod=type&type=3";
		} else if(s.equals("8")){
			url= "http://blog.sciencenet.cn/blog.php?mod=type&type=10";
		} else if(s.equals("9")){
			url= "http://blog.sciencenet.cn/blog.php?mod=type&type=2";
		} else if(s.equals("10")){
			url= "http://blog.sciencenet.cn/blog.php?mod=type&type=7";
		} else if(s.equals("11")){
			url= "http://blog.sciencenet.cn/blog.php?mod=type&type=5";
		} else if(s.equals("12")){
			url= "http://blog.sciencenet.cn/blog.php?mod=type&type=6";
		} 
		return url;
	}

}
