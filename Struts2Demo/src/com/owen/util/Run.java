package com.owen.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.html.HtmlDefinitionDescription;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.owen.util.GetAnchorList;

public class Run {
	
	//爬虫测试用
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
/*    	getAnchorList gta = new getAnchorList();
		HtmlPage firstPage = gta.getInitialPage("http://blog.sciencenet.cn/blog.php?mod=type&type=9");
//		System.out.println(gta.getInitialPage(gta.getCommentsList(firstPage)).asText());  //测试用，已经固定到tr的某个链接
		gta.getAnchorList(firstPage);
*/		
		RunHtmlunit rh = new RunHtmlunit();
	    HtmlPage firstPage = rh.getInitialPage("http://blog.sciencenet.cn/blog-814548-977887.html");
	    List<HtmlPage> pageList = rh.getAllPage(firstPage);
	    for(HtmlPage page:pageList){
	    	List<HtmlDefinitionDescription> listDD = rh.getCommentsList(page);
	    	for(HtmlDefinitionDescription dd:listDD){
	    		System.out.println(dd.asText()+"\n");
	    	}
	    }
		
		
		
	} 
}
