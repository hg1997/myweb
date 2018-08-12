package utils;

import java.io.File;

/**
 * Created by aa on 2017/8/6.
 */

/**
 * 作为附件描述类
 */

public class AttachBean {
    //指定附件的文件和附件名字
    private String FileName;
    private File file;

    //constructor
    public AttachBean() {
    }

    public AttachBean(String fileName, File file) {
        FileName = fileName;
        this.file = file;
    }

    //setter/getter
    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {

        FileName = fileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
