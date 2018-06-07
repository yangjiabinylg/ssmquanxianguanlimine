
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--     项目根目录    --%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <%@include file="common.jsp"%>
    <script type="text/javascript" src="${path}/static/js/auth.js">
        // ${path}  只能在jsp中使用

    </script>
</head>
<body>
    <%--     右击事件的弹出框   控件自身默认是不显示的     --%>
    <div id="mm" class="easyui-menu" style="width:120px;">
        <div onclick="addOrUpdateForm('添加')" data-options="iconCls:'icon-add'">增加子节点</div>
        <div onclick="addOrUpdateForm('修改')" data-options="iconCls:'icon-edit'">编辑</div>
        <div onclick="refreshAuth()" data-options="iconCls:'icon-reload'">刷新</div>
        <%--<div onclick="removeIt()" data-options="iconCls:'icon-remove'">Remove</div>--%>
        <%--<div class="menu-sep"></div>--%>
        <%--<div onclick="collapse()">Collapse</div>--%>
        <%--<div onclick="expand()">Expand</div>--%>
    </div>

    <table id="auth-treegrid" ></table>
    <%--<div id="authWindow" class="easyui-window" title="Modal Window" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:200px;padding:10px;">--%>
    <div id="authWindow"   style="padding:10px;">
        <form id="authForm" method="post">

            <%--  更新要用到主键  设置为隐藏控件最好了  --%>
            <input type="hidden" id="dbid" name="dbid"/>
            <input type="hidden" id="parentId" name="parentId"/>
            <%--    name="authName"  这个拿掉  就不提交 了    --%>

            <div style="margin-bottom:5px">
                <input class="easyui-textbox"  id="parentName"  name="parentName" style="width:100%" data-options="label:'上级节点:',readonly:true ">
            </div>
            <div style="margin-bottom:5px">
                <input class="easyui-textbox"  id="layer"  name="layer" style="width:100%" data-options="label:'当前层级:'  ">
            </div>
            <div style="margin-bottom:5px">
                <input class="easyui-textbox"   id="authName" name="authName" style="width:100%" data-options="label:'权限名称:',required:true ">
            </div>
            <div style="margin-bottom:5px">
                <input class="easyui-textbox"   id="authCode" name="authCode" style="width:100%" data-options="label:'权限编码:' ">
            </div>
            <div style="margin-bottom:5px">
                <input class="easyui-textbox"   id="authURL" name="authURL" style="width:100%" data-options="label:'url:' ">
            </div>
             <div style="margin-bottom:5px">
                    <input class="easyui-textbox"   id="order" name="order" style="width:100%" data-options="label:'排序:' ">
            </div>
            <div style="margin-bottom:5px">
                <select class="easyui-combobox"  id="type" name="type" label="类型" style="width:100%">
                    <option value="1">模块</option>
                    <option value="2">资源</option>
                </select>
            </div>
            <div style="margin-bottom:5px">
                <%--<select class="easyui-combobox" id="valid"  name="valid" label="是否有效" style="width:100%">--%>
                    <%--<option value="1">有效</option>--%>
                    <%--<option value="0">无效</option>--%>
                <%--</select>--%>
                    <select class="easyui-combobox" data-options="panelHeight:'50px',editable:false" name="valid" id="valid" label="是否有效" style="width:100%">
                        <option value="1" >有效</option>
                        <option value="0" >无效</option>
                    </select>
            </div>

        </form>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" data-options="iconCls:'icon-ok'" class="easyui-linkbutton" name="btnAddForm" id="btnAddForm"  onclick="addForm()" style="width:80px">添加</a>
            <a href="javascript:void(0)" data-options="iconCls:'icon-ok'" class="easyui-linkbutton" name="btnUpdateForm" id="btnUpdateForm" onclick="updateForm()" style="width:80px">更新</a>
            <a href="javascript:void(0)" data-options="iconCls:'icon-cancel'" class="easyui-linkbutton" onclick="closeForm()" style="width:80px">取消</a>
        </div>
    </div>

</body>
</html>
