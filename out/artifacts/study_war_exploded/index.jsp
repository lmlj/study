 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta http-equiv="content-Type" content="text/html; charset=utf-8"/>
    <title>test</title>
    <link rel="stylesheet" type="text/css" href="resource/css/mystyle1.css">
</head>
<body>

	<div id="header">

		<div id="ull">	
		    <a id="dl">登录</a>	
			<a id="zc">注册</a>
		</div>
		<div id="box1" class="dlbox">
			<span id="dra1">登录</span>
			<a id="close1" class="myclose"></a>
			<form>
				<input type="text" placeholder="手机/邮箱/用户名" id="dluser" />
				
				<input type="password" placeholder="密码" id="dlpass" />
				
				<input type="checkbox" checked="checked" />
				<label>下次自动登录</label>

				<input type="submit" value="登&nbsp录" id="subdl" />
			</form>
		</div>

		<div id="box2" class="dlbox">
			<span id="dra2">注册</span>
			<a id="close2" class="myclose"></a>
			<form>
				<input type="text" placeholder="用户名" />

				<input type="text" placeholder="手机号" />
				
				<input type="password" placeholder="密码" />

				<input type="submit" value="注&nbsp册" id="subzc" />
			</form>
		</div>

	</div>
	<div id="bodyer">
		<div class="logobox">
			<label>在线查询系统：</label>
			<input class="shu" type="text" name="a" placeholder="请输入用户名或ID" />
			<input class="suo" type="submit" name="b" value="查询" />
		</div>
	</div>
	<div id="footer">
		<!-- <p>©2016&nbsp233333</p> -->
	</div>

<script src="resource/jquery-1.11.3.js" type="text/javascript"></script>
<script src="resource/javascript/myjs1.js" type="text/javascript"></script>

</body>
</html>
