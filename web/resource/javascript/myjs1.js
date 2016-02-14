	function addLoadEvent(func){
		var oldonload=window.onload;
		if(typeof window.onload!='function'){
			window.onload=func;
		}else{
			window.onload=function(){
				oldonload();
				func();
			}
		}
	}

	addLoadEvent();

	var dl=document.getElementById("dl");
	var zc=document.getElementById("zc");

	var dra1=document.getElementById("dra1");
	var dra2=document.getElementById("dra2");

	var close1=document.getElementById("close1")
	var close2=document.getElementById("close2")

	var box1=document.getElementById("box1");
	var box2=document.getElementById("box2");


	dl.onclick=function(){
		openNew(box1,close1);
	}
	zc.onclick=function(){
		openNew(box2,close2);
	}
	function openNew(box,close){
	    
	    box.style.display="block";
	    //获取页面的高度和宽度
	    var sWidth=document.documentElement.scrollWidth;
	    var sHeight=document.documentElement.scrollHeight;  //获取页面的高度
		
	    //获取页面的可视区域高度和宽度
	    var wHeight=document.documentElement.clientHeight;     // 获取页面可视区域的高度
	    var wWidth=document.documentElement.clientWidth;
	    
	    var oMask=document.createElement("div");
	        oMask.id="mask";
	        oMask.style.width=sWidth+"px";
	        oMask.style.height=sHeight+"px";
	        document.body.appendChild(oMask);    
	    	
		//获取登陆框的宽和高
		var dHeight=box.offsetHeight;   // 获取登陆框的高度
		var dWidth=box.offsetWidth;      // 获取登陆框的宽度
		//设置登陆框的left和top
		box.style.left=wWidth/2-dWidth/2+"px";
		box.style.top=wHeight/2-dHeight/2+"px";  //设置登陆框top值
		
		//点击登陆框以外的区域也可以关闭登陆框
		oMask.onclick=close.onclick=function(){
            document.body.removeChild(oMask);
            box.style.display="none";
		}
	}
	dra1.onmousedown=function(){
		fnDown(event,box1);
	}
	dra2.onmousedown=function(){
		fnDown(event,box2);
	}	    
	function fnDown(event,box){
	    event = event || window.event;
        // 光标按下时光标和面板之间的距离
        var disX=event.clientX-box.offsetLeft,
            disY=event.clientY-box.offsetTop;
	    
	    document.onmousemove=function(event){
	    	event = event || window.event;
	    	var a=box;
	    	fnMove(event,a,disX,disY);
	    }
	    // 释放鼠标
	    document.onmouseup=function(){
	    	document.onmousemove=null;
	    	document.onmouseup=null;
	    }
	}

	function fnMove(e,a,posX,posY){
	    var l=e.clientX-posX,
	        t=e.clientY-posY,
	        winW=document.documentElement.clientWidth || document.body.clientWidth,
	        winH=document.documentElement.clientHeight || document.body.clientHeight,
	        maxW=winW-a.offsetWidth,
	        maxH=winH-a.offsetHeight;
	    if(l<0){
	        l=0;
	    }else if(l>maxW){
	        l=maxW;
	    }
	    if(t<0){
	        t=0;
	    }else if(t>maxH){
	        t=maxH;
	    }
	    a.style.left=l+'px';
	    a.style.top=t+'px';
	}


$(function(){
	$("#subdl").click(function(){

		$.ajax({
			url: "http://192.168.23.1:8080/login",

			type: "POST",
			data:{
				userName:$("#dluser").val(), 
				passWord:$("#dlpass").val()
			},
			dataType: "json",
			
			success: function(data){
				if(data.isSuccess){
					alert("登录成功！");
					$("#box1").hide();
				}else{
					alert("用户名或密码错误，请重新登录！");
				}
			},
			error: function(){
				alert("error");
			},
		})	
	})
})


