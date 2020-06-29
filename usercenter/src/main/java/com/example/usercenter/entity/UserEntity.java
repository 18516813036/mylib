package com.example.usercenter.entity;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.usercenter.BR;

/**
 * {   “ id”:1
 * “ username”:“示例字符串2”，
 * “ pwd”:“样本字符串3”，
 * “ sex”:“样本字符串4”，
 * “ birthday”:“样本字符串5”,
 * “ headerimg”:“样本字符串6”,
 * “ nick”:“样本字符串7”,
 * “ utype”：8 }
 */
public class UserEntity extends BaseObservable {
    private int id;
    private String username;
    private String pwd;
    private String sex;
    private String birthday;
    private String headerimg;
    private String nick;
    private int utype;

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
        notifyPropertyChanged(BR.pwd);
    }

    @Bindable
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        notifyPropertyChanged(BR.sex);
    }

    @Bindable
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        notifyPropertyChanged(BR.birthday);
    }

    @Bindable
    public String getHeaderimg() {
        return headerimg;
    }

    public void setHeaderimg(String headerimg) {
        this.headerimg = headerimg;
        notifyPropertyChanged(BR.headerimg);
    }

    @Bindable
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
        notifyPropertyChanged(BR.nick);
    }

    @Bindable
    public int getUtype() {
        return utype;
    }

    public void setUtype(int utype) {
        this.utype = utype;
        notifyPropertyChanged(BR.utype);
    }
}
