package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bo.ChucNangBo;
import Dao.ChucNangDao;
import Dao.KetNoiSqlDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmFormDangNhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField pwfPass;
	public ChucNangBo cnb = new ChucNangBo();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFormDangNhap frame = new FrmFormDangNhap();
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
	public FrmFormDangNhap() {
		setTitle("Đăng Nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(35, 75, 76, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(35, 118, 73, 23);
		contentPane.add(lblNewLabel_1);
		
		txtUser = new JTextField();
		txtUser.setBounds(121, 71, 171, 32);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JButton btnNewButton = new JButton("Đăng Nhập");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				try {
					String user = txtUser.getText().toString().toLowerCase();
					String pass = new String(pwfPass.getPassword());
					cnb.ketnoi();
					if (cnb.checkDangNhap(user, pass) == true) 
					{
						JOptionPane.showMessageDialog(null,"Đăng nhập thành công !");
					} 
					else 
					{
						JOptionPane.showMessageDialog(null,"Sai tài khoản hoặc mật khẩu !");
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null,"Lỗi trong quá trình đăng nhập !");
				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(147, 157, 131, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Đăng Ký");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				
				FrmFormDangKy frmdk = new FrmFormDangKy();
				frmdk.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(147, 200, 131, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome Back To Work");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(32, 11, 389, 49);
		contentPane.add(lblNewLabel_2);
		
		pwfPass = new JPasswordField();
		pwfPass.setBounds(121, 114, 171, 32);
		contentPane.add(pwfPass);
	}
}
