<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>词法分析系统</title>
    <link rel="stylesheet" href="../css/my.css">
</head>
<body>
<div class="box">
    <h1>词法分析系统</h1>
    <h2>欢迎您</h2>
    <input type="file" onchange="doFileUp(this)" multiple style="display: none" id="fileChoice"/>
    <a href="javascript:void(0);" onclick="doFileChoice()">上传文件</a>
    <div class="fileList" id="fileList">
        <ul>
            <li style="width: 30%">文件名</li>
            <li style="width: 68%">上传情况</li>
        </ul>
    </div>
</div>
<div class="box">
<a href="${pageContext.request.contextPath}/user/analyzer">查询分析结果</a><br><br><br>
<%--<a href="./pages/File_up.jsp">文件上传</a><br>--%>
</div>
<script type="text/javascript">
    function doFileChoice(){
        document.getElementById("fileChoice").click();
    }

    function doFileUp(fileObj){
        var files = fileObj.files;
        var backHtml = "";
        for(var i = 0; i < files.length; i++){
            var file = files[i];
            <!--progress进度条组件-->
            backHtml += "<ul><li style=\"width: 30%\">"+file.name+"</il><li style=\"width: 68%\"><progress id = 'pro"+i+"' max=\"100\" value=\"0\"></progress><label id='lab"+i+"'></label></li></ul>";
            // 每一个文件单独创建一个上传进程
            fileUp(file, i);
        }

        document.getElementById("fileList").innerHTML += backHtml;
    }

    function fileUp(file, index){
        // 相当于form表单
        var formData = new FormData();
        formData.append("file", file);
        var xhr = new XMLHttpRequest();
        var oldLoaded=0,total=0,curLoaded=0;
        xhr.upload.addEventListener("progress", function(event){
            //loaded total
            var percent = Math.round(event.loaded/event.total*100);
            document.getElementById("pro"+index).value = percent;
            curLoaded = event.loaded;
            if(oldLoaded == 0){
                total = event.total;
                oldLoaded = event.loaded;
            }
        }, false);

        //开启定时器
        var upSpeet = setInterval(function(){
            if(oldLoaded != 0){
                var speet = curLoaded-oldLoaded;
                document.getElementById("lab"+index).innerHTML = "速度:"+Math.round((speet/(1024*1024)*100)/100)+"m/s 剩余时间:"+Math.round((total-curLoaded)/speet)+"s";
                if(curLoaded == total){
                    document.getElementById("lab"+index).innerHTML = "上传完成";
                    clearInterval(upSpeet);
                }
                oldLoaded = curLoaded;
            }
        }, 1000);
        xhr.open("post", "/user/doUpload",true);//true表示是异步的
        xhr.send(formData);
    }
</script>
</body>
</html>
