package com.owen.showpage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.html.HtmlDefinitionDescription;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.owen.classify.RunClassifier;
import com.owen.util.RunHtmlunit;

public class LoadCommentData {
//	public List<CommentData> listCommentData;
	public RunClassifier classifier;
	public RunHtmlunit spider;
	
	public LoadCommentData(){
//		listCommentData = new ArrayList<CommentData>();
		//读取已经在tomcat启动时加载好的分类器classifier
		HttpServletRequest res = ServletActionContext.getRequest();
		ServletContext sct = res.getServletContext();
		//classifier = new RunClassifier();
		classifier = (RunClassifier) sct.getAttribute("classifier");
		spider = new RunHtmlunit();
	}
	
	public String classify(String s) throws ClassNotFoundException, IOException{
		String result = "";
		String classifiedResult = classifier.classifyString(s);
	//	ServletContext sct= this.getServletContext();

		
		
		if(classifiedResult.equals("neg.csv")){
			result="negative";
		}else if(classifiedResult.equals("neu.csv")){
			result="neutral";
		}else if(classifiedResult.equals("pos.csv")){
			result="positive";
		}
		return result;	
	}
	
	public List<String> getComments(String url) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		HtmlPage firstPage = spider.getInitialPage(url);
		List<String> comments = new ArrayList<String>();
	    List<HtmlPage> pageList = spider.getAllPage(firstPage);
	    for(HtmlPage page:pageList){
	    	List<HtmlDefinitionDescription> listDD = spider.getCommentsList(page);
	    	for(HtmlDefinitionDescription dd:listDD){
	    		comments.add(dd.asText());
	    	//	System.out.println(dd.asText()+"\n");
	    	}
	    }
		
		return comments;
	}
	//最终生成完整的评论+情感倾向的list
	public List<CommentData> generateCommentData(String url) throws FailingHttpStatusCodeException, MalformedURLException, IOException, ClassNotFoundException{		
		List<CommentData> listCommentData = new ArrayList<CommentData>();
		List<String> comments = getComments(url);
		for(String s:comments){
			CommentData commentData = new CommentData();
			commentData.setComment(s);
			commentData.setSentiment(classify(s));
			listCommentData.add(commentData);
		}
		return listCommentData;
	}	
}
