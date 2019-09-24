<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import = "com.kuaisuji.pojo.Account,java.util.List,com.kuaisuji.pojo.Type,java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta charset="UTF-8">
<title>快速记 记下明白生活</title>

<link rel="stylesheet" href="../res/layui/css/layui.css">
<link rel="stylesheet" href="../res/css/global.css">
<link rel="stylesheet" href="../res/css/cntl.css">
</head>
<body>


<jsp:include page="../head.jsp"></jsp:include>


<div class="fly-panel fly-column">
  <div class="layui-container">
    <ul class="layui-clear">
      <li class="layui-hide-xs layui-this"><a href="../index.jsp">主页</a></li> 
      <%
      Map<Integer,Type> typeMap = (Map<Integer,Type>)request.getSession().getAttribute("typeMap");
      for(Integer key : typeMap.keySet()){
    	  
      %>
      	 <li><a href="${pageContext.request.contextPath }/ToMain?cid=<%=key%>"><%=typeMap.get(key).getAccount_item_name() %></a></li> 
      <%
      }
      %>

      
    </ul> 
    
    <div class="fly-column-right layui-hide-xs"> 
      <span class="fly-search"><i class="layui-icon"></i></span> 
      <a href="add2.jsp" class="layui-btn">记一笔</a> 
    </div> 
  
  </div>
</div>

<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md12">
      <div class="fly-panel" style="margin-bottom: 0;">
        
        <div class="fly-panel-title fly-filter">
          <a href="${pageContext.request.contextPath }/ToMain?type=0">支出</a>
          <span class="fly-mid"></span>
          <a href="${pageContext.request.contextPath }/ToMain?type=1">收入</a>
          <span class="fly-mid"></span>
          <a href="${pageContext.request.contextPath }/ToMain?all=true">全部</a>
          <span class="fly-filter-right layui-hide-xs">
            <a href="#" class="layui-this" onclick = "window.alert('未开放功能')">时间</a>
            <span class="fly-mid"></span>
            <a href="#" onclick = "window.alert('未开放功能')">金额</a>
          </span>
        </div>

        <ul class="fly-list">  
         
          
         	<%
         	List<Account> allAccountList = (List<Account>)request.getSession().getAttribute("allAccountList");
         	if(allAccountList != null){
         		for(Account account: allAccountList){
         	%>
         		<li>
		            <a href="#" class="fly-avatar">
		              <img src="../res/images/cat/<%=typeMap.get(account.getAccount_item()).getItem_img_src() %>" alt="<%=account.getAccount_item() %>">
		            </a>
		            <h2>
		              <a class="layui-badge"><%=typeMap.get(account.getAccount_item()).getAccount_item_name()  %></a>
		              <a href="#" onclick = "window.alert('未开放功能')"><%=account.getAccount_remark() %></a>
		            </h2>
		            <div class="fly-list-info">
		              <span><%=account.getAccount_date() %></span>
		            </div>
		            <div class="fly-list-badge">
		              <span class="layui-badge layui-bg-red"><%=account.getAccount_amount() %></span>
		            </div>
		          </li>
         	 <%
         		}
         	}
         	 %>  
         	
         		

      </div>
    </div>

  </div>
</div>


<div class="fly-footer">
  <p><a href="http://www.xintoucloud.com" target="_blank">新投云</a> 2017 &copy; <a href="http://www.xintoucloud.com" target="_blank">xintoucloud.com 出品</a></p>
</div>

<script src="../res/layui/layui.js"></script>
<script>
layui.config({
	  version: "3.0.0"
	  ,base: '../res/mods/'
	}).extend({
	  fly: 'index'
	}).use('fly');
</script>

<script type="text/javascript">
layui.cache.page = 'jie';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '../res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '../res/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>
</body>
</html>