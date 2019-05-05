package com.zking.ssm.utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.util.Map;


public class PageTag extends BodyTagSupport {

	private static final long serialVersionUID = 8003507841172246203L;

	private PageBean pageBean;

	public PageTag() {
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

		// 生成分页按钮
		bf.append("<div style='text-align: center;font-size: 12px;'>每页" + this.getPageBean().getRows() + "条，共"
				+ this.pageBean.getTotal() + "条，第" + pageBean.getPage() + "页，共" + pageBean.getMaxPage()
				+ "页&nbsp;&nbsp;<a href='javascript:gotoPage(1)'>首&nbsp;&nbsp;页</a>&nbsp;&nbsp;<a href='javascript:gotoPage("
				+ pageBean.getPreviousPage() + ")'>上一页</a>&nbsp;&nbsp;<a href='javascript:gotoPage("
				+ pageBean.getNextPage() + ")'>下一页</a>&nbsp;&nbsp;<a href='javascript:gotoPage(" + pageBean.getMaxPage()
				+ ")'>末&nbsp;&nbsp;页</a>&nbsp;&nbsp;<input id='skipPage' type='text' style='text-align: center;font-size: 12px;width:50px;'>&nbsp;&nbsp;<a href='javascript:skipPage();'>GO</a></div>");

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
