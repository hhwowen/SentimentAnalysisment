package com.owen.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.owen.util.Data;

public class GetAnchorList {
	 public WebClient webClient;
	
	 public  GetAnchorList(){
	    	webClient = new WebClient(BrowserVersion.CHROME);
	    	webClient.getOptions().setJavaScriptEnabled(true);  
	        webClient.getOptions().setActiveXNative(false);  
	        webClient.getOptions().setCssEnabled(false);  
	        webClient.getOptions().setThrowExceptionOnScriptError(false); 
	        webClient.waitForBackgroundJavaScript(600*1000);
	        webClient.setAjaxController(new  NicelyResynchronizingAjaxController());
			  	
	    }
		
		public  HtmlPage getInitialPage(String url1) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		    HtmlPage page = null ;
			page = webClient.getPage(url1);
			webClient.waitForBackgroundJavaScript(1000*3);  
	        webClient.setJavaScriptTimeout(0);
	
			return page;
		}
	    
		public  List<HtmlPage> getAllPage(HtmlPage page){
			List<HtmlPage> pageList = new ArrayList<HtmlPage>();
			pageList.add(0, page.cloneNode(true));
		 //第一页已经在getInitalpage中得到。
			for(int i = 2;i<4;i++){
				try{
					HtmlAnchor Btn1 = page.getAnchorByText("下一页");  //测试是否存在下一页，若不存在则用try catch 抛出异常。
					try {
						HtmlInput input = (HtmlInput)page.getHtmlElementById("skiptopage");
						input.setValueAttribute(i+" "); //该input框只能填string
						HtmlAnchor Btn = page.getAnchorByText("跳转");
					//	String pageName = "pageNew" + i;
						HtmlPage pageNew = Btn.click();
						
					//	pageNew = Btn.click();
						webClient.waitForBackgroundJavaScript(1000*3);  
				        webClient.setJavaScriptTimeout(0);
					//	getComments(pageNew);
				    //  pageList.add(pageNew.cloneNode(true));
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
		////*[@id="main"]/div/table/tbody/tr[11]/td[2]/a
		// List<HtmlElement>
		public List<Data> getAnchorList(HtmlPage page){
			@SuppressWarnings("unchecked")
			HtmlDivision div = (HtmlDivision) page.getElementById("main"); 
			List<HtmlElement> listTR = div.getElementsByTagName("tr").subList(1,div.getElementsByTagName("tr").getLength() );
			// listTR.remove(0);
			List<Data> listData = new ArrayList<Data>();
			for(HtmlElement TR:listTR){
				Data D = new Data();
				D.setTitle(TR.getElementsByTagName("a").get(0).getAttribute("title"));
				D.setHref(TR.getElementsByTagName("td").get(1).getElementsByTagName("a").get(0).getAttribute("href"));
				D.setAnthor(TR.getElementsByTagName("td").get(2).asText());
				D.setClickSum(TR.getElementsByTagName("td").get(3).asText());
				D.setCommentSum(TR.getElementsByTagName("td").get(4).asText());
				D.setDate(TR.getElementsByTagName("td").get(5).asText());				
				listData.add(D);				
			}	
			
//			System.out.println(listTR.get(1).getElementsByTagName("td").get(1).getElementsByTagName("a").get(0).getAttribute("href")+"href\n");//href
//			System.out.println(listTR.get(1).getElementsByTagName("td").get(1).getElementsByTagName("a").get(0).getAttribute("title")+"title\n");//title
//			System.out.println(listTR.get(1).getElementsByTagName("td").get(2).asText()+"author\n"); //author
//			System.out.println(listTR.get(1).getElementsByTagName("td").get(3).asText()+"clicksum\n"); //clicksum
//			System.out.println(listTR.get(1).getElementsByTagName("td").get(4).asText()+"commentsum\n"); //commentsum
//			System.out.println(listTR.get(1).getElementsByTagName("td").get(5).asText()+"date\n"); //date
			
/*			String s = listTR.get(1).getElementsByTagName("a").get(0).getAttribute("href");
			System.out.println(s);
			String newurl = "http://blog.sciencenet.cn/" + s;
*/			
		//	List<HtmlAnchor> listDD = (List<HtmlAnchor>) div.getByXPath("");//getByXPath("//dd[contains(@id,'comment_')]");
//			for(int i = 0;i < listTR.size();i++ ){
//				System.out.println(listTR.get(i).asXml()+"\n");	
//			}
			return listData; 
		}
		

}
