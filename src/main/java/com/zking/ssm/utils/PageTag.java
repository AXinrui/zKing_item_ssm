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
			out.println(this.toHtml());
			return SKIP_BODY;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String toHtml() {
		StringBuffer bf = new StringBuffer();
		if (null == pageBean || !pageBean.isPagination()) {
			return bf.toString();
		}

		// 1. 鐢熸垚琛ㄥ崟
		bf.append("<form id='pageBeanForm' action='" + pageBean.getUrl() + "' method='post'>");
		bf.append("<input type='hidden' name='page' value=''>");
		for (Map.Entry<String, String[]> entry : pageBean.getParameterMap().entrySet()) {
			String name = entry.getKey();
			String[] values = entry.getValue();
			if ("page".equals(name)) {
				continue;
			}

			for (String value : values) {
				bf.append("<input type='hidden' name='" + name + "' value='" + value + "'>");
			}
		}
		bf.append("</form>");

		// 2. 鐢熸垚鎸夐挳
		bf.append("<div style='text-align: right;font-size: 12px;'>每页" + pageBean.getRows() + "条，共"
				+ pageBean.getTotal() + "条，第" + pageBean.getPage() + "页，共" + pageBean.getMaxPage()
				+ "页&nbsp;&nbsp;<a href='javascript:doGotoPage(1)'>首&nbsp;&nbsp;页</a>&nbsp;&nbsp;<a href='javascript:doGotoPage("
				+ pageBean.getPreviousPage() + ")'>上一页</a>&nbsp;&nbsp;<a href='javascript:doGotoPage("
				+ pageBean.getNextPage() + ")'>下一页</a>&nbsp;&nbsp;<a href='javascript:doGotoPage("
				+ pageBean.getMaxPage()
				+ ")'>末&nbsp;&nbsp;页</a>&nbsp;&nbsp;<input id='pageNumber' type='text' style='text-align: center;width: 30px;'>&nbsp;&nbsp;<a href='javascript:doSkipPage();'>GO</a></div>");

		// 3. 鍔ㄦ�佺敓鎴恓s
		bf.append("<script type='text/javascript'>");
		bf.append("function doGotoPage(page){");
		bf.append("  var form = document.getElementById('pageBeanForm');");
		bf.append("  form.page.value = page;");
		bf.append("  form.submit();");
		bf.append("}");
		bf.append("function doSkipPage(page){");
		bf.append("  var page = document.getElementById('pageNumber').value;");
		bf.append("  if(!page||isNaN(page)||parseInt(page)<1||parseInt(page)>"+pageBean.getMaxPage()+"){");
		bf.append("    alert('椤电爜蹇呴』涓�1~"+pageBean.getMaxPage()+"涔嬮棿鏁板瓧');");
		bf.append("    document.getElementById('pageNumber').value = '';");
		bf.append("    return;");
		bf.append("  }");
		bf.append("  doGotoPage(parseInt(page));");
		bf.append("}");
		bf.append("</script>");
		bf.append("");
		bf.append("");
		bf.append("");
		bf.append("");
		bf.append("");
		return bf.toString();
	}
}
