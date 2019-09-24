<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import = "com.kuaisuji.pojo.Account,java.util.List,com.kuaisuji.pojo.Type,java.util.Map"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>记一笔</title>

<link rel="stylesheet" href="../res/layui/css/layui.css">
<link rel="stylesheet" href="../res/css/global.css">
<link rel="stylesheet" href="../res/css/cntl.css">
</head>
<body>


<jsp:include page="../head.jsp"></jsp:include>

<div class="layui-container fly-marginTop">
  <div class="fly-panel" pad20 style="padding-top: 5px;">
    <!--<div class="fly-none">没有权限</div>-->
    <div class="layui-form layui-form-pane">
      <div class="layui-tab layui-tab-brief" lay-filter="user">
        <ul class="layui-tab-title">
          <li class="layui-this">支出</li>
          <li><a href="add2.jsp">收入</a></li>
        </ul>
        <div class="layui-form layui-tab-content" id="zhichu" style="padding: 20px 0;">
          <div class="layui-tab-item layui-show">
            <form action="${pageContext.request.contextPath }/AddAccount" method="post">
              <input type="hidden" name="type" value="0"> 
              <div class="layui-row layui-col-space15 layui-form-item">
              	 <div class="layui-col-md6">
                  <label class="layui-form-label">支出金额</label>
                  <div class="layui-input-block">
                   <input type="text" id="L_title" name="money" required lay-verify="required|number" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-col-md3">
                  <label class="layui-form-label">支出类别</label>
                  <div class="layui-input-block">
                    <select lay-verify="required" name="cid" lay-filter="column"> 
                      <option></option> 
                      		<%
                      		Map<Integer,Type> typeMap = (Map<Integer,Type>)request.getSession().getAttribute("typeMapBy0");
                            for(Integer key : typeMap.keySet()){
                      		%>
                      			<option value="<%=key %>"><%=typeMap.get(key).getAccount_item_name() %></option> 
                      		<%
                            }
                      		%>

                      
                    </select>
                  </div>
                </div>
                <div class="layui-col-md3">
                  <label for="L_title" class="layui-form-label">发生日期</label>
                  <div class="layui-input-block">
                    <input  type="text" class="layui-input" id="test5" name="addTime" placeholder="yyyy-MM-dd HH:mm:ss">
                  </div>
                </div>
              </div>
          
              <div class="layui-form-item layui-form-text">
                <div class="layui-input-block">
                  <textarea id="L_content" name="details" required lay-verify="required"  placeholder="详细描述" class="layui-textarea fly-editor" style="height: 260px;"></textarea>
                </div>
              </div>
          
              <div class="layui-form-item">
                <button class="layui-btn" lay-filter="*" lay-submit>记一笔</button>
              </div>
            </form>
          </div>
          
           
        </div>
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

<script>
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
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  laydate.render({
		   elem: '#test5'
		   ,type: 'datetime'
	  });
	 
});
</script>
</body>
</html>