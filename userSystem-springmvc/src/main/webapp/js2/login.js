$('#LoginDiv').dialog({    
    title: '',  
    top: 50,  
    width: 320,    
    height: 200,    
    closable: false,
    cache: false,   
    draggable:false,
    modal: true,
    border:false
});    

$('#uname').textbox({    
})

$('#ucode').textbox({    
})

$('#bnt_login').linkbutton({    
    iconCls: 'icon-man',
    onClick : function(){
    	$('#loginForm').submit();
    }
});  

/*$('#loginForm').form({    
    url:'User_login',    
    success:function(data){    
        if(data.trim() == "true"){
        	location.replace("easyui_page/user_edit.jsp");
        }else{
        	$.messager.show({
        		title:'登陆消息',
        		msg:'登陆失败',
        		showType:'show',
        		timeout:1000,
        		style:{
        			right:'',
        			top:document.body.scrollTop+document.documentElement.scrollTop,
        			bottom:''
        		}
        	});
        }
    }    
});*/


