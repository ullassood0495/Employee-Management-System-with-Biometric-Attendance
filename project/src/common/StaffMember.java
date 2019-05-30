package common;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import view.MainWindow;

public class StaffMember {
	protected String firstname = "";
	protected String lastname = "";
	protected String designation = "";
	protected String department = "";
	protected double basic_salary = 0.0;
	protected double incentive = 0.0;
	protected String housenum = "";
	protected String street = "";
	protected String district = "";
	protected String state = "";
	protected String contact_num = "";
	protected String username = "";
	protected String pass = "";
	protected String pincode = "";
	protected String id = "";
	protected String account_type = ""; 
	protected Connection connector = null;
	protected File pic = null;
	protected byte[] profilepic = null;
	protected int emp_id = -1;
	protected int admin_id = -1;
	
	
	public StaffMember() {
		
	}
	
	public StaffMember(String fname, String lname, String contact) {
		this.firstname = fname;
		this.lastname = lname;
		this.contact_num = contact;
		this.username = fname + contact.substring(contact.length() - 3);
		this.pass = this.username;
	}
	

	public byte[] getPic() throws IOException {
		return profilepic;
	}
	
	public void setPic(File img) throws IOException {
		this.pic = img;
		/*
		byte[] fileContent = Files.readAllBytes(img.toPath());
		pic = fileContent;	
		System.out.println(pic.length);
		*/
	}

	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public double getBasic_salary() {
		return basic_salary;
	}


	public void setBasic_salary(double basic_salary) {
		this.basic_salary = basic_salary;
	}


	public double getIncentive() {
		return incentive;
	}


	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}


	public String getHousenum() {
		return housenum;
	}


	public void setHousenum(String housenum) {
		this.housenum = housenum;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getContact_num() {
		return contact_num;
	}


	public void setContact_num(String contact_num) {
		this.contact_num = contact_num;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPincode() {
		return pincode;
	}
	
	public void setid(String id) {
		this.id = id;
	}

	public String getid() {
		return id;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public String getAccountType() {
		return account_type;
	}
	
	public void setConnector(Connection c) {
		this.connector = c;
	}


	public void setAccountType(String actype) {
		this.account_type = actype;
	}
	
	public String getFullName() {
		return this.firstname + " " + this.lastname;
	}
	
	public String getAddress() {
		return this.housenum + ", " + this.street + ", " + this.district + ", " + this.state + ", " + this.pincode;
	}
	
	public boolean validateCredentials() throws SQLException, ClassNotFoundException, IOException {
		// DB access
		int vid = -1;
		
		// TODO get admin name from db
		String name = "";
		if(this.account_type.equals("Admin")) {
			String stmt = "SELECT * FROM admin_info WHERE uname = ? and upass = ?";
			PreparedStatement ps = this.connector.prepareStatement(stmt);
			ps.setString(1, this.username);
			ps.setString(2, this.pass);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				vid = rs.getInt(1);
				name = rs.getString("adminname");
			}
			setid(vid + "");
			this.admin_id = vid;
			ps.close();
			if(vid != -1) {
				String[] temp = name.split(" ");
				this.firstname = temp[0];
				if(temp.length > 1)
					this.lastname = temp[1];
				Blob blob;
				
				PreparedStatement ps2 = this.connector.prepareStatement("select profilepic from admin_info where uname = ?");
				ps2.setString(1, this.username);
				ResultSet rs2 = ps2.executeQuery();
				
				while(rs2.next()) {
					blob = rs2.getBlob("profilepic");
					if(blob == null)
						break;
					profilepic = blob.getBytes(1, (int) blob.length());
				}
				if(pic == null && profilepic == null) {
					File f = new File("src//common//employee.png");
					byte[] fileContent = Files.readAllBytes(f.toPath());
					pic = f;
					profilepic = fileContent;
				}
				return true;
			}
		}
		else {
			if(this.account_type.equals("Employee")) {
				int id = 0;
				String stmt = "SELECT * FROM employee_login WHERE emp_username = ? and emp_password = ?";
				PreparedStatement ps = this.connector.prepareStatement(stmt);
				ps.setString(1, this.username);
				ps.setString(2, this.pass);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					id = rs.getInt(1);
				}
				setid(id + "");
				emp_id = id;
				ps.close();
				if(id != 0) {
					Blob blob;
					
					PreparedStatement ps2 = this.connector.prepareStatement("select emp_profilepic from employee_login where emp_username = ?");
					ps2.setString(1, this.username);
					ResultSet rs2 = ps2.executeQuery();
					
					while(rs2.next()) {
						blob = rs2.getBlob("emp_profilepic");
						if(blob == null)
							break;
						profilepic = blob.getBytes(1, (int) blob.length());
					}
					if(pic == null && profilepic == null) {
						File f = new File("src//common//employee.png");
						byte[] fileContent = Files.readAllBytes(f.toPath());
						pic = f;
						profilepic = fileContent;
					}
					return true;
				}
			}
		}
		return false;
	}
}
