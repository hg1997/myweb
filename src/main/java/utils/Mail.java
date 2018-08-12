package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aa on 2017/8/6.
 */
public class Mail {
    /*========================> members  <=============================*/

    //发件人
    private String from;

    //发送   抄送   暗送
    private StringBuilder toAddress = new StringBuilder();
    private StringBuilder ccAddress = new StringBuilder();
    private StringBuilder bccAddress = new StringBuilder();

    //主题  内容
    private String subject;
    private String content;

    //附件
    private List<AttachBean> beanList = new ArrayList<AttachBean>();

    /*=====================> 构造函数  <======================*/
    //默认构造
    public Mail() {
    }

    //发件人，主题，内容
    public Mail(String from, String subject, String content) {
        /*
        *  Mail mail =
        *  new Mail(javax.mail.internet.MimeUtility.encodeText("我的昵称")+"<18883731560@163.com>",
        *  "没什么主题",
        *  "这就是我的内容");
        * */
        this.from = from;
        this.subject = subject;
        this.content = content;
    }

    /*===================>  setter/getter  <==========================*/
    //from subject  content

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //发送  抄送 暗送 附件 add

    public void addToAddress(String to) {
        if (toAddress.length() > 0) { //逗号隔开
            toAddress.append(",");
        }
        toAddress.append(to);

    }

    public void addCCAddress(String cc) {
        if (ccAddress.length() > 0) { //逗号隔开
            ccAddress.append(",");
        }
        toAddress.append(cc);

    }

    public void addBCCAddress(String bcc) {
        if (bccAddress.length() > 0) { //逗号隔开
            bccAddress.append(",");
        }
        toAddress.append(bcc);
    }

    public void addAttachBean(AttachBean bean) {
        beanList.add(bean);
    }

    //发送  抄送 暗送 附件  getter
    public String getToAddress() {
        return toAddress.toString();
    }

    public String getCcAddress() {
        return ccAddress.toString();
    }

    public String getBccAddress() {
        return bccAddress.toString();
    }

    public List<AttachBean> getBeanList() {
        return beanList;
    }
}
