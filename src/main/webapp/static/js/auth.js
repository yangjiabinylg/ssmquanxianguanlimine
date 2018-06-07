function addForm(){
    //提交表单   这里使用ajax
    //ajax提交表单
    //1.准备请求参数
    var fromData = $("#authForm").form().serialize();
    //dbid=11&
    // parentId=10
    // &parentName=%E6%96%B0%E9%97%BB%E7%AE%A1%E7%90%86
    // &layer=2
    // &authName=%E5%8F%91%E5%B8%83%E6%96%B0%E9%97%BB&
    // authCode=&authURL=%2Fnews%2F
    // toMain&order=1
    // &type=2
    // &valid=1
    console.log(fromData);
    //ajax提交参数
    $.ajax({
        // path+
        //url:'${path}/auth/add',
        url: path+'/auth/add',
        method:'post',
        data:fromData,
        success:function (res) {//服务器请求过来的书  true false都是这里
            //res服务器返回的数据   更新成功或者失败
            console.log(res);
            if(res.msg){//true
                //更新成功   弹框消失
                $("#authWindow").window("close");
                //刷新表格
                $("#auth-treegrid").treegrid("reload");
            }else{//false
                //更新失败

            }
        },error:function (res) {//网络请求失败  网络请求超时这些情况
            console.log(res.msg);
            console.log("网络连接失败");

        }
    });
}


function updateForm(){
    //提交表单   这里使用ajax
    //ajax提交表单
    //1.准备请求参数
    var fromData = $("#authForm").form().serialize();
    //dbid=11&
    // parentId=10
    // &parentName=%E6%96%B0%E9%97%BB%E7%AE%A1%E7%90%86
    // &layer=2
    // &authName=%E5%8F%91%E5%B8%83%E6%96%B0%E9%97%BB&
    // authCode=&authURL=%2Fnews%2F
    // toMain&order=1
    // &type=2
    // &valid=1
    console.log(fromData);
    //ajax提交参数
    $.ajax({
        // path+
        //url:'${path}/auth/update',
        url : path+'/auth/update',
        method:'post',
        data:fromData,
        success:function (res) {//服务器请求过来的书  true false都是这里
            //res服务器返回的数据   更新成功或者失败
            console.log(res);
            if(res.msg){//true
                //更新成功   弹框消失
                $("#authWindow").window("close");
                //刷新表格
                $("#auth-treegrid").treegrid("reload");
            }else{//false
                //更新失败

            }
        },error:function (res) {//网络请求失败  网络请求超时这些情况
            console.log(res);
            console.log("网络连接失败");
        }
    });
}

//点击取消添加   点击取消更新
function closeForm() {
    $("#authWindow").window("close");
}

function refreshAuth() {
    //刷新treegrid权限列表
    $("#auth-treegrid").treegrid("reload");
}


function addOrUpdateForm(action) {

    //获取treegrid中选中的行
    var row = $("#auth-treegrid").treegrid("getSelected");
    var parent = $("#auth-treegrid").treegrid("getParent",row.dbid);//获取选中行的父节点
    console.log(row);
    console.log(parent);
    if(action == '添加'){ //添加
        //添加
        $("#parentId").val(row.dbid);
        $("#parentName").textbox("setValue",row.authName);
        $("#layer").textbox("setValue",row.layer+1);
        $("#dbid").val(0);
        $("#type").combobox(  "setValue",row.type);
        $("#valid").combobox(  "setValue",row.valid);
        $("#btnAddForm").show();
        $("#btnUpdateForm").hide();

    }else{
        $("#btnAddForm").hide();
        $("#btnUpdateForm").show();
        //修改
        $("#parentName").textbox("setValue",parent.authName);
        $("#layer").textbox("setValue",row.layer);
        $("#authName").textbox("setValue",row.authName);
        $("#authCode").textbox("setValue",row.authCode);
        $("#authURL").textbox("setValue",row.authURL);
        $("#order").textbox("setValue",row.order);
        // $("#type").textbox("setValue",row.type);
        // $("#valid").textbox("setValue",row.valid);
        $("#type").combobox("setValue",row.type);
        $("#valid").combobox("setValue",row.valid);
       //    更新要用到主键  设置为隐藏控件最好了
        $("#dbid").val(row.dbid);
        $("#parentId").val(row.parentId);
    }


    //$("#authWindow").window("open");
    $("#authWindow").window({
        modal:true,//灰色的隔层  即背景是灰色  不可以交互  除弹框外不可点击
        closed:true,//默认关闭
        iconCls:'icon-edit',//图标
        width:300,
        height:'400px',
        title:action+'权限',
        collapsible:false,//不可折叠
        minimizable:false,//不可最小化
        maximizable:false,//不可最大化
        resizable:false,//不可改变大小
        onBeforeClose:function () {
            //在弹框关闭时  清空表单中的数据
            $("#authForm").form("reset");
        }
    }).window("open");

}

function  onContextMenu( e , row) {
    if(row){//当右击行     响应右击事件
        e.preventDefault();//取消默认的右击事件    阻止浏览器的右键菜单
        //console.log(e);
        //console.log(row);
        //console.log(this);//this 就是我们自己的table
        //$(this).treegrid("select",row.id);//选中指定的单元行
        $(this).treegrid("select",row.dbid);//选中指定的单元行
        //右键显示菜单
        $("#mm").menu("show",{
            left:e.pageX,
            top:e.pageY
        });
    }
}
$(function () {//相当于window.onload
    $("#auth-treegrid").treegrid({
        //数据现在我们发现了  就是ajax
        //url:"${path}/static/temp/treegrid_data1.json",//请求数据地址  静态
        //path+
        //url:"${path}/auth/getAllAuth",//请求数据地址  动态
        url:path+"/auth/getAllAuth",//请求数据地址  动态
        //idField:"id",//指定唯一字段
        idField:"dbid",//指定唯一字段
        rownumbers:true,//行号显示
        method:"get",//get方式请求数据  目前是静态资源  只能用get方式请求数据  不写默认是post
        //treeField:"name",//需要显示为tree的字段  点击可以展开的字段
        treeField:"authName",//需要显示为tree的字段  点击可以展开的字段
        fit:true,//宽度填满窗体
        onContextMenu:onContextMenu, //当点击item可以右键   add 或者 remove  onContextMenu自定义方法
        columns:[[//数据域
            // {title:"编号",field:"id"},
            // {title:"名字",field:"name"},
            // {title:"大小",field:"size"},
            // {title:"时间",field:"date"}
            {title:"权限名称",field:"authName",width:"200px"},
            {title:"权限编码",field:"authCode"},
            {title:"URL",field:"authURL"},
            {title:"类型",field:"type",width:"80px",
                formatter:function (value,row,index) {
                    if(value == '1'){
                        return '模块';
                    }else{
                        return '资源';
                    }

                }
            },
            {title:"排序",field:"order",width:"80px"},
            {title:"是否有效",field:"valid",width:"80px",
                formatter:function (value,row,index) {
                    if(value == '1'){
                        return '有效';
                    }else{
                        return  '<span style="color:red">无效</span>';
                    }

                }
            },
            {title:"层级",field:"layer",width:"80px"}
        ]]
    })
});