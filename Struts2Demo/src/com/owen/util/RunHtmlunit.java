package com.owen.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDefinitionDescription;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class RunHtmlunit {
	public WebClient webClient;
	
	public RunHtmlunit(){
    	webClient = new WebClient(BrowserVersion.CHROME);
    	webClient.getOptions().setJavaScriptEnabled(true);  
        webClient.getOptions().setActiveXNative(false);  
        webClient.getOptions().setCssEnabled(false);  
        webClient.getOptions().setThrowExceptionOnScriptError(false); 
        webClient.waitForBackgroundJavaScript(600*1000);
        webClient.setAjaxController(new  NicelyResynchronizingAjaxController());
	}
	
	//获取Url的初始页面
	public  HtmlPage getInitialPage(String url1) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
	    HtmlPage page = null ;
		page = webClient.getPage(url1);
		webClient.waitForBackgroundJavaScript(1000*3);  
        webClient.setJavaScriptTimeout(0);
		return page;
	}
	
	//获取ajax页面，得到多个页面的list
	public  List<HtmlPage> getAllPage(HtmlPage page){
		List<HtmlPage> pageList = new ArrayList<HtmlPage>();
		pageList.add(0, page.cloneNode(true));
	 //第一页已经在getInitalpage中得到。
		for(int i = 2;i<4;i++){
			try{
				HtmlAnchor Btn1 = page.getAnchorByText("下一页");  //测试是否存在下一页，若不存在则用try catch 抛出异常，结束爬取。
				try {
					HtmlInput input = (HtmlInput)page.getHtmlElementById("skiptopage");
					input.setValueAttribute(i+" "); //该input框只能填string
					HtmlAnchor Btn = page.getAnchorByText("跳转");
					HtmlPage pageNew = Btn.click();
					webClient.waitForBackgroundJavaScript(1000*3);  
			        webClient.setJavaScriptTimeout(0);
			        pageList.add(i-1, pageNew.cloneNode(true));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}catch(ElementNotFoundException e){
				i--;
	        	System.out.println("共"+i+"页,无下一页"); 
	        	break;
	        }			
		}
		return pageList;	
	}
	
	//获取评论 并删除空白行
	public List<HtmlDefinitionDescription> getCommentsList(HtmlPage page){
		@SuppressWarnings("unchecked")
		List<HtmlDefinitionDescription> listDD = (List<HtmlDefinitionDescription>) page.getByXPath("//dd[contains(@id,'comment_')]");
		for(int i = 0;i < listDD.size();i++ ){
			//System.out.println(dd.asText()+"\n");	
		if(listDD.get(i).asText().equals("")){
				listDD.remove(i);
			}
		}
		return listDD;
	}
}
