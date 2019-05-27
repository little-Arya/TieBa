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
	static ResultSet rs = null;  //�����ѯ
	static PreparedStatement ps = null;
	//�������ݿ�
	public static void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			System.out.println("[SQL���������ʼ��ʧ�ܣ�]");
			e.printStackTrace();
		}
	}
	
	//�Ͽ����ݿ�
	 public static void closeConn() {
	     try {
	    	 if(conn != null){
	         conn.close();}
	     } catch (Exception e) {
	    	 System.out.println("sql���ݿ�ر��쳣");
	       e.printStackTrace();
	     }
	  }
	 

		public static ResultSet selectSql(String sql){  //���ݿ��ѯ
			try {
				ps =  (PreparedStatement) conn.prepareStatement(sql);
				rs =  ps.executeQuery(sql);  //���ڲ����������������䣬������ִ��SELECT���
			} catch (SQLException e) {
				System.out.println("sql���ݿ��ѯ�쳣");
				e.printStackTrace();
			}
			return rs;
		}
	 
	 public static ResultSet Search(String sql, String str[]) {		
			try {
				ps = (PreparedStatement) conn.prepareStatement(sql);
				if (str != null) {
					for (int i = 0; i < str.length; i++) {
						ps.setString(i + 1, str[i]);//��Ԥ��������е�δ֪����ֵ,����values(?,?,?)�е�ÿһ��?��ֵ
					}
				}		
				rs = ps.executeQuery();	//executeQueryֻ�����ڲ�ѯ��execute�����ſ���ִ��insert��update��delete����
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
						ps.setString(i + 1, (String) str[i]);//setString()��1��ʼ
					}
				}
				a = ps.executeUpdate();
			} catch (Exception e) {
				System.out.println("��ɾ���쳣");
			}

			return a;
		}

	public ResultSet executeQuery(String sql, String[]param) {
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		
		int a = 0;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			a = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Sql���ݿ���ɾ���쳣");
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
