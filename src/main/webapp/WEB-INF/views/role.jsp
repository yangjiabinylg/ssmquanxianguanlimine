<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/6
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="common.jsp"%>
    <script type="text/javascript" src="${path}/static/js/role.js">
        // ${path}  只能在jsp中使用
    </script>


</head>
<body class="easyui-layout">
    <%--   2个输入框  一个下拉列表    2个按钮   --%>
    <%--   输入框是textbox   下拉框combox     按钮linkbutton  --%>
    <!--    data-options没见过吧  这是esay-ui独有的   这里有5大块你可以选择性使用  -->
    <%--<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>--%>
    <div data-options="region:'north',border:false" style="height:50px;padding:10px">
        <input class="easyui-textbox"    id="roleName"   data-options="prompt:'输入权限名称'"  style="width:20%;"  >
        <input class="easyui-textbox"    id="roleCode"  data-options="prompt:'输入权限编码'"  style="width:20%; "  >
        <select class="easyui-combobox"  id="valid"    data-options="panelHeight:'50px',editable:false" name="state" id="valid"  style="width:10%; ">
            <option value="1" >有效</option>
            <option value="0" >无效</option>
        </select>&nbsp;&nbsp;&nbsp;
        <a href="#" class="easyui-linkbutton" onclick="searchRole()" data-options="iconCls:'icon-search',width:80" style="margin-left: 20px;">搜索</a>
        <a href="#" class="easyui-linkbutton" onclick="searchRole()" data-options="iconCls:'icon-add',width:80" style="margin-left: 20px;">添加</a>
    </div>
    <%--<div data-options="region:'center',title:'Center'">--%>
    <div data-options="region:'center'">
         <%--   这个里面放dataGrid    和treeGrid  是很相似的  而且更简单    而且可以分页的    --%>
             <table id="role-datagrid"   >
             </table>

             <div id="grantWindow"  style="padding:10px;margin-top: 5px">
                 <div class="easyui-panel" style="padding:5px">
                     <%--  隐藏域  用于存放 角色的id  --%>
                     <input type="hidden" id="roleId" name="roleId"/>
                     <ul id="grantrole2auth" class="easyui-tree" ></ul>
                     <%--<ul id="grantrole2auth" class="easyui-tree" data-options="url:'${path}/role/getAllAuth',method:'get',animate:true,checkbox:true"></ul>--%>

                 </div>

                 <br><br>
                 <div style="text-align:center;padding:5px 0">
                     <a href="javascript:void(0)" data-options="iconCls:'icon-ok'" class="easyui-linkbutton" onclick="submitGrantForm()" style="width:80px">提交</a>
                     <a href="javascript:void(0)" data-options="iconCls:'icon-cancel'" class="easyui-linkbutton" onclick="closeGrantForm()" style="width:80px">关闭</a>
                 </div>
             </div>
    </div>
    <%--<div data-options="region:'west',split:true,title:'West'" style="width:150px;padding:10px;">west content</div>--%>
    <%--<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>--%>
    <%--<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>--%>

</body>









</html>
