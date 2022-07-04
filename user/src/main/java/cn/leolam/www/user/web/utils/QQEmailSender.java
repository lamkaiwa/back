package cn.leolam.www.user.web.utils;


import cn.leolam.www.user.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
@Component
public class QQEmailSender {
    @Autowired
    SecurityProperties securityProperties;

    public boolean sendEmail(String email,String content) throws Exception{
        //创建properties，类用于记录邮箱的一些属性
        Properties props=new Properties();
        //表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth","true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //QQ邮箱的端口号
        props.put("mail,smtp,port","587");
        //写信人的账号
        props.put("mail.user",securityProperties.getEmailAddress());
        //STMP口令
        props.put("mail.password",securityProperties.getEmailPassWord());

        Authenticator authenticator=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String userName=props.getProperty("mail.user");
                String password=props.getProperty("mail.password");
                return new PasswordAuthentication(userName,password);
            }
        };
        //使用环境属性和授权信息，创建邮件会话
        Session mailSession=Session.getInstance(props,authenticator);
        // 创建邮件消息
        MimeMessage message=new MimeMessage(mailSession);

        //设置发件人
        InternetAddress form=new InternetAddress(props.getProperty("mail.user"));
        message.setFrom(form);
        //设置收件人的邮箱
        InternetAddress to=new InternetAddress(email);
        message.setRecipient(RecipientType.TO,to);
        //设置邮件标题
        message.setSubject("TV验证码");
        //设置邮件内容体
        message.setContent(content,"text/html;charset=UTF-8");
        //最后当然就是发送邮件啦
        Transport.send(message);
        return true;
    }
}
