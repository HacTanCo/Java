package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Bo.ChucNangBo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmFormDoiMatKhau extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public FrmFormDangNhap frmdn = new FrmFormDangNhap();
	public static String user;
	public static String pass;
	private JPasswordField pwmkc;
	private JPasswordField pwmkm;
	private JPasswordField pwnlmk;
	public ChucNangBo cnb = new ChucNangBo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFormDoiMatKhau frame = new FrmFormDoiMatKhau(user,pass);
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
	public FrmFormDoiMatKhau(String userLogin,String passLogin) {
		user = userLogin;
		pass = passLogin;
		System.out.println(user+" "+pass);
		setTitle("Đổi Mật Khẩu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đổi Mật Khẩu");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(72, 11, 287, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu cũ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(65, 91, 84, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mật khẩu mới");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(60, 134, 100, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nhập lại mật khẩu");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(32, 179, 126, 21);
		contentPane.add(lblNewLabel_3);
		
		pwmkc = new JPasswordField();
		pwmkc.setBounds(185, 87, 149, 30);
		contentPane.add(pwmkc);
		
		pwmkm = new JPasswordField();
		pwmkm.setBounds(185, 130, 149, 30);
		contentPane.add(pwmkm);
		
		pwnlmk = new JPasswordField();
		pwnlmk.setBounds(185, 175, 149, 30);
		contentPane.add(pwnlmk);
		
		JButton btnNewButton = new JButton("Đổi mật khẩu");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String mkc = new String(pwmkc.getPassword());
					String mkm = new String(pwmkm.getPassword());
					String nlmk = new String(pwnlmk.getPassword());
					cnb.ketnoi();
					String[] duyet = {mkc,mkm,nlmk};
					for (String i : duyet) {
						if(i.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin !");
	                        return;
						}
					}
					if(!pass.equals(mkc)) {
						JOptionPane.showMessageDialog(null, "Mật khẩu cũ không khớp với mật khẩu hiện tại !");
						return;
					}
					else if(!mkm.equals(nlmk)) {
						JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại không khớp !");
						return;
					}
					else {
						cnb.doiMatKhau(user, mkm, pass);
						JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công !");
						return;
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e2.getMessage());
					return;
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(150, 237, 122, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quay lại");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					setVisible(false);
//					if(pwmkm.getPassword() == null) {
//						pass = 
//					}
					pass = new String(pwmkm.getPassword());
					FrmMenu frmmn = new FrmMenu(user, pass);
					frmmn.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e2.getMessage());
					return;
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(282, 237, 122, 35);
		contentPane.add(btnNewButton_1);
	}
}
