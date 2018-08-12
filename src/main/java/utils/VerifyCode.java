package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by aa on 2017/11/15.
 */
public class VerifyCode {
    //图片大小，字体，文本内容
    private  int width;
    private  int height;
    private Random random = new Random();
    private String[] fontNames  = {"宋体", "华文楷体", "黑体", "华文新魏", "华文隶书", "微软雅黑", "楷体_GB2312"};
    private String codes  = "23456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";
    private StringBuilder sb = new StringBuilder();

    /**
     * 文本颜色随机
     * @return
     */
    private Color randomColor () {
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }

    /**
     * 文本字体随机
     * @return
     */
    private Font randomFont () {
        int x = random.nextInt(fontNames.length);
        String fontName = fontNames[x];
        int style = random.nextInt(4);
        //int size = random.nextInt(6) + 24;
        int size = 28;
        return new Font(fontName, style, size);
    }

    /**
     * 文本内容随机
     * @return
     */
    private String randomText () {
        int x = random.nextInt(codes.length());
        return  codes.charAt(x)+"";
    }

    /**
     * 【step1】 创建图片，设置边框颜色，填充背景颜色
     * @param width
     * @param height
     * @return
     */
    public  BufferedImage createImage(int width,int height){
        //设置图片大小
        this.width = width;
        this.height = height;
        //创建内存图片
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        //拿到画笔
        Graphics graphics = bufferedImage.getGraphics();
        //设置边界颜色+画边界
        graphics.setColor(Color.CYAN);
        graphics.drawRect(0,0,width,height);
        //设置背景填充颜色+背景填充区域
        graphics.setColor(Color.BLACK);
        graphics.fillRect(1,1,width-2,height-2);

        return bufferedImage;
    }

    /**
     * 【step2】为图片添加干扰线
     */
    public void drawLine(BufferedImage bufferedImage){
        //拿到画笔
        Graphics graphics = bufferedImage.getGraphics();

        //添加x根干扰线
        int startX;
        int startY;
        int endX;
        int endY;

        for(int x=1;x<=8;x++){
            //随机设置颜色
            graphics.setColor(randomColor());
            //干扰线起点坐标
            startX = random.nextInt(width);
            startY = random.nextInt(height);
            //干扰线终点坐标  --- >  两点确定一条直线（干扰线）
            endX = random.nextInt(width);
            endY = random.nextInt(height);
            //画上干扰线
            graphics.drawLine(startX,startY,endX,endY);
        }
    }

    /**
     * 【step3】为图片添加文字
     *  > 文字的字体随机生成
     *  > 文字的内容随机生成
     */
    public void drawText(BufferedImage bufferedImage){
        //拿到画笔
        Graphics graphics = bufferedImage.getGraphics();

        //设置4个字母的横向排列间距
        int len = width/5;
        int start = len;
        String str;

        for(int x=1;x<=4;x++){
            //随机设置文字颜色
            graphics.setColor(randomColor());
            //随机设置文字字体
            graphics.setFont(randomFont());
            //随机设置文字内容(文字底部位于整个图片的：三分之二处)
            str = randomText();
            sb.append(str);
            graphics.drawString(str,start,height*2/3);

            //横向文字间距为len
            start+=len;
        }

        //释放资源
        graphics.dispose();
    }


    /**
     *【step1+step2+step3】将创建的图片添加干扰线和文字，制成成品验证码图片
     * @return
     */
    public  BufferedImage getImage(BufferedImage bufferedImage){
        //对验证码图片添干扰线
        drawLine(bufferedImage);
        //添文字内容
        drawText(bufferedImage);

        return bufferedImage;
    }

    /**
     * 获取验证码的文本内容
     * @return
     */
    public String getText(){
        return sb.toString();
    }

    /**
     * 将内存图片写出到指定的输出流
     * @param outputStream
     */
    public static void writeImage(BufferedImage bufferedImage,OutputStream outputStream){
        try {
            ImageIO.write(bufferedImage,"jpg",outputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("生成验证码失败。。。。。");
        }
    }
}
