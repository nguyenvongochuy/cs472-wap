package edu.miu.cs.cs427.lesson14.customertag;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CurrDateTag extends SimpleTagSupport {

	//private static final String DT_FORMAT_FULL = "EEEE, dd MMMM yyyy, HH:mm:ss";  
	//private static final String DT_FORMAT_FULL = "E yyyy.MM.dd hh:mm:ss a";  
	private static final String DT_FORMAT_DATE = "E yyyy.MM.dd";
	//private static final String DT_FORMAT_TIME = "hh:mm:ss a z";
	
	private String color;
	private String text;
	private String size;
	
	
	public CurrDateTag() {
		ZonedDateTime dtNow = ZonedDateTime.now();
		this.text = dtNow.format(DateTimeFormatter.ofPattern(DT_FORMAT_DATE));
	}
	
	public void doTag() throws JspException , IOException { //render custom tag
		JspWriter out = getJspContext().getOut();
		StringBuilder sb = new StringBuilder();
		sb.append("<span ");
		if (color!=null && size!=null) {
			sb.append(String.format("style='color:%s;font-size:%s'", color, size));
		} else if (color!=null && size==null) {
			sb.append(String.format("style='color:%s;'", color));
		} else if (color==null && size!=null) {
			sb.append(String.format("style='font-size:%s;'", size));
		}
			
		sb.append(">" + text + "</span>");
		out.write(sb.toString());
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setSize(String size) {
		this.size = size;
	}

}
