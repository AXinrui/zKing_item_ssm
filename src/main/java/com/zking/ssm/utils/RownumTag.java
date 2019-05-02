package com.zking.ssm.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;


public class RownumTag extends BodyTagSupport {

	private static final long serialVersionUID = 8003507841172246203L;

	private PageBean pageBean;

	private Integer count;

	public RownumTag() {
		super();
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			int rownum = (pageBean.getPage() - 1) * pageBean.getRows() + count;
			JspWriter out = pageContext.getOut();
			out.println(rownum + "");
			return SKIP_BODY;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
