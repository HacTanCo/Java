package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bo.hangbo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmaccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtsn;
	private JTextField txtuser;
	private JTextField txtps;
	public hangbo hb = new hangbo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmaccount frame = new frmaccount();
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
	public frmaccount() {
		setTitle("Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Servername");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(28, 40, 95, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(28, 90, 62, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(28, 125, 86, 24);
		contentPane.add(lblNewLabel_2);
		
		txtsn = new JTextField();
		txtsn.setBounds(162, 39, 143, 29);
		contentPane.add(txtsn);
		txtsn.setColumns(10);
		
		txtuser = new JTextField();
		txtuser.setBounds(162, 79, 143, 30);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		txtps = new JTextField();
		txtps.setBounds(162, 120, 143, 29);
		contentPane.add(txtps);
		txtps.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					if(e.getKeyCode()==10) {
						String sn = txtsn.getText().toString();
						String us = txtuser.getText().toString();
						String pw = txtps.getText().toString();
						hb.ketnoivaomay(sn, us, pw);
						JOptionPane.showMessageDialog(null,"Đã kết nối thành công !");
						frmbanhang frbh = new frmbanhang();
						frbh.setVisible(true);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String sn = txtsn.getText().toString();
					String us = txtuser.getText().toString();
					String pw = txtps.getText().toString();
					hb.ketnoivaomay(sn, us, pw);
					JOptionPane.showMessageDialog(null,"Đã kết nối thành công !");
					frmbanhang frbh = new frmbanhang();
					frbh.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(186, 163, 89, 29);
		contentPane.add(btnNewButton);
	}
}
