package View;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.cj.jdbc.JdbcStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Helper.*;
import Model.Yönetici;
public class LoginGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2049047014657374168L;
	private JLabel mesaj;
	private JPanel w_pane;
	private JTextField lblTc1;
	
	private JPasswordField fld_YöneticiPass;
	private JTextField fld_YöneticiTc;
    private  JLabel lb_label;
    private JTextField fldTc;
    private DBConnection conn = new DBConnection();
    private JPasswordField fldPass;
    private JPasswordField passwordField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 446);
		w_pane = new JPanel();
		w_pane.setBackground(new Color(255, 255, 255));
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lb_label = new JLabel(new ImageIcon(getClass().getResource("car.png")));
		lb_label.setBounds(114, 10, 232, 135);
		w_pane.add(lb_label);
		
		JLabel lblNewLabel = new JLabel("Araba Kiralama Şirketi Sistemine Hoşgeldiniz");
		lblNewLabel.setForeground(new Color(232, 75, 0));
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		lblNewLabel.setBounds(55, 161, 396, 25);
		w_pane.add(lblNewLabel);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(24, 196, 443, 197);
		w_pane.add(tabbedPane);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Müşteri Girişi", null, panel, null);
		panel.setLayout(null);
		
		
		
		
		JLabel fld_MüşteriTc = new JLabel("T.C. Numaranız:");
		fld_MüşteriTc.setBounds(10, 10, 156, 25);
		fld_MüşteriTc.setForeground(new Color(0, 0, 0));
		fld_MüşteriTc.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		panel.add(fld_MüşteriTc);

		JLabel fld_MüşteriPa = new JLabel("Parola :");
		fld_MüşteriPa.setBounds(10, 45, 156, 25);
		fld_MüşteriPa.setForeground(Color.BLACK);
		fld_MüşteriPa.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		panel.add(fld_MüşteriPa);

		lblTc1 = new JTextField();
		lblTc1.setBounds(194, 10, 180, 36);
		lblTc1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		panel.add(lblTc1);
		lblTc1.setColumns(10);

		JButton btn_kayıt = new JButton("Kayıt Ol");
		btn_kayıt.setBackground(new Color(244, 80, 0));
		btn_kayıt.setBounds(39, 124, 140, 36);
		btn_kayıt.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		panel.add(btn_kayıt);

		JButton btn_giriş = new JButton("Giriş");
		btn_giriş.setBackground(new Color(244, 80, 0));
		btn_giriş.setBounds(234, 124, 140, 36);
		btn_giriş.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_giriş.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		panel.add(btn_giriş);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(194, 56, 180, 36);
		panel.add(passwordField_1);

		JPanel p_2 = new JPanel();
		p_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Yönetici Girişi", null, p_2, null);
		p_2.setLayout(null);

		JPanel pn_yönetici = new JPanel();
		pn_yönetici.setLayout(null);
		pn_yönetici.setBackground(Color.WHITE);
		pn_yönetici.setBounds(0, 0, 438, 170);
		p_2.add(pn_yönetici);

		JLabel fld_Yönetici = new JLabel("T.C. Numaranız:");
		fld_Yönetici.setForeground(Color.BLACK);
		fld_Yönetici.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		fld_Yönetici.setBounds(10, 10, 156, 25);
		pn_yönetici.add(fld_Yönetici);

		JLabel fld_YöneticiP = new JLabel("Parola :");
		fld_YöneticiP.setForeground(Color.BLACK);
		fld_YöneticiP.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		fld_YöneticiP.setBounds(10, 45, 156, 25);
		pn_yönetici.add(fld_YöneticiP);

		

		JButton btn_YöneticiG = new JButton("Giriş");
		btn_YöneticiG.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(fldTc.getText().length()== 0 || fldPass.getText().length() == 0 ) {
					Helper.showMsg("fill");
				}else {
						
						try {
							Connection con = conn.connDb();
						
							Statement st =  con.createStatement();
							ResultSet rs = st.executeQuery("SELECT * FROM user");
							while(rs.next()) {
								if(fldTc.getText().equals(rs.getString("tcno")) && fldPass.getText().equals(rs.getString("password"))) {}
							   Yönetici yönetici = new Yönetici();
							   yönetici.setId(rs.getInt("id"));
							    yönetici.setPassword("password");
							   yönetici.setTcno(rs.getString("tcno"));
							  yönetici.setName(rs.getString("name"));
							  yönetici.setType(rs.getString("type"));
							  System.out.println(yönetici.getName());
							
							
							}
							
							
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
				}
			}
			
		});
		
		
		btn_YöneticiG.setBackground(new Color(244, 80, 0));
		btn_YöneticiG.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		btn_YöneticiG.setBounds(27, 116, 346, 44);
		pn_yönetici.add(btn_YöneticiG);
		
		fldTc = new JTextField();
		fldTc.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		fldTc.setBounds(194, 10, 180, 36);
		pn_yönetici.add(fldTc);
		fldTc.setColumns(10);
		
		fldPass = new JPasswordField();
		fldPass.setBounds(194, 56, 180, 36);
		pn_yönetici.add(fldPass);
	}
	}


