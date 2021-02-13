/**
 * Project Name:wjzc
 * File Name:LoginBody
 * Package Name:com.wjzc.framework.security
 * Date:2020/4/8 9:57
 * Copyright (c) 2020, cbq@bostech.com All Rights Reserved.
 */
package com.wjzc.framework.security;

/**
 * TODO
 * @author 程碧泉
 * @since JDK1.7
 * @history 2020/4/8 程碧泉 新建
 */
public class LoginBody
{
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 唯一标识
     */
    private String uuid = "";

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
}