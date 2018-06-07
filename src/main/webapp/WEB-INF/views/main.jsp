<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/30
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--     项目根目录    --%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <%--
        E:\web_ssm_ssh_zixue\workspace_ide\ssmquanxianguanlimine\src\main\webapp\static\jquery-easyui-1.5.3\demo\accordion
        accordion 手风琴  可折叠的
    --%>


    <title>RBAC</title>
    <link rel="stylesheet" type="text/css" href="${path}/static/jquery-easyui-1.5.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${path}/static/jquery-easyui-1.5.3/themes/icon.css">
    <%--<link rel="stylesheet" type="text/css" href="${path}/static/jquery-easyui-1.5.3/demo/demo.css">--%>
    <script type="text/javascript" src="${path}/static/jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="${path}/static/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        $(function () {
           // 这个数据应该是数据库中查找  放在request中拿过来的
           <%--var treeData = [{--%>
               <%--"id":1,--%>
               <%--"text":"考试11管理",--%>
               <%--"children":[{--%>
                   <%--"id":11,--%>
                   <%--"text":"创建11查询",--%>
                   <%--"url":"http://www.baidu.com"--%>
               <%--},{--%>
                   <%--"id":12,--%>
                   <%--"text":"成绩11查询",--%>
                   <%--"state":"closed",--%>
                   <%--"children":[{--%>
                       <%--"id":121,--%>
                       <%--"text":"考试11成绩",--%>
                       <%--"url":"http://www.zjut.edu.cn"--%>
                   <%--},{--%>
                       <%--"id":122,--%>
                       <%--"text":"考勤11成绩",--%>
                       <%--"url":"http://www.youku.com/"--%>
                   <%--},{--%>
                       <%--"id":123,--%>
                       <%--"text":"项目11成绩",--%>
                       <%--"url":'${path}/auth/toMain'--%>
                   <%--}]--%>
               <%--}]--%>
           <%--}];--%>

            <%--var treeData = [{--%>
                <%--"id":12,--%>
                <%--"text":"系统管理",--%>
                <%--"state":"closed",--%>
                <%--"children":[{--%>
                    <%--"id":121,--%>
                    <%--"text":"用户管理",--%>
                    <%--"url":"http://www.zjut.edu.cn"--%>
                <%--},{--%>
                    <%--"id":122,--%>
                    <%--"text":"角色管理",--%>
                    <%--"url":"http://www.youku.com/"--%>
                <%--},{--%>
                    <%--"id":123,--%>
                    <%--"text":"权限管理",--%>
                    <%--"url":'${path}/auth/toMain'--%>
                <%--}]--%>
            <%--}];--%>
            var treeData = [{
                "id":12,
                "text":"系统管理",

                "children":[{
                    "id":121,
                    "text":"用户管理",
                    "url":"http://www.zjut.edu.cn"
                },{
                    "id":122,
                    "text":"角色管理",
                    "url":"${path}/role/toRole"
                },{
                    "id":123,
                    "text":"权限管理",
                    "url":'${path}/auth/toAuth'
                }]
            }];
           $("#my-tree").tree({
               data:treeData,
               onClick:function (node) {
                   //console.log(node);
                   //通过node是否有children  来判断点击界面是否页面跳转   有children就是不跳转   没有children就跳转页面，
                   //console.log(  !node.children );
                   if(  !node.children ){ //有children就是不跳转
                       console.log(  node.url );//打开页面
                       if($("#main-tab").tabs("exists",node.text)){//根据标题是否标题是否存在  判断这个页面是否已经打开过了
                           //tab中已有此标签
                           //根据标签选中这个页面
                           $("#main-tab").tabs("select",node.text);
                       }else{
                           $("#main-tab").tabs("add",{//"add"表示添加tab标签
                               title:node.text,
                               //content:"<h1>"+node.text+"</h1>",
                               content: "<iframe width='100%' height='100%' src="+node.url+"/>",
                               closable:true
                           });
                       }

                   }
               }
           });
        });
    </script>
</head>
<body class="easyui-layout">

    <!--    data-options没见过吧  这是esay-ui独有的   这里有5大块你可以选择性使用    -->
    <div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">
        我是顶部内容
    </div>


    <%--   session 默认有效期是 30min   --%>
    <%--split:true 可以拖拽   false不可以拖拽  title:'West' 标题--%>
    <div data-options="region:'west',split:false,title:'导航栏'" style="width:210px;padding:0px;">
        <%--左侧导航栏--%>
        <%--<div class="easyui-accordion" style="width:500px;height:300px;">--%>

        <%--<div class="easyui-accordion" style="width:auto;height:auto;">--%>
        <%--   data-options="fit:true" 点击item是否滑动到底部  高度铺满窗体  --%>
        <div class="easyui-accordion"  data-options="fit:true">

            <%--<div title="About" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">--%>
            <%--<div title="About" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">--%>
            <div title="About">
                <%--<h3 style="color:#0099FF;">Accordion for jQuery</h3>--%>
                <%--<p>Accordion is a part of easyui framework for jQuery. It lets you define your accordion component on web page more easily.</p>--%>
                <%--<h4>About</h4>--%>
                <%--   还有比这个更简单的   --%>
                <%--<ul class="easyui-tree" data-options="url:'${path}/static/temp/tree_data1.json',method:'get',animate:true"></ul>--%>
                <%--   点击item节点跳转url   --%>
                <ul id="my-tree"></ul>

            </div>


            <%--<div title="Help" data-options="iconCls:'icon-help'" style="padding:10px;">--%>
            <div title="Help"  >
                <%--<p>The accordion allows you to provide multiple panels and display one or more at a time. Each panel has built-in support for expanding and collapsing. Clicking on a panel header to expand or collapse that panel body. The panel content can be loaded via ajax by specifying a 'href' property. Users can define a panel to be selected. If it is not specified, then the first panel is taken by default.</p>--%>
                    <h4>Help</h4>
            </div>


            <%--<div title="TreeMenu" data-options="iconCls:'icon-search'" style="padding:10px;">--%>
            <div title="TreeMenu"  >
                <%--<ul class="easyui-tree">--%>
                    <%--<li>--%>
                        <%--<span>Foods</span>--%>
                        <%--<ul>--%>
                            <%--<li>--%>
                                <%--<span>Fruits</span>--%>
                                <%--<ul>--%>
                                    <%--<li>apple</li>--%>
                                    <%--<li>orange</li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                            <%--<li>--%>
                                <%--<span>Vegetables</span>--%>
                                <%--<ul>--%>
                                    <%--<li>tomato</li>--%>
                                    <%--<li>carrot</li>--%>
                                    <%--<li>cabbage</li>--%>
                                    <%--<li>potato</li>--%>
                                    <%--<li>lettuce</li>--%>
                                <%--</ul>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                <%--</ul>--%>
                    <h4>TreeMenu</h4>




            </div>



        </div>

    </div>


    <%--<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>--%>
    <%--<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>--%>
    <%--   data-options="fit:true"    点击item是否滑动到底部  高度铺满窗体  --%>
    <div data-options="region:'center',title:'业务面板'"  >
        <div id="main-tab" class="easyui-tabs" data-options="fit:true"></div>
    </div>



</body>
</html>
