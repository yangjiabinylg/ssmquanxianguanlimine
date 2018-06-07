$(function () {
   initDataGrid();
});

function searchRole() {
    //alert("haha");
    //两个输入框的内容。下拉框的内容
    var roleName = $("#roleName").textbox("getValue");
    var roleCode = $("#roleCode").textbox("getValue");
    var valid = $("#valid").combobox("getValue");
    console.log(roleName+"   "+roleCode+"   "+valid);

    var formData = {
          roleName : $("#roleName").textbox("getValue"),
          roleCode : $("#roleCode").textbox("getValue"),
          valid : $("#valid").combobox("getValue")
    }
    console.log(formData);
    //刷新datagrid的数据
    $("#role-datagrid").datagrid("load",formData);

}

function initDataGrid() {

    //这个和treeGrid很像    带分页的dataGrid
    $("#role-datagrid").datagrid({
        rownumbers:true,//显示行号
        singleSelect:true,//单选
        autoRowHeight:false,//自动行高
        pagination:true,//是否分页
        pageSize:10,//每页条数
        //url:path+'/static/temp/datagrid_data1.json',
        url: path + '/role/queryRole',
        //method:'get',
        method:'post',
        fit:true,//纵向铺满屏幕
        fitColumns:true,
        pageList:[3,5,8,10,20,40],

        columns:[[

            {field:'roleName',title:'角色名称',width:100},
            {field:'roleCode',title:'角色编码',width:100},
            {field:'valid',title:'是否有效',width:100,
                formatter:function (value,row,index) {
                    if(value == "1"){
                        return "有效";
                    }else{
                        return '<span style="color: red">无效</span>>'
                    }
                }},
            {field:'orders',title:'排序',width:100},
            {field:'dbid',title:'授权',width:100,
                formatter:function (value,row,index) {
                        return '<a href="javascript:void(0)" onclick="showGrantAuth2Role('+value+')"  >授权</a>'
                }
            }
        ]]


    });

}

function closeGrantForm() {
    //关闭授权窗口
    $("#grantWindow").window("close");
}

function submitGrantForm() {
    //alert("hhaha");
    var nodes = $("#grantrole2auth").tree("getChecked");
    console.log(nodes);
    var authIds = [];
    for(var i = 0; i < nodes.length; i++){
        console.log(nodes[i].id);
        authIds.push(nodes[i].id);
    }
    console.log("角色的权限id "+authIds);
    var roleId = $("#roleId").val();
    console.log("角色的id "+roleId);
    //准备数据
    var formData = {
        roleId : roleId,
        authIds : authIds
    };
    //发起ajax请求  向服务器发送数据
    $.ajax({
        url:path+"/role/grantAuth",
        method:"post",
        data:formData,
        traditional:true,//不加上会把数组拆分开的
        success:function (res) {
            console.log(res.msg);
            console.log("连接服务器成功  "+res.msg);
            if(res.msg){
                //关闭授权窗口
                $("#grantWindow").window("close");

            }
        }

    });
}

function showGrantAuth2Role(roleId) {
    console.log("dddd   "+roleId);

    $("#roleId").val(roleId);
    $("#grantrole2auth").tree({
        //url:path+'/role/getAllAuth?roleId='+roleId,
        url:path+'/role/getAllVilidAuth?roleId='+roleId ,
        method:'get',
        animate:true,
        checkbox:true,
        cascadeCheck:false
    });

    // console.log(roleId)
    $("#grantWindow").window({
        modal: true,//灰色的隔层
        close: true,//是否可以关闭
        iconCls: 'icon-save',//图标
        title: "授权窗口",
        height:560,
        width: 500,
        collapsible: false,//折叠
        minimizable: false,//最小化
        maxmizable: false,//最大化
        resizable: false,//拉伸
        //关闭窗口时重置表单
        onBeforeClose:function () {
            $("#grantForm").form("reset");
        }
   
    }).window("open");

}














