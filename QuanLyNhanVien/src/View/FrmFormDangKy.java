package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bo.ChucNangBo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JCheckBox;

public class FrmFormDangKy extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField pwfPass;
	private JPasswordField pwfConfirmPass;
	public ChucNangBo cnb = new ChucNangBo();
	public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private JTextField txtMNS;
	private JTextField txtName;
	private JTextField txtNS;
	private JTextField txtSDT;
	private JTextField txtLuong;
	private JTextField txtGT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFormDangKy frame = new FrmFormDangKy();
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
	public FrmFormDangKy() {
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(64, 385, 80, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(64, 425, 91, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(64, 465, 116, 14);
		contentPane.add(lblNewLabel_2);
		
		txtUser = new JTextField();
		txtUser.setBounds(205, 379, 145, 29);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		pwfPass = new JPasswordField();
		pwfPass.setBounds(205, 419, 145, 29);
		contentPane.add(pwfPass);
		
		pwfConfirmPass = new JPasswordField();
		pwfConfirmPass.setBounds(205, 459, 145, 29);
		contentPane.add(pwfConfirmPass);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String mans = txtMNS.getText().toString();
					String hvt = txtName.getText().toString();
					String gt = txtGT.getText().toString().toLowerCase();
					String ns = txtNS.getText().toString();
					String sdt = txtSDT.getText().toString();
					String luong = txtLuong.getText().toString();
					String user = txtUser.getText().toString();
					String pass = new String(pwfPass.getPassword());
					String confirm = new String(pwfConfirmPass.getPassword());
					cnb.ketnoi();
					
					if(cnb.checkma(user,mans) == true)
					{
						JOptionPane.showMessageDialog(null, "Tên tài khoản hoặc mã nhân sự đã tồn tại, vui lòng thử lại !");
                        return;
					}
						
					if(!pass.equals(confirm))
					{
						JOptionPane.showMessageDialog(null, "Mật khẩu không khớp, vui lòng thử lại !");
                        return;
					}
//					if(mans.isEmpty() || hvt.isEmpty() || gt.isEmpty() || ns.isEmpty() || sdt.isEmpty() || luong.isEmpty() || user.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
//						JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin !");
//                        return;
//					}
					
					String[] duyet = {mans, hvt, gt, ns, sdt, luong, user, pass, confirm};
					for(String i : duyet) {
						if(i.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin !");
	                        return;
						}
					}
					boolean gt1 = false;
					if(mans.substring(0,2).equals("NV")) {
						
						if(gt.equals("nam")) {
							gt1 = true;
						}
						else if(gt.equals("nữ")) {
							gt1 = false;
						}
						cnb.themNhanVien(mans, hvt, gt1, new Date(sdf.parse(ns).getTime()), sdt, Float.parseFloat(luong));
						cnb.dangKyTaiKhoan(user, pass, mans);
						JOptionPane.showMessageDialog(null, "Đã tạo tài khoản thành công !");
					}
					else if (mans.substring(0,2).equals("QL")) {
						if(gt.equals("nam")) {
							gt1 = true;
						}
						else if(gt.equals("nữ")) {
							gt1 = false;
						}
						cnb.themQuanLy(mans, hvt, gt1, new Date(sdf.parse(ns).getTime()), sdt, Float.parseFloat(luong));
						cnb.dangKyTaiKhoan(user, pass, mans);
						JOptionPane.showMessageDialog(null, "Đã tạo tài khoản thành công !");
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(225, 506, 89, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("\u0110\u0103ng K\u00FD T\u00E0i Kho\u1EA3n");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_3.setBounds(116, 11, 429, 37);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mã nhân sự");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(64, 109, 80, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Họ và tên");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(64, 154, 80, 18);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Giới Tính");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(82, 196, 62, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Ngày sinh");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(64, 221, 80, 26);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("SĐT");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(80, 297, 46, 20);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Mức lương");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(68, 328, 80, 23);
		contentPane.add(lblNewLabel_9);
		
		txtMNS = new JTextField();
		txtMNS.setBounds(205, 105, 145, 29);
		contentPane.add(txtMNS);
		txtMNS.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(205, 150, 145, 29);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtNS = new JTextField();
		txtNS.setBounds(205, 238, 145, 29);
		contentPane.add(txtNS);
		txtNS.setColumns(10);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(205, 288, 145, 29);
		contentPane.add(txtSDT);
		txtSDT.setColumns(10);
		
		txtLuong = new JTextField();
		txtLuong.setBounds(205, 325, 145, 29);
		contentPane.add(txtLuong);
		txtLuong.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("(Năm-Tháng-Ngày)");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(43, 248, 136, 19);
		contentPane.add(lblNewLabel_10);
		
		txtGT = new JTextField();
		txtGT.setBounds(205, 194, 145, 29);
		contentPane.add(txtGT);
		txtGT.setColumns(10);
	}
}
