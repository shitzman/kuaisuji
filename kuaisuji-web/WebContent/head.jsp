<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="javax.servlet.http.HttpSession,com.kuaisuji.pojo.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>head</title>
</head>
<body>

<div class="fly-header layui-bg-black">
  <div class="layui-container">
    <a class="fly-logo" href="${pageContext.servletContext.contextPath }">
      <img src="${pageContext.servletContext.contextPath }/res/images/logo.png" alt="layui">
    </a> 
    <ul class="layui-nav fly-nav-user">
      	  
      	  <%
      	  User user = (User)session.getAttribute("user");
      	  	if(user != null){
      	  %>
  	      <!-- 登入后的状态 -->
	      <li class="layui-nav-item">
	        <a class="fly-nav-avatar"  href="javascript:;">
	          <cite class="layui-hide-xs"><%=user.getUsername() %></cite>
	          <i class="iconfont icon-renzheng layui-hide-xs" title=""></i>
	          <i class="layui-badge fly-badge-vip layui-hide-xs">VIP1</i>
	        </a>
	        <dl class="layui-nav-child">
	          <dd><a href="#" onclick = "window.alert('未开放功能')"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
	          <dd><a href="#" onclick = "window.alert('未开放功能')"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
	          <dd><a href="${pageContext.request.contextPath }/ToMain?all=true"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
	          <hr style="margin: 5px 0;">
	          <dd><a href="${pageContext.servletContext.contextPath }/Logout" style="text-align: center;">退出</a></dd>
	        </dl>
	      </li>
	      <%
      	  	}else{
      	  %>
      	  
      	  	<!-- 未登入的状态 -->
  	      <li class="layui-nav-item">
  	        <a class="iconfont icon-touxiang layui-hide-xs" href="login.jsp"></a>
  	      </li>
  	      <li class="layui-nav-item">
  	        <a href="${pageContext.servletContext.contextPath }/login.jsp">登入</a>
  	      </li>
  	      <li class="layui-nav-item">
  	        <a href="${pageContext.servletContext.contextPath }/reg.jsp">注册</a>
  	      </li>
  	      <li class="layui-nav-item layui-hide-xs">
  	        <a href="${pageContext.servletContext.contextPath }" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" title="QQ登入" class="iconfont icon-qq"></a>
  	      </li>
  	      <li class="layui-nav-item layui-hide-xs">
  	        <a href="${pageContext.servletContext.contextPath }" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" title="微博登入" class="iconfont icon-weibo"></a>
  	      </li>
      	  <%
      	  	}
	      %>
    </ul>
    
  </div>
</div>

</body>
</html>