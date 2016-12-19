$('#editUser').datagrid({    
    url:'user/list', 
	fitColumns:true,
	singleSelect:true,
	pagination:true,
    columns:[[    
        {field:'id',title:'编号',width:20,align:'center'},    
        {field:'name',title:'姓名',width:50,align:'center'},
        {field:'birthday',title:'生日',width:40,align:'center'},
        {field:'gender',title:'性别',width:20,align:'center'},
        {field:'career',title:'职位',width:30,align:'center'},
        {field:'address',title:'地址',width:70,align:'center'},
        {field:'mobile',title:'电话',width:40,align:'center'},
        {field:'picpath',title:'图像',width:50,height:50,align:'center',
        	formatter :function(value,row,index){
        		var path='';
        		if(row.picpath == '' || row.picpath==null){
        			path='images/QQ.png';
        		}else{
        			path=row.picpath
        		}
        		return "<img src='"+path+"' style='width:100px;height:100px'/>";
        	}
        },
        /*{field:'operator',title:'操作',width:60,align:'center',
        	formatter :function(value,row,index){
        		var str ='<a class="u_detail" href="javascript:void(0);"  onClick="OpWindow(this.innerText,'+row.id+')">详情</a> &nbsp;'
        		+'<a class="u_modify" href="javascript:void(0);"  onClick="OpWindow(this.innerText,'+row.id+')">修改</a>';
        		str+="<script>$('.u_detail').linkbutton({ iconCls: 'icon-search' });$('.u_modify').linkbutton({iconCls: 'icon-pencil'});</script>";
        		return str;
        	}
        },*/
        //第二种直接在网页上获取
        {field:'operator',title:'操作',width:60,align:'center',
        	formatter :function(value,row,index){
        		var str ='<a class="u_detail" href="javascript:void(0);"  onClick="OpDetail('+index+')">详情</a> &nbsp;'
        		+'<a class="u_modify" href="javascript:void(0);"  onClick="OpModify('+index+')">修改</a>';
        		str+="<script>$('.u_detail').linkbutton({ iconCls: 'icon-search' });$('.u_modify').linkbutton({iconCls: 'icon-pencil'});</script>";
        		return str;
        	}
        },
    ]]    
});



function OpModify(index){
	$("<div></div>").dialog({
		id:"mUser",
		title:'修改用户',
		width:300,
		height:500,
		left:100,
		top:60 + $(document).scrollTop(),
		//加载不了页面的 onload方法里面的东西 ，用异步的时候要考虑同步取数据的问题
		href:'easyui_page/modifyUser.jsp' ,/*"user/getModifyUser?usid="+usid,*/
		onClose:function(){
			 $(this).dialog('destroy');
		},
		modal: true  ,
		onLoad:function(){
			var row = $('#editUser').datagrid('getRows')[index];
			
			$("#m_id").textbox("setText",row.id);
			$("#m_name").textbox("setText",row.name);
			$("#m_birthday").textbox("setText",row.birthday);
			$("#m_gender").textbox("setText",row.gender);
			$("#m_career").textbox("setText",row.career);
			$("#m_address").textbox("setText",row.address);
			$("#m_mobile").textbox("setText",row.mobile);
			var picpath = "images/QQ.png";
			if(row.picpath !="" && row.picpath != null){
				picpath = row.picpath;
			}
			$("#m_picpath").attr("src",picpath);
			/**
			 * easyui textbox == > 3个input  一个放id（隐藏的）  一个放样式和值  最后一个放name（隐藏的）
			 * 所以需要提交表单时，必须在给最后一个放name的input也要取值
			 */
			//用于提交表单的formdata使用
			$("input[name='id']").val(row.id);
			$("input[name='name']").val(row.name);
			$("input[name='birthday']").val(row.birthday);
			$("input[name='gender']").val(row.gender);
			$("input[name='career']").val(row.career);
			$("input[name='address']").val(row.address);
			$("input[name='mobile']").val(row.mobile);
			//多一个记录数据库原来的头像路径
			$("input[name='picpath']").val(row.picpath);
		}
	});
}

function OpDetail(index){
	
	$("<div></div>").dialog({
		id:"dUser",
		title:'用户详情',
		width:300,
		height:500,
		left:100,
		top:60 + $(document).scrollTop(),
		//加载不了页面的 onload方法里面的东西 ，用异步的时候要考虑同步取数据的问题
		href:'easyui_page/getUser.jsp' ,/*"user/getModifyUser?usid="+usid,*/
		onClose:function(){
			 $(this).dialog('destroy');
		},
		modal: true  ,
		onLoad:function(){
			var row = $('#editUser').datagrid('getRows')[index];
			$("#g_id").textbox("setText",row.id);
			$("#g_name").textbox("setText",row.name);
			$("#g_birthday").textbox("setText",row.birthday);
			$("#g_gender").textbox("setText",row.gender);
			$("#g_career").textbox("setText",row.career);
			$("#g_address").textbox("setText",row.address);
			$("#g_mobile").textbox("setText",row.mobile);
			var picpath = "images/QQ.png";
			if(row.picpath !="" && row.picpath != null){
				picpath = row.picpath;
			}
			$("#g_picpath").attr("src",picpath);
		}
	});
}



/*
function OpWindow(opStr,usid){
	switch(opStr.trim()){
		case opType='详情':openDeatil(usid);break;
		case opType='修改':openModify(usid);break;
	}
}


function openModify(usid){
	$("<div></div>").dialog({
		id:"mUser",
		title:'修改用户',
		width:300,
		height:500,
		left:100,
		top:60 + $(document).scrollTop(),
		//加载不了页面的 onload方法里面的东西 ，用异步的时候要考虑同步取数据的问题
		href:'easyui_page/modifyUser.jsp' ,"user/getModifyUser?usid="+usid,
		onClose:function(){
			 $(this).dialog('destroy');
		},
		modal: true   
	});
}

function openDeatil(usid){
	$("<div></div>").dialog({
		id:"dUser",
		title:'用户详情',
		width:300,
		height:500,
		left:100,
		top:60+$(document).scrollTop(),
		//加载不了页面的 onload方法里面的东西 ，用异步的时候要考虑同步取数据的问题
		href:"user/getUser?usid="+usid,
		onClose:function(){
			 $(this).dialog('destroy');
		},
		modal: true   
	});	
}*/