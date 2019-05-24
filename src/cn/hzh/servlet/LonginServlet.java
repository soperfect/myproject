package cn.hzh.servlet;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login.do")
public class LonginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //设置响应的MIME类型和字符编码6
        response.setContentType("text/html;charset = utf-8");
        String account1 = "GDUT";
        String password1 ="123456";
        System.out.println("已经进入LoginSevlet");
        //接收小程序传过来的account和password
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        System.out.println(account);
        System.out.println(password);
        //初始化为false
        Boolean isLogin=false;
        //判断是否登陆成功
        try {
            if (account1.equals(account) && password1.equals(password)) {
                isLogin = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(isLogin);
        Map<String,String> map = new HashMap<String,String>();
        if(isLogin) map.put("message", "ok");
        else map.put("message", "err");
        //System.out.println(map);
        //要将Map转化为JSON，才可以传数据返回小程序
        JSONObject mapObject = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println("JSON字符串"+mapObject.toString());
        //从服务器传mapObject数据到小程序
        response.getWriter().write(mapObject.toString());

    }
}
