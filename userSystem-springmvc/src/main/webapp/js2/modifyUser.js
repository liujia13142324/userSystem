
// 图标无法显示
$('.but_close').linkbutton({ iconCls: 'icon-cancel',  });

$('#modify').linkbutton({ 
	iconCls: 'icon-ok', 
	onClick:function(){
		$("#modify_user").submit();
	}
});

$(".but_close").click(function(){
	$('#mUser').dialog('destroy');
})
$(".opt_input").textbox({  
})
/*$("#picpathFile").filebox({    
    buttonText: '选择', 
    buttonAlign: 'left', 
    onChange:function(newValue, oldValue){
    	
    }
});
*/

$("#modify_user").form({
	url:"user/modify",
    success:function(data){
  	  //这种异步获得都是字符串
  	  if(data.trim() =='true'){
  		  msg("修改通知","修改成功..");
  		  $("#mUser").dialog("destroy");
  		  $("#editUser").datagrid("reload");
  	  }else{
  		  $.messager.alert('修改通知','修改失败！！','info');
  	  }
    },
    //服务器端关于修改错误的异常应该传过来
    error:function(e){
        alert("错误！！");
    }
});


/*function modify_User(id){
	
	var form = new FormData(document.getElementById("modify_user"));
	
	$.ajax({
      url:"user/modifyUser",
      type:"post",
      data:form,
      processData:false,
      contentType:false,
      success:function(data){
    	  //这种异步获得都是字符串
    	  if(data.trim() =='true'){
    		  msg("修改通知","修改成功..");
    		  $("#mUser").dialog("destroy");
    		  $("#editUser").datagrid("reload");
    	  }else{
    		  $.messager.alert('修改通知','修改失败！！','info');
    	  }
      },
      //服务器端关于修改错误的异常应该传过来
      error:function(e){
          alert("错误！！");
      }
  });        
}*/



function openPic(obj){
	var uriStr = window.URL.createObjectURL(obj.files[0]);
	console.info(uriStr);
	$("#m_picpath").attr("src",uriStr );
	//需要上传图片，这是二进制的图片
	//$("input[name='user.picpath']").val($("#m_picpath").attr("src"));
}

	

function msg(title,msg){
	$.messager.show({
			title:title,
			msg:msg,
			showType:'show',
			timeout:1000,
			style:{
				right:screen.availWidth/2+this.clientWidth/2,
				top:document.body.scrollTop+document.documentElement.scrollTop+screen.availHeight/2-this.clientHeight/2,
				bottom:''
			}
	
	});
}
