<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>后台登陆界面</title>
<link rel="stylesheet" href="easyui/themes/icon.css">
<link  rel="stylesheet" href="easyui/themes/default/easyui.css">
<link  rel="stylesheet" href="css/login.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
</head>
<body>
	<div id="LoginDiv">
		<form id="loginForm" action="user/login" method="post">
			
		<table>
			<tr>
				<td colspan="2">
					<label id="errorMsg">${errorMsg}&nbsp;</label>
					<c:remove var="errorMsg"/>
				</td>
			</tr>
			<tr>
				<td>
					编号：
				</td>
				<td>
					<input  required="required" name="id" id="ucode" value='1003'/>
				</td>
			</tr>
			<tr>
				<td>
					姓名：
				</td>
				<td>
					<input  required="required" name="name" id="uname" value='gIYSutLzoWOhtyjzUbxi' />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><button id="bnt_login">登陆</button></td>
			</tr>
		</table>
			
		</form>
	</div>
	<img src="/upload/7.jpg"/>
</body>
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js2/login.js"></script>
</html>