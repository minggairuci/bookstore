<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my.js">
	
</script>
<script type="text/javascript">
<!--
	function fillNameValue(subDiv) {
		document.getElementById("name").value = subDiv.innerHTML;
		
		document.getElementById("content").style.display="none";
	}

	function searchName() {
		var nameElement = document.getElementById("name");
		//获取输入的信息
		var nameValue = nameElement.value;

		var div = document.getElementById("content");
		div.innerHTML = "";
		//1.获取XMLHttpRequest对象
		var xmlhttp = getXMLHttpRequest();

		//2.绑定回调函数
		xmlhttp.onreadystatechange = function() {

			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

				var jsonObj = eval("(" + xmlhttp.responseText + ")");
				
				if(jsonObj.length>0){
					document.getElementById("content").style.display="block";
					for ( var i = 0; i < jsonObj.length; i++) {
						div.innerHTML += "<div onclick='fillNameValue(this)' onmouseover='changeBackground_over(this)' onmouseout='changeBackground_out(this)'>"
								+ jsonObj[i] + "</div>"
					}
				}

			}
		};
		//3.open
		xmlhttp.open("GET",
				"${pageContext.request.contextPath}/findProductName?name="
						+ window.encodeURIComponent(nameValue, "utf-8")
						+ "&time=" + new Date().getTime());
		//4.send
		xmlhttp.send(null);
	};
	
	function changeBackground_over(div){
		div.style.background="gray";
	}
	
	function changeBackground_out(div){
		div.style.background="white";
	}
//-->
</script>

<div id="divmenu">
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=文学">文学</a>
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=生活">生活</a>
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=计算机">计算机</a>
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=外语">外语</a>
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=经营">经管</a>
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=励志">励志</a>
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=社科">社科</a>
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=学术">学术</a>
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=少儿">少儿</a>
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=艺术">艺术</a>
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=原版">原版</a>
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=科技">科技</a>
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=考试">考试</a>
	<a
		href="${pageContext.request.contextPath}/addproduct?method=findByPage2&category=生活百科">生活百科</a>
	<a href="${pageContext.request.contextPath}/addproduct?method=findByPage2"
		style="color:#FFFF00">全部商品目录</a>
</div>
|

/div>