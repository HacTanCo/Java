package Ltgd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class srmmaytinh extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txta;
	private JTextField txtb;
	private JTextField txtkq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					srmmaytinh frame = new srmmaytinh();
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
	public srmmaytinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("A = ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(33, 71, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("B =");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(33, 108, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("KQ =");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(33, 152, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txta = new JTextField();
		txta.setBounds(80, 70, 123, 20);
		contentPane.add(txta);
		txta.setColumns(10);
		
		txtb = new JTextField();
		txtb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==10)
				{
					Double a=Double.parseDouble(txta.getText());
					Double b=Double.parseDouble(txtb.getText());
					Double kq=a+b;
					txtkq.setText(kq.toString());
				}
				if(e.getKeyCode()==27)
				{
					System.exit(1);
				}
			}
		});
		txtb.setBounds(80, 107, 123, 20);
		contentPane.add(txtb);
		txtb.setColumns(10);
		
		txtkq = new JTextField();
		txtkq.setBounds(80, 146, 123, 20);
		contentPane.add(txtkq);
		txtkq.setColumns(10);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Double a=Double.parseDouble(txta.getText());
				Double b=Double.parseDouble(txtb.getText());
				Double kq=a+b;
				txtkq.setText(kq.toString());
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 198, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Double a=Double.parseDouble(txta.getText());
				Double b=Double.parseDouble(txtb.getText());
				Double kq=a-b;
				txtkq.setText(kq.toString());
			}
		});
		btnNewButton_1.setBounds(109, 198, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("*");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Double a=Double.parseDouble(txta.getText());
				Double b=Double.parseDouble(txtb.getText());
				Double kq=a*b;
				txtkq.setText(kq.toString());
			}
		});
		btnNewButton_2.setBounds(208, 198, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("/");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Double a=Double.parseDouble(txta.getText());
				Double b=Double.parseDouble(txtb.getText());
				if(b==0)
				{
//					txtkq.setText("Loi");
					JOptionPane.showMessageDialog(null, "Loi");
				}
				else
				{
					Double kq=a/b;
					txtkq.setText(kq.toString());
				}
				
			}
		});
		btnNewButton_3.setBounds(305, 198, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}