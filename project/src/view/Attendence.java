package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Attendence extends JDialog {
	public JButton btnPunchIn;
	public JComboBox comboBox;
	public JLabel lblAttendencePane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Attendence dialog = new Attendence();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Attendence() {
		getContentPane().setForeground(new Color(248, 248, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Attendence.class.getResource("/resources/ems main.png")));
		setTitle("Attendance");

		initComponents();
		createEvents();
	}

	private void createEvents() {
		// TODO Auto-generated method stub
		// TODO add punch in function
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 490, 337);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Attendence.class.getResource("/resources/att_icon.png")));
		
		JLabel lblEmployee = new JLabel("Employee :");
		lblEmployee.setFont(new Font("Tempus Sans ITC", Font.BOLD, 18));
		
		comboBox = new JComboBox();
		
		btnPunchIn = new JButton("Punch In");
		
		lblAttendencePane = new JLabel("Attendence Pane");
		lblAttendencePane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(107)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(184)
							.addComponent(btnPunchIn)))
					.addContainerGap(117, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblEmployee)
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addGap(43))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(162)
					.addComponent(lblAttendencePane)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblAttendencePane)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmployee))
					.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
					.addComponent(btnPunchIn)
					.addGap(32))
		);
		getContentPane().setLayout(groupLayout);
	}
}
