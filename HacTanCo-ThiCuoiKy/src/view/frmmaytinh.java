package view;

import java.awt.EventQueue;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.maytinhbanbean;
import bean.maytinhbean;
import bean.maytinhxachtaybean;
import bo.maytinhbo;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class frmmaytinh extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	public maytinhbo mtb = new maytinhbo();
	private JTextField txtmm;
	private JTextField txtsl;
	
	public void napbangfile(ArrayList<maytinhbean> ds) {
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Cot 1");
		dtm.addColumn("Cot 2");
		dtm.addColumn("Cot 3");
		dtm.addColumn("Cot 4");
		dtm.addColumn("Cot 5");
		dtm.addColumn("Cot 6");
		dtm.addColumn("Cot 7");
		for(maytinhbean i : ds) {
			if(i instanceof maytinhxachtaybean) {
				dtm.addRow(i.toString().split("[;]"));
			}
			else if( i instanceof maytinhbanbean) {
				dtm.addRow(i.toString().split("[;]"));
			}
		}
		table.setModel(dtm);
	}
	public void napbangxachtay(ArrayList<maytinhbean> ds) {
		//String mm, String tm, Date nnh, float gia, int sl, String mau, float kcmh
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma may");
		dtm.addColumn("Ten may");
		dtm.addColumn("Ngay nhap hang");
		dtm.addColumn("Gia");
		dtm.addColumn("So luong");
		dtm.addColumn("Mau");
		dtm.addColumn("Kich co man hinh");
		for(maytinhbean i : ds) {
			if(i instanceof maytinhxachtaybean) {
				dtm.addRow(i.toString().split("[;]"));
			}
		}
		table_1.setModel(dtm);
	}
	public void napbangban(ArrayList<maytinhbean> ds) {
		//String mm, String tm, Date nnh, float gia, int sl, String tncc
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Ma may");
		dtm.addColumn("Ten may");
		dtm.addColumn("Ngay nhap hang");
		dtm.addColumn("Gia");
		dtm.addColumn("So luong");
		dtm.addColumn("Ten nha cung cap");
		for(maytinhbean i : ds) {
			if(i instanceof maytinhbanbean) {
				dtm.addRow(i.toString().split("[;]"));
			}
		}
		table_2.setModel(dtm);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmmaytinh frame = new frmmaytinh();
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
	public frmmaytinh() throws Exception{
		mtb.ketnoi();
		mtb.infile();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 869, 418);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Danh Sach File", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Danh Sach MTXachTay", null, scrollPane_1, null);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("Danh Sach MTBan", null, scrollPane_2, null);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JButton btnNewButton = new JButton("Lay FILE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					napbangfile(mtb.ds());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(48, 538, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("DS MTXachTay");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					napbangxachtay(mtb.ds());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(224, 538, 138, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DS MTBan");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					napbangban(mtb.ds());
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(432, 538, 118, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Thanh Tien");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String mm = txtmm.getText().toString();
					int sl = Integer.parseInt(txtsl.getText());
					mtb.buycomputer(mm, sl);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(590, 538, 138, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Ma may");
		lblNewLabel.setBounds(45, 466, 66, 17);
		contentPane.add(lblNewLabel);
		
		txtmm = new JTextField();
		txtmm.setBounds(121, 464, 118, 20);
		contentPane.add(txtmm);
		txtmm.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("So luong");
		lblNewLabel_1.setBounds(296, 467, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		txtsl = new JTextField();
		txtsl.setBounds(397, 464, 105, 20);
		contentPane.add(txtsl);
		txtsl.setColumns(10);
	}
}
