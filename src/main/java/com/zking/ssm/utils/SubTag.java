package com.zking.ssm.utils;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class SubTag extends BodyTagSupport{

	private static final long serialVersionUID = -5021671818137777473L;
	
	private String name;
	
	private int size = 10;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void setSize(String size) {
		this.size = Integer.parseInt(size);
	}

	public String getName() {
		return name;
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        

	public void setName(String name) {
		this.name = name;
	}

	public SubTag() {
	}
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		if(name.length()>this.size) {
			name=name.substring(0, this.size)+"...";
		}
		try {
			out.print(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}

}
