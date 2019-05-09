package com.zking.ssm.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.util.Map;


public class PageTagLayui extends BodyTagSupport {

	private static final long serialVersionUID = 8003507841172246203L;

	private PageBean pageBean;

	public PageTagLayui() {
		super();
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
			JspWriter out = pageContext.getOut();
			out.println(this.toHTML());
			return SKIP_BODY;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String toHTML() {

		if (null == pageBean || !pageBean.isPagination()) {
			return "";
		}
		StringBuffer bf = new StringBuffer();
		// 生成表单及参数
		bf.append("<form id='pageBeanForm' action='" + this.pageBean.getUrl() + "' method='post'>");
		bf.append("<input type='hidden' name='page' value=''>");
		String name = null;
		String[] values = null;
		for (Map.Entry<String, String[]> entry : pageBean.getParameterMap().entrySet()) {
			name = entry.getKey();
			if ("page".equals(name)) {
				continue;// 通过js代码修改
			}
			values = entry.getValue();
			for (String value : values) {
				bf.append("<input type='hidden' name='" + name + "' value='" + value + "'>");
			}
		}
		bf.append("</form>");

		int max =	pageBean.getMaxPage();//当前页面
		int rows = pageBean.getRows();//每页都是条
		int page =  pageBean.getPage();//当前页面
		String minDisabled = "";
		String maxDisabled = "";
		if(page==1){
			minDisabled = "layui-disabled";
		}
		if (page==max||max==0) {
			maxDisabled = "layui-disabled";
		}
		String str = "<div class='layui-card-body '><div class='page'><div><a class='prev "+minDisabled+"' href='javascript:gotoPage("+ pageBean.getPreviousPage() + ")'>上一页</a>";
		String front ="";
		if(max<=5){
			for (int i= 1;i<=max;i++){
				if (i==page) {
					front +="<span class='current'>"+ page + "</span>";
				}else{
					front += "<a class='num' href='javascript:gotoPage("+i+")'>"+i+"</a>";
				}
			}
		}else if(max>5&&max<9){
			if (page>=5) {
				front += "<a class='num' href='javascript:gotoPage(1)'>1</a>";
				front += "<a class='layui-laypage-spr'>...</a>";
				for (int i= max-4;i<=max;i++){
					if (i==page) {
						front +="<span class='current'>"+ page + "</span>";
					}else{
						front += "<a class='num' href='javascript:gotoPage("+i+")'>"+i+"</a>";
					}
				}
			}else{
				for (int i= 1;i<5;i++){
					if (i==page) {
						front +="<span class='current'>"+ page + "</span>";
					}else{
						front += "<a class='num' href='javascript:gotoPage("+i+")'>"+i+"</a>";
					}
				}
				front += "<a class='layui-laypage-spr' >...</a>";
				front += "<a class='num' href='javascript:gotoPage("+max+")'>"+max+"</a>";
			}
		}else{
			if(page<5){
				for (int i= 1;i<=5;i++){
					if (i==page) {
						front +="<span class='current'>"+ page + "</span>";
					}else{
						front += "<a class='num' href='javascript:gotoPage("+i+")'>"+i+"</a>";
					}
				}
				front += "<a class='layui-laypage-spr' >...</a>";
				front += "<a class='num' href='javascript:gotoPage("+max+")'>"+max+"</a>";
			}else if(page>max-4){
				front += "<a class='num' href='javascript:gotoPage(1)'>1</a>";
				front += "<a class='layui-laypage-spr'>...</a>";
				for (int i= max-5;i<=max;i++){
					if (i==page) {
						front +="<span class='current'>"+ page + "</span>";
					}else{
						front += "<a class='num' href='javascript:gotoPage("+i+")'>"+i+"</a>";
					}
					System.out.println("i----------:"+i);
				}
			}else{
				front += "<a class='num' href='javascript:gotoPage(1)'>1</a>";
				front += "<a class='layui-laypage-spr' >...</a>";
				for (int i= page-2;i<page;i++){
					front += "<a class='num' href='javascript:gotoPage("+i+")'>"+i+"</a>";
				}
				front +="<span class='current'>"+ page + "</span>";
				for (int i= page+1;i<page+3;i++){
					front += "<a class='num' href='javascript:gotoPage("+i+")'>"+i+"</a>";
				}
				front += "<a class='layui-laypage-spr' href=''>...</a>";
				front += "<a class='num' href='javascript:gotoPage("+max+")'>"+max+"</a>";
			}

		}
		str += front;
		str += "<a class='next "+maxDisabled+"' href='javascript:gotoPage("+ pageBean.getNextPage() +")'>下一页</a></div></div></div>";

		// 生成分页按钮
		bf.append(str);

		// 生成js
		bf.append("<script>");
		bf.append("function gotoPage(page){");
		bf.append("  document.getElementById('pageBeanForm').page.value = page;");
		bf.append("  document.getElementById('pageBeanForm').submit();");
		bf.append("}");
		bf.append("var maxPage="+pageBean.getMaxPage()+";");
		bf.append("function skipPage(){");
		bf.append("  var page = document.getElementById('skipPage').value;");
		bf.append("  if(!page||isNaN(page)||parseInt(page)<1||parseInt(page)>maxPage){");
		bf.append("    alert('请输入1~8之间的数字');");
		bf.append("    return;");
		bf.append("  }");
		bf.append("  gotoPage(page);");
		bf.append("}");
		bf.append("</script>");
		return bf.toString();
	}
}
