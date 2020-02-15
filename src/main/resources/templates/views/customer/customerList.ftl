<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>客户列表</title>
    <link rel="stylesheet" href="${request.contextPath}/static/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${request.contextPath}/static/layuiadmin/style/admin.css" media="all">
</head>
<body style="background-color: #F2F2F2;" >
<div style="padding: 20px; ">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
<#--                <div class="layui-card-header">-->
<#--                    <form class="layui-form" action="">-->
<#--                        <div class="layui-form-item">-->
<#--                            <label class="layui-form-label">单行输入框</label>-->
<#--                            <div class="layui-input-block" style="width: 100px;padding-top: 5px">-->
<#--                                <input style="height: 30px;" type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">-->
<#--                            </div>-->
<#--                        </div>-->
<#--                    </form>-->
<#--                </div>-->
                <div class="layui-card-body">
                    <form class="layui-form" action="">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">客户名称</label>
                                <div class="layui-input-inline" style="width: 100px;">
                                    <input  type="text" name="title" lay-verify="title" autocomplete="off" placeholder="" class="layui-input">
                                </div>
                                <label class="layui-form-label">客户电话</label>
                                <div class="layui-input-inline" style="width: 150px;">
                                    <input  type="text" name="title" lay-verify="title" autocomplete="off" placeholder="" class="layui-input">
                                </div>
                                <label class="layui-form-label">联系人</label>
                                <div class="layui-input-inline" style="width: 100px;">
                                    <input  type="text" name="title" lay-verify="title" autocomplete="off" placeholder="" class="layui-input">
                                </div>
                                <div class="layui-input-inline" >

                                </div>
                                <div class="layui-input-inline" >
                                    <button type="button" class="layui-btn">查询</button>
                                    <button type="button" class="layui-btn">清空</button>
                                </div>
                            </div>


                        </div>
                    </form>
                    <#-- 数据表格-->
                    <table class="layui-hide" id="customer" lay-filter="customer"></table>

                    <script type="text/html" id="toolbar">
                        <div class="layui-btn-container">
                            <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
                            <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
                            <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
                        </div>
                    </script>

                    <script type="text/html" id="bar">
                        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                    </script>

                </div>
            </div>
        </div>
    </div>
</div>
<script src="${request.contextPath}/static/layuiadmin/layui/layui.js"></script>

<script>
    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#customer'
            ,url:'${request.contextPath}/customer/getPageList'
            ,method:'post'
            ,contentType: "application/json;charset=UTF-8"
            ,dataType: 'json'
            ,done:function (res,curr,count) {
                console.log(res)
            }
            ,toolbar: '#toolbar' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                ,layEvent: 'LAYTABLE_TIPS'
                ,icon: 'layui-icon-tips'
            }]
            ,title: '客户表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'id', title:'客户id', fixed: 'left', unresize: true, sort: true}
                ,{field:'customername', title:'客户名称', edit: 'text'}
                ,{field:'zip', title:'客户邮编',  edit: 'text'}

                ,{field:'address', title:'客户地址',  edit: 'text', sort: true}
                ,{field:'telephone', title:'客户电话', }
                ,{field:'connectionperson', title:'联系人'}
                ,{field:'phone', title:'联系人电话',  sort: true}
                ,{field:'bank', title:'开户行', }
                ,{field:'account', title:'账户',  sort: true}
                ,{field:'email', title:'邮箱',  edit: 'text', templet: function(res){
                        return '<em>'+ res.email +'</em>'
                    }}
                ,{fixed: 'right', title:'操作', toolbar: '#bar', width:150}
            ]]
            ,page: true
        });

        //头工具栏事件
        table.on('toolbar(customer)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选');
                    break;

                //自定义头工具栏右侧图标 - 提示
                case 'LAYTABLE_TIPS':
                    layer.alert('这是工具栏右侧自定义的一个图标按钮');
                    break;
            };
        });

        //监听行工具事件
        table.on('tool(customer)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.prompt({
                    formType: 2
                    ,value: data.email
                }, function(value, index){
                    obj.update({
                        email: value
                    });
                    layer.close(index);
                });
            }
        });
    });
</script>
</body>
</html>