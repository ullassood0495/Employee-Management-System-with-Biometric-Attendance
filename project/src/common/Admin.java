package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Admin extends StaffMember {
	
	public Admin(String user, String pass, Connection con) {
		super();
		setUsername(user);
		setPass(pass);
		setAccountType("Admin");
		setConnector(con);
	}
	
	public String[] getAllEmployees() throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		int i = 1;
		int total = 0;
		ps = this.connector.prepareStatement("SELECT COUNT(*) FROM emp_details");
		rs = ps.executeQuery();
		while(rs.next())
			total = rs.getInt(1);
		ps.close();
		String[] model = new String[total + 1];
		model[0] = "<SELECT>";
		ps = this.connector.prepareStatement("SELECT emp_id, emp_fname, emp_lname FROM emp_details");
		rs = ps.executeQuery();
		while(rs.next()) {
			String val = rs.getInt(1) + "-" + rs.getString(2) + " " + rs.getString(3); 
			model[i] = val;
			i++;
		}
		ps.close();
		return model;
	}
	
	public boolean createNewAdmin() throws SQLException, FileNotFoundException {
		boolean flag = true;
		PreparedStatement ps;
		ResultSet rs = null;
		ps = this.connector.prepareStatement("SELECT COUNT(*) FROM admin_info WHERE uname = ?");
		ps.setString(1, this.username);
		rs = ps.executeQuery();
		rs.next();
		if(rs.getInt(1) != 0) {
			flag = false;;
		}
		if(flag) {
			ps = this.connector.prepareStatement("SELECT MAX(admin_id) FROM admin_info");
			rs = ps.executeQuery();
			int temp = 0;
			while(rs.next())
				temp = rs.getInt(1);
			if(temp == 0)
				flag = false;
			this.admin_id = temp + 1;
			ps.close();
			
			if(flag) {
				FileInputStream fis = new FileInputStream(this.pic);
				
				ps = this.connector.prepareStatement("INSERT INTO admin_info (admin_id, uname, upass, profilepic, adminname) VALUES (?, ?, ?, ?, ?)");
				ps.setInt(1, this.admin_id);
				ps.setString(2, this.username);
				ps.setString(3, this.pass);
				ps.setBinaryStream(4, fis, (int)this.pic.length());
				ps.setString(5, this.firstname);
				int x = ps.executeUpdate();
				ps.close();
				if(x == 0) {
					flag = false;
				}
			}
		}
		ps.close();
		if(flag)
			this.connector.commit();
		
		return flag;
	}
	
	public boolean updatePassword(String oldpass, String newpass) throws SQLException {
		boolean flag = true;
		PreparedStatement ps;
		ResultSet rs = null;
		ps = this.connector.prepareStatement("SELECT * FROM admin_info WHERE uname = ?");
		ps.setString(1, this.username);
		rs = ps.executeQuery();
		while(rs.next()) {
			if(!rs.getString("upass").equals(oldpass)) {
				flag = false;
			}
		}
		ps.close();
		
		if(flag) {
			ps = this.connector.prepareStatement("UPDATE admin_info SET upass = ? WHERE uname = ?");
			ps.setString(1, newpass);
			ps.setString(2, this.username);
			int x = ps.executeUpdate();
			if(x > 0) {
				flag = true;
				this.pass = newpass;
				this.connector.commit();
			}
		}
		return flag;
	}
	
	public Object[][] getLeaveInfor() throws SQLException{
		PreparedStatement ps;
		ResultSet rs;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		ps = this.connector.prepareStatement("select a.leave_id, a.emp_id, b.emp_fname, b.emp_lname, a.fromdate, "
				+ "a.todate, a.reason, a.type, a.status from leaverequest a INNER JOIN emp_details b ON a.emp_id = b.emp_id order by applieddate DESC;\r\n" + 
				"");
		rs = ps.executeQuery();
		rs.last();
		int count = rs.getRow();
		rs.beforeFirst();
		Object[][] obj = new Object[count][8];
		int i = 0;
		while(rs.next()) {
			String[] temp = {"", "", "", "", "", "", "", ""};
			temp[0] = rs.getInt(1) + "";
			temp[1] = rs.getInt(2) + "";
			temp[2] = rs.getString(3) + " " + rs.getString(4);
			temp[3] = df.format(rs.getDate(5));
			temp[4] = df.format(rs.getDate(6));
			temp[5] = rs.getString(7) + "";
			temp[6] = rs.getString(8) + "";
			temp[7] = rs.getString(9) + "";
			obj[i] = temp;
			i++;
		}
		ps.close();
		return obj;
	}
	
	public boolean rejectRequest(int id) throws SQLException {
		boolean flag = false;
		PreparedStatement ps;

		ps = this.connector.prepareStatement("UPDATE leaverequest SET status = 'R', satus_o = 'R' WHERE leave_id = ?");
		ps.setInt(1, id);
		int x = ps.executeUpdate();
		if(x > 0) {
			this.connector.commit();
			flag = true;
		}
		ps.close();
		return flag;
	}
	
	public boolean acceptRequest(int id) throws SQLException {
		boolean flag = false;
		PreparedStatement ps;

		ps = this.connector.prepareStatement("UPDATE leaverequest SET status = 'A', satus_o = 'A' WHERE leave_id = ?");
		ps.setInt(1, id);
		int x = ps.executeUpdate();
		if(x > 0) {
			this.connector.commit();
			flag = true;
		}
		ps.close();
		return flag;
	}
	
	public boolean giveSalary(int empid, int m, int y, float bs, float i) throws SQLException {
		boolean flag = false;
		PreparedStatement ps;

		ps = this.connector.prepareStatement("INSERT INTO salary_info VALUES (?, ?, ?, ?, ?)");
		ps.setInt(1, empid);
		ps.setInt(2, m);
		ps.setInt(3, y);
		ps.setDouble(4, bs);
		ps.setDouble(5, i);
		int x = ps.executeUpdate();
		if(x > 0) {
			this.connector.commit();
			flag = true;
		}
		ps.close();
		return flag;
	}
	
}
