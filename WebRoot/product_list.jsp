<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>bookStore列表</title>
<%--导入css --%>
<link rel="stylesheet" href="css/main.css" type="text/css" />
</head>

<body class="main">

	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td>
					<div style="text-align:right; margin:5px 10px 5px 0px">
						<a href="index.jsp">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;计算机&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;图书列表
					</div>

					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h1>商品目录</h1>
								<hr />
								<h1>计算机</h1>&nbsp;&nbsp;&nbsp;&nbsp;共100种商品
								<hr />
								<div style="margin-top:20px; margin-bottom:5px">
									<img src="images/productlist.gif" width="100%" height="38" />
								</div>
								<table cellspacing="0" class="booklist">
									<tr>
										<c:forEach var="p" items="${pagebean.beanList }">
											<td>

												<div class="divbookpic">
													<p>
														<a href="${pageContext.request.contextPath }/addproduct?method=findinfo&pid=${p.pid}"><img
															src="bookcover/101.jpg" width="115" height="129"
															border="0" /> </a>
													</p>
												</div>

												<div class="divlisttitle">
													<a href="${pageContext.request.contextPath }/addproduct?method=findinfo&pid=${p.pid}">书名:${p.pname }<br />售价:${p.price
														} </a>
												</div>
											</td>
											<td>
										</c:forEach>


									</tr>
								</table>

















								<div class="pagination">
									<ul>

										<c:if test="${pagebean.pageCode>1 }">
											<li class="disablepage">
												<a  href="${pagebean.url }&pc=${pagebean.pageCode-1}">上一页</a>
												<!--<a  href="${pageContext.request.contextPath }/addproduct?method=findByPage2&pc=${pagebean.pageCode-1}">上一页</a>-->
											</li>
										</c:if>
										<!-- 如果总页数小于10,begin=1,end=totalPage
										如果页面大于10  begin=&-5 end =&+4
										if  bengin<0  begin =1
										if end <0  end =totalPage
										 -->
										<!--   设置变量 -->

										<!-- 判断 总页数小于10 -->
										<c:choose>
											<c:when test="${ pagebean.totalPage <= 10 }">
												<c:set var="begin" value="1"></c:set>
												<c:set var="end" value="${ pagebean.totalPage }"></c:set>
											</c:when>
											<c:otherwise>
												<c:set var="begin" value="${ pagebean.pageCode - 5 }"></c:set>
												<c:set var="end" value="${ pagebean.pageCode + 4 }"></c:set>
												<%--头溢出 --%>
												<c:if test="${ begin < 1 }">
													<c:set var="begin" value="1"></c:set>
													<c:set var="end" value="10"></c:set>
												</c:if>
												<%--尾溢出 --%>
												<c:if test="${ end > pagebean.totalPage }">
													<c:set var="begin" value="${ pagebean.totalPage - 9 }"></c:set>
													<c:set var="end" value="${ pagebean.totalPage }"></c:set>
												</c:if>
											</c:otherwise>
										</c:choose>

										<c:forEach var="i" begin="${begin }" end="${end }" step="1">

											<c:if test="${pagebean.pageCode==i }">
												<li class="currentpage">${i }</li>
											</c:if>
											<c:if test="${pagebean.pageCode!=i }">
												<li><a	href="${pagebean.url }&pc=${i}">
												<!-- <a	href="${pageContext.request.contextPath }/addproduct?method=findByPage2&pc=${i}"> -->${i
														}</a>
											</c:if>
											<!--  <li class="currentpage">i</li>
										<li><a href="product_info.jsp">2</a>
										</li>
						
										<li><a href="product_info.jsp">3</a>
										</li>
										<li><a href="product_info.jsp">4</a>
										</li>-->
										</c:forEach>
										<c:if test="${pagebean.pageCode<pagebean.totalPage }">
											<li class="nextpage">
											<a href="${pagebean.url }&pc=${ pagebean.pageCode+1}">
												<!--  <a href="${pageContext.request.contextPath }/addproduct?method=findByPage2&pc=${ pagebean.pageCode+1}">-->下一页&gt;&gt;</a>
											</li>
										</c:if>

									</ul>
								</div></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>



	<jsp:include page="foot.jsp" />


</body>
</html>
