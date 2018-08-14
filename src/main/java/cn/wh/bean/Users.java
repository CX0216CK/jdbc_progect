package cn.wh.bean;

public class Users {
    private Integer uid;
    private String uName;
    private String upwd;
    private Integer type;
    private String Email;
    private String file;

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uName='" + uName + '\'' +
                ", upwd='" + upwd + '\'' +
                ", type=" + type +
                ", Email='" + Email + '\'' +
                ", file='" + file + '\'' +
                '}';
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Users(Integer uid, String uName, String upwd, Integer type, String email, String file) {
        this.uid = uid;
        this.uName = uName;
        this.upwd = upwd;
        this.type = type;
        Email = email;
        this.file = file;
    }

    public Users() {

    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;

    }

}
