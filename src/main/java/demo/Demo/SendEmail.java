package demo.Demo;// 需要用户名密码邮件发送实例
//文件名 SendEmail2.java
//本实例以QQ邮箱为例，你需要在qq后台设置

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;



public class SendEmail
{
    public static void main(String [] args)
    {
        // 收件人电子邮箱
        String to = "1206614724@qq.com";

        // 发件人电子邮箱
        String from = "1026225160@qq.com";

        // 指定发送邮件的主机为 localhost
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // 启用身份验证
        props.put("mail.smtp.ssl.enable", "true"); // 启用SSL
        props.put("mail.smtp.host", host);  // 设置邮件服务器
        props.put("mail.smtp.port", "465"); // SSL的端口通常为465

        // 获取默认session对象
        Session session = Session.getDefaultInstance(props,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("1026225160@qq.com", "dpfpqvlsnwjmbdjh"); //发件人邮件用户名、密码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("This is the Subject Line!");

            // 设置消息体
            message.setText("This is actual message");

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....from .cn");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
