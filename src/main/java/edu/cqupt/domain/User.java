package edu.cqupt.domain;

public class User {
    private Integer uid;

    private String username;

    private String password;

    private String accountName;

    private String image;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountName='" + accountName + '\'' +
                ", image='" + image + '\'' +
                ", tel='" + tel + '\'' +
                ", sex='" + sex + '\'' +
                ", click=" + click +
                ", store=" + store +
                '}';
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {

        this.accountName = accountName;
    }

    private String tel;

    private String sex;

    private Integer click;

    private Integer store;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

}