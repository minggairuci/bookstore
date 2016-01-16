<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath}/admin/css/Style.css"
	type="text/css" rel="stylesheet">
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/public.js"></script>
<script language="javascript"
	src="${pageContext.request.contextPath}/admin/js/check.js"></script>

</HEAD>
<body><!-- enctype="multipart/form-data" -->
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath }/addproduct" method="post">
		<input type="hidden" name="method" value="updateproduct"/>
		<input type="hidden" name="pid" value="${p.pid }">
	
		<table cellSpacing="1" cellPadding="5" width="100%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
					height="26"><strong><STRONG>编辑商品</STRONG> </strong></td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品名称：</td>
				<td class="ta_01" bgColor="#ffffff">
				<input type="text" name="pname" class="bg" value="${p.pname }" /></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品价格：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="price" class="bg" value="${p.price }" /></td>
			</tr>
			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品数量：</td>
				<td class="ta_01" bgColor="#ffffff"><input type="text"
					name="pnum" class="bg" value="${p.pnum }" /></td>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品类别：</td>
				<td class="ta_01" bgColor="#ffffff"><select name="category"
					id="category">
						<option value="">--选择商品类加--</option>
						<option value="文学" <c:if test="${p.category eq '文学' }">selected</c:if>>文学</option>
						<option value="生活"<c:if test="${p.category eq '生活' }">selected</c:if>>生活</option>
						<option value="计算机"<c:if test="${p.category eq '计算机' }">selected</c:if>>计算机</option>
						<option value="外语"<c:if test="${p.category eq '外语' }">selected</c:if>>外语</option>
						<option value="经营"<c:if test="${p.category eq '经营' }">selected</c:if>>经营</option>
						<option value="励志"<c:if test="${p.category eq '励志' }">selected</c:if>>励志</option>
						<option value="社科"<c:if test="${p.category eq '社科' }">selected</c:if>>社科</option>
						<option value="学术"<c:if test="${p.category eq '学术' }">selected</c:if>>学术</option>
						<option value="少儿"<c:if test="${p.category eq '少儿' }">selected</c:if>>少儿</option>
						<option value="艺术"<c:if test="${p.category eq '艺术' }">selected</c:if>>艺术</option>
						<option value="原版"<c:if test="${p.category eq '原版' }">selected</c:if>>原版</option>
						<option value="科技"<c:if test="${p.category eq '科技' }">selected</c:if>>科技</option>
						<option value="考试"<c:if test="${p.category eq '考试' }">selected</c:if>>考试</option>
						<option value="生活百科"<c:if test="${p.category eq '生活百科' }">selected</c:if>>生活百科</option>
				</select></td>
			</tr>


			<tr>
				<td align="center" bgColor="#f5fafe" class="ta_01">商品图片：</td>
				<td class="ta_01" bgColor="#ffffff" colSpan="3"><input
					type="file" name="upload" size="30" value="" /></td>
			</tr>
			<TR>
				<TD class="ta_01" align="center" bgColor="#f5fafe">商品描述：</TD>
				<TD class="ta_01" bgColor="#ffffff" colSpan="3"><textarea
						name="description" cols="30" rows="3" style="WIDTH: 96%">${p.description}</textarea>
				</TD>
			</TR>
			<TR>
				<td align="center" colSpan="4" class="sep1"><img
					src="${pageContext.request.contextPath}/admin/images/shim.gif">
				</td>
			</TR>


			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4"><input type="submit"
					class="button_ok" value="确定"> <FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>



					<input type="reset" value="重置" class="button_cancel"> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					class="button_ok" type="button" onclick="history.go(-1)" value="返回" />
					<span id="Label1"> </span></td>
			</tr>
		</table>
	</form>




</body>
</HTML>