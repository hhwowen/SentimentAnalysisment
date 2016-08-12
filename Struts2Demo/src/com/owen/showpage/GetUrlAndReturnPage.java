package com.owen.showpage;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class GetUrlAndReturnPage extends ActionSupport{
	public String url;
	public List<CommentData> listCommentsData;
	public String date;
	public int numPos;
	public int numNeu;
	public int numNeg;
	public String percentagePos;
	public String percentageNeu;
	public String percentageNeg;
	
	public String getPercentagePos() {
		return percentagePos;
	}

	public void setPercentagePos(String percentagePos) {
		this.percentagePos = percentagePos;
	}

	public String getPercentageNeu() {
		return percentageNeu;
	}

	public void setPercentageNeu(String percentageNeu) {
		this.percentageNeu = percentageNeu;
	}

	public String getPercentageNeg() {
		return percentageNeg;
	}

	public void setPercentageNeg(String percentageNeg) {
		this.percentageNeg = percentageNeg;
	}
	public int getNumPos() {
		return numPos;
	}

	public void setNumPos(int numPos) {
		this.numPos = numPos;
	}

	public int getNumNeu() {
		return numNeu;
	}

	public void setNumNeu(int numNeu) {
		this.numNeu = numNeu;
	}

	public int getNumNeg() {
		return numNeg;
	}

	public void setNumNeg(int numNeg) {
		this.numNeg = numNeg;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<CommentData> getListCommentsData() {
		return listCommentsData;
	}

	public void setListCommentsData(List<CommentData> listCommentsData) {
		this.listCommentsData = listCommentsData;
	}
	
	public String myPercent(int y,int z){
		   String baifenbi="";//接受百分比的值
		   double baiy=y*1.0;
		   double baiz=z*1.0;
		   double fen=baiy/baiz;
		   //NumberFormat nf   =   NumberFormat.getPercentInstance();     //注释掉的也是一种方法
		   //nf.setMinimumFractionDigits( 2 );        保留到小数点后几位
		   DecimalFormat df1 = new DecimalFormat("##.0%");    //##.00%   百分比格式，后面不足2位的用0补齐
		    //baifenbi=nf.format(fen);   
		   baifenbi= df1.format(fen);  
		    return baifenbi;
	}
	
	public String execute() throws Exception {  
        // TODO Auto-generated method stub  
		date = DateFormat.getInstance().format(new Date());
    	url = "http://blog.sciencenet.cn/"+ServletActionContext.getRequest().getParameter("url1").toString();     
        System.out.println(url);
        LoadCommentData lcd = new LoadCommentData();
        listCommentsData = lcd.generateCommentData(url);
        
    //    ServletContext sct= this.getServletConfig().getServletContext();
        
        HttpServletRequest res = ServletActionContext.getRequest();
		res.setAttribute("listCD", listCommentsData);
		res.setAttribute("NumPos", numPos);
		//new add
		numPos = 0;
		numNeu = 0;
		numNeg = 0;
        for(CommentData cd:listCommentsData){
        	String re = cd.sentiment;
        	if(re.equals("positive")){
        		numPos++;
        	}else if (re.equals("neutral")){
        		numNeu++;
        	}else if (re.equals("negative")){
        		numNeg++;
        	}
        	
        }
        int all = numPos+numNeu+numNeg; 
        percentagePos = myPercent(numPos,all);
        percentageNeu = myPercent(numNeu,all);
        percentageNeg = myPercent(numNeg,all);
        
        System.out.println(numPos+"aaa"+numNeu+"bbb"+numNeg);
        return SUCCESS;  
    } 

}
