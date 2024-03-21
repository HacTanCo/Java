package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.CanBoBean;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;

public class HienThi extends JFrame {

	private JPanel contentPane;
	private JTextField txtmcb;
	private JTextField txtht;
	private JTextField txthsl;
	private JTable table;
	void NapBang(ArrayList<CanBoBean> ds) {
		// tao mo hinh bang
		DefaultTableModel mh = new DefaultTableModel();
		// tao cot
		mh.addColumn("Mã cán bộ");
		mh.addColumn("Tên cán bộ");
		mh.addColumn("hệ số lương");
		for(CanBoBean i : ds) {
			Object[] che = {i.getMa(),i.getHoten(),i.getHsl()};
			mh.addRow(che);
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
					HienThi frame = new HienThi();
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
	ArrayList<CanBoBean> ds = new ArrayList<CanBoBean>();
	private JTable table_1;
	
	public HienThi() {
		setTitle("Hắc Tấn Có");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M\u00E3 c\u00E1n b\u1ED9");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(25, 123, 79, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(25, 161, 79, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("H\u1EC7 s\u1ED1 l\u01B0\u01A1ng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(25, 199, 105, 27);
		contentPane.add(lblNewLabel_2);
		
		txtmcb = new JTextField();
		txtmcb.setBounds(140, 120, 195, 30);
		contentPane.add(txtmcb);
		txtmcb.setColumns(10);
		
		txtht = new JTextField();
		txtht.setBounds(140, 161, 195, 30);
		contentPane.add(txtht);
		txtht.setColumns(10);
		
		txthsl = new JTextField();
		txthsl.setBounds(140, 199, 195, 30);
		contentPane.add(txthsl);
		txthsl.setColumns(10);
		
		JButton btnNewButton = new JButton("Lay danh sach");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FileReader f1 = new FileReader("cb.txt");
					BufferedReader r = new BufferedReader(f1);
					while (true) {
						String line = r.readLine();
						if (line == null || line == "")
							break;
						String[] che = line.split("[|]");
						String ma=che[0];
						String ht=che[1];
						double hsl = Double.parseDouble(che[2]);
						CanBoBean cb = new CanBoBean(ma, ht, hsl);
						ds.add(cb);
					}
					r.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				NapBang(ds);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(164, 252, 156, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String x = txtht.getText().trim().toLowerCase();
				int dem=0;
				for(CanBoBean i : ds) {
					if(i.getHoten().trim().toLowerCase().equals(x)) {
						dem++;
						JOptionPane.showMessageDialog(null, "Đã tìm thấy:\n" +i.getMa()+"|"+i.getHoten()+"|"+i.getHsl());
						break;
					}
				}
				if(dem==0) {
					JOptionPane.showMessageDialog(null, "Không có trong list !!!\n");
				}
			}
		});

		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(164, 288, 156, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String xoamh = txtmcb.getText().trim().toLowerCase();
				for(CanBoBean i : ds)
					if(i.getMa().trim().toLowerCase().equals(xoamh)) {
						ds.remove(i);
						NapBang(ds);
						txtmcb.setText("");
						txtht.setText("");
						txthsl.setText("");
						break;
					}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(164, 322, 156, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Sum luong");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double sum=0;
				for(CanBoBean i : ds) {
					sum+= i.luong();
				}
				JOptionPane.showMessageDialog(null, "Tổng lương của cán bộ: "+sum+" VNĐ");
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_3.setBounds(164, 356, 156, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Add");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ma = txtmcb.getText().toString();
				String ht = txtht.getText().toString();
				String x = txthsl.getText().toString();
				double hsl = Double.parseDouble(x);
				CanBoBean cb = new CanBoBean(ma, ht, hsl);
				ds.add(cb);
				NapBang(ds);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_4.setBounds(164, 390, 156, 23);
		contentPane.add(btnNewButton_4);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(376, 65, 485, 400);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Cán Bộ", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Cán bộ 1", null, scrollPane_1, null);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		
	}
}
