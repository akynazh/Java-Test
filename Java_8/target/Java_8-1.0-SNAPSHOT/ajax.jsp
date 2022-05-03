<%--
  Created by IntelliJ IDEA.
  User: akyna
  Date: 2021/8/15
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>

</head>
<body>
    <button onclick="ajaxRequest()">ajax Request</button>
    <button id="ajax">jQuery_ajaxRequest</button>
    <div id="mydiv"></div>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
    <script>
        $("#ajax").click(function() {
            $.ajax({
                url: "http://localhost:8080/Java_8/ajaxServlet",
                data: "action=ajax1",
                type: "GET",
                success: function(data) {
                    $("#mydiv").html("年龄：" + data.age + "<br/>" + "姓名：" + data.name);
                },
                dataType: "json"
            });
        });

        function ajaxRequest() {
            let xmlHttpRequest;
            if (window.XMLHttpRequest) {
                //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                xmlHttpRequest = new XMLHttpRequest();
            } else {
                // // IE6, IE5 浏览器执行代码
                xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlHttpRequest.open("GET", "http://localhost:8080/Java_8/ajaxServlet?action=ajax", true);
            xmlHttpRequest.onreadystatechange = function () {
                if (xmlHttpRequest.readyState === 4 && xmlHttpRequest.status === 200) {
                    // alert("收到服务器返回的数据" + xmlHttpRequest.responseText);
                    let jsonObj = JSON.parse(xmlHttpRequest.responseText);
                    document.getElementById("mydiv").innerHTML = "年龄：" + jsonObj.age + "<br/>" + "姓名：" + jsonObj.name;
                }
            }
            xmlHttpRequest.send();
            // alert("asynchronous")
        }
    </script>
</body>
</html>
