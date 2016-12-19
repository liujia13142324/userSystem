<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body style="width:100%; margin:0px auto;">
<c:set var="user" value="${requestScope.user }"/>
	<c:set var="user" value="${requestScope.user }"/>
	<form  method="post" id="modify_user" enctype="multipart/form-data" style="width:80%; margin:0px auto;">
      <p>
        <label>编号</label>
        <input name="id" readonly="readonly" type="text" class="opt_input" id="m_id" />
        <label></label>
      </p>
      <p>
        <label>姓名</label>
        <input name="name" type="text" class="opt_input" id="m_name" required="required" />
        <label></label>
      </p>
      <p>
       	<label>生日 </label>
       	<input name="birthday" type="text" class="opt_input" id="m_birthday" required="required" />
      </p>
      
      <p>
        <label>性别</label>
        <input name="gender" type="text" class="opt_input" id="m_gender" required="required"/>
        <label></label>
	  </p>     
	  
	   <p>
        <label>职位</label>
        <input name="career" type="text" class="opt_input" id="m_career" required="required"/>
        <label></label>
	  </p>   
	  
	   <p>
        <label>地址</label>
        <input name="address" type="text" class="opt_input" id="m_address" required="required" />
        <label></label>
	  </p>   
	  
	   <p>
        <label>电话</label>
        <input name="mobile" type="text" class="opt_input" id="m_mobile" required="required" required="required"/>
        <label></label>
	  </p>   
	  <lable>头像</lable> <input type="file" style="width:70px;" name="picpathFile" id="picpathFile" onchange="openPic(this)"/>
	  					<input type="hidden" name="picpath"/>
	  <img src="${picpath eq null ? 'images/QQ.png' : picpath}" id="m_picpath"/><br/><br/><br/>
      <a type="button" id="modify">修改</a>
      <a type="button"  class="but_close" >关闭</a>
    </form>
    
	<script src="js2/modifyUser.js"></script>
	
</body>
</html>