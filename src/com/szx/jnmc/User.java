package com.szx.jnmc;

/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;*/

public class User {
	private String username;
    private String userpass;
    private int role;
    private int lognum;
    private  String regtime;
    private String title;
    private String message;
    private String time;
  //  private String reusername;
    private int id;
    private int to_id;
    private String content;
    private String createtime;
    public int getTo_id() {
        return to_id;
    }
    public void setTo_id(int to_id) {
        this.to_id = to_id;
    }
/*   public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }*/
    public String getContent() {
    	return content;
    }
    public void setContent(String content) {
    	this.content=content;
    }
    public String getCreatetime() {
        return createtime;
    }
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpass() {
        return userpass;
    }
    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }

    public int getLognum() {
        return lognum;
    }
    public void setLognum(int lognum) {
        this.lognum = lognum;
    }
    public String getRegtime() {
        return regtime;
    }
    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

  
	
}
