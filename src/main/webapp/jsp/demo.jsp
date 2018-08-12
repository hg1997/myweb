<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>demo.jsp</title>
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        function demo(){
             $.ajax({
                    type:"post",
                    url:"/demo",
                    //contentType:"application/json;charset=utf-8",
                    //contentType:"application/x-www-form-urlencoded",
                    //data:'{"name":"测试商品","age":99.9,"info":{"addr":"cq","major":"computer"}}',
                    data:"date=2015年5月2日",
                    success:function(){
                        alert("ok....");
                    }
                });

        }
    </script>
</head>
<body>

   <input type="button" name="but" onclick="demo()" value="点击">



</body>
</html>
