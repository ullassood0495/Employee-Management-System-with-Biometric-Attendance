package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee extends StaffMember {
	private int dept_id;
	
	public Employee() {
		super();
	}
	
	public Employee(int id, Connection con) {
		super();
		this.emp_id = id;
		setConnector(con);
	}
	
	public Employee(String user, String pass, Connection con) {
		super();
		setUsername(user);
		setPass(pass);
		setAccountType("Employee");
		setConnector(con);
	}
	
	public int getDeptID() {
		return this.dept_id;
	}
	
	public byte[] getImage() throws SQLException {
		byte[] b = null;
		Blob blob;
		PreparedStatement ps = this.connector.prepareStatement("select emp_profilepic from employee_login WHERE emp_id = ?");
		ps.setInt(1, this.emp_id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			blob = rs.getBlob("emp_profilepic");
			if(blob == null)
				break;
			b = blob.getBytes(1, (int) blob.length());	
		}
		this.profilepic = b;
		ps.close();
		if(this.profilepic == null)
			return null;
		return b;
	}
	
	public void getDetails() throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		ps = this.connector.prepareStatement("SELECT * FROM emp_details WHERE emp_id = ?");
		ps.setInt(1, this.emp_id);
		rs = ps.executeQuery();
		while(rs.next()) {
			setFirstname(rs.getString(2));
			setLastname(rs.getString(3));
			setDesignation(rs.getString(4));
			this.dept_id = rs.getInt(5);
			setBasic_salary(rs.getDouble(6));
			setIncentive(rs.getDouble(7));
			setContact_num(rs.getString(8));
		}
		ps = this.connector.prepareStatement("SELECT dept_name FROM depts WHERE dept_id = ?");
		ps.setInt(1, this.dept_id);
		rs = ps.executeQuery();
		while(rs.next())
			setDepartment(rs.getString("dept_name"));
		ps.close();
		
		ps = this.connector.prepareStatement("SELECT * FROM addresses WHERE emp_id = ?");
		ps.setInt(1, this.emp_id);
		rs = ps.executeQuery();
		while(rs.next()){
			setHousenum(rs.getString(2));
			setStreet(rs.getString(3));
			setDistrict(rs.getString(4));
			setState(rs.getString(5));
			setPincode(rs.getString(6));
		}
		ps.close();
		
	}
	
	public boolean enterDetails() throws SQLException, IOException {
		PreparedStatement ps;
		int x = 0, y = 0, z = 0;
		ResultSet rs;
		int id = 0;
		FileInputStream fis = new FileInputStream(this.pic);
		
		ps = this.connector.prepareStatement("INSERT INTO employee_login (emp_username, emp_password, emp_profilepic) VALUES (?, ?, ?)");
		ps.setString(1, this.username);
		ps.setString(2, this.pass);
		ps.setBinaryStream(3, fis, (int)this.pic.length());
		x = ps.executeUpdate();
		ps.close();
		fis.close();
		
		ps = this.connector.prepareStatement("SELECT emp_id FROM employee_login WHERE emp_username = ?");
		ps.setString(1, this.username);
		rs = ps.executeQuery();
		while(rs.next())
			id = rs.getInt("emp_id");
		emp_id = id;
		setid(id + "");
		ps.close();
		
		ps = this.connector.prepareStatement("SELECT dept_id FROM depts WHERE dept_name = ?");
		ps.setString(1, this.department);
		rs = ps.executeQuery();
		while(rs.next())
			dept_id = rs.getInt("dept_id");
		emp_id = id;
		setid(id + "");
		ps.close();
		
		ps = this.connector.prepareStatement("INSERT INTO emp_details (emp_id, emp_fname, emp_lname, emp_desig, emp_dept, emp_basesalary, emp_incentive, emp_contact) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		ps.setInt(1, emp_id);
		ps.setString(2, this.firstname);
		ps.setString(3, this.lastname);
		ps.setString(4, this.designation);
		ps.setInt(5, dept_id);
		ps.setFloat(6, (float) this.basic_salary);
		ps.setFloat(7, (float) this.incentive);
		ps.setString(8, this.contact_num);
		y = ps.executeUpdate();
		ps.close();
		
		ps = this.connector.prepareStatement("INSERT INTO addresses (emp_id, hnum, street, district, state, pincode) VALUES (?, ?, ?, ?, ?, ?)");
		ps.setInt(1, emp_id);
		ps.setString(2, this.housenum);
		ps.setString(3, this.street);
		ps.setString(4, this.district);
		ps.setString(5, this.state);
		ps.setString(6, this.pincode);
		z = ps.executeUpdate();
		ps.close();
		
		if(x == 1 && y == 1 && z == 1) {
			this.connector.commit();
			return true;
		}
		return false;
	}
	
	public int getAttendence(int month) throws SQLException {
		int val = -1;
		PreparedStatement ps = this.connector.prepareStatement("SELECT COUNT(*) FROM attendence_" + month + " WHERE emp_id = ?");
		ps.setInt(1, this.emp_id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			val = rs.getInt(1);
		}
		System.out.println(val);
		return val;
	}
	
	public boolean updateDetails() throws SQLException, IOException {
		PreparedStatement ps;
		int x = 0, y = 0, z = 0;
		ResultSet rs;
		int id = 0;
		FileInputStream fis = new FileInputStream(this.pic);
		
		// Update Profile pic
		
		ps = this.connector.prepareStatement("UPDATE employee_login SET emp_profilepic = ? WHERE emp_id = ?");
		ps.setBinaryStream(1, fis, (int)this.pic.length());
		ps.setInt(2, this.emp_id);
		x = ps.executeUpdate();
		ps.close();
		fis.close();
		
		
		ps = this.connector.prepareStatement("SELECT dept_id FROM depts WHERE dept_name = ?");
		ps.setString(1, this.department);
		rs = ps.executeQuery();
		while(rs.next())
			dept_id = rs.getInt("dept_id");
		ps.close();
		
		ps = this.connector.prepareStatement("UPDATE emp_details SET emp_desig = ?, emp_dept = ?, emp_basesalary = ?, emp_incentive = ?, emp_contact = ? WHERE emp_id = ?");
		ps.setString(1, this.designation);
		ps.setInt(2, this.dept_id);
		ps.setFloat(3, (float) this.basic_salary);
		ps.setFloat(4, (float) this.incentive);
		ps.setString(5, this.contact_num);
		ps.setInt(6, this.emp_id);
		y = ps.executeUpdate();
		ps.close();
		
		ps = this.connector.prepareStatement("UPDATE addresses SET hnum = ?, street = ?, district = ?, state = ?, pincode = ? WHERE emp_id = ?");
		ps.setString(1, this.housenum);
		ps.setString(2, this.street);
		ps.setString(3, this.district);
		ps.setString(4, this.state);
		ps.setString(5, this.pincode);
		ps.setInt(6, this.emp_id);
		z = ps.executeUpdate();
		ps.close();

		if(x >= 1 && y >= 1 && z >= 1) {
			this.connector.commit();
			return true;
		}
		return false;
	}
	
	
	public boolean deleteEmployee() throws SQLException {
		PreparedStatement ps;
		int x = 0, y = 0, z = 0;
		
		ps = this.connector.prepareStatement("DELETE FROM attendence_3 WHERE emp_id = ?");
		ps.setInt(1, this.emp_id);
		x = ps.executeUpdate();
		ps.close();
		
		ps = this.connector.prepareStatement("DELETE FROM day_attendence WHERE eid = ?");
		ps.setInt(1, this.emp_id);
		x = ps.executeUpdate();
		ps.close();
		
		
		
		ps = this.connector.prepareStatement("DELETE FROM emp_details WHERE emp_id = ?");
		ps.setInt(1, this.emp_id);
		x = ps.executeUpdate();
		ps.close();
		
		ps = this.connector.prepareStatement("DELETE FROM addresses WHERE emp_id = ?");
		ps.setInt(1, this.emp_id);
		y = ps.executeUpdate();
		ps.close();
		
		ps = this.connector.prepareStatement("DELETE FROM employee_login WHERE emp_id = ?");
		ps.setInt(1, this.emp_id);
		z = ps.executeUpdate();
		ps.close();
		
		this.connector.commit();
		return true;
	}
	
	public boolean applyLeave(int duration, Date from, Date to, String reason, String type) throws SQLException {
		boolean flag = false;
		java.sql.Date datefrom = new java.sql.Date(from.getTime());
		java.sql.Date dateto = new java.sql.Date(to.getTime());
		
		Date date = new Date();
		java.sql.Date apldate = new java.sql.Date(date.getTime());
		
		
		PreparedStatement ps;
		
		ps = this.connector.prepareStatement("INSERT INTO leaverequest (emp_id, duration, fromdate, todate, reason, type, applieddate) VALUES (?, ?, ?, ?, ?, ?, ?)");
		ps.setInt(1, this.emp_id);
		ps.setInt(2, duration);
		ps.setDate(3, datefrom);
		ps.setDate(4, dateto);
		ps.setString(5, reason);
		ps.setString(6, type);
		ps.setDate(7, apldate);
		int temp = ps.executeUpdate();
		if(temp > 0) {
			this.connector.commit();
			flag = true;
		}
		return flag;
	}
	
	public String checkLeaveRequests() throws SQLException {
		String ret = "";
		java.sql.Date fromDate = null;
		java.sql.Date toDate = null;
		String status = "";
		Date from;
		Date to;
		PreparedStatement ps;
		ResultSet rs;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		int leave_id = -1;
		
		ps = this.connector.prepareStatement("Select t.leave_id, t.emp_id, fromdate, todate, status,max_date\r\n" + 
				"		from leaverequest t\r\n" + 
				"		inner join \r\n" + 
				"		(SELECT emp_id,MAX(applieddate) as max_date\r\n" + 
				"		FROM leaverequest\r\n" + 
				"		GROUP BY emp_id) as a\r\n" + 
				"		on a.emp_id = t.emp_id and a.max_date = applieddate\r\n" + 
				"        where t.emp_id = ?;");
		ps.setInt(1, this.emp_id);
		rs = ps.executeQuery();
		while(rs.next()) {
			leave_id = rs.getInt(1);
			fromDate = rs.getDate(3);
			toDate = rs.getDate(4);
			status = rs.getString(5);
		}
		
		if(fromDate != null && toDate != null) {
			from = new Date(fromDate.getTime());
			to = new Date(toDate.getTime());
			ps = this.connector.prepareStatement("UPDATE leaverequest SET status = 'C' WHERE leave_id = ?");
			if(status.equals("P")) {
				ret = "Leave Request: \nFrom : " + dateFormat.format(from) + " To : " + dateFormat.format(to) + " pending to be approved";
			}
			else if(status.equals("A")){
				ret = "Leave Request: \nFrom : " + dateFormat.format(from) + " To : " + dateFormat.format(to) + " is approved";
				ps.setInt(1, leave_id);
				ps.executeUpdate();
				this.connector.commit();
			}
			else if(status.equals("R")){
				ret = "Leave Request: \nFrom : " + dateFormat.format(from) + " To : " + dateFormat.format(to) + " is rejected";
				
				ps.setInt(1, leave_id);
				ps.executeUpdate();
				this.connector.commit();
			}
			ps.close();
		}
		return ret;
	}
	
	public boolean updatePassword(String oldpass, String newpass) throws SQLException {
		boolean flag = true;
		PreparedStatement ps;
		ResultSet rs = null;
		ps = this.connector.prepareStatement("SELECT * FROM employee_login WHERE emp_username = ?");
		ps.setString(1, this.username);
		rs = ps.executeQuery();
		while(rs.next()) {
			if(!rs.getString("emp_password").equals(oldpass)) {
				flag = false;
			}
		}
		ps.close();
		
		if(flag) {
			ps = this.connector.prepareStatement("UPDATE employee_login SET emp_password = ? WHERE emp_username = ?");
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
	
	public String[] getSalaryDetails(int m, int y) throws SQLException {
		PreparedStatement ps;
		ResultSet rs;
		boolean flag = false;
		ps = this.connector.prepareStatement("SELECT * FROM salary_info WHERE emp_id = ? and month = ? and year = ?");
		ps.setInt(1, this.emp_id);
		ps.setInt(2, m);
		ps.setInt(3, y);
		String bs = "";
		String i = "";
		rs = ps.executeQuery();
		while(rs.next()) {
			flag = true;
			bs = rs.getDouble(4) + "";
			i = rs.getDouble(5) + "";
		}
		ps.close();
		if(flag)
			return new String[] {bs, i};
		else
			return null;
	}
	
	public Object[][] getLeaveInfor() throws SQLException{
		PreparedStatement ps;
		ResultSet rs;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

		ps = this.connector.prepareStatement("select leave_id, fromdate, todate, reason, `type`, satus_o from leaverequest where emp_id = ?");
		ps.setInt(1, this.emp_id);
		rs = ps.executeQuery();
		rs.last();
		int count = rs.getRow();
		rs.beforeFirst();
		Object[][] obj = null;
		int i = 0;
		int j = 0;
		while(rs.next()) {
			if(j == 0) {
				obj = new Object[count][6];
				j++;
			}
			String[] temp = {"", "", "", "", "", ""};
			temp[0] = rs.getInt(1) + "";
			temp[1] = df.format(rs.getDate(2));
			temp[2] = df.format(rs.getDate(3));
			temp[3] = rs.getString(4) + "";
			temp[4] = rs.getString(5) + "";
			temp[5] = rs.getString(6) + "";
			obj[i] = temp;
			i++;
		}
		ps.close();
		return obj;
	}
}
