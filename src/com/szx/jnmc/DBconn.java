package com.szx.jnmc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/A20170512?serverTimezone=GMT%2B8&useunicuee=true& characterEncoding=utf8&useSSL=false";
	private static String username = "root";
	private static String password = "123456";
	static Connection conn = null;
	static ResultSet rs = null;  //结果查询
	static PreparedStatement ps = null;
	//连接数据库
	public static void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			System.out.println("[SQL驱动程序初始化失败！]");
			e.printStackTrace();
		}
	}
	
	//断开数据库
	 public static void closeConn() {
	     try {
	    	 if(conn != null){
	         conn.close();}
	     } catch (Exception e) {
	    	 System.out.println("sql数据库关闭异常");
	       e.printStackTrace();
	     }
	  }
	 

		public static ResultSet selectSql(String sql){  //数据库查询
			try {
				ps =  (PreparedStatement) conn.prepareStatement(sql);
				rs =  ps.executeQuery(sql);  //用于产生单个结果集的语句，多用于执行SELECT语句
			} catch (SQLException e) {
				System.out.println("sql数据库查询异常");
				e.printStackTrace();
			}
			return rs;
		}
	 
	 public static ResultSet Search(String sql, String str[]) {		
			try {
				ps = (PreparedStatement) conn.prepareStatement(sql);
				if (str != null) {
					for (int i = 0; i < str.length; i++) {
						ps.setString(i + 1, str[i]);//给预处理语句中的未知数赋值,即给values(?,?,?)中的每一个?赋值
					}
				}		
				rs = ps.executeQuery();	//executeQuery只能用于查询，execute方法才可以执行insert，update，delete操作
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return rs;         
		}
	 
	 
	 public static int addUser(String sql,String[]str) {
			int a = 0;
			try {
				ps = (PreparedStatement) conn.prepareStatement(sql);
				if (str != null) {
					for (int i = 0; i < str.length; i++) {
						ps.setString(i + 1, (String) str[i]);//setString()从1开始
					}
				}
				a = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println("增删改异常");
			}

			return a;
		}

	public ResultSet executeQuery(String sql, String[]param) {
		// TODO 自动生成的方法存根
		try{
            ps = (PreparedStatement) conn.prepareStatement(sql);
            if(param != null){
                for (int i = 0; i < param.length; i++) {
                    ps.setString(i + 1, param[i]);
                }
            }
            rs = ps.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }       
        return rs;
	}

	public static int addU(String sql) {
		// TODO 自动生成的方法存根
		
		int a = 0;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			a = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Sql数据库增删改异常");
			e.printStackTrace();
		}

		return a;
	}
	
	
/*	 public static ArrayList<Comment> getCommentList(String sql){
		 ArrayList<Comment> list = new ArrayList<Comment>(); 
			try {
			Connect();
			ps =  (PreparedStatement) conn.prepareStatement(sql);
			rs =  ps.executeQuery(sql);
			while(rs.next()) {
				int to_id=Integer.valueOf(rs.getString(2)).intValue();
				String username=rs.getString(1);				
				String createtime=rs.getString(4);
				String content=rs.getString(3);
				
				Comment msg=new Comment();
	
				msg.setTo_id(to_id);
				msg.setUsername(username);
				msg.setCreatetime(createtime);
				msg.setContent(content);
				
				
				list.add(msg);
			}
			closeConn();
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return list;
	 }*/

}
