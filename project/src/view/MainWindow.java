package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import common.Admin;
import common.Employee;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class MainWindow {

	private JFrame frmEmployeeManagementSystem;
	private JButton btnLogin;
	private JPanel MainScreen;
	private JPanel MainAdmin;
	private JLabel lblGreeting;
	private JLabel lblPleaseLogin;
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JComboBox cmbAccountType;
	private JButton btnEmployeeAttendance;
	private JButton btnReset;
	private JButton btnDetailsOfEmployee;
	private JButton btnUpdateEmployeeInformation;
	private JButton btnDeleteEmployee;
	private JLabel lblAdminImage;
	private JLabel lblAdminUsername;
	private JLabel lblName;
	private JLabel lblAdminAccountType;
	private JLabel lblAdmin;
	private JButton btnLogOut;
	private JButton btnSettings;
	private JPanel MainEmpty;
	private JPanel AddEmployee;
	private JLabel lblEnterEmployeeDetails;
	private JButton btnAddnewemployee;
	private JPanel DetailsEmployee;
	private JLabel lblEmployeeDetails;
	private JPanel UpdateEmployee;
	private JLabel lblUpdateEmployeeDetails;
	private JPanel DeleteEmployee;
	private JLabel lblDeleteEmployeeDetails;
	private JPanel AdminSettings;
	private JLabel lblSettings;
	private JPanel MainEmployee;
	private JButton btnLogOutE;
	private JButton btnSettingsE;
	private JButton btnLeaveRequest;
	private JButton btnSalaryStatement;
	private JButton btnAttendanceDetails;
	private JLabel lblEmployeeName;
	private JLabel lblEmployeeImage;
	private JPanel AttendanceDetails;
	private JLabel lblAttendanceDetails;
	private JPanel MainEEmpty;
	private JPanel SalaryStatement;
	private JLabel lblSalaryStatement;
	private JPanel LeaveRequest;
	private JLabel lblApplyLeave;
	private JPanel EmployeeSettings;
	private JLabel lblChangeAccountSettings;
	private JLabel lblFirstName;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtBasicSalary;
	private JTextField txtIncentive;
	private JTextField txtHnum;
	private JTextField txtStreet;
	private JTextField txtDistrict;
	private JTextField txtPincode;
	private JLabel lblContactNumber;
	private JTextField txtContactNumber;
	private JLabel lblProfileImage;
	private JLabel lblEmpProfilePic;
	private JButton btnChooseFile;
	private JButton btnAddEReset;
	private JButton btnAddEmployee;
	private JButton btnCreateNewAdmin;
	private JButton btnChangePassword;
	private JTextField txtNewAdminUsername;
	private JPasswordField txtNewAdminPassword;
	private JPasswordField txtNewAdminConfirmPassword;
	private JPasswordField txtOldPassword;
	private JPasswordField txtNewPassword;
	private JPasswordField txtConfirmPassword;
	private JButton btnChange;
	private JPanel SettingsOptions;
	private JPanel EmptyPanel;
	private JPanel NewAdmin;
	private JPanel ChangePassword;
	private JLabel lblChooseEmployee;
	private JLabel lblEmployeeId;
	private JTextField txtEmpID;
	private JLabel lblEmployeeName_1;
	private JTextField txtEmpName;
	private JLabel lblDesig;
	private JLabel label_11;
	private JTextField txtEmpContactNum;
	private JLabel lblDepartment_1;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JTextField txtEmpBasicSalary;
	private JLabel label_16;
	private JLabel lblEmpImage;
	private JLabel label_18;
	private JLabel label_19;
	private JTextField txtEmpIncentive;
	private JLabel label_20;
	private JButton btnEmpChangeImage;
	private JLabel label_21;
	private JTextField txtEmpHouseNum;
	private JLabel label_22;
	private JTextField txtEmpStreet;
	private JLabel label_23;
	private JTextField txtEmpDistrict;
	private JLabel label_24;
	private JButton btnUpdateInformation;
	private JLabel label_25;
	private JTextField txtEmpPinCode;
	private JTextField txtEmpDesig;
	private JTextField txtEmpState;
	private JLabel lblChooseEmployeeId;
	private JComboBox cmdEmpIDSelect;
	private JButton btnFind;
	private JLabel lblChooseEmployeeId_1;
	private JComboBox cmbViewEmployee;
	private JButton btnViewFind;
	private JSeparator separator_3;
	private JLabel lblViewImage;
	private JLabel lblViewEmployeeID;
	private JLabel lblViewEmployeeName;
	private JLabel lblViewEmployeeDesignation;
	private JLabel lblViewEmployeeDepartment;
	private JLabel lblViewEmployeeAddress;
	private JSeparator separator_4;
	private JLabel lblBasicDetails;
	private JLabel lblSalaryDetails;
	private JLabel lblBasicSalary_1;
	private JLabel lblIncentives;
	private JLabel lblTotalSalary;
	private JLabel lblNewLabel_2;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel lblViewBasicSalary;
	private JLabel lblViewIncentiveAmount;
	private JLabel lblViewTotalAmount;
	private JPasswordField txtEmpOldPasswrod;
	private JPasswordField txtEmpNewPassword;
	private JPasswordField txtEmpConfirmPassword;
	private JLabel lblLeaveDuration;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JDateChooser dtcFrom;
	private JRadioButton rdbtnSingleDay;
	private JRadioButton rdbtnMultipleDays;
	private JDateChooser dtcTO;
	private JButton btnEmpPasswordChange;
	private JComboBox cmbLeaveType;
	private JTextArea txtAreaReason;
	private JButton btnApply;
	private JMonthChooser mtcSalary;
	private JYearChooser yrcSalary;
	private JButton btnCheck;
	private JLabel lblBasicSalary_2;
	private JLabel lblIncentives_1;
	private JLabel lblTotalSalary_1;
	private JTextField txtShowBasicSalary;
	private JTextField txtShowIncentive;
	private JTextField txtShowTotalSalary;
	private JLabel lblMonthAndYear_1;
	private JTextField txtAttPresent;
	private JTextField txtAttNumWorkingDays;
	private JTextField txtAttPercentage;
	private JButton btnNewAdminChoosePic;
	private JButton btnNewAdminReset;
	private JButton btnNewAdminAddAdmin;
	private JButton btnAttendanceCheck;
	private JMonthChooser mtcAttendence;
	private static Connection con;
	private JTextField txtAddEmpUsername;
	private Admin admin;
	private Employee emp;
	private JComboBox cmbDesignation_1;
	private JComboBox cmbDepartment_1;
	private JComboBox cmbState_1;
	private String ImageFilePath = "";
	private JComboBox cmbEmployees;
	private JLabel lblViewEmployeeContact;
	private JComboBox cmbEmpDepartment;
	private JButton btnDeleteEmp;
	private JLabel lblNewAdminViewPic;
	private Admin newadmin = null;
	private JTextField txtAdminName;
	private JButton btnLeaveRequests;
	private JPanel LeaveRequests;
	private JTable tblLeaveInformationTable;
	private JButton btnAccept;
	private JButton btnReject;
	private JButton btnSalaryPortal;
	private JPanel SalaryWindow;
	private JLabel lblChooseEmployee_1;
	private JComboBox cmbSalSelectEmp;
	private JButton btnSelectEmployee;
	private JLabel lblBasicSalary_3;
	private JTextField txtSalBasicSalary;
	private JTextField txtSalIncentive;
	private JMonthChooser mtcSalMonth;
	private JYearChooser ychSalYear;
	private JButton btnGiveSalary;
	private static Attendence dialog = null;
	private boolean Attendanceflag = true; 
	private static SerialPort[] ports;
	private static SerialPort port;
	public static int scan_id = 1;
	private JButton btnEnterFingerprint;
	private boolean Addresult = false;
	private static boolean addfinger = false;
	private static boolean success = false;
	private JButton btnOldLeaves;
	private JPanel oldLeaves;
	private JTable tblOldLeaves;
	private JTextField txtCurMonthAttendance;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			Class.forName("com.mysql.jdbc.Driver");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dialog = new Attendence();
					
					MainWindow window = new MainWindow();
					window.frmEmployeeManagementSystem.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initComponents();
		createEvents();
	}
	
	// Reset Functions
	public void resetAddEmployeeForm() {
		txtFname.setText("");
		txtLname.setText("");
		cmbDesignation_1.setSelectedIndex(0);
		cmbDepartment_1.setSelectedIndex(0);
		txtBasicSalary.setText("");
		txtIncentive.setText("");
		txtHnum.setText("");
		txtStreet.setText("");
		txtDistrict.setText("");
		cmbState_1.setSelectedIndex(0);
		txtPincode.setText("");
		txtContactNumber.setText("");
		lblEmpProfilePic.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/employee.png")));
		txtAddEmpUsername.setText("");
		ImageFilePath = "";
	}
	public void resetUpdateEmployee() {
		txtEmpID.setText("");
		txtEmpName.setText("");
		txtEmpContactNum.setText("");
		txtEmpBasicSalary.setText("");
		lblEmpImage.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/employee.png")));
		txtEmpIncentive.setText("");
		txtEmpHouseNum.setText("");
		txtEmpStreet.setText("");
		txtEmpDistrict.setText("");
		txtEmpPinCode.setText("");
		txtEmpDesig.setText("");
		cmbEmpDepartment.setSelectedIndex(0);
		txtEmpState	.setText("");
	}
		
	private void createEvents() {
		
		// Main Screen buttons
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost/emssystem?user=root&password=root");
					con.setAutoCommit(false);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				MainScreen.setVisible(false);
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				if(cmbAccountType.getSelectedItem().toString().equals("Admin")) {	
					admin = new Admin(username, password, con);
					try {
						if(admin.validateCredentials()) {
							txtUsername.setText("");
							txtPassword.setText("");
							lblName.setText(admin.getFullName());
							lblAdminImage.setIcon(new ImageIcon(admin.getPic()));
							MainAdmin.setVisible(true);
						}
						else {
							txtPassword.setText("");
							JOptionPane.showMessageDialog(null, "Username or Password incorrect!");
						}
					} catch (HeadlessException | SQLException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else {					
					emp = new Employee(username, password, con);
					try {
						try {
							if(emp.validateCredentials()) {
								txtUsername.setText("");
								txtPassword.setText("");
								emp.getDetails();
								lblEmployeeName.setText(emp.getFullName());
								lblEmployeeImage.setIcon(new ImageIcon(emp.getPic()));
								String temp = emp.checkLeaveRequests();
								MainEmployee.setVisible(true);
								if(!temp.equals(""))
									JOptionPane.showMessageDialog(null, temp);
							}
							else {
								txtPassword.setText("");
								JOptionPane.showMessageDialog(null, "Username or Password incorrect!");
							}
						} catch (HeadlessException | SQLException e1) {
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnEmployeeAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(Attendanceflag) {						
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);

					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost/emssystem?user=root&password=root");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					String[] model = null;
					PreparedStatement ps;
					ResultSet rs;
					int i = 1;
					int total = 0;
					try {
						ps = con.prepareStatement("SELECT COUNT(*) FROM emp_details");
						rs = ps.executeQuery();
						while(rs.next())
							total = rs.getInt(1);
						ps.close();
						model = new String[total + 1];
						model[0] = "<SELECT>";
						ps = con.prepareStatement("SELECT emp_id, emp_fname, emp_lname FROM emp_details");
						rs = ps.executeQuery();
						while(rs.next()) {
							String val = rs.getInt(1) + "-" + rs.getString(2) + " " + rs.getString(3); 
							model[i] = val;
							i++;
						}
						ps.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					DefaultComboBoxModel x = (DefaultComboBoxModel) dialog.comboBox.getModel();
			        // removing old data
			        x.removeAllElements();
			        
			        if(model != null) {
			        	for(String val : model)
			        		x.addElement(val);
			        }
			        
			        dialog.comboBox.setModel(x);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Attendance is Closed for the Day!");
				}
			}
		});
		
		dialog.btnPunchIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean flag = true;
				String selected = dialog.comboBox.getSelectedItem().toString();
				if(selected.equals("<SELECT>"))
					flag = false;
				if(flag) {
					
					String[] temp = selected.split("-");
					int emp_id = Integer.parseInt(temp[0]);
					scan_id = emp_id;
					System.out.println(scan_id);
					String name = temp[1];
					SerialTest main = new SerialTest();
					main.params(2, 0, true);
					main.initialize();
					Thread t=new Thread() {
						public void run() {
							//the following line will keep this app alive for 1000 seconds,
							//waiting for events to occur and responding to them (printing incoming messages to console).
							try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
						}
					};
					t.start();
					JOptionPane.showMessageDialog(null, "Employee selected : " + temp[0]);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Selection!");
				}
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUsername.setText("");
				txtPassword.setText("");
			}
		});
		
		// Admin Screen show and approve leave requests
		
		btnLeaveRequests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[][] obj = null;
				DefaultTableModel m = new DefaultTableModel(new String[] {"Leave id", "Employee id", "Employee name", "From date", "To date", "Reason", "Leave Type", "Status"}, 0);
				
				tblLeaveInformationTable.setModel(m);
				try {
					obj = admin.getLeaveInfor();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
				for(Object[] a : obj)
					m.addRow(a);

				tblLeaveInformationTable.setModel(m);
				MainEmpty.setVisible(false);
				SalaryWindow.setVisible(false);
				DetailsEmployee.setVisible(false);
				UpdateEmployee.setVisible(false);
				DeleteEmployee.setVisible(false);
				AdminSettings.setVisible(false);
				AddEmployee.setVisible(false);
				LeaveRequests.setVisible(true);
			}
		});
		

		btnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int leave_id = 0;
				int column = tblLeaveInformationTable.getSelectedRow();
				if(column == -1) {
					JOptionPane.showMessageDialog(null, "No request Selected");
				}
				else {
					String value = tblLeaveInformationTable.getModel().getValueAt(column, leave_id).toString();
					int val = Integer.parseInt(value);
					try {
						if(admin.rejectRequest(val)) {
							JOptionPane.showMessageDialog(null, "leave id : " + value + " Request Rejected!");
							DefaultTableModel m = new DefaultTableModel(new String[] {"Leave id", "Employee id", "Employee name", "From date", "To date", "Reason", "Leave Type", "Status"}, 0);

							Object[][] obj = null;
							tblLeaveInformationTable.setModel(m);
							try {
								obj = admin.getLeaveInfor();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}	
							for(Object[] a : obj)
								m.addRow(a);

							tblLeaveInformationTable.setModel(m);
						}
						else {
							JOptionPane.showMessageDialog(null, "Action cannot b performed");
						}
						
					} catch (HeadlessException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		

		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int leave_id = 0;
				int column = tblLeaveInformationTable.getSelectedRow();
				if(column == -1) {
					JOptionPane.showMessageDialog(null, "No request Selected");
				}
				else {
					String value = tblLeaveInformationTable.getModel().getValueAt(column, leave_id).toString();
					int val = Integer.parseInt(value);
					try {
						if(admin.acceptRequest(val)) {
							JOptionPane.showMessageDialog(null, "leave id : " + value + " Request Accepted!");
							DefaultTableModel m = new DefaultTableModel(new String[] {"Leave id", "Employee id", "Employee name", "From date", "To date", "Reason", "Leave Type", "Status"}, 0);

							Object[][] obj = null;
							tblLeaveInformationTable.setModel(m);
							try {
								obj = admin.getLeaveInfor();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}	
							for(Object[] a : obj)
								m.addRow(a);

							tblLeaveInformationTable.setModel(m);
						}
						else {
							JOptionPane.showMessageDialog(null, "Action cannot b performed");
						}
						
					} catch (HeadlessException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		// Admin Screen Add new Employee options 
		
		btnAddnewemployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeaveRequests.setVisible(false);
				MainEmpty.setVisible(false);
				SalaryWindow.setVisible(false);
				DetailsEmployee.setVisible(false);
				UpdateEmployee.setVisible(false);
				DeleteEmployee.setVisible(false);
				AdminSettings.setVisible(false);
				AddEmployee.setVisible(true);
			}
		});
		

		btnEnterFingerprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Addresult) {
					addfinger = true;
					SerialTest main = new SerialTest();
					main.params(1, Integer.parseInt(emp.getid()), false);
					main.initialize();
					Thread t=new Thread() {
						public void run() {
							//the following line will keep this app alive for 1000 seconds,
							//waiting for events to occur and responding to them (printing incoming messages to console).
							try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
						}
					};
					t.start();
				}
				else {
					JOptionPane.showMessageDialog(null, "Add employee first!");
				}
			}
		});
		
		// Admin Screen Add employee

		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Select Image");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					ImageFilePath = chooser.getSelectedFile().getAbsolutePath();
					lblEmpProfilePic.setIcon(new ImageIcon(ImageFilePath));
				}
			}
		});
				
				
		btnAddEReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetAddEmployeeForm();
			}
		});
		

		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean flag = true;
				String fname = txtFname.getText();
				String lname = txtLname.getText();
				String desig = cmbDesignation_1.getSelectedItem().toString();
				String dept = cmbDepartment_1.getSelectedItem().toString();
				float salary = 0.0f;
				float incentive = 0.0f;
				try {
					salary = Float.parseFloat(txtBasicSalary.getText());
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Salary Details Incorrect");
					flag = false;
				}
				try {
					incentive = Float.parseFloat(txtIncentive.getText());
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Incentive Details Incorrect");
					flag = false;
				}
				String hnum = txtHnum.getText();
				String street = txtStreet.getText();
				String distrct = txtDistrict.getText();
				String state = cmbState_1.getSelectedItem().toString();
				String pincode = txtPincode.getText();
				String num = txtContactNumber.getText();
				File f;
				if(ImageFilePath.equals(""))
					f = new File("src//common//employee.png");
				else
					f = new File(ImageFilePath);
				ImageFilePath = "";
				String username = txtAddEmpUsername.getText();
				Pattern p = Pattern.compile("[0-9]+");
				Matcher m = p.matcher(num);
				if(!m.matches() && num.length() != 10) {
					JOptionPane.showMessageDialog(null, "Invalid Contact number!");
					flag = false;
				}
				if(fname.equals("") || username.equals("") || dept.equals("") || salary == 0.0 || hnum.equals("") || street.equals("") || distrct.equals("")) {
					JOptionPane.showMessageDialog(null, "Insufficient Details");
					flag = false;
				}
				if(salary < 0.0 || salary > 1000000.0 || incentive < 0.0 || incentive > 50000.0) {
					JOptionPane.showMessageDialog(null, "Salary or Incentive details out of range!");
					flag = false;
				}
				if(flag) {
					emp = new Employee();
					emp.setFirstname(fname);
					emp.setLastname(lname);
					emp.setAccountType("Employee");
					emp.setBasic_salary(salary);
					emp.setConnector(con);
					emp.setContact_num(num);
					emp.setDepartment(dept);
					emp.setDesignation(desig);
					emp.setDistrict(distrct);
					emp.setHousenum(hnum);
					emp.setIncentive(incentive);
					emp.setPass(username);
					emp.setUsername(username);
					emp.setPincode(pincode);
					emp.setState(state);
					emp.setStreet(street);
					Addresult = false;
					try {
						emp.setPic(f);
						Addresult = emp.enterDetails();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if(Addresult) {
						JOptionPane.showMessageDialog(null, "Employee successfully added!");

						resetAddEmployeeForm();
					}
					else {
						JOptionPane.showMessageDialog(null, "Employee cannot be added!");
						Addresult = false;
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Employee cannot be added!");
				}
			}
		});
		
		//Admin Screen Details of employee
		
		btnDetailsOfEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] model = null;
				try {
					model = admin.getAllEmployees();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DefaultComboBoxModel x = (DefaultComboBoxModel) cmbViewEmployee.getModel();
		        // removing old data
		        x.removeAllElements();
		        
		        if(model != null) {
		        	for(String val : model)
		        		x.addElement(val);
		        }
		        
		        cmbViewEmployee.setModel(x);

				LeaveRequests.setVisible(false);
				SalaryWindow.setVisible(false);
				MainEmpty.setVisible(false);
				AddEmployee.setVisible(false);
				UpdateEmployee.setVisible(false);
				DeleteEmployee.setVisible(false);
				AdminSettings.setVisible(false);
				DetailsEmployee.setVisible(true);
			}
		});
		
		// Admin Screen select details to show
		
		btnViewFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean flag = true;
				byte[] img = null;
				String selected = cmbViewEmployee.getSelectedItem().toString();
				if(selected.equals("<SELECT>"))
					flag = false;
				if(flag) {
					String[] temp = selected.split("-");
					int emp_id = Integer.parseInt(temp[0]);
					emp = new Employee(emp_id, con);
					try {
						emp.getDetails();
						img = emp.getImage();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					lblViewEmployeeID.setText(emp_id + "");
					
					if(img != null)
						lblViewImage.setIcon(new ImageIcon(img));
					
					lblViewEmployeeName.setText(emp.getFullName());
					lblViewEmployeeDesignation.setText(emp.getDesignation());
					lblViewEmployeeDepartment.setText(emp.getDepartment());
					lblViewEmployeeAddress.setText(emp.getAddress());
					lblViewEmployeeContact.setText(emp.getContact_num());
					lblViewBasicSalary.setText(emp.getBasic_salary() + "");
					lblViewIncentiveAmount.setText(emp.getIncentive() + "");
					lblViewTotalAmount.setText(emp.getBasic_salary() + emp.getIncentive() + "");
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid selection!");
				}
			}
		});
		
		// Admin Screen Salary giving

		btnSalaryPortal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] model = null;
				try {
					model = admin.getAllEmployees();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DefaultComboBoxModel x = (DefaultComboBoxModel) cmbSalSelectEmp.getModel();
		        // removing old data
		        x.removeAllElements();
		        
		        if(model != null) {
		        	for(String val : model)
		        		x.addElement(val);
		        }
		        
		        cmbSalSelectEmp.setModel(x);
				
				MainEmpty.setVisible(false);
				LeaveRequests.setVisible(false);
				AddEmployee.setVisible(false);
				DetailsEmployee.setVisible(false);
				UpdateEmployee.setVisible(false);
				DeleteEmployee.setVisible(false);
				AdminSettings.setVisible(false);
				SalaryWindow.setVisible(true);
			}
		});
		

		btnSelectEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				Calendar c = Calendar.getInstance();
			    int year = c.get(Calendar.YEAR);
			    int month = mtcSalMonth.getMonth();;
			    int day = 1;
			    c.set(year, month, day);
			    int numOfDaysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			    Date start = c.getTime();
			    c.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth-1);
			    Date end = c.getTime();
			    

		        Calendar cal = Calendar.getInstance();
		        cal.setTime(start);
		        Calendar cal1 = Calendar.getInstance();
				cal1.setTime(end);
		        int workingDays = 0;
		        do {
		             cal.add(Calendar.DAY_OF_MONTH, 1);
		             if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
		                 workingDays++;;
		             }
		         } while (cal.getTimeInMillis() < cal1.getTimeInMillis());
				String selected = cmbSalSelectEmp.getSelectedItem().toString();
				if(selected.equals("<SELECT>"))
					flag = false;
				if(flag) {
					String[] temp = selected.split("-");
					int emp_id = Integer.parseInt(temp[0]);
					emp = new Employee(emp_id, con);
					try {
						emp.getDetails();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					try {
						txtCurMonthAttendance.setText(workingDays - emp.getAttendence(mtcSalMonth.getMonth()) + "");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					txtSalBasicSalary.setText(emp.getBasic_salary() + "");
					txtSalIncentive.setText(emp.getIncentive() + "");
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Selection!");
				}
			}
		});
		

		btnGiveSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selected = cmbSalSelectEmp.getSelectedItem().toString();
				String[] temp = selected.split("-");
				int emp_id = Integer.parseInt(temp[0]);
				String basicsalary = txtSalBasicSalary.getText();
				String incentive = txtSalIncentive.getText();
				int month = mtcSalMonth.getMonth();
				int year = ychSalYear.getYear();
				boolean flag = true;
				float salary = 0.0f;
				float incent = 0.0f;
				try {
					salary = Float.parseFloat(txtSalBasicSalary.getText());
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Salary Details Incorrect");
					flag = false;
				}
				try {
					incent = Float.parseFloat(txtSalIncentive.getText());
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Incentive Details Incorrect");
					flag = false;
				}
				if(salary < 0.0 || salary > 1000000.0 || incent < 0.0 || incent > 50000.0) {
					JOptionPane.showMessageDialog(null, "Salary or Incentive details out of range!");
					flag = false;
				}
				if(flag) {
					try {
						if(admin.giveSalary(emp_id, month, year, salary, incent)) {
							JOptionPane.showMessageDialog(null, "Salary details added!");
						}
						else {
							JOptionPane.showMessageDialog(null, "Salary details cannot be added!");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Salary details cannot be added!");
				}
			}
		});
		
		// Update Employee Information
		
		btnUpdateEmployeeInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] model = null;
				try {
					model = admin.getAllEmployees();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DefaultComboBoxModel x = (DefaultComboBoxModel) cmdEmpIDSelect.getModel();
		        // removing old data
		        x.removeAllElements();
		        
		        if(model != null) {
		        	for(String val : model)
		        		x.addElement(val);
		        }
		        
		        cmdEmpIDSelect.setModel(x);

				LeaveRequests.setVisible(false);
				SalaryWindow.setVisible(false);
		        MainEmpty.setVisible(false);
				AddEmployee.setVisible(false);
				DetailsEmployee.setVisible(false);
				DeleteEmployee.setVisible(false);
				AdminSettings.setVisible(false);
				UpdateEmployee.setVisible(true);
			}
		});
		

		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				byte[] img = null;
				String selected = cmdEmpIDSelect.getSelectedItem().toString();
				if(selected.equals("<SELECT>"))
					flag = false;
				if(flag) {
					String[] temp = selected.split("-");
					int emp_id = Integer.parseInt(temp[0]);
					emp = new Employee(emp_id, con);
					try {
						emp.getDetails();
						img = emp.getImage();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
	
					txtEmpID.setText(emp_id + "");
					txtEmpName.setText(emp.getFullName());
					txtEmpContactNum.setText(emp.getContact_num());
					txtEmpBasicSalary.setText(emp.getBasic_salary() + "");
					if(img != null)
						lblEmpImage.setIcon(new ImageIcon(img));
					txtEmpIncentive.setText(emp.getIncentive() + "");
					txtEmpHouseNum.setText(emp.getHousenum());
					txtEmpStreet.setText(emp.getStreet());
					txtEmpDistrict.setText(emp.getDistrict());
					txtEmpPinCode.setText(emp.getPincode());
					txtEmpDesig.setText(emp.getDesignation());
					cmbEmpDepartment.setSelectedIndex(emp.getDeptID() - 1);
					txtEmpState	.setText(emp.getState());
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalied Selection!");
				}
			}
		});
		
		// Admin Screen Update Employee choose new pic

		btnEmpChangeImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Select Image");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					ImageFilePath = chooser.getSelectedFile().getAbsolutePath();
					lblEmpImage.setIcon(new ImageIcon(ImageFilePath));
				}
			}
		});
		
		btnUpdateInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				String desig = txtEmpDesig.getText();
				String dept = cmbEmpDepartment.getSelectedItem().toString();
				float salary = 0.0f;
				float incentive = 0.0f;
				try {
					salary = Float.parseFloat(txtEmpBasicSalary.getText());
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Salary Details Incorrect");
					flag = false;
				}
				try {
					incentive = Float.parseFloat(txtEmpIncentive.getText());
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Incentive Details Incorrect");
					flag = false;
				}
				String hnum = txtEmpHouseNum.getText();
				String street = txtEmpStreet.getText();
				String distrct = txtEmpDistrict.getText();
				String state = txtEmpState.getText();
				String pincode = txtEmpPinCode.getText();
				String num = txtEmpContactNum.getText();
				File f;
				if(ImageFilePath.equals(""))
					f = new File("src//common//employee.png");
				else
					f = new File(ImageFilePath);
				ImageFilePath = "";
				String username = txtAddEmpUsername.getText();
				Pattern p = Pattern.compile("[0-9]+");
				Matcher m = p.matcher(num);
				if(!m.matches() && num.length() != 10) {
					JOptionPane.showMessageDialog(null, "Invalid Contact number!");
					flag = false;
				}
				if(dept.equals("") || salary == 0.0 || hnum.equals("") || street.equals("") || distrct.equals("")) {
					JOptionPane.showMessageDialog(null, "Insufficient Details");
					flag = false;
				}
				if(salary < 0.0 || salary > 1000000.0 || incentive < 0.0 || incentive > 50000.0) {
					JOptionPane.showMessageDialog(null, "Salary or Incentive details out of range!");
					flag = false;
				}
				
				if(flag) {
					emp.setAccountType("Employee");
					emp.setBasic_salary(salary);
					emp.setConnector(con);
					emp.setContact_num(num);
					emp.setDepartment(dept);
					emp.setDesignation(desig);
					emp.setDistrict(distrct);
					emp.setHousenum(hnum);
					emp.setIncentive(incentive);
					emp.setPass(username);
					emp.setUsername(username);
					emp.setPincode(pincode);
					emp.setState(state);
					emp.setStreet(street);
					boolean result = false;
					try {
						emp.setPic(f);
						result = emp.updateDetails();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if(result) {
						JOptionPane.showMessageDialog(null, "Employee information successfully updated!");

						resetUpdateEmployee();
					}
					else {
						JOptionPane.showMessageDialog(null, "Employee information cannot be updated!");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Employee information cannot be updated!");
				}
			}
		});
		
		// Delete Employee Information
		
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] model = null;
				try {
					model = admin.getAllEmployees();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DefaultComboBoxModel x = (DefaultComboBoxModel) cmbEmployees.getModel();
		        // removing old data
		        x.removeAllElements();
		        
		        if(model != null) {
		        	for(String val : model)
		        		x.addElement(val);
		        }

				LeaveRequests.setVisible(false);
		        cmbEmployees.setModel(x);
				SalaryWindow.setVisible(false);
				MainEmpty.setVisible(false);
				AddEmployee.setVisible(false);
				DetailsEmployee.setVisible(false);
				UpdateEmployee.setVisible(false);
				AdminSettings.setVisible(false);
				DeleteEmployee.setVisible(true);
			}
		});
		
		// Delete Employee Confirm

		btnDeleteEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = true;
				String selected = cmbEmployees.getSelectedItem().toString();
				if(selected.equals("<SELECT>"))
					flag = false;
				if(flag) {
					String[] temp = selected.split("-");
					int emp_id = Integer.parseInt(temp[0]);
					int input = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + selected + " ?");
					if(input == 0) {
						emp = new Employee(emp_id, con);
						try {
							if(emp.deleteEmployee()) {
								JOptionPane.showMessageDialog(null, "Employee Details deleted!");
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Selection!");
				}
			}
		});
		
		// Admin Settings
		
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainEmpty.setVisible(false);
				LeaveRequests.setVisible(false);
				AddEmployee.setVisible(false);
				DetailsEmployee.setVisible(false);
				UpdateEmployee.setVisible(false);
				DeleteEmployee.setVisible(false);
				SalaryWindow.setVisible(false);
				AdminSettings.setVisible(true);
			}
		});
		
		// Admin Screen add new Admin
		btnCreateNewAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmptyPanel.setVisible(false);
				ChangePassword.setVisible(false);
				NewAdmin.setVisible(true);
			}
		});
		
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmptyPanel.setVisible(false);
				NewAdmin.setVisible(false);
				ChangePassword.setVisible(true);
			}
		});
		
		// Admin Settings Add new Admin
		
		btnNewAdminChoosePic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Select Image");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					ImageFilePath = chooser.getSelectedFile().getAbsolutePath();
					lblNewAdminViewPic.setIcon(new ImageIcon(ImageFilePath));
				}
			}
		});
		
		btnNewAdminReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtAdminName.setText("");
				txtNewAdminUsername.setText("");
				txtNewAdminPassword.setText("");
				txtNewAdminConfirmPassword.setText("");
				lblNewAdminViewPic.setIcon(null);
			}
		});
		
		btnNewAdminAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txtAdminName.getText();
				String adUsername = txtNewAdminUsername.getText();
				String adPassword = txtNewAdminPassword.getText();
				String adConfirmPassword = txtNewAdminConfirmPassword.getText();
				//lblNewAdminViewPic
				if(adPassword.equals(adConfirmPassword) && !adUsername.equals("") && !adPassword.equals("") || !name.equals("")) {
					newadmin = new Admin(adUsername, adPassword, con);
					File f;
					if(ImageFilePath.equals(""))
						f = new File("src//common//employee.png");
					else
						f = new File(ImageFilePath);
					ImageFilePath = "";
					try {
						newadmin.setPic(f);
						newadmin.setFirstname(name);
						
						if(newadmin.createNewAdmin()) {
							JOptionPane.showMessageDialog(null, "Admin Added successfully!");
							txtNewAdminUsername.setText("");
							txtNewAdminPassword.setText("");
							txtNewAdminConfirmPassword.setText("");
							lblNewAdminViewPic.setIcon(null);
						}
						else {
							JOptionPane.showMessageDialog(null, "Admin cannot be added!");	
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Details");
				}
				
			}
		});
				
		// Admin Settings Change Password
		
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String oldpass = txtOldPassword.getText();
				String newpass = txtNewPassword.getText();
				String connewpass = txtConfirmPassword.getText();
				
				if(oldpass.equals("") || newpass.equals("") || connewpass.equals("") || !newpass.equals(connewpass)) {
					JOptionPane.showMessageDialog(null, "Invalid information. Cannot update Password!");
				}
				else {
					boolean x = false;
					try {
						x = admin.updatePassword(oldpass, newpass);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					if(x)
						JOptionPane.showMessageDialog(null, "Password Update successfull!");
					else
						JOptionPane.showMessageDialog(null, "Password update unsuccessfull!");
				}
				
			}
		});
		
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin = null;
				emp = null;
				AddEmployee.setVisible(false);
				DetailsEmployee.setVisible(false);
				UpdateEmployee.setVisible(false);
				DeleteEmployee.setVisible(false);
				AdminSettings.setVisible(false);
				
				MainAdmin.setVisible(false);
				MainEmpty.setVisible(true);
				MainScreen.setVisible(true);
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// Employee Screen	

		btnLogOutE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainEmployee.setVisible(false);
				SalaryStatement.setVisible(false);
				LeaveRequest.setVisible(false);
				EmployeeSettings.setVisible(false);
				AttendanceDetails.setVisible(false);
				oldLeaves.setVisible(false);
				MainEEmpty.setVisible(true);
				MainScreen.setVisible(true);
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// Attedence of Employee
		
		btnAttendanceDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainEEmpty.setVisible(false);
				SalaryStatement.setVisible(false);
				LeaveRequest.setVisible(false);
				EmployeeSettings.setVisible(false);
				oldLeaves.setVisible(false);
				AttendanceDetails.setVisible(true);
			}
		});
		

		btnAttendanceCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date start;
			    Date end;

				Calendar c = Calendar.getInstance();
			    int year = c.get(Calendar.YEAR);
			    int month = mtcAttendence.getMonth();;
			    int day = 1;
			    c.set(year, month, day);
			    int numOfDaysInMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			    start = c.getTime();
			    c.add(Calendar.DAY_OF_MONTH, numOfDaysInMonth-1);
			    end = c.getTime();
			    

		        Calendar cal = Calendar.getInstance();
		        cal.setTime(start);
		        Calendar cal1 = Calendar.getInstance();
				cal1.setTime(end);
		        int workingDays = 0;
		        do {
		             cal.add(Calendar.DAY_OF_MONTH, 1);
		             if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
		                 workingDays++;;
		             }
		         } while (cal.getTimeInMillis() < cal1.getTimeInMillis());
		        
		        try {
					int num = emp.getAttendence(month);
					if(num == -1) {
						JOptionPane.showMessageDialog(null, "No attendance details for selected month");
					}
					else {
						txtAttNumWorkingDays.setText(workingDays + "");
						txtAttPresent.setText(workingDays - num + "");
						float temp = (workingDays - num) / (float) workingDays * 100;
						txtAttPercentage.setText(temp + "");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// txtAttPresent
			}
		});
		

		btnOldLeaves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO fill old leaves table
				MainEEmpty.setVisible(false);
				AttendanceDetails.setVisible(false);
				SalaryStatement.setVisible(false);
				EmployeeSettings.setVisible(false);
				LeaveRequest.setVisible(false);
				oldLeaves.setVisible(true);
			}
		});
		
		// Salary Statement
		
		btnSalaryStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainEEmpty.setVisible(false);
				AttendanceDetails.setVisible(false);
				LeaveRequest.setVisible(false);
				EmployeeSettings.setVisible(false);
				oldLeaves.setVisible(false);
				SalaryStatement.setVisible(true);
			}
		});
		

		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int month = mtcSalary.getMonth();
				int year = yrcSalary.getYear();
				txtShowBasicSalary.setText("");
				txtShowIncentive.setText("");
				txtShowTotalSalary.setText("");
				try {
					String[] x = emp.getSalaryDetails(month, year);
					if(x == null) {
						JOptionPane.showMessageDialog(null, "No salary information available for choosen month and year!");
					}
					else {
						txtShowBasicSalary.setText(x[0]);
						txtShowIncentive.setText(x[1]);
						txtShowTotalSalary.setText(Float.parseFloat(x[0]) + Float.parseFloat(x[1]) + "");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		// Leave Request
		
		btnLeaveRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[][] obj = null;
				DefaultTableModel m = new DefaultTableModel(new String[] {"Leave id", "From date", "To date", "Reason", "Leave Type", "Status"}, 0);
				
				tblOldLeaves.setModel(m);
				
				try {
					obj = emp.getLeaveInfor();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				if(obj != null) {
					for(Object[] a : obj)
						m.addRow(a);
					
	
					tblOldLeaves.setModel(m);
					MainEEmpty.setVisible(false);
					AttendanceDetails.setVisible(false);
					SalaryStatement.setVisible(false);
					EmployeeSettings.setVisible(false);
					oldLeaves.setVisible(false);
					LeaveRequest.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "No old records found!");
				}
			}
		});
		

		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean single = rdbtnSingleDay.isSelected();
				boolean multiple = rdbtnMultipleDays.isSelected();
				Date d1 = dtcFrom.getDate();
				Date d2 = dtcTO.getDate();
				String type = cmbLeaveType.getSelectedItem().toString();
				String reason = txtAreaReason.getText();
				int x = (int) ChronoUnit.DAYS.between(d1.toInstant(),d2.toInstant());
				if((!single && !multiple) || d1 == null || d2 == null || reason.equals("") || x < 0) {
					JOptionPane.showMessageDialog(null, "Incorrect or Invalid information to apply leave!");
				}
				else {
					if(single) {
						if(x > 1)
							JOptionPane.showMessageDialog(null, "Incorrect Leave Duration");
						else {
							try {
								if(emp.applyLeave(x, d1, d2, reason, type)) {
									JOptionPane.showMessageDialog(null, "Leave request Sent!");
								}
								else {
									JOptionPane.showMessageDialog(null, "Leave request cannot be Sent!");
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
					else {
						try {
							if(emp.applyLeave(x, d1, d2, reason, type)) {
								JOptionPane.showMessageDialog(null, "Leave request Sent!");
							}
							else {
								JOptionPane.showMessageDialog(null, "Leave request cannot be Sent!");
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
				
				
			}
		});
		
		// Settings change password

		btnSettingsE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainEEmpty.setVisible(false);
				AttendanceDetails.setVisible(false);
				SalaryStatement.setVisible(false);
				LeaveRequest.setVisible(false);
				oldLeaves.setVisible(false);
				EmployeeSettings.setVisible(true);
			}
		});
		

		btnEmpPasswordChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldpass = txtEmpOldPasswrod.getText();
				String newpass = txtEmpNewPassword.getText();
				String confirmpass = txtEmpConfirmPassword.getText();
				
				if(oldpass.equals("") || newpass.equals("") || confirmpass.equals("") || !newpass.equals(confirmpass)) {
					JOptionPane.showMessageDialog(null, "Invalid information. Cannot update Password!");
				}
				else {
					boolean x = false;
					try {
						x = emp.updatePassword(oldpass, newpass);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if(x)
						JOptionPane.showMessageDialog(null, "Password Update successfull!");
					else
						JOptionPane.showMessageDialog(null, "Password update unsuccessfull!");
				}
			}
		});
	}

	private void initComponents() {
		Thread t1 = new Thread(new CheckTime());
        t1.start();
		frmEmployeeManagementSystem = new JFrame();
		frmEmployeeManagementSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/resources/ems main.png")));
		frmEmployeeManagementSystem.setTitle("Employee Management System");
		frmEmployeeManagementSystem.setBounds(100, 100, 1491, 943);
		frmEmployeeManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeeManagementSystem.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		MainScreen = new JPanel();
		MainScreen.setBackground(new Color(0, 191, 255));
		frmEmployeeManagementSystem.getContentPane().add(MainScreen, "name_2225097533752");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 191, 255));
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/FPage.png")));
		GroupLayout gl_MainScreen = new GroupLayout(MainScreen);
		gl_MainScreen.setHorizontalGroup(
			gl_MainScreen.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_MainScreen.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 784, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		gl_MainScreen.setVerticalGroup(
			gl_MainScreen.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_MainScreen.createSequentialGroup()
					.addGap(89)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 701, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(94, Short.MAX_VALUE))
		);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setAlignmentY(Component.TOP_ALIGNMENT);
		
		String n = "Hello";
		n = LocalTime.now().toString();
		String[] val = n.split(":");
		if(Integer.parseInt(val[0]) < 12)
			n = "Hello, Good Morning!";
		else if(Integer.parseInt(val[0]) >= 12 && Integer.parseInt(val[0]) <= 16)
			n = "Hello, Good Afternoon!";
		else
			n = "Hello, Good Evening!";
		
		lblGreeting = new JLabel(n);
		lblGreeting.setForeground(new Color(0, 0, 0));
		lblGreeting.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblGreeting.setText(n);
		
		lblPleaseLogin = new JLabel("Please Login");
		lblPleaseLogin.setForeground(new Color(0, 0, 0));
		lblPleaseLogin.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		lblUsername = new JLabel("Username :");
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblAccountType = new JLabel("Account Type :");
		lblAccountType.setForeground(new Color(0, 0, 0));
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		cmbAccountType = new JComboBox();
		cmbAccountType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cmbAccountType.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Employee"}));
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblonlyForEmployees = new JLabel("( Only for Employees )");
		lblonlyForEmployees.setForeground(new Color(0, 0, 0));
		lblonlyForEmployees.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		btnEmployeeAttendance = new JButton("Employee Attendance");
		btnEmployeeAttendance.setBackground(UIManager.getColor("Button.background"));
		btnEmployeeAttendance.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnReset = new JButton("Reset");
		
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(70)
							.addComponent(btnReset)
							.addGap(86)
							.addComponent(btnLogin))
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPleaseLogin)
								.addComponent(lblGreeting)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(87)
							.addComponent(btnEmployeeAttendance))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAccountType)
								.addComponent(lblPassword)
								.addComponent(lblUsername))
							.addGap(40)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cmbAccountType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtPassword)
								.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(63)
							.addComponent(lblonlyForEmployees)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(lblGreeting)
					.addGap(18)
					.addComponent(lblPleaseLogin)
					.addGap(50)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccountType)
						.addComponent(cmbAccountType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(60)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnReset))
					.addGap(59)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblonlyForEmployees)
					.addGap(48)
					.addComponent(btnEmployeeAttendance)
					.addGap(206))
		);
		panel.setLayout(gl_panel);
		MainScreen.setLayout(gl_MainScreen);
		
		MainAdmin = new JPanel();
		MainAdmin.setBackground(new Color(0, 191, 255));
		frmEmployeeManagementSystem.getContentPane().add(MainAdmin, "name_2318421792546");
		
		JPanel AdminOptions = new JPanel();
		AdminOptions.setBackground(new Color(255, 250, 250));
		
		JPanel AdminDetails = new JPanel();
		AdminDetails.setBackground(new Color(255, 250, 250));
		
		JPanel Options = new JPanel();

		GroupLayout gl_MainAdmin = new GroupLayout(MainAdmin);
		gl_MainAdmin.setHorizontalGroup(
			gl_MainAdmin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MainAdmin.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_MainAdmin.createParallelGroup(Alignment.LEADING)
						.addComponent(AdminDetails, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
						.addComponent(AdminOptions, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(Options, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_MainAdmin.setVerticalGroup(
			gl_MainAdmin.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_MainAdmin.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_MainAdmin.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_MainAdmin.createSequentialGroup()
							.addGap(9)
							.addComponent(Options, GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE))
						.addGroup(gl_MainAdmin.createSequentialGroup()
							.addComponent(AdminOptions, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
							.addComponent(AdminDetails, GroupLayout.PREFERRED_SIZE, 374, GroupLayout.PREFERRED_SIZE)))
					.addGap(28))
		);
		Options.setLayout(new CardLayout(0, 0));
		
		MainEmpty = new JPanel();
		MainEmpty.setBackground(new Color(255, 250, 250));
		Options.add(MainEmpty, "name_18594775489898");
		
		AddEmployee = new JPanel();
		AddEmployee.setBackground(new Color(255, 250, 250));
		Options.add(AddEmployee, "name_18611848762155");
		
		lblEnterEmployeeDetails = new JLabel("Enter Employee Details");
		lblEnterEmployeeDetails.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtFname = new JTextField();
		txtFname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtFname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtLname = new JTextField();
		txtLname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLname.setColumns(10);
		
		JLabel lblDesignation = new JLabel("Designation :");
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cmbDesignation_1 = new JComboBox();
		cmbDesignation_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbDesignation_1.setModel(new DefaultComboBoxModel(new String[] {"", "Manager", "Team Lead", "Employee"}));
		
		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cmbDepartment_1 = new JComboBox();
		cmbDepartment_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cmbDepartment_1.setModel(new DefaultComboBoxModel(new String[] {"", "Accounts", "Sales", "Development"}));
		
		JLabel lblBasicSalary = new JLabel("Basic Salary :");
		lblBasicSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtBasicSalary = new JTextField();
		txtBasicSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtBasicSalary.setColumns(10);
		
		JLabel label = new JLabel("\u20B9");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblpA = new JLabel("(p. a.)");
		lblpA.setForeground(new Color(192, 192, 192));
		lblpA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblIncentiveToBe = new JLabel("Incentive given :");
		lblIncentiveToBe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label_1 = new JLabel("\u20B9");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtIncentive = new JTextField();
		txtIncentive.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtIncentive.setColumns(10);
		
		JLabel label_2 = new JLabel("(p. a.)");
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblHouseNumber = new JLabel("House Number :");
		lblHouseNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtHnum = new JTextField();
		txtHnum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHnum.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street :");
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtStreet = new JTextField();
		txtStreet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtStreet.setColumns(10);
		
		JLabel lblDistrict = new JLabel("District :");
		lblDistrict.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtDistrict = new JTextField();
		txtDistrict.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDistrict.setColumns(10);
		
		JLabel lblState = new JLabel("State :");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cmbState_1 = new JComboBox();
		cmbState_1.setModel(new DefaultComboBoxModel(new String[] {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttarakhand", "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh", "Dadra and Nagar Haveli", "Daman & Diu", "Lakshadweep", "Puducherry"}));
		cmbState_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblPinCode = new JLabel("Pin Code :");
		lblPinCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtPincode = new JTextField();
		txtPincode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPincode.setColumns(10);
		
		lblContactNumber = new JLabel("Contact Number :");
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtContactNumber = new JTextField();
		txtContactNumber.setColumns(10);
		
		lblProfileImage = new JLabel("Profile Image :");
		lblProfileImage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblEmpProfilePic = new JLabel("");
		lblEmpProfilePic.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/employee.png")));
		lblEmpProfilePic.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnChooseFile = new JButton("Choose File");
		btnChooseFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnAddEReset = new JButton("Reset");
		
		btnAddEReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblUsername_1 = new JLabel("Username :");
		lblUsername_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtAddEmpUsername = new JTextField();
		txtAddEmpUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAddEmpUsername.setColumns(10);
		
		btnEnterFingerprint = new JButton("Enter FingerPrint");
		GroupLayout gl_AddEmployee = new GroupLayout(AddEmployee);
		gl_AddEmployee.setHorizontalGroup(
			gl_AddEmployee.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddEmployee.createSequentialGroup()
					.addGap(354)
					.addComponent(lblEnterEmployeeDetails)
					.addContainerGap(370, Short.MAX_VALUE))
				.addGroup(gl_AddEmployee.createSequentialGroup()
					.addContainerGap(607, Short.MAX_VALUE)
					.addComponent(btnAddEReset)
					.addGap(100)
					.addComponent(btnAddEmployee)
					.addGap(172))
				.addGroup(gl_AddEmployee.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_AddEmployee.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddEmployee.createSequentialGroup()
							.addComponent(lblUsername_1)
							.addContainerGap())
						.addGroup(gl_AddEmployee.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_AddEmployee.createSequentialGroup()
								.addComponent(lblFirstName)
								.addContainerGap())
							.addGroup(gl_AddEmployee.createSequentialGroup()
								.addGroup(gl_AddEmployee.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_AddEmployee.createSequentialGroup()
										.addGroup(gl_AddEmployee.createParallelGroup(Alignment.LEADING)
											.addComponent(lblDesignation)
											.addComponent(lblDepartment)
											.addComponent(lblIncentiveToBe)
											.addComponent(lblBasicSalary))
										.addGap(103)
										.addGroup(gl_AddEmployee.createParallelGroup(Alignment.LEADING)
											.addComponent(label)
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)))
									.addComponent(lblPinCode)
									.addComponent(lblState)
									.addComponent(lblDistrict)
									.addComponent(lblStreet)
									.addComponent(lblHouseNumber))
								.addGap(18)
								.addGroup(gl_AddEmployee.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_AddEmployee.createSequentialGroup()
										.addGroup(gl_AddEmployee.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_AddEmployee.createSequentialGroup()
												.addComponent(txtBasicSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(lblpA))
											.addGroup(gl_AddEmployee.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtIncentive, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_AddEmployee.createSequentialGroup()
												.addGroup(gl_AddEmployee.createParallelGroup(Alignment.TRAILING, false)
													.addComponent(txtAddEmpUsername, Alignment.LEADING)
													.addComponent(txtFname, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
													.addComponent(cmbDesignation_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(cmbDepartment_1, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
												.addGroup(gl_AddEmployee.createParallelGroup(Alignment.LEADING)
													.addComponent(lblLastName)
													.addComponent(lblContactNumber)
													.addComponent(lblProfileImage)))
											.addGroup(gl_AddEmployee.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(txtPincode, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
												.addComponent(cmbState_1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
												.addComponent(txtDistrict, Alignment.LEADING)
												.addComponent(txtStreet, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGap(55))
									.addGroup(gl_AddEmployee.createSequentialGroup()
										.addComponent(txtHnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_AddEmployee.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_AddEmployee.createSequentialGroup()
										.addGroup(gl_AddEmployee.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_AddEmployee.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblEmpProfilePic, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_AddEmployee.createSequentialGroup()
												.addGap(15)
												.addComponent(btnChooseFile))
											.addGroup(gl_AddEmployee.createSequentialGroup()
												.addGap(2)
												.addGroup(gl_AddEmployee.createParallelGroup(Alignment.LEADING)
													.addComponent(txtContactNumber, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
													.addComponent(txtLname, 0, 0, Short.MAX_VALUE))))
										.addGap(223))
									.addGroup(gl_AddEmployee.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnEnterFingerprint)
										.addContainerGap()))))))
		);
		gl_AddEmployee.setVerticalGroup(
			gl_AddEmployee.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddEmployee.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_AddEmployee.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_AddEmployee.createSequentialGroup()
							.addComponent(lblEnterEmployeeDetails)
							.addGap(20)
							.addGroup(gl_AddEmployee.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblFirstName)
								.addComponent(txtFname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLastName)))
						.addComponent(txtLname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_AddEmployee.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername_1)
						.addComponent(txtAddEmpUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_AddEmployee.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDesignation)
						.addComponent(cmbDesignation_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContactNumber)
						.addComponent(txtContactNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_AddEmployee.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDepartment)
						.addComponent(cmbDepartment_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProfileImage))
					.addGroup(gl_AddEmployee.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AddEmployee.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_AddEmployee.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBasicSalary)
								.addComponent(label)
								.addComponent(txtBasicSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblpA))
							.addGap(42)
							.addGroup(gl_AddEmployee.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIncentiveToBe)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtIncentive, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_AddEmployee.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblEmpProfilePic, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addGroup(gl_AddEmployee.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnChooseFile)
								.addComponent(txtHnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHouseNumber))))
					.addGap(55)
					.addGroup(gl_AddEmployee.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtStreet, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStreet))
					.addGap(45)
					.addGroup(gl_AddEmployee.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddEReset)
						.addComponent(btnAddEmployee)
						.addComponent(txtDistrict, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDistrict))
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(gl_AddEmployee.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbState_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblState)
						.addComponent(btnEnterFingerprint))
					.addGap(50)
					.addGroup(gl_AddEmployee.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPincode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPinCode))
					.addGap(46))
		);
		AddEmployee.setLayout(gl_AddEmployee);
		
		DetailsEmployee = new JPanel();
		DetailsEmployee.setBackground(new Color(255, 250, 250));
		Options.add(DetailsEmployee, "name_19038763109748");
		
		lblEmployeeDetails = new JLabel("Employee Details");
		lblEmployeeDetails.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		lblChooseEmployeeId_1 = new JLabel("Choose Employee ID :");
		lblChooseEmployeeId_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cmbViewEmployee = new JComboBox();
		
		btnViewFind = new JButton("Find Employee");
		
		separator_3 = new JSeparator();
		
		lblViewImage = new JLabel("");
		lblViewImage.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/employee.png")));
		
		lblViewEmployeeID = new JLabel("ID");
		lblViewEmployeeID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblViewEmployeeName = new JLabel("Employee Name");
		lblViewEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblViewEmployeeDesignation = new JLabel("Employee Designation");
		lblViewEmployeeDesignation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblViewEmployeeDepartment = new JLabel("Employee Department");
		lblViewEmployeeDepartment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblViewEmployeeAddress = new JLabel("Employee Address");
		lblViewEmployeeAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		separator_4 = new JSeparator();
		
		lblBasicDetails = new JLabel("Basic Details");
		lblBasicDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblSalaryDetails = new JLabel("Salary Details");
		lblSalaryDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		lblBasicSalary_1 = new JLabel("Basic Salary :");
		lblBasicSalary_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblIncentives = new JLabel("Incentives :");
		lblIncentives.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblTotalSalary = new JLabel("Total Salary :");
		lblTotalSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblNewLabel_2 = new JLabel("\u20B9");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		label_8 = new JLabel("\u20B9");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		label_9 = new JLabel("\u20B9");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblViewBasicSalary = new JLabel("Salary Amount");
		lblViewBasicSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblViewIncentiveAmount = new JLabel("Incentive Amount");
		lblViewIncentiveAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblViewTotalAmount = new JLabel("Total Amount");
		lblViewTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblViewEmployeeContact = new JLabel("Employee Contact");
		lblViewEmployeeContact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_DetailsEmployee = new GroupLayout(DetailsEmployee);
		gl_DetailsEmployee.setHorizontalGroup(
			gl_DetailsEmployee.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DetailsEmployee.createSequentialGroup()
					.addGap(215)
					.addComponent(lblChooseEmployeeId_1)
					.addGap(77)
					.addComponent(cmbViewEmployee, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addGap(88)
					.addComponent(btnViewFind)
					.addContainerGap(166, Short.MAX_VALUE))
				.addGroup(gl_DetailsEmployee.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_DetailsEmployee.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBasicDetails)
						.addGroup(gl_DetailsEmployee.createSequentialGroup()
							.addComponent(lblViewImage, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_DetailsEmployee.createParallelGroup(Alignment.LEADING)
								.addComponent(lblViewEmployeeContact)
								.addComponent(lblViewEmployeeID)
								.addComponent(lblViewEmployeeName)
								.addComponent(lblViewEmployeeDesignation)
								.addComponent(lblViewEmployeeDepartment)
								.addComponent(lblViewEmployeeAddress))))
					.addContainerGap(719, Short.MAX_VALUE))
				.addGroup(gl_DetailsEmployee.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_DetailsEmployee.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSalaryDetails)
						.addGroup(gl_DetailsEmployee.createSequentialGroup()
							.addGroup(gl_DetailsEmployee.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBasicSalary_1)
								.addComponent(lblIncentives)
								.addComponent(lblTotalSalary))
							.addGap(41)
							.addGroup(gl_DetailsEmployee.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DetailsEmployee.createSequentialGroup()
									.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblViewTotalAmount))
								.addGroup(gl_DetailsEmployee.createSequentialGroup()
									.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblViewIncentiveAmount))
								.addGroup(gl_DetailsEmployee.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(lblViewBasicSalary)))))
					.addContainerGap(762, Short.MAX_VALUE))
				.addComponent(separator_3, GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE)
				.addGroup(gl_DetailsEmployee.createSequentialGroup()
					.addGap(371)
					.addComponent(lblEmployeeDetails)
					.addContainerGap(442, Short.MAX_VALUE))
				.addComponent(separator_4, GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE)
		);
		gl_DetailsEmployee.setVerticalGroup(
			gl_DetailsEmployee.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DetailsEmployee.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEmployeeDetails)
					.addGap(45)
					.addGroup(gl_DetailsEmployee.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChooseEmployeeId_1)
						.addComponent(cmbViewEmployee, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnViewFind))
					.addGap(17)
					.addComponent(separator_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblBasicDetails)
					.addGap(31)
					.addGroup(gl_DetailsEmployee.createParallelGroup(Alignment.LEADING)
						.addComponent(lblViewImage, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_DetailsEmployee.createSequentialGroup()
							.addComponent(lblViewEmployeeID)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblViewEmployeeName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblViewEmployeeDesignation)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblViewEmployeeDepartment)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblViewEmployeeAddress)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblViewEmployeeContact)))
					.addGap(33)
					.addComponent(separator_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSalaryDetails)
					.addGap(50)
					.addGroup(gl_DetailsEmployee.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBasicSalary_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblViewBasicSalary))
					.addGap(49)
					.addGroup(gl_DetailsEmployee.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DetailsEmployee.createSequentialGroup()
							.addGroup(gl_DetailsEmployee.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIncentives)
								.addComponent(label_8, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addGap(51)
							.addGroup(gl_DetailsEmployee.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DetailsEmployee.createParallelGroup(Alignment.BASELINE)
									.addComponent(label_9, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblViewTotalAmount))
								.addComponent(lblTotalSalary)))
						.addComponent(lblViewIncentiveAmount))
					.addContainerGap(165, Short.MAX_VALUE))
		);
		DetailsEmployee.setLayout(gl_DetailsEmployee);
		
		UpdateEmployee = new JPanel();
		UpdateEmployee.setBackground(new Color(255, 250, 250));
		Options.add(UpdateEmployee, "name_19219407794567");
		
		lblUpdateEmployeeDetails = new JLabel("Update Employee Details");
		lblUpdateEmployeeDetails.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		lblEmployeeId = new JLabel("Employee ID :");
		lblEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtEmpID = new JTextField();
		txtEmpID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmpID.setColumns(10);
		
		lblEmployeeName_1 = new JLabel("Employee Name :");
		lblEmployeeName_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtEmpName = new JTextField();
		txtEmpName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmpName.setColumns(10);
		
		lblDesig = new JLabel("Designation :");
		lblDesig.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		label_11 = new JLabel("Contact Number :");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtEmpContactNum = new JTextField();
		txtEmpContactNum.setColumns(10);
		
		lblDepartment_1 = new JLabel("Department :");
		lblDepartment_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		label_13 = new JLabel("Profile Image :");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		label_14 = new JLabel("Basic Salary :");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		label_15 = new JLabel("\u20B9");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtEmpBasicSalary = new JTextField();
		txtEmpBasicSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmpBasicSalary.setColumns(10);
		
		label_16 = new JLabel("(p. a.)");
		label_16.setForeground(Color.LIGHT_GRAY);
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblEmpImage = new JLabel("");
		lblEmpImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblEmpImage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		label_18 = new JLabel("Incentive given :");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		label_19 = new JLabel("\u20B9");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtEmpIncentive = new JTextField();
		txtEmpIncentive.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmpIncentive.setColumns(10);
		
		label_20 = new JLabel("(p. a.)");
		label_20.setForeground(Color.LIGHT_GRAY);
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnEmpChangeImage = new JButton("Choose File");
		btnEmpChangeImage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		label_21 = new JLabel("House Number :");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtEmpHouseNum = new JTextField();
		txtEmpHouseNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmpHouseNum.setColumns(10);
		
		label_22 = new JLabel("Street :");
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtEmpStreet = new JTextField();
		txtEmpStreet.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmpStreet.setColumns(10);
		
		label_23 = new JLabel("District :");
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtEmpDistrict = new JTextField();
		txtEmpDistrict.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmpDistrict.setColumns(10);
		
		label_24 = new JLabel("State :");
		label_24.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnUpdateInformation = new JButton("Update Information");
		btnUpdateInformation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		label_25 = new JLabel("Pin Code :");
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtEmpPinCode = new JTextField();
		txtEmpPinCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmpPinCode.setColumns(10);
		
		txtEmpDesig = new JTextField();
		txtEmpDesig.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmpDesig.setColumns(10);
		
		txtEmpState = new JTextField();
		txtEmpState.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEmpState.setColumns(10);
		
		lblChooseEmployeeId = new JLabel("Choose Employee ID :");
		lblChooseEmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cmdEmpIDSelect = new JComboBox();
		
		btnFind = new JButton("Find");
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cmbEmpDepartment = new JComboBox();
		cmbEmpDepartment.setModel(new DefaultComboBoxModel(new String[] {"Accounts", "Sales", "Development"}));
		GroupLayout gl_UpdateEmployee = new GroupLayout(UpdateEmployee);
		gl_UpdateEmployee.setHorizontalGroup(
			gl_UpdateEmployee.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_UpdateEmployee.createSequentialGroup()
					.addGap(138)
					.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addComponent(label_21, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(73)
							.addComponent(txtEmpHouseNum, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addGap(338)
							.addComponent(btnEmpChangeImage, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addComponent(label_22, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(132)
							.addComponent(txtEmpStreet, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addComponent(label_23, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(128)
							.addComponent(txtEmpDistrict, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
							.addComponent(btnUpdateInformation))
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDepartment_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDesig, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
							.addGap(95)
							.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEmpDesig, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
								.addComponent(txtEmpID, 0, 0, Short.MAX_VALUE))
							.addGap(171)
							.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_UpdateEmployee.createSequentialGroup()
									.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblEmployeeName_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(label_11, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
									.addGap(57)
									.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtEmpContactNum)
										.addComponent(txtEmpName)))
								.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
								.addComponent(label_25, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_24, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
							.addGap(115)
							.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEmpState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEmpPinCode, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblEmployeeId, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
								.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_18, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
							.addGap(32)
							.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
								.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_19, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_UpdateEmployee.createSequentialGroup()
									.addGap(32)
									.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtEmpBasicSalary, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
										.addComponent(txtEmpIncentive, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
										.addComponent(cmbEmpDepartment, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
									.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
										.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_20, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
									.addGap(262)
									.addComponent(lblEmpImage, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_UpdateEmployee.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblChooseEmployeeId)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cmdEmpIDSelect, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnFind))))
						.addComponent(lblUpdateEmployeeDetails))
					.addGap(144))
		);
		gl_UpdateEmployee.setVerticalGroup(
			gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_UpdateEmployee.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUpdateEmployeeDetails)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
							.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblEmployeeName_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtEmpName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtEmpID, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(30))
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.BASELINE)
								.addComponent(cmdEmpIDSelect, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnFind)
								.addComponent(lblChooseEmployeeId))
							.addGap(68)
							.addComponent(lblEmployeeId, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblDesig, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtEmpDesig, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDepartment_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_13, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbEmpDepartment, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addComponent(txtEmpContactNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGap(36)
							.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(label_18, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGap(36)
							.addComponent(label_15, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(label_19, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGap(33)
							.addComponent(txtEmpBasicSalary, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(txtEmpIncentive, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGap(36)
							.addComponent(label_16, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(48)
							.addComponent(label_20, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblEmpImage, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGap(3)
							.addComponent(label_21, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtEmpHouseNum, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGap(21)
							.addComponent(btnEmpChangeImage, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(21)
					.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGap(3)
							.addComponent(label_22, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtEmpStreet, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGap(3)
							.addComponent(label_23, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtEmpDistrict, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnUpdateInformation, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(54)
					.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_24, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmpState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(gl_UpdateEmployee.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_UpdateEmployee.createSequentialGroup()
							.addGap(3)
							.addComponent(label_25, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtEmpPinCode, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		UpdateEmployee.setLayout(gl_UpdateEmployee);
		
		DeleteEmployee = new JPanel();
		DeleteEmployee.setBackground(new Color(255, 250, 250));
		Options.add(DeleteEmployee, "name_19391174616882");
		
		lblDeleteEmployeeDetails = new JLabel("Delete Employee Details");
		lblDeleteEmployeeDetails.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		lblChooseEmployee = new JLabel("Choose Employee :");
		lblChooseEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cmbEmployees = new JComboBox();
		cmbEmployees.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnDeleteEmp = new JButton("Delete");
		btnDeleteEmp.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/Delete Emp.png")));
		btnDeleteEmp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_DeleteEmployee = new GroupLayout(DeleteEmployee);
		gl_DeleteEmployee.setHorizontalGroup(
			gl_DeleteEmployee.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DeleteEmployee.createSequentialGroup()
					.addGroup(gl_DeleteEmployee.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DeleteEmployee.createSequentialGroup()
							.addGap(235)
							.addComponent(lblChooseEmployee)
							.addGap(116)
							.addComponent(cmbEmployees, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_DeleteEmployee.createSequentialGroup()
							.addGap(312)
							.addComponent(lblDeleteEmployeeDetails))
						.addGroup(gl_DeleteEmployee.createSequentialGroup()
							.addGap(417)
							.addComponent(btnDeleteEmp)))
					.addContainerGap(242, Short.MAX_VALUE))
		);
		gl_DeleteEmployee.setVerticalGroup(
			gl_DeleteEmployee.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DeleteEmployee.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDeleteEmployeeDetails)
					.addGap(94)
					.addGroup(gl_DeleteEmployee.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbEmployees, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblChooseEmployee))
					.addGap(91)
					.addComponent(btnDeleteEmp)
					.addContainerGap(549, Short.MAX_VALUE))
		);
		DeleteEmployee.setLayout(gl_DeleteEmployee);
		
		AdminSettings = new JPanel();
		AdminSettings.setBackground(new Color(255, 250, 250));
		Options.add(AdminSettings, "name_19538531685946");
		
		lblSettings = new JLabel("Settings");
		lblSettings.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		btnCreateNewAdmin = new JButton("Create New Admin Account");
		
		btnCreateNewAdmin.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/admin account.png")));
		btnCreateNewAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnChangePassword = new JButton("Change Password");
		
		btnChangePassword.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/password change.png")));
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JSeparator separator_2 = new JSeparator();
		
		SettingsOptions = new JPanel();
		GroupLayout gl_AdminSettings = new GroupLayout(AdminSettings);
		gl_AdminSettings.setHorizontalGroup(
			gl_AdminSettings.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AdminSettings.createSequentialGroup()
					.addGap(168)
					.addComponent(btnCreateNewAdmin)
					.addGap(203)
					.addComponent(btnChangePassword, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(188, Short.MAX_VALUE))
				.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
				.addGroup(gl_AdminSettings.createSequentialGroup()
					.addGap(457)
					.addComponent(lblSettings)
					.addContainerGap(463, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_AdminSettings.createSequentialGroup()
					.addContainerGap(127, Short.MAX_VALUE)
					.addComponent(SettingsOptions, GroupLayout.PREFERRED_SIZE, 840, GroupLayout.PREFERRED_SIZE)
					.addGap(76))
		);
		gl_AdminSettings.setVerticalGroup(
			gl_AdminSettings.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AdminSettings.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSettings)
					.addGap(50)
					.addGroup(gl_AdminSettings.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreateNewAdmin)
						.addComponent(btnChangePassword))
					.addGap(51)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addComponent(SettingsOptions, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);
		SettingsOptions.setLayout(new CardLayout(0, 0));
		
		EmptyPanel = new JPanel();
		EmptyPanel.setBackground(new Color(255, 250, 250));
		SettingsOptions.add(EmptyPanel, "name_17283018603240");
		
		NewAdmin = new JPanel();
		NewAdmin.setBackground(new Color(255, 250, 250));
		SettingsOptions.add(NewAdmin, "name_17247026574514");
		
		JLabel label_3 = new JLabel("New Admin Account");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_4 = new JLabel("Username :");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtNewAdminUsername = new JTextField();
		txtNewAdminUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNewAdminUsername.setColumns(10);
		
		JLabel label_5 = new JLabel("Password :");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtNewAdminPassword = new JPasswordField();
		txtNewAdminPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel label_6 = new JLabel("Confirm Password :");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtNewAdminConfirmPassword = new JPasswordField();
		txtNewAdminConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblNewAdminViewPic = new JLabel("");
		lblNewAdminViewPic.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnNewAdminChoosePic = new JButton("Choose Image");
		btnNewAdminChoosePic.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnNewAdminReset = new JButton("Reset");
		btnNewAdminReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnNewAdminAddAdmin = new JButton("Create Admin");
		
		btnNewAdminAddAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblAdminName = new JLabel("Admin Name :");
		lblAdminName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtAdminName = new JTextField();
		txtAdminName.setColumns(10);
		GroupLayout gl_NewAdmin = new GroupLayout(NewAdmin);
		gl_NewAdmin.setHorizontalGroup(
			gl_NewAdmin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NewAdmin.createSequentialGroup()
					.addGap(310)
					.addComponent(label_3)
					.addContainerGap(326, Short.MAX_VALUE))
				.addGroup(gl_NewAdmin.createSequentialGroup()
					.addGap(263)
					.addComponent(btnNewAdminReset)
					.addGap(134)
					.addComponent(btnNewAdminAddAdmin)
					.addContainerGap(253, Short.MAX_VALUE))
				.addGroup(gl_NewAdmin.createSequentialGroup()
					.addGroup(gl_NewAdmin.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_NewAdmin.createSequentialGroup()
							.addGap(143)
							.addGroup(gl_NewAdmin.createParallelGroup(Alignment.LEADING)
								.addComponent(label_4)
								.addComponent(label_5)
								.addComponent(lblAdminName))
							.addGap(68))
						.addGroup(gl_NewAdmin.createSequentialGroup()
							.addGap(144)
							.addComponent(label_6)
							.addGap(35)))
					.addGroup(gl_NewAdmin.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_NewAdmin.createSequentialGroup()
							.addComponent(txtNewAdminConfirmPassword)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(txtNewAdminPassword)
						.addComponent(txtNewAdminUsername)
						.addComponent(txtAdminName, Alignment.LEADING))
					.addGroup(gl_NewAdmin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NewAdmin.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
							.addComponent(lblNewAdminViewPic, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addGap(144))
						.addGroup(gl_NewAdmin.createSequentialGroup()
							.addGap(144)
							.addComponent(btnNewAdminChoosePic)
							.addContainerGap())))
		);
		gl_NewAdmin.setVerticalGroup(
			gl_NewAdmin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NewAdmin.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_NewAdmin.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_NewAdmin.createSequentialGroup()
							.addGroup(gl_NewAdmin.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_NewAdmin.createSequentialGroup()
									.addComponent(label_3)
									.addGap(122)
									.addComponent(txtNewAdminUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_NewAdmin.createSequentialGroup()
									.addGroup(gl_NewAdmin.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAdminName)
										.addComponent(txtAdminName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(52)
									.addComponent(label_4)))
							.addGap(46)
							.addGroup(gl_NewAdmin.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNewAdminPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5)))
						.addComponent(lblNewAdminViewPic, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_NewAdmin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NewAdmin.createSequentialGroup()
							.addGap(18)
							.addComponent(btnNewAdminChoosePic))
						.addGroup(gl_NewAdmin.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_NewAdmin.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_6)
								.addComponent(txtNewAdminConfirmPassword, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))))
					.addGap(70)
					.addGroup(gl_NewAdmin.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewAdminReset)
						.addComponent(btnNewAdminAddAdmin))
					.addContainerGap(119, Short.MAX_VALUE))
		);
		NewAdmin.setLayout(gl_NewAdmin);
		
		ChangePassword = new JPanel();
		ChangePassword.setBackground(new Color(255, 250, 250));
		SettingsOptions.add(ChangePassword, "name_17329821691967");
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblOldPassword = new JLabel("Old Password :");
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewPassword = new JLabel("New Password :");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtOldPassword = new JPasswordField();
		txtOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtNewPassword = new JPasswordField();
		txtNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtConfirmPassword = new JPasswordField();
		
		btnChange = new JButton("Change");
		
		btnChange.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_ChangePassword = new GroupLayout(ChangePassword);
		gl_ChangePassword.setHorizontalGroup(
			gl_ChangePassword.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ChangePassword.createSequentialGroup()
					.addGroup(gl_ChangePassword.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ChangePassword.createSequentialGroup()
							.addGap(329)
							.addComponent(lblChangePassword))
						.addGroup(gl_ChangePassword.createSequentialGroup()
							.addGap(197)
							.addGroup(gl_ChangePassword.createParallelGroup(Alignment.LEADING)
								.addComponent(lblOldPassword)
								.addComponent(lblNewPassword)
								.addComponent(lblConfirmPassword))
							.addGap(43)
							.addGroup(gl_ChangePassword.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtConfirmPassword)
								.addComponent(txtNewPassword)
								.addComponent(txtOldPassword, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
								.addComponent(btnChange))))
					.addContainerGap(227, Short.MAX_VALUE))
		);
		gl_ChangePassword.setVerticalGroup(
			gl_ChangePassword.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ChangePassword.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChangePassword)
					.addGap(92)
					.addGroup(gl_ChangePassword.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOldPassword)
						.addComponent(txtOldPassword, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(65)
					.addGroup(gl_ChangePassword.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewPassword)
						.addComponent(txtNewPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(67)
					.addGroup(gl_ChangePassword.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblConfirmPassword)
						.addComponent(txtConfirmPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(66)
					.addComponent(btnChange)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		ChangePassword.setLayout(gl_ChangePassword);
		AdminSettings.setLayout(gl_AdminSettings);
		
		LeaveRequests = new JPanel();
		LeaveRequests.setBackground(new Color(255, 250, 250));
		Options.add(LeaveRequests, "name_269883978056848");
		
		JLabel lblEmployeeLeaveRequests = new JLabel("Employee Leave Requests");
		lblEmployeeLeaveRequests.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		btnReject = new JButton("Reject");
		btnReject.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnAccept = new JButton("Accept");
		GroupLayout gl_LeaveRequests = new GroupLayout(LeaveRequests);
		gl_LeaveRequests.setHorizontalGroup(
			gl_LeaveRequests.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LeaveRequests.createSequentialGroup()
					.addContainerGap(83, Short.MAX_VALUE)
					.addComponent(lblEmployeeLeaveRequests)
					.addGap(327))
				.addGroup(gl_LeaveRequests.createSequentialGroup()
					.addGap(335)
					.addComponent(btnReject)
					.addPreferredGap(ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
					.addComponent(btnAccept)
					.addGap(281))
				.addGroup(Alignment.TRAILING, gl_LeaveRequests.createSequentialGroup()
					.addContainerGap(29, Short.MAX_VALUE)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 1020, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		gl_LeaveRequests.setVerticalGroup(
			gl_LeaveRequests.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LeaveRequests.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEmployeeLeaveRequests)
					.addGap(85)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 511, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addGroup(gl_LeaveRequests.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReject)
						.addComponent(btnAccept))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		
		tblLeaveInformationTable = new JTable();
		tblLeaveInformationTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tblLeaveInformationTable.setBackground(new Color(255, 255, 255));
		scrollPane_1.setViewportView(tblLeaveInformationTable);
		LeaveRequests.setLayout(gl_LeaveRequests);
		
		SalaryWindow = new JPanel();
		SalaryWindow.setBackground(new Color(255, 255, 255));
		Options.add(SalaryWindow, "name_283863773528499");
		
		JLabel lblSalaryPortal = new JLabel("Salary Portal");
		lblSalaryPortal.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		lblChooseEmployee_1 = new JLabel("Choose Employee :");
		lblChooseEmployee_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cmbSalSelectEmp = new JComboBox();
		cmbSalSelectEmp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnSelectEmployee = new JButton("Select Employee");
		btnSelectEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblBasicSalary_3 = new JLabel("Basic Salary :");
		lblBasicSalary_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtSalBasicSalary = new JTextField();
		txtSalBasicSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSalBasicSalary.setColumns(10);
		
		JLabel lblIncentive = new JLabel("Incentive :");
		lblIncentive.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtSalIncentive = new JTextField();
		txtSalIncentive.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSalIncentive.setColumns(10);
		
		JLabel lblMonthAndYear_2 = new JLabel("Month and Year :");
		lblMonthAndYear_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		mtcSalMonth = new JMonthChooser();
		
		ychSalYear = new JYearChooser();
		
		btnGiveSalary = new JButton("Give Salary");
		btnGiveSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblAttendanceForCurrent = new JLabel("Attendance for current Month :");
		lblAttendanceForCurrent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtCurMonthAttendance = new JTextField();
		txtCurMonthAttendance.setColumns(10);
		GroupLayout gl_SalaryWindow = new GroupLayout(SalaryWindow);
		gl_SalaryWindow.setHorizontalGroup(
			gl_SalaryWindow.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SalaryWindow.createSequentialGroup()
					.addContainerGap(482, Short.MAX_VALUE)
					.addComponent(lblSalaryPortal)
					.addGap(397))
				.addGroup(gl_SalaryWindow.createSequentialGroup()
					.addGroup(gl_SalaryWindow.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_SalaryWindow.createSequentialGroup()
							.addGap(283)
							.addComponent(lblChooseEmployee_1)
							.addGap(60)
							.addComponent(cmbSalSelectEmp, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_SalaryWindow.createSequentialGroup()
							.addGap(410)
							.addGroup(gl_SalaryWindow.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBasicSalary_3)
								.addComponent(lblIncentive)
								.addComponent(lblMonthAndYear_2)
								.addComponent(lblAttendanceForCurrent))
							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
							.addGroup(gl_SalaryWindow.createParallelGroup(Alignment.LEADING, false)
								.addComponent(mtcSalMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSalIncentive)
								.addComponent(txtSalBasicSalary)
								.addComponent(txtCurMonthAttendance))))
					.addGap(6)
					.addGroup(gl_SalaryWindow.createParallelGroup(Alignment.LEADING)
						.addComponent(ychSalYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSelectEmployee))
					.addContainerGap(138, Short.MAX_VALUE))
				.addGroup(gl_SalaryWindow.createSequentialGroup()
					.addContainerGap(511, Short.MAX_VALUE)
					.addComponent(btnGiveSalary)
					.addGap(457))
		);
		gl_SalaryWindow.setVerticalGroup(
			gl_SalaryWindow.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SalaryWindow.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_SalaryWindow.createParallelGroup(Alignment.TRAILING)
						.addComponent(ychSalYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_SalaryWindow.createSequentialGroup()
							.addComponent(lblSalaryPortal)
							.addGap(53)
							.addGroup(gl_SalaryWindow.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblChooseEmployee_1)
								.addComponent(cmbSalSelectEmp, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSelectEmployee))
							.addGap(105)
							.addGroup(gl_SalaryWindow.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBasicSalary_3)
								.addComponent(txtSalBasicSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(44)
							.addGroup(gl_SalaryWindow.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIncentive)
								.addComponent(txtSalIncentive, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(41)
							.addGroup(gl_SalaryWindow.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAttendanceForCurrent)
								.addComponent(txtCurMonthAttendance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(gl_SalaryWindow.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblMonthAndYear_2)
								.addComponent(mtcSalMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(49)
					.addComponent(btnGiveSalary)
					.addContainerGap(297, Short.MAX_VALUE))
		);
		SalaryWindow.setLayout(gl_SalaryWindow);
		
		lblAdminImage = new JLabel("");
		
		lblAdminUsername = new JLabel("Username :");
		lblAdminUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblAdminAccountType = new JLabel("Account Type :");
		lblAdminAccountType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblAdmin = new JLabel("Admin");
		lblAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnLogOut = new JButton("Log Out");
		
		btnLogOut.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/logout.png")));
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnSettings = new JButton("Settings");
		
		btnSettings.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSettings.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/settings.png")));
		GroupLayout gl_AdminDetails = new GroupLayout(AdminDetails);
		gl_AdminDetails.setHorizontalGroup(
			gl_AdminDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AdminDetails.createSequentialGroup()
					.addGroup(gl_AdminDetails.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AdminDetails.createSequentialGroup()
							.addGap(89)
							.addComponent(lblAdminImage, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_AdminDetails.createSequentialGroup()
							.addGroup(gl_AdminDetails.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_AdminDetails.createSequentialGroup()
									.addGap(49)
									.addGroup(gl_AdminDetails.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAdminUsername)
										.addComponent(lblAdminAccountType)))
								.addGroup(gl_AdminDetails.createSequentialGroup()
									.addGap(31)
									.addComponent(btnSettings)))
							.addGroup(gl_AdminDetails.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_AdminDetails.createSequentialGroup()
									.addGap(29)
									.addGroup(gl_AdminDetails.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAdmin)
										.addComponent(lblName)))
								.addGroup(gl_AdminDetails.createSequentialGroup()
									.addGap(18)
									.addComponent(btnLogOut)))))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		gl_AdminDetails.setVerticalGroup(
			gl_AdminDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AdminDetails.createSequentialGroup()
					.addGap(51)
					.addComponent(lblAdminImage, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(gl_AdminDetails.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdminUsername)
						.addComponent(lblName))
					.addGap(18)
					.addGroup(gl_AdminDetails.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdminAccountType)
						.addComponent(lblAdmin))
					.addGap(22)
					.addGroup(gl_AdminDetails.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSettings)
						.addComponent(btnLogOut))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		AdminDetails.setLayout(gl_AdminDetails);
		
		btnAddnewemployee = new JButton("Add New Employee");
		
		btnAddnewemployee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddnewemployee.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/add-user.png")));
		
		btnDetailsOfEmployee = new JButton("Details of Employee");
		
		btnDetailsOfEmployee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDetailsOfEmployee.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/Details.png")));
		
		btnUpdateEmployeeInformation = new JButton("Update Employee \r\nInformation");
		btnUpdateEmployeeInformation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateEmployeeInformation.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/update.png")));
		
		
		btnDeleteEmployee = new JButton("Delete Employee");
		
		btnDeleteEmployee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteEmployee.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/delete employee.png")));
		
		btnLeaveRequests = new JButton("Leave Requests");
		btnLeaveRequests.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/Leave Request.png")));
		btnLeaveRequests.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnSalaryPortal = new JButton("Salary Portal");
		btnSalaryPortal.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/salary.png")));
		btnSalaryPortal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_AdminOptions = new GroupLayout(AdminOptions);
		gl_AdminOptions.setHorizontalGroup(
			gl_AdminOptions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AdminOptions.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_AdminOptions.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnSalaryPortal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnUpdateEmployeeInformation, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(btnDetailsOfEmployee, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAddnewemployee, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
						.addComponent(btnDeleteEmployee, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLeaveRequests, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		gl_AdminOptions.setVerticalGroup(
			gl_AdminOptions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AdminOptions.createSequentialGroup()
					.addGap(23)
					.addComponent(btnAddnewemployee)
					.addGap(18)
					.addComponent(btnDetailsOfEmployee)
					.addGap(18)
					.addComponent(btnUpdateEmployeeInformation, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDeleteEmployee)
					.addGap(18)
					.addComponent(btnLeaveRequests)
					.addGap(18)
					.addComponent(btnSalaryPortal)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		AdminOptions.setLayout(gl_AdminOptions);
		MainAdmin.setLayout(gl_MainAdmin);
		
		MainEmployee = new JPanel();
		MainEmployee.setBackground(new Color(0, 191, 255));
		frmEmployeeManagementSystem.getContentPane().add(MainEmployee, "name_9086920778786");
		
		JPanel EmployeeOptions = new JPanel();
		EmployeeOptions.setBackground(new Color(255, 250, 250));
		
		JPanel EmployeeDetails = new JPanel();
		EmployeeDetails.setBackground(new Color(255, 250, 250));
		
		JPanel EOptions = new JPanel();
		EOptions.setBackground(new Color(255, 250, 250));
		GroupLayout gl_MainEmployee = new GroupLayout(MainEmployee);
		gl_MainEmployee.setHorizontalGroup(
			gl_MainEmployee.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MainEmployee.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_MainEmployee.createParallelGroup(Alignment.LEADING)
						.addComponent(EmployeeOptions, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)
						.addComponent(EmployeeDetails, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(EOptions, GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_MainEmployee.setVerticalGroup(
			gl_MainEmployee.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_MainEmployee.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_MainEmployee.createParallelGroup(Alignment.TRAILING)
						.addComponent(EOptions, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_MainEmployee.createSequentialGroup()
							.addComponent(EmployeeOptions, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(EmployeeDetails, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		EOptions.setLayout(new CardLayout(0, 0));
		
		MainEEmpty = new JPanel();
		MainEEmpty.setBackground(new Color(255, 250, 250));
		EOptions.add(MainEEmpty, "name_11110470376809");
		
		AttendanceDetails = new JPanel();
		AttendanceDetails.setBackground(new Color(255, 250, 250));
		EOptions.add(AttendanceDetails, "name_10985641900840");
		
		lblAttendanceDetails = new JLabel("Attendance Details");
		lblAttendanceDetails.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		lblMonthAndYear_1 = new JLabel("Month and Year :");
		lblMonthAndYear_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		mtcAttendence = new JMonthChooser();
		
		btnAttendanceCheck = new JButton("Check");
		btnAttendanceCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblPresent = new JLabel("Present :");
		lblPresent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtAttPresent = new JTextField();
		txtAttPresent.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAttPresent.setColumns(10);
		
		JLabel lblNumberOfWorking = new JLabel("Number of working days :");
		lblNumberOfWorking.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtAttNumWorkingDays = new JTextField();
		txtAttNumWorkingDays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAttNumWorkingDays.setColumns(10);
		
		JLabel lblPercentage = new JLabel("Percentage :");
		lblPercentage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtAttPercentage = new JTextField();
		txtAttPercentage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAttPercentage.setColumns(10);
		GroupLayout gl_AttendanceDetails = new GroupLayout(AttendanceDetails);
		gl_AttendanceDetails.setHorizontalGroup(
			gl_AttendanceDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AttendanceDetails.createSequentialGroup()
					.addContainerGap(212, Short.MAX_VALUE)
					.addGroup(gl_AttendanceDetails.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_AttendanceDetails.createSequentialGroup()
							.addGroup(gl_AttendanceDetails.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPercentage)
								.addComponent(lblNumberOfWorking)
								.addComponent(lblPresent))
							.addGap(66))
						.addGroup(gl_AttendanceDetails.createSequentialGroup()
							.addComponent(lblMonthAndYear_1)
							.addGap(127)))
					.addGroup(gl_AttendanceDetails.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AttendanceDetails.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mtcAttendence, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(157)
							.addComponent(btnAttendanceCheck)
							.addContainerGap(304, Short.MAX_VALUE))
						.addGroup(gl_AttendanceDetails.createSequentialGroup()
							.addGap(51)
							.addGroup(gl_AttendanceDetails.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtAttNumWorkingDays)
								.addComponent(txtAttPercentage)
								.addComponent(txtAttPresent))
							.addContainerGap(456, Short.MAX_VALUE))))
				.addGroup(gl_AttendanceDetails.createSequentialGroup()
					.addGap(389)
					.addComponent(lblAttendanceDetails)
					.addContainerGap(424, Short.MAX_VALUE))
		);
		gl_AttendanceDetails.setVerticalGroup(
			gl_AttendanceDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AttendanceDetails.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAttendanceDetails)
					.addGap(76)
					.addGroup(gl_AttendanceDetails.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AttendanceDetails.createSequentialGroup()
							.addGroup(gl_AttendanceDetails.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnAttendanceCheck)
								.addComponent(mtcAttendence, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(94)
							.addGroup(gl_AttendanceDetails.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPresent)
								.addComponent(txtAttPresent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblMonthAndYear_1))
					.addGap(46)
					.addGroup(gl_AttendanceDetails.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfWorking)
						.addComponent(txtAttNumWorkingDays, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(gl_AttendanceDetails.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPercentage)
						.addComponent(txtAttPercentage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(408, Short.MAX_VALUE))
		);
		AttendanceDetails.setLayout(gl_AttendanceDetails);
		
		SalaryStatement = new JPanel();
		SalaryStatement.setBackground(new Color(255, 250, 250));
		EOptions.add(SalaryStatement, "name_11171420815764");
		
		lblSalaryStatement = new JLabel("Salary Statement");
		lblSalaryStatement.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblMonthAndYear = new JLabel("Month and Year :");
		lblMonthAndYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		mtcSalary = new JMonthChooser();
		
		yrcSalary = new JYearChooser();
		
		btnCheck = new JButton("Check");
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblBasicSalary_2 = new JLabel("Basic Salary :");
		lblBasicSalary_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblIncentives_1 = new JLabel("Incentives :");
		lblIncentives_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblTotalSalary_1 = new JLabel("Total Salary :");
		lblTotalSalary_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtShowBasicSalary = new JTextField();
		txtShowBasicSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtShowBasicSalary.setColumns(10);
		
		txtShowIncentive = new JTextField();
		txtShowIncentive.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtShowIncentive.setColumns(10);
		
		txtShowTotalSalary = new JTextField();
		txtShowTotalSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtShowTotalSalary.setColumns(10);
		GroupLayout gl_SalaryStatement = new GroupLayout(SalaryStatement);
		gl_SalaryStatement.setHorizontalGroup(
			gl_SalaryStatement.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SalaryStatement.createSequentialGroup()
					.addContainerGap(420, Short.MAX_VALUE)
					.addComponent(lblSalaryStatement)
					.addGap(400))
				.addGroup(gl_SalaryStatement.createSequentialGroup()
					.addGap(312)
					.addComponent(lblMonthAndYear)
					.addGap(87)
					.addComponent(mtcSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(yrcSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(89)
					.addComponent(btnCheck)
					.addContainerGap(225, Short.MAX_VALUE))
				.addGroup(gl_SalaryStatement.createSequentialGroup()
					.addGap(394)
					.addGroup(gl_SalaryStatement.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBasicSalary_2)
						.addComponent(lblIncentives_1)
						.addComponent(lblTotalSalary_1))
					.addGap(116)
					.addGroup(gl_SalaryStatement.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtShowBasicSalary)
						.addComponent(txtShowIncentive)
						.addComponent(txtShowTotalSalary))
					.addContainerGap(347, Short.MAX_VALUE))
		);
		gl_SalaryStatement.setVerticalGroup(
			gl_SalaryStatement.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_SalaryStatement.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSalaryStatement)
					.addGap(68)
					.addGroup(gl_SalaryStatement.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCheck)
						.addComponent(lblMonthAndYear)
						.addComponent(mtcSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(yrcSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(109)
					.addGroup(gl_SalaryStatement.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBasicSalary_2)
						.addComponent(txtShowBasicSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(67)
					.addGroup(gl_SalaryStatement.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblIncentives_1)
						.addComponent(txtShowIncentive, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(75)
					.addGroup(gl_SalaryStatement.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotalSalary_1)
						.addComponent(txtShowTotalSalary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(368, Short.MAX_VALUE))
		);
		SalaryStatement.setLayout(gl_SalaryStatement);
		
		LeaveRequest = new JPanel();
		LeaveRequest.setBackground(new Color(255, 250, 250));
		EOptions.add(LeaveRequest, "name_11272345880560");
		
		lblApplyLeave = new JLabel("Apply Leave");
		lblApplyLeave.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		lblLeaveDuration = new JLabel("Leave Duration :");
		lblLeaveDuration.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		rdbtnSingleDay = new JRadioButton("Single Day");
		buttonGroup.add(rdbtnSingleDay);
		rdbtnSingleDay.setBackground(new Color(255, 250, 250));
		rdbtnSingleDay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		rdbtnMultipleDays = new JRadioButton("Multiple Days");
		buttonGroup.add(rdbtnMultipleDays);
		rdbtnMultipleDays.setBackground(new Color(255, 250, 250));
		rdbtnMultipleDays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		dtcFrom = new JDateChooser();
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		dtcTO = new JDateChooser();
		
		JLabel lblLeaveType = new JLabel("Leave Type :");
		lblLeaveType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cmbLeaveType = new JComboBox();
		cmbLeaveType.setModel(new DefaultComboBoxModel(new String[] {"Casual", "Urgent"}));
		
		JLabel lblReason = new JLabel("Reason : ");
		lblReason.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_LeaveRequest = new GroupLayout(LeaveRequest);
		gl_LeaveRequest.setHorizontalGroup(
			gl_LeaveRequest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LeaveRequest.createSequentialGroup()
					.addContainerGap(682, Short.MAX_VALUE)
					.addComponent(lblApplyLeave)
					.addGap(444))
				.addGroup(gl_LeaveRequest.createSequentialGroup()
					.addGap(251)
					.addGroup(gl_LeaveRequest.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLeaveDuration)
						.addComponent(lblDate)
						.addComponent(lblLeaveType)
						.addComponent(lblReason))
					.addGap(78)
					.addGroup(gl_LeaveRequest.createParallelGroup(Alignment.LEADING)
						.addComponent(cmbLeaveType, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_LeaveRequest.createSequentialGroup()
							.addComponent(rdbtnSingleDay)
							.addGap(86)
							.addComponent(rdbtnMultipleDays))
						.addGroup(gl_LeaveRequest.createSequentialGroup()
							.addComponent(dtcFrom, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addComponent(lblTo)
							.addGap(76)
							.addComponent(dtcTO, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 445, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(198, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_LeaveRequest.createSequentialGroup()
					.addContainerGap(712, Short.MAX_VALUE)
					.addComponent(btnApply)
					.addGap(499))
		);
		gl_LeaveRequest.setVerticalGroup(
			gl_LeaveRequest.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LeaveRequest.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblApplyLeave)
					.addGap(66)
					.addGroup(gl_LeaveRequest.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLeaveDuration)
						.addComponent(rdbtnSingleDay)
						.addComponent(rdbtnMultipleDays))
					.addGap(53)
					.addGroup(gl_LeaveRequest.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDate)
						.addComponent(dtcFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_LeaveRequest.createParallelGroup(Alignment.TRAILING)
							.addComponent(dtcTO, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTo)))
					.addGap(70)
					.addGroup(gl_LeaveRequest.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLeaveType)
						.addComponent(cmbLeaveType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(66)
					.addGroup(gl_LeaveRequest.createParallelGroup(Alignment.LEADING)
						.addComponent(lblReason)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(74)
					.addComponent(btnApply)
					.addContainerGap(244, Short.MAX_VALUE))
		);
		
		txtAreaReason = new JTextArea();
		txtAreaReason.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(txtAreaReason);
		LeaveRequest.setLayout(gl_LeaveRequest);
		
		EmployeeSettings = new JPanel();
		EmployeeSettings.setBackground(new Color(255, 250, 250));
		EOptions.add(EmployeeSettings, "name_11309335034690");
		
		lblChangeAccountSettings = new JLabel("Change Account Settings");
		lblChangeAccountSettings.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblOldPassword_1 = new JLabel("Old Password :");
		lblOldPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewPassword_1 = new JLabel("New Password :");
		lblNewPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblConfirmPassword_1 = new JLabel("Confirm Password :");
		lblConfirmPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtEmpOldPasswrod = new JPasswordField();
		
		txtEmpNewPassword = new JPasswordField();
		
		txtEmpConfirmPassword = new JPasswordField();
		
		btnEmpPasswordChange = new JButton("Change");
		btnEmpPasswordChange.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_EmployeeSettings = new GroupLayout(EmployeeSettings);
		gl_EmployeeSettings.setHorizontalGroup(
			gl_EmployeeSettings.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_EmployeeSettings.createSequentialGroup()
					.addContainerGap(328, Short.MAX_VALUE)
					.addGroup(gl_EmployeeSettings.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewPassword_1)
						.addComponent(lblOldPassword_1)
						.addComponent(lblConfirmPassword_1))
					.addGap(61)
					.addGroup(gl_EmployeeSettings.createParallelGroup(Alignment.LEADING)
						.addComponent(txtEmpConfirmPassword, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmpNewPassword, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmpOldPasswrod, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(337, Short.MAX_VALUE))
				.addGroup(gl_EmployeeSettings.createSequentialGroup()
					.addContainerGap(363, Short.MAX_VALUE)
					.addComponent(lblChangeAccountSettings)
					.addGap(322))
				.addGroup(Alignment.LEADING, gl_EmployeeSettings.createSequentialGroup()
					.addGap(439)
					.addComponent(btnEmpPasswordChange)
					.addContainerGap(525, Short.MAX_VALUE))
		);
		gl_EmployeeSettings.setVerticalGroup(
			gl_EmployeeSettings.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_EmployeeSettings.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChangeAccountSettings)
					.addGap(68)
					.addGroup(gl_EmployeeSettings.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOldPassword_1)
						.addComponent(txtEmpOldPasswrod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_EmployeeSettings.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmpNewPassword, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewPassword_1))
					.addGap(54)
					.addGroup(gl_EmployeeSettings.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmpConfirmPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmPassword_1))
					.addGap(72)
					.addComponent(btnEmpPasswordChange)
					.addContainerGap(438, Short.MAX_VALUE))
		);
		EmployeeSettings.setLayout(gl_EmployeeSettings);
		
		oldLeaves = new JPanel();
		oldLeaves.setBackground(new Color(255, 250, 250));
		EOptions.add(oldLeaves, "name_182470590818689");
		
		JLabel lblDetailsOfPast = new JLabel("Details of Past Leave Requests");
		lblDetailsOfPast.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_oldLeaves = new GroupLayout(oldLeaves);
		gl_oldLeaves.setHorizontalGroup(
			gl_oldLeaves.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_oldLeaves.createSequentialGroup()
					.addContainerGap(116, Short.MAX_VALUE)
					.addComponent(lblDetailsOfPast)
					.addGap(308))
				.addGroup(gl_oldLeaves.createSequentialGroup()
					.addGap(116)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 878, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(104, Short.MAX_VALUE))
		);
		gl_oldLeaves.setVerticalGroup(
			gl_oldLeaves.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_oldLeaves.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDetailsOfPast)
					.addGap(130)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(195, Short.MAX_VALUE))
		);
		
		tblOldLeaves = new JTable();
		scrollPane_2.setViewportView(tblOldLeaves);
		oldLeaves.setLayout(gl_oldLeaves);
		
		lblEmployeeImage = new JLabel("");
		
		btnSettingsE = new JButton("Settings");
		btnSettingsE.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/settings.png")));
		btnSettingsE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblEmployeeUsername = new JLabel("Name :");
		lblEmployeeUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblEmployeeName = new JLabel("Sahil");
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblAccountType_1 = new JLabel("Account Type :");
		lblAccountType_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnLogOutE = new JButton("Log Out");
		btnLogOutE.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/logout.png")));
		btnLogOutE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout gl_EmployeeDetails = new GroupLayout(EmployeeDetails);
		gl_EmployeeDetails.setHorizontalGroup(
			gl_EmployeeDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_EmployeeDetails.createSequentialGroup()
					.addGap(22)
					.addComponent(btnSettingsE)
					.addGap(18)
					.addComponent(btnLogOutE)
					.addContainerGap(48, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_EmployeeDetails.createSequentialGroup()
					.addContainerGap(89, Short.MAX_VALUE)
					.addComponent(lblEmployeeImage, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(83))
				.addGroup(gl_EmployeeDetails.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_EmployeeDetails.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAccountType_1)
						.addComponent(lblEmployeeUsername))
					.addGap(18)
					.addGroup(gl_EmployeeDetails.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmployeeName)
						.addComponent(lblEmployee))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		gl_EmployeeDetails.setVerticalGroup(
			gl_EmployeeDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_EmployeeDetails.createSequentialGroup()
					.addGap(39)
					.addComponent(lblEmployeeImage, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_EmployeeDetails.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmployeeUsername)
						.addComponent(lblEmployeeName))
					.addGap(27)
					.addGroup(gl_EmployeeDetails.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccountType_1)
						.addComponent(lblEmployee))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(gl_EmployeeDetails.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSettingsE)
						.addComponent(btnLogOutE))
					.addGap(53))
		);
		EmployeeDetails.setLayout(gl_EmployeeDetails);
		
		btnAttendanceDetails = new JButton("Attendance Details");
		
		btnAttendanceDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAttendanceDetails.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/Attendance details.png")));
		
		btnSalaryStatement = new JButton("Salary Statement");
		
		btnSalaryStatement.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/salary.png")));
		btnSalaryStatement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnLeaveRequest = new JButton("Leave Request");
		
		btnLeaveRequest.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/Leave Request.png")));
		btnLeaveRequest.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnOldLeaves = new JButton("Old Leaves");
		btnOldLeaves.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnOldLeaves.setIcon(new ImageIcon(MainWindow.class.getResource("/resources/Details.png")));
		GroupLayout gl_EmployeeOptions = new GroupLayout(EmployeeOptions);
		gl_EmployeeOptions.setHorizontalGroup(
			gl_EmployeeOptions.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_EmployeeOptions.createSequentialGroup()
					.addGap(49)
					.addGroup(gl_EmployeeOptions.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnOldLeaves, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(btnLeaveRequest, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(btnSalaryStatement, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
						.addComponent(btnAttendanceDetails, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(64))
		);
		gl_EmployeeOptions.setVerticalGroup(
			gl_EmployeeOptions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_EmployeeOptions.createSequentialGroup()
					.addGap(58)
					.addComponent(btnAttendanceDetails)
					.addGap(34)
					.addComponent(btnSalaryStatement)
					.addGap(27)
					.addComponent(btnOldLeaves)
					.addGap(30)
					.addComponent(btnLeaveRequest)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		EmployeeOptions.setLayout(gl_EmployeeOptions);
		MainEmployee.setLayout(gl_MainEmployee);
	}
	

	public static class SerialTest implements SerialPortEventListener {
		SerialPort serialPort;
		public boolean flag = true;
	        /** The port we're normally going to use. */
		private static final String PORT_NAMES[] = { 
				"/dev/tty.usbserial-A9007UX1", // Mac OS X
	                        "/dev/ttyACM0", // Raspberry Pi
				"/dev/ttyUSB0", // Linux
				"COM3", // Windows
		};
		/**
		* A BufferedReader which will be fed by a InputStreamReader 
		* converting the bytes into characters 
		* making the displayed results codepage independent
		*/
		private BufferedReader input;
		/** The output stream to the port */
		private OutputStream output;
		/** Milliseconds to block while waiting for port open */
		private static final int TIME_OUT = 2000;
		/** Default bits per second for COM port. */
		private static final int DATA_RATE = 9600;
	
		int choice = 0;
		int id = 0;
		boolean check = false;
		public void params(int x, int val, boolean b) {
			choice = x;
			id = val;
			check = b;
		}
		
		public void initialize() {
	                // the next line is for Raspberry Pi and 
	                // gets us into the while loop and was suggested here was suggested https://www.raspberrypi.org/phpBB3/viewtopic.php?f=81&t=32186
	                //System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");
	
			CommPortIdentifier portId = null;
			Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
	
			//First, Find an instance of serial port as set in PORT_NAMES.
			while (portEnum.hasMoreElements()) {
				CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
				for (String portName : PORT_NAMES) {
					if (currPortId.getName().equals(portName)) {
						portId = currPortId;
						break;
					}
				}
			}
			if (portId == null) {
				System.out.println("Could not find COM port.");
				return;
			}
	
			try {
				// open serial port, and use class name for the appName.
				serialPort = (SerialPort) portId.open(this.getClass().getName(),
						TIME_OUT);
	
				// set port parameters
				serialPort.setSerialPortParams(DATA_RATE,
						SerialPort.DATABITS_8,
						SerialPort.STOPBITS_1,
						SerialPort.PARITY_NONE);
	
				// open the streams
				input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
				output = serialPort.getOutputStream();
	
				// add event listeners
				serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
	
		/**
		 * This should be called when you stop using the port.
		 * This will prevent port locking on platforms like Linux.
		 */
		public synchronized void close() {
			if (serialPort != null) {
				serialPort.removeEventListener();
				serialPort.close();
			}
		}
	
		/**
		 * Handle an event on the serial port. Read the data and print it.
		 */
		public synchronized void serialEvent(SerialPortEvent oEvent) {
			if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
				try {
					String inputLine=input.readLine();
					//System.out.println(inputLine);
	
					if(flag) {
						if(inputLine.matches("Waiting for valid finger to enroll as #\\d")) {
							dialog.lblAttendencePane.setText(inputLine);
						}
						else if(inputLine.equals("Select")) {
							dialog.lblAttendencePane.setText(inputLine);
							writetodevice(choice + "");
						}
						else if(inputLine.equals("Checking")) {
							dialog.lblAttendencePane.setText("Put finger on the Sensor");
						}
						else if(inputLine.equals("Ready, type ID")) {
							writetodevice(id + "");
						}
						else if(inputLine.matches("Found ID [\\d]+")){
							
							JOptionPane.showMessageDialog(null, inputLine);
							String[] temp = inputLine.split(" ");
							System.out.println(Integer.parseUnsignedInt(temp[2]));
							System.out.println(scan_id);
							if(scan_id == Integer.parseUnsignedInt(temp[2])) {
								JOptionPane.showMessageDialog(null, "Attendance Marked!");
								
							}
							else {
								JOptionPane.showMessageDialog(null, "Attendance Not Marked!");
							}
							close();
						}
						else if(inputLine.matches("No match found!")){
							JOptionPane.showMessageDialog(null, inputLine + " Attendence Not Marked");
							scan_id = 0;
							close();
						}
						else if(inputLine.matches("Waiting for valid finger to enroll as #\\d")) {
							JOptionPane.showMessageDialog(null, "Put finger on sensor!");
						}
						else if(inputLine.equals("Stored")) {
							close();
							JOptionPane.showMessageDialog(null, inputLine);
							if(addfinger) {
								Date x = new Date();
								java.sql.Date y = new java.sql.Date(x.getTime());
								PreparedStatement p = con.prepareStatement("INSERT INTO day_attendence (eid, att, today) VALUES (?, ?, ?)");
								p.setInt(1, id);
								p.setString(2, "F");
								p.setDate(3, y);
								int val = p.executeUpdate();
								if(val > 0) {
									JOptionPane.showMessageDialog(null, "Finger Print added successfully");
									con.commit();
									success = true;
									addfinger = false;
								}
								else {
									JOptionPane.showMessageDialog(null, "Fingerprint not added, try again!");
								}
								p.close();
								
							}
							System.out.println("1");
						}
						else if(inputLine.equals("Image taken")) {
							//dialog.lblAttendencePane.setText(inputLine);
						}
						else if(inputLine.equals("Image converted")) {
							//dialog.lblAttendencePane.setText(inputLine);
						}						
						else if(inputLine.equals("Remove finger")) {
							JOptionPane.showMessageDialog(null, "Remove finger!");
						}
						else if(inputLine.equals("Prints matched!")) {
							//dialog.lblAttendencePane.setText(inputLine);
						}
						else if(inputLine.equals("Place same finger again")) {
							JOptionPane.showMessageDialog(null, inputLine);
						}
						else {
							System.out.println(inputLine);
						}
					}
					
				} catch (Exception e) {
					dialog.lblAttendencePane.setText("Waiting for module to respond!");
				}
			}
			
			// Ignore all the other eventTypes, but you should consider the other ones.
		}
	
	
		public void writetodevice(String val) {
			try {
				output.write(val.getBytes());
	
				output.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
	}

	
	private class CheckTime implements Runnable {
		int i = 1;
		int numupdates = 0;
		@Override
		public void run() {
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost/emssystem?user=root&password=root");
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			Date d = new Date();
			java.sql.Date datefrom = new java.sql.Date(d.getTime());
			PreparedStatement ps;
			try {
				ps = con.prepareStatement("UPDATE day_attendence SET today = ?");
				ps.setDate(1, datefrom);
				ps.executeUpdate();
				ps.close();
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			while(true) {
				int hours = LocalTime.now().getHour();
				//System.out.println(hours);
				if(hours >= 20 && Attendanceflag && numupdates == 0) {
					try {
						Connection c = DriverManager.getConnection("jdbc:mysql://localhost/emssystem?user=root&password=root");
						Calendar today = Calendar.getInstance();
			            today.add(Calendar.DAY_OF_YEAR, i);
			            Date d1 = today.getTime();
						java.sql.Date sqldate = new java.sql.Date(d1.getTime());
						
						PreparedStatement p = c.prepareStatement("INSERT INTO attendence_" + (month - 1) + " (fordate, emp_id) SELECT today, eid FROM day_attendence WHERE att = 'F'");
						p.executeUpdate();
						p.close();
						
						PreparedStatement ps2 = c.prepareStatement("UPDATE day_attendence SET att = 'F', today = ?");
						ps2.setDate(1, sqldate);
						int x = ps2.executeUpdate();
						ps2.close();
						c.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					Attendanceflag = false;
					numupdates = 1;
				}
				if(hours >= 8 && hours < 20 && !Attendanceflag) {
					try {
						numupdates = 0;
						Connection c = DriverManager.getConnection("jdbc:mysql://localhost/emssystem?user=root&password=root");
						PreparedStatement p = c.prepareStatement("UPDATE day_attendence SET att = 'T', today = ? WHERE eid = ?");
						Calendar today = Calendar.getInstance();
			            today.add(Calendar.DAY_OF_YEAR, i - 1);
			            Date d1 = today.getTime();
						java.sql.Date d2 = new java.sql.Date(d1.getTime());
						p.setDate(1, d2);
						p.setInt(2, scan_id);
						int x = p.executeUpdate();
						p.close();
						c.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					Attendanceflag = true;
					if(!Attendanceflag)
						scan_id = -1;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}
	}
}
