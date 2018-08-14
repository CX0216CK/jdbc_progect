<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/3
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <title>Free HTML5 Bootstrap Admin Template</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.css" rel="stylesheet">
    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/charisma-app.css" rel="stylesheet">
    <link href="css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
    <link href='css/fullcalendar.css' rel='stylesheet'>
    <link href='css/fullcalendar.print.css' rel='stylesheet'  media='print'>
    <link href='css/chosen.css' rel='stylesheet'>
    <link href='css/uniform.default.css' rel='stylesheet'>
    <link href='css/colorbox.css' rel='stylesheet'>
    <link href='css/jquery.cleditor.css' rel='stylesheet'>
    <link href='css/jquery.noty.css' rel='stylesheet'>
    <link href='css/noty_theme_default.css' rel='stylesheet'>
    <link href='css/elfinder.min.css' rel='stylesheet'>
    <link href='css/elfinder.theme.css' rel='stylesheet'>
    <link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='css/opa-icons.css' rel='stylesheet'>
    <link href='css/uploadify.css' rel='stylesheet'>
    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
<div class="row-fluid sortable">
    <div class="box span12">
        <div class="box-header well" data-original-title>
            <h2><i class="icon-user"></i> Members</h2>
            <div class="box-icon">
                <a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
                <a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
                <a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
            </div>
        </div>
        <div class="box-content">
            <table class="table table-striped table-bordered bootstrap-datatable datatable">
                <thead>
                <tr>
                    <th>用户编号</th>
                    <th>用户名</th>
                    <th>用户邮箱</th>
                    <th>用户类型</th>
                </tr>
                </thead>
                <tbody id="list-content">
                </tbody>
            </table>
        </div>
    </div><!--/span-->

</div><!--/row-->
<%--引入自己的pagination--%>


<footer>
    <p class="pull-left">&copy; <a href="http://usman.it" target="_blank">Muhammad Usman</a> 2012</p>
    <p class="pull-right">Powered by: <a href="http://usman.it/free-responsive-admin-template">Charisma</a></p>
</footer>

<%--引入自己的pagination--%>
<div class="pagination" id="pagination"></div>



</div><!--/.fluid-container-->

<!-- external javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<%-- 模态窗口--%>
<div class="modal hide fade" id="myModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>温馨提示</h3>
    </div>
    <div class="modal-body">
        <p>您是否确定删除...</p>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal">关闭</a>
        <a onclick="realDelete();" class="btn btn-primary">确认删除</a>
    </div>
    <%--设置隐藏域 获取需要删除的id--%>
    <input type="hidden" id="deleteId">
</div>
<!-- jQuery -->
<script src="js/jquery-1.7.2.min.js"></script>
<!-- jQuery UI -->
<script src="js/jquery-ui-1.8.21.custom.min.js"></script>
<!-- transition / effect library -->
<script src="js/bootstrap-transition.js"></script>
<!-- alert enhancer library -->
<script src="js/bootstrap-alert.js"></script>
<!-- modal / dialog library -->
<script src="js/bootstrap-modal.js"></script>
<!-- custom dropdown library -->
<script src="js/bootstrap-dropdown.js"></script>
<!-- scrolspy library -->
<script src="js/bootstrap-scrollspy.js"></script>
<!-- library for creating tabs -->
<script src="js/bootstrap-tab.js"></script>
<!-- library for advanced tooltip -->
<script src="js/bootstrap-tooltip.js"></script>
<!-- popover effect library -->
<script src="js/bootstrap-popover.js"></script>
<!-- button enhancer library -->
<script src="js/bootstrap-button.js"></script>
<!-- accordion library (optional, not used in demo) -->
<script src="js/bootstrap-collapse.js"></script>
<!-- carousel slideshow library (optional, not used in demo) -->
<script src="js/bootstrap-carousel.js"></script>
<!-- autocomplete library -->
<script src="js/bootstrap-typeahead.js"></script>
<!-- tour library -->
<script src="js/bootstrap-tour.js"></script>
<!-- library for cookie management -->
<script src="js/jquery.cookie.js"></script>
<!-- calander plugin -->
<script src='js/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='js/jquery.dataTables.min.js'></script>
<!-- chart libraries start -->
<script src="js/excanvas.js"></script>
<script src="js/jquery.flot.min.js"></script>
<script src="js/jquery.flot.pie.min.js"></script>
<script src="js/jquery.flot.stack.js"></script>
<script src="js/jquery.flot.resize.min.js"></script>
<!-- chart libraries end -->
<!-- select or dropdown enhancer -->
<script src="js/jquery.chosen.min.js"></script>
<!-- checkbox, radio, and file input styler -->
<script src="js/jquery.uniform.min.js"></script>
<!-- plugin for gallery image view -->
<script src="js/jquery.colorbox.min.js"></script>
<!-- rich text editor library -->
<script src="js/jquery.cleditor.min.js"></script>
<!-- notification plugin -->
<script src="js/jquery.noty.js"></script>
<!-- file manager library -->
<script src="js/jquery.elfinder.min.js"></script>
<!-- star rating plugin -->
<script src="js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="js/charisma.js"></script>
<script src="js/jquery.pagination.js"></script>
<%--ajax分页操作--%>
<script type="text/javascript">
    loadData(0);//加载数据  0 当前页
    function loadData(pageIndex) {//初始化数据的ajax操作
        $.ajax({
            url:"/home?methodName=findAllByPage",
            type:"POST",
            data:{"pageIndex":pageIndex},
            success:function (data) {
                //每次成功清除之前的数据
                $("#list-content").html("");
                var data=$.parseJSON(data);
                //遍历数据
                $.each(data.list,function (i,dom) {
                    $("#list-content").append(" <tr>\n" +
                        "  <td>"+dom.uid+"</td>\n" +
                        "                    <td class=\"center\">"+dom.uName+"</td>\n" +
                        "                    <td class=\"center\">\n" +
                        "                        <span class=\"label label-warning\">"+dom.email+"</span>\n" +
                        "                    </td>\n" +
                        "                    <td class=\"center\">\n" +
                        "                        <span class=\"label label-warning\">"+dom.type+"</span>\n" +
                        "                    </td>\n" +
                        "                    <td class=\"center\">\n" +
                        "                        <a class=\"btn btn-danger\" onclick=\"showModal("+dom.uid+");\">\n" +
                        "                            <i class=\"icon-trash icon-white\"></i>\n" +
                        "                            删除\n" +
                        "                        </a>\n" +
                        "                    </td>\n" +
                        "                </tr>");
                });  // each结束
                //使用分页插件
                $("#pagination").pagination(data.totalCount,
                    {
                        current_page:0, //当前页面
                        items_per_page:data.pageSize, //每页显示的条目数
                        load_first_page:false,
                        prev_text:"上一页",
                        next_text:"下一页",
                        callback:loadData //回调函数
                    });
            }//success回调函数
        }); /**
         * 模态窗口的操作
         */
    };
    function  showModal(delId) {
        //显示模态窗口
        $("#myModal").modal("show");
        //给隐藏域赋值
        $("#deleteId").val(delId);
    }
    /**
     * 真正的删除
     */
    function realDelete() {
        var id= $("#deleteId").val();
        window.location.href="/home?methodName=deleteUser&id="+id;
    }
</script>
</body>
</html>
