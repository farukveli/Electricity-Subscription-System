import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;

public class TesisatKayit extends JFrame {

	private JPanel contentPane;
	private JTextField tesisat_no;
	private JTextField karne_no;
	private JTextField sira_no;
	private JLabel lbl_KarneNo;
	private JLabel lbl_SiraNo;
	private JTextField kurulu_guc;
	private JTextField og_dur;
	private JTextField abone_no;

	
	public TesisatKayit(Connection conn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 384, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_TesisatNo = new JLabel("Tesisat No");
		lbl_TesisatNo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TesisatNo.setBounds(10, 11, 103, 25);
		panel.add(lbl_TesisatNo);
		
		lbl_KarneNo = new JLabel("Karne No");
		lbl_KarneNo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_KarneNo.setBounds(10, 57, 103, 25);
		panel.add(lbl_KarneNo);

		JLabel lbl_il = new JLabel("\u0130l");
		lbl_il.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_il.setBounds(10, 149, 103, 25);
		panel.add(lbl_il);
		
		lbl_SiraNo = new JLabel("S\u0131ra No");
		lbl_SiraNo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SiraNo.setBounds(10, 103, 103, 25);
		panel.add(lbl_SiraNo);

		JLabel lbl_ilce = new JLabel("\u0130l\u00E7e");
		lbl_ilce.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ilce.setBounds(10, 195, 103, 25);
		panel.add(lbl_ilce);

		JLabel lbl_tarife = new JLabel("Tarife");
		lbl_tarife.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tarife.setBounds(10, 287, 103, 25);
		panel.add(lbl_tarife);

		JLabel lbl_kuruluguc = new JLabel("Kurulu G\u00FC\u00E7");
		lbl_kuruluguc.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_kuruluguc.setBounds(10, 333, 103, 25);
		panel.add(lbl_kuruluguc);

		JLabel lbl_ogdur = new JLabel("OG_dur");
		lbl_ogdur.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ogdur.setBounds(10, 379, 103, 25);
		panel.add(lbl_ogdur);

		JLabel lbl_aboneno = new JLabel("Abone Numaras\u0131");
		lbl_aboneno.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_aboneno.setBounds(10, 430, 103, 25);
		panel.add(lbl_aboneno);

		JLabel lbl_mahalle = new JLabel("Mahalle");
		lbl_mahalle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mahalle.setBounds(10, 246, 103, 25);
		panel.add(lbl_mahalle);

		JLabel uyari = new JLabel("");
		uyari.setHorizontalAlignment(SwingConstants.CENTER);
		uyari.setFont(new Font("Ubuntu", Font.BOLD, 14));
		uyari.setBounds(20, 466, 297, 23);
		panel.add(uyari);
		
		tesisat_no = new JTextField();
		tesisat_no.setColumns(10);
		tesisat_no.setBounds(157, 6, 160, 35);
		tesisat_no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		panel.add(tesisat_no);
		
		karne_no = new JTextField();
		karne_no.setColumns(10);
		karne_no.setBounds(157, 52, 160, 35);
		karne_no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		panel.add(karne_no);
		
		sira_no = new JTextField();
		sira_no.setColumns(10);
		sira_no.setBounds(157, 98, 160, 35);
		sira_no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		panel.add(sira_no);
	
		JComboBox il = new JComboBox();
		il.setBounds(157, 144, 160, 35);
		String il_sorgu="Select isim from iller";
		il.addItem("Seçiniz...");
		il.setSelectedIndex(0);
		try {
			Statement s = conn.createStatement();
			ResultSet r = s.executeQuery(il_sorgu);
			while(r.next()) {
				il.addItem(r.getString(1));
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		il.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		
		panel.add(il);
		
		
		JComboBox ilce = new JComboBox();
		ilce.addItem("Seçiniz...");
		ilce.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String query_1="select isim from iller where id="+Integer.toString(il.getSelectedIndex());
				String il_adi ;
				uyari.setVisible(false);
				try {
					Statement s = conn.createStatement();
					ResultSet r = s.executeQuery(query_1);
					r.next();
					il_adi=r.getString(1);
					Locale trlocale = new Locale("tr","TR");
					il_adi=il_adi.toLowerCase(trlocale);
					String query_2="select ilce from "+ il_adi;
					r=s.executeQuery(query_2);
					while(r.next()) {
						ilce.addItem(r.getString(1));
					}
					ilce.setMaximumRowCount(10);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}

		});
		ilce.setBounds(157, 190, 160, 35);
		panel.add(ilce);

		JComboBox mahalle = new JComboBox();
		mahalle.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz..."}));
		mahalle.setSelectedIndex(0);
		mahalle.setBounds(157, 236, 160, 35);
		mahalle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		panel.add(mahalle);
		
		JComboBox tarife = new JComboBox();
		tarife.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "Mesken", "Ticari", "Sanayi", "Ayd\u0131nlatma", "Tar\u0131msal Sulama"}));
		tarife.setSelectedIndex(0);
		tarife.setBounds(157, 282, 160, 35);
		tarife.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		panel.add(tarife);
		
		kurulu_guc = new JTextField();
		kurulu_guc.setColumns(10);
		kurulu_guc.setBounds(157, 328, 160, 35);
		kurulu_guc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		panel.add(kurulu_guc);
		
		og_dur = new JTextField();
		og_dur.setColumns(10);
		og_dur.setBounds(157, 374, 160, 35);
		og_dur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		panel.add(og_dur);
		
		abone_no = new JTextField();
		abone_no.setColumns(10);
		abone_no.setBounds(157, 420, 160, 35);
		abone_no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		panel.add(abone_no);
		
		JButton kaydet = new JButton("Kaydet");
		kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(il.getSelectedIndex()==0) {
					uyari.setText("Lütfen Ýl Seçiniz!!!");
					uyari.setForeground(Color.red);
				}else if(ilce.getSelectedIndex()==0) {
					uyari.setText("Lütfen Ýlçe Seçiniz!!!");
					uyari.setForeground(Color.red);
				}else if(mahalle.getSelectedIndex()==0) {
					uyari.setText("Lütfen Mahalle Seçiniz!!!");
					uyari.setForeground(Color.red);
				}else if(tarife.getSelectedIndex()==0) {
					uyari.setText("Lütfen Tarife Durumu Seçiniz!!!");
					uyari.setForeground(Color.red);
				}else {
					try {
						int durum= new Tesisat().Tesisat_Ekle_Duzenle(conn, Integer.parseInt(tesisat_no.getText()),Integer.parseInt(karne_no.getText()),
								Integer.parseInt(sira_no.getText()), il.getSelectedIndex(),(String) ilce.getSelectedItem(),(String) mahalle.getSelectedItem(), 
								tarife.getSelectedIndex(), Integer.parseInt(kurulu_guc.getText()),Integer.parseInt(og_dur.getText()),
								Integer.parseInt(abone_no.getText()), 0);
						if(durum==-1) {
							uyari.setText(tesisat_no.getText()+"NO'lu Tesisat Kayýtlý!!!");
							uyari.setForeground(Color.red);
						}else if(durum == -2) {
							uyari.setText(karne_no.getText()+"NO'lu Karne Bulunamadý!!!");
							uyari.setForeground(Color.red);
						}else {
							uyari.setText(tesisat_no.getText()+"NO'lu Tesisat Kaydedild!!!");
							uyari.setForeground(Color.GREEN);
						}
						tesisat_no.setText("");
						karne_no.setText("");
						sira_no.setText("");
						il.setSelectedIndex(0);
						ilce.setSelectedIndex(0);
						mahalle.setSelectedIndex(0);
						tarife.setSelectedIndex(0);
						kurulu_guc.setText("");
						og_dur.setText("");
						abone_no.setText("");
					} catch (Exception e1) {
						uyari.setText("Lütfen Bütün Alanlarý Doldurunuz!!!");
						uyari.setForeground(Color.RED);
					}
				}
				uyari.setVisible(true);
			}
		});
		kaydet.setBounds(186, 497, 89, 23);
		panel.add(kaydet);
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		geri_don.setBounds(285, 497, 89, 23);
		panel.add(geri_don);
		
		
		
	}
}
