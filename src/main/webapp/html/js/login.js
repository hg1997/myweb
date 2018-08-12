/**
 * Created by aa on 2017/8/3.
 */
var user  = document.getElementById("uid");
var password  = document.getElementById("pid");
var verifycode = document.getElementById("vid");
var welcome = document.getElementById("welcome");



//******************************

/*获取连接*/
var createXMLHttpRequest = function(){
    try{
        return new XMLHttpRequest();
    }catch(e){
        try{
            return new  ActiveXObject("Msxml2.XMLHTTP"); //IE6.0
        }catch(e){
            try{
                return new ActiveXObject("Microsoft.XMLHTTP");//IE5.5及更早版本
            }catch(e){
                throw e;
            }
        }
    }
}

/*加载页面时*/
window.onload = function(){
    /*用户框失去焦点*/
    user.onblur = function () {
        user.style.borderColor = "#4f5556";
        var userValue = user.value;
        if(userValue == "") //用户名为空
            welcome.innerHTML = "用户名不能为空！";
        else{   //用户名不为空，ajax校验
            //创建对象  打开连接  发送请求体  接收响应
            var request = createXMLHttpRequest();
            request.open("post","${pageContext.request.contextPath}/login.action",true);
            request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            request.send("username="+userValue);
            request.onreadystatechange = function()
            {
                if(request.status == 200 && request.readyState == 4)
                {  /* responseText是属性  不是request的函数 */
                    content = request.responseText;
                    welcome.innerHTML = content;
                }
            }
        }
    }

    /*密码框失去焦点*/
    password.onblur = function () {
        password.style.borderColor = "#4f5556";
        if(password.value == "")
            welcome.innerHTML = "密码不能为空！";
        else
            welcome.innerHTML = "";
    }
    verifycode.onblur = function () {
        verifycode.style.borderColor = "#4f5556";
        if(password.value == "")
            welcome.innerHTML = "验证码不能为空！";
        else
            welcome.innerHTML = "";
    }

    /*获得焦点*/
    user.onfocus = function () {
        user.style.border = "2px solid lightblue";
    }
    password.onfocus = function () {
        password.style.border = "2px solid lightblue";
    }
    verifycode.onfocus = function () {
        verifycode.style.border = "2px solid lightblue";
    }

}
