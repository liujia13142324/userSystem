<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<base href="/userSystem/">
</head>
<body style="width:100%;margin:0px auto;">
<c:set var="user" value="${requestScope.user }"/>
	<c:set var="user" value="${requestScope.user }"/>
	<form style="width:80%;margin:0px auto;">
      <p>
        <label>编号</label>
        <input  readonly="readonly" type="text" class="opt_input" id="g_id"  value="${user.id } "/>
        <label></label>
      </p>
      <p>
        <label>姓名</label>
        <input type="text" class="opt_input" id="g_name" readonly="readonly" value="${user.name }"/>
        <label></label>
      </p>
      <p>
       	<label>生日 </label>
       	<input  type="text" class="opt_input" id="g_birthday" readonly="readonly" value="${user.birthday }"/>
      </p>
      
      <p>
        <label>性别</label>
        <input  type="text" class="opt_input" id="g_gender" readonly="readonly" value="${user.gender }"/>
        <label></label>
	  </p>     
	  
	   <p>
        <label>职位</label>
        <input type="text" class="opt_input" id="g_career" readonly="readonly" value="${user.career }"/>
        <label></label>
	  </p>   
	  
	   <p>
        <label>地址</label>
        <input  type="text" class="opt_input" id="g_address" readonly="readonly" value="${user.address }"/>
        <label></label>
	  </p>   
	  
	   <p>
        <label>电话</label>
        <input  type="text" class="opt_input" id="g_mobile" readonly="readonly" value="${user.mobile }"/>
        <label></label>
	  </p>   
     	 <lable>头像</lable><img src="${user.picpath eq null ? 'images/QQ.png' : picpath}" id="g_picpath"/><br/><br/><br/>
      <a class="but_close" >关闭</a>
      
    </form>
    
	<script src="js2/getUser.js"></script>
	
</body>
</html>