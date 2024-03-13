package Ltgd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class srmbanhang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtgia;
	private JTextField txtslton;
	private JTextField txtslmua;
	private JTextField txtthanhtien;
	JComboBox cmbhang = new JComboBox();

	void NapBang(ArrayList<String> ds) {
		// tao mo hinh bang
		DefaultTableModel mh = new DefaultTableModel();
		// tao cot
		mh.addColumn("Ma hang");
		mh.addColumn("Ten hang");
		mh.addColumn("So luong");
		mh.addColumn("Gia");
//		Object[] t = new Object[4];
//		t[0]="mh1";t[1]="abc";t[2]=10;t[3]=10000;
		for (String i : ds) {
			String[] t = i.split("[;]");
			mh.addRow(t);
		}
		// Dua mo hinh vao Jtable
		table.setModel(mh);
	}
	void NapBang2(ArrayList<String> ds2) {
		// tao mo hinh bang
		DefaultTableModel mh = new DefaultTableModel();
		// tao cot
		mh.addColumn("Ten hang");
		mh.addColumn("So luong");
		mh.addColumn("Gia");
		mh.addColumn("Thanh tien");
		mh.addColumn("Ngay");
		for (String i : ds2) {
			String[] t = i.split("[;]");
			mh.addRow(t);
		}
		// Dua mo hinh vao Jtable
		table.setModel(mh);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					srmbanhang frame = new srmbanhang();
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
	ArrayList<String> ds = new ArrayList<String>();
	ArrayList<String> ds2 = new ArrayList<String>();
	private JTable table;

	public srmbanhang() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
//				cmbhang.addItem("Xang");
//				cmbhang.addItem("Dau");
//				cmbhang.addItem("Xi Mang");
//				cmbhang.addItem("Nhot");
//				cmbhang.addItem("Thep");
				try {
					FileReader f1 = new FileReader("hang.txt");
					BufferedReader r = new BufferedReader(f1);
					while (true) {
						String st = r.readLine();
						if (st == null || st == "")
							break;
						System.out.println(st);
						// them 1 phan tu vao mang
						cmbhang.addItem(st.split("[;]")[1]);
						ds.add(st);
					}
					r.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				NapBang(ds);

			}

		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Chọn Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(25, 43, 107, 29);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Giá");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(25, 83, 86, 26);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Số Lượng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(25, 120, 86, 27);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nhập SL");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(25, 158, 86, 26);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Thành Tiền");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(25, 195, 86, 19);
		contentPane.add(lblNewLabel_4);
		cmbhang.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String th = cmbhang.getSelectedItem().toString();
				for (String i : ds) {
					String[] t = i.split("[;]");
					if (t[1].equals(th)) {
						txtslton.setText(t[2]);
						txtgia.setText(t[3]);
					}
				}
			}
		});

		cmbhang.setBounds(144, 43, 153, 22);
		contentPane.add(cmbhang);

		txtgia = new JTextField();
		txtgia.setBounds(144, 82, 153, 20);
		contentPane.add(txtgia);
		txtgia.setColumns(10);

		txtslton = new JTextField();
		txtslton.setBounds(144, 119, 153, 20);
		contentPane.add(txtslton);
		txtslton.setColumns(10);

		txtslmua = new JTextField();
		txtslmua.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					Double a = Double.parseDouble(txtgia.getText());
					Double b = Double.parseDouble(txtslmua.getText());
					Double kq = a * b;
					txtthanhtien.setText(kq.toString());
				}
				if (e.getKeyCode() == 27) {
					System.exit(1);
				}
			}
		});
		txtslmua.setBounds(144, 157, 153, 20);
		contentPane.add(txtslmua);
		txtslmua.setColumns(10);

		txtthanhtien = new JTextField();
		txtthanhtien.setBounds(144, 194, 153, 20);
		contentPane.add(txtthanhtien);
		txtthanhtien.setColumns(10);

		JButton btnNewButton = new JButton("Bán");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mh = cmbhang.getSelectedItem().toString();
				String g = txtgia.getText().toString();
				String sl = txtslmua.getText().toString();
				String tien = txtthanhtien.getText().toString();
				Date n = new Date();
				SimpleDateFormat dd = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				String ngay=dd.format(n);
				String tt = mh + ";" + sl + ";" + g + ";" + (Double.parseDouble(sl) * Double.parseDouble(g)) + ";" + ngay;
				ds2.add(tt);
				NapBang2(ds2);
				try {
					FileWriter f = new FileWriter("save.txt", true);
					PrintWriter ghi = new PrintWriter(f);
					ghi.println(tt);
					ghi.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Double a = Double.parseDouble(txtgia.getText());
				Double b = Double.parseDouble(txtslmua.getText());
				Double kq = a * b;
				txtthanhtien.setText(kq.toString());
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(154, 227, 123, 23);
		contentPane.add(btnNewButton);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 281, 630, 196);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}