package utils;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created by aa on 2017/8/6.
 */
public class MailUtils {
    /**
     * （1）获取连接,开启session
     *
     * @param host     -- >邮箱服务器主机
     *                 	163：smtp.163.com 和 pop3.163.com；
     *                 	126：smtp.126.com 和 pop3.126.com；
     *                 	qq：smtp.qq.com 和 pop3.qq.com；
     *                 	sohu：smtp.sohu.com 和 pop3.sohu.com；
     *                 	sina：smtp.sina.com 和 pop3.sina.com。
     * @param username
     * @param password
     * @return
     */
    public static Session getSession(String host, final String username, final String password) {
        //参数1
        Properties props = new Properties();
        props.setProperty("mail.host", host);/* 指定：主机名 */
        props.setProperty("mail.smtp.auth", "true");//设置需要认证

        //参数2
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);   /* 指定：用户名，密码*/
            }
        };

        //获取返回
        return Session.getInstance(props, authenticator);
    }

    /**
     * （2）指定发送内容（封装到Mai内中）
     * (3) 发送
     *
     * @param session -- > getSession（）方法获取
     * @param mail    -- > 创建mail对象(该类封装了发送内容)
     * @throws MessagingException
     * @throws IOException
     */
    public static void send(Session session, Mail mail) throws MessagingException, IOException {
        MimeMessage msg = new MimeMessage(session);

        msg.setFrom(new InternetAddress(mail.getFrom()));//发件人
        msg.setSubject(mail.getSubject());//主题
        msg.addRecipients(MimeMessage.RecipientType.TO, mail.getToAddress());//收件人


        //抄送
        String cc = mail.getCcAddress();
        if (cc.length() != 0) {
            msg.addRecipients(MimeMessage.RecipientType.CC, cc);
        }

        //暗送
        String bcc = mail.getBccAddress();
        if (bcc.length() != 0) {
            msg.addRecipients(MimeMessage.RecipientType.BCC, bcc);
        }

        /*
        * 多部件登场
        * */
        //正文
        MimeMultipart multipart = new MimeMultipart();
        MimeBodyPart body = new MimeBodyPart();
        body.setContent(mail.getContent(), "text/html;charset=utf-8");
        //body.setContent("就看你显示内容不，，，，","text/html;charset=utf-8");
        multipart.addBodyPart(body);

        //附件
        List<AttachBean> list = mail.getBeanList();
        if (list.size() != 0) {
            MimeBodyPart body2 = new MimeBodyPart();
            for (AttachBean bean : list) {
                //添加文件
                body2.attachFile(bean.getFile());
                //设置文件名，中文注意编码问题
                body2.setFileName(MimeUtility.encodeText(bean.getFileName()));
                //添加到多部件中
                multipart.addBodyPart(body2);
            }
        }
        //添加多部件
        msg.setContent(multipart);
        //发送
        Transport.send(msg);
    }

}
