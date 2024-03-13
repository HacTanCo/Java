package Ltgd;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class srmquanly extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtmh;
	private JTextField txtth;
	private JTextField txtg;
	private JTextField txtsl;
	private JTable table;

	void NapBang(ArrayList<String> ds) {
		// tao mo hinh bang
		DefaultTableModel mh = new DefaultTableModel();
		// tao cot
		mh.addColumn("Mã hàng");
		mh.addColumn("Tên hàng");
		mh.addColumn("Giá");
		mh.addColumn("Số lượng");
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
		mh.addColumn("Mã hàng");
		mh.addColumn("Tên hàng");
		mh.addColumn("Giá");
		mh.addColumn("Số lượng");
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
					srmquanly frame = new srmquanly();
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

	public srmquanly() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileReader f1 = new FileReader("quanly.txt");
					BufferedReader r = new BufferedReader(f1);
					while (true) {
						String st = r.readLine();
						if (st == null || st == "")
							break;
//						System.out.println(st);
						// them 1 phan tu vao mang
						ds2.add(st);
					}
					r.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				NapBang(ds2);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtmh = new JTextField();
		txtmh.setBounds(130, 28, 267, 20);
		contentPane.add(txtmh);
		txtmh.setColumns(10);

		txtth = new JTextField();
		txtth.setBounds(130, 66, 267, 20);
		contentPane.add(txtth);
		txtth.setColumns(10);

		txtg = new JTextField();
		txtg.setBounds(130, 109, 267, 20);
		contentPane.add(txtg);
		txtg.setColumns(10);

		txtsl = new JTextField();
		txtsl.setBounds(130, 155, 267, 20);
		contentPane.add(txtsl);
		txtsl.setColumns(10);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mh = txtmh.getText().toString();
				String th = txtth.getText().toString();
				String g = txtg.getText().toString();
				String sl = txtsl.getText().toString();
				String tt = mh + ";" + th + ";" + g + ";" + sl;
				ds2.add(tt);
				NapBang2(ds2);

				
			}
		});
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String xoamh = txtmh.getText().trim().toLowerCase();
				for (int i = 0; i < ds2.size(); i++) {
					String[] t = ds2.get(i).split("[;]");
					if (t[0].equals(xoamh)) {
						ds2.remove(i);
						NapBang2(ds2);
						txtmh.setText("");
						txtth.setText("");
						txtg.setText("");
						txtsl.setText("");
						break;
					}
				}
			}
		});
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String capnhatmh = txtmh.getText().trim().toLowerCase();
				for (int i = 0; i < ds2.size(); i++) {
					String[] t = ds2.get(i).split(";");
					if ( t[0].equals(capnhatmh)) {
						ds2.remove(i);
						String mh = txtmh.getText().toString();
						String th = txtth.getText().toString();
						String g = txtg.getText().toString();
						String sl = txtsl.getText().toString();
						String mh1 = mh + ";" + th + ";" + g + ";" + sl;
						ds2.add(mh1);
						NapBang2(ds2);
						txtmh.setText("");
						txtth.setText("");
						txtg.setText("");
						txtsl.setText("");
						break;
					}
				}
			}
		});
		JButton btnNewButton_3 = new JButton("Find");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String x = txtmh.getText().trim().toLowerCase();
				int dem=0;
				for (int i = 0; i < ds2.size(); i++) {
					String[] t = ds2.get(i).split(";");
					if ( t[0].equals(x)) {
						dem++;
						JOptionPane.showMessageDialog(null, "Đã tìm thấy:\n" + ds2.get(i));
						break;
					}
				}
				if(dem==0) {
					JOptionPane.showMessageDialog(null, "Không có trong file !!!\n");
				}
			}
		});
		JButton btnNewButton_4 = new JButton("Save file");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FileWriter f = new FileWriter("quanly.txt", false);
					PrintWriter ghi = new PrintWriter(f);
					for (String i : ds2) {
						ghi.println(i);
					}

					ghi.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Đã Lưu");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(0, 212, 89, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(99, 212, 89, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(198, 212, 89, 23);
		contentPane.add(btnNewButton_2);

		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(308, 212, 89, 23);
		contentPane.add(btnNewButton_3);

		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(423, 212, 104, 23);
		contentPane.add(btnNewButton_4);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(26, 261, 778, 337);
		contentPane.add(tabbedPane);

		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Ds các hàng", null, scrollPane, null);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Mã hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(26, 31, 80, 27);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(26, 69, 80, 17);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Giá");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(26, 106, 63, 23);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Số lượng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(26, 146, 63, 34);
		contentPane.add(lblNewLabel_3);
	}
}