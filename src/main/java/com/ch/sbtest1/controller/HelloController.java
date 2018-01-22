package com.ch.sbtest1.controller;

import com.ch.sbtest1.bean.PeopleBean;
import com.ch.sbtest1.bean.User;
import com.ch.sbtest1.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

//等价于@Controller+@ResponseBody的结合，使用这个注解的类里面的方法都以json格式输出
@RestController
@RequestMapping("c1")
@EnableConfigurationProperties({PeopleBean.class})
public class HelloController {

    @Autowired
    PeopleBean p;

    @Value("${com.ch.all}")
    private String all;

    @RequestMapping("/hello")
    public String say(){
        System.out.print(p.getName()+p.getWant());
        return p.getName()+p.getWant();
    }


    @RequestMapping("/hello2")
    public String say2(){
        return  all;
    }


    //读取配置文件的随机值,前两个如果写成基本数据类型的话恒为负值？
    @Value("${random1}")
    private Integer r1;
    @Value("${random2}")
    private Long r2;
    @Value("${random3}")
    private String r3;
    @Value("${random4}")
    private String r4;

    @RequestMapping("/hello3")
    public String say3(){
        return r1+"  "+r2+"  "+r3+"  "+r4;//返回换行符\n没用，都是json数据了
    }

    //获取用户IP地址
    @RequestMapping(value = "/getIp", method = RequestMethod.GET)
    @ResponseBody
    public String getIp(HttpServletRequest request) {
        return IpUtil.getIpAddr(request);
    }

    @RequestMapping("getUsers")
    public ArrayList<User> getUsers(HttpServletRequest request){
        String ip=IpUtil.getIpAddr(request);
        ArrayList<User> datas=new ArrayList<>();
       // User user =null;
        for(int i=1;i<11;i++){
            User user=new User();
            user.setId(1505200+i);
            user.setUsername("耗子"+i);
            user.setPassword(ip);
            datas.add(user);
            //user=null;
        }

        return datas;
    }
}
