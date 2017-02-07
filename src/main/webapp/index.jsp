<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>什马 Portal Demo</title>
</head>
<body>
	<br><br><br><br><br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;什马数据部门门户网站1.0版本<br/><br>
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/iattachment.jsp"><input id="map" name="map" type="button" value="地图demo"></a><br/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<iattachment.jsp"><input id="radio" name="radio" type="button" value="雷达demo"></a>
            
            
            
            <%-- <form action="<st:url value="login/getIAttachment"></st:url>" method="post">  
			   <!--  username:<input type="text" name="username">  
			    <br/>  
			    password:<input type="text" name="password">  
			    <br/>   -->
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提交">  
			</form>  --%>
	<script type="text/javascript">
		/*window.onload = function () {
			document.getElementById("map").onclick = function () {
				alert("触发成功！！！")
				$.ajax({
					type: "post",
					url: "../login/getIAttachment",
					data:{},
					dataType: "json",
					success: function (data) {},
					error: function () {
					}
				});

			}
		}*/
		
	

	</script>
</body>
</html>