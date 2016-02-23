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

    var signin=document.getElementById("signin");
    var signup=document.getElementById("signup");

    var inbox=document.getElementById("inbox");
    var upbox=document.getElementById("upbox");

    var intext=document.getElementById("intext");

    var close=document.getElementById("close")


    signin.onclick=function(){
        openNew(inbox,close);
    }
    signup.onclick=function(){
        openNew(upbox);
    }
    function openNew(box,close){

        box.style.display="block";
        //获取页面的高度和宽度
        var sWidth=document.documentElement.scrollWidth||document.body.scrollWidth;
        var sHeight=document.documentElement.scrollHeight||document.body.scrollHeight;

        //获取页面的可视区域高度和宽度
        var wHeight=document.documentElement.clientHeight||document.body.clientHeight;
        var wWidth=document.documentElement.clientWidth||document.body.clientWidth;

        if(arguments.length==2){
            var oMask=document.createElement("div");
                oMask.id="mask";
                oMask.style.width=sWidth+"px";
                oMask.style.height=sHeight+"px";
                document.body.appendChild(oMask);

            //获取登陆框的宽和高
            var dHeight=box.offsetHeight;
            var dWidth=box.offsetWidth;

            //设置登陆框的left和top
            box.style.left=wWidth/2-dWidth/2+"px";
            box.style.top=wHeight/2-dHeight/2+"px";  /

            //点击登陆框以外的区域也可以关闭登陆框
            oMask.onclick=close.onclick=function(){
                document.body.removeChild(oMask);
                box.style.display="none";
            }
        }else{
            var oMask=document.createElement("div");
                oMask.id="omask";
                oMask.style.width=sWidth+"px";
                oMask.style.height=sHeight+"px";
            var oclose=document.createElement("div");
                oclose.id="close";
                oMask.appendChild(oclose);
                document.body.appendChild(oMask);

            //获取登陆框的宽和高
            var dHeight=box.offsetHeight;
            var dWidth=box.offsetWidth;

            //设置登陆框的left和top
            box.style.left=wWidth/2-dWidth/2+"px";
            box.style.top=wHeight/2-dHeight/2+"px";

            //点击登陆框以外的区域也可以关闭登陆框
            oclose.onclick=function(){
                document.body.removeChild(oMask);
                box.style.display="none";
            }
        }
    }


    intext.onmousedown=function(){
        fnDown(event,inbox);
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
    $("#btn-up").click(function(){

        $.ajax({
            url: "http://192.168.23.1:8080/register",

            type: "POST",
            data:{
                userName:$(".signup-text:eq(0)").val(),
                passWord:$(".signup-password").val(),
                age:$(".signup-text:eq(1)").val()
            },
            dataType: "json",

            success: function(data){
                if(data.isSuccess){
                    alert("注册成功！");
                }else{
                    alert("输入错误，请重新填写！");
                }
            },
            error: function(){
                alert("error");
            },
        })
    })
    $(".btn-search").click(function(){
        var url="http://192.168.23.1:8080/list?userName="+$(".search-text").val()
        $.ajax({
            url: url,

            type: "GET",
            dataType: "json",

            success: function(data){
                if(data.isSuccess){
                    $.each(data.data,function(index,ele){
                        $(".show-search").append("<tr><td>"+parseInt(index+1)+"</td><td>"+
                                            $(ele).attr('name')+"</td><td>"+
                                            $(ele).attr('age')+"</td></tr>");

                    })
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

