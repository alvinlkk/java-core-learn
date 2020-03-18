package com.alvinlkk.chapter01;

/**
 * 用户对象
 * @author : alvinlkk
 * @version V1.0
 * @date Date : 2020-02-28 18:01
 */
public class User {

    private String username;

    private String sex;

    /**
     * 是否是学生
     */
    private Boolean student;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Boolean getStudent() {
        return student;
    }

    public void setStudent(Boolean student) {
        this.student = student;
    }
}
