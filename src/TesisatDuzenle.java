import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TesisatDuzenle extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField tesisat_no;
	private JTextField karne_no;
	private JTextField sira_no;
	private JLabel lbl_KarneNo;
	private JLabel lbl_SiraNo;
	private JTextField kurulu_guc;
	private JTextField og_dur;
	private JTextField abone_no;

	
	public TesisatDuzenle(Connection conn,JPanel islem_ekran) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 384, 531);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 384, 531);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton kaydet = new JButton("Kaydet");
		kaydet.setBackground(new Color(0, 128, 0));
		kaydet.setForeground(new Color(176, 224, 230));
		
		JLabel lbl_TesisatNo = new JLabel("Tesisat No");
		lbl_TesisatNo.setForeground(new Color(0, 139, 139));
		lbl_TesisatNo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TesisatNo.setBounds(10, 11, 103, 25);
		panel.add(lbl_TesisatNo);
		
		lbl_KarneNo = new JLabel("Karne No");
		lbl_KarneNo.setForeground(new Color(0, 139, 139));
		lbl_KarneNo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_KarneNo.setBounds(10, 57, 103, 25);
		lbl_KarneNo.setVisible(false);
		panel.add(lbl_KarneNo);

		JLabel lbl_il = new JLabel("\u0130l");
		lbl_il.setForeground(new Color(0, 139, 139));
		lbl_il.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_il.setBounds(10, 149, 103, 25);
		lbl_il.setVisible(false);
		panel.add(lbl_il);
		
		lbl_SiraNo = new JLabel("S\u0131ra No");
		lbl_SiraNo.setForeground(new Color(0, 139, 139));
		lbl_SiraNo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SiraNo.setBounds(10, 103, 103, 25);
		lbl_SiraNo.setVisible(false);
		panel.add(lbl_SiraNo);

		JLabel lbl_ilce = new JLabel("\u0130l\u00E7e");
		lbl_ilce.setForeground(new Color(0, 139, 139));
		lbl_ilce.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ilce.setBounds(10, 195, 103, 25);
		lbl_ilce.setVisible(false);
		panel.add(lbl_ilce);

		JLabel lbl_tarife = new JLabel("Tarife");
		lbl_tarife.setForeground(new Color(0, 139, 139));
		lbl_tarife.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tarife.setBounds(10, 287, 103, 25);
		lbl_tarife.setVisible(false);
		panel.add(lbl_tarife);

		JLabel lbl_kuruluguc = new JLabel("Kurulu G\u00FC\u00E7");
		lbl_kuruluguc.setForeground(new Color(0, 139, 139));
		lbl_kuruluguc.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_kuruluguc.setBounds(10, 333, 103, 25);
		lbl_kuruluguc.setVisible(false);
		panel.add(lbl_kuruluguc);

		JLabel lbl_ogdur = new JLabel("OG_dur");
		lbl_ogdur.setForeground(new Color(0, 139, 139));
		lbl_ogdur.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ogdur.setBounds(10, 379, 103, 25);
		lbl_ogdur.setVisible(false);
		panel.add(lbl_ogdur);

		JLabel lbl_aboneno = new JLabel("Abone Numaras\u0131");
		lbl_aboneno.setForeground(new Color(0, 139, 139));
		lbl_aboneno.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_aboneno.setBounds(10, 430, 103, 25);
		lbl_aboneno.setVisible(false);
		panel.add(lbl_aboneno);

		JLabel lbl_mahalle = new JLabel("Mahalle");
		lbl_mahalle.setForeground(new Color(0, 139, 139));
		lbl_mahalle.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mahalle.setBounds(10, 246, 103, 25);
		lbl_mahalle.setVisible(false);
		panel.add(lbl_mahalle);

		JLabel uyari = new JLabel("");
		uyari.setHorizontalAlignment(SwingConstants.CENTER);
		uyari.setFont(new Font("Ubuntu", Font.BOLD, 14));
		uyari.setBounds(20, 466, 297, 23);
		uyari.setVisible(false);
		panel.add(uyari);
		
		tesisat_no = new JTextField();
		tesisat_no.setForeground(new Color(176, 224, 230));
		tesisat_no.setBackground(new Color(0, 139, 139));
		tesisat_no.setColumns(10);
		tesisat_no.setBounds(140, 6, 160, 35);
		tesisat_no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		panel.add(tesisat_no);
		
		karne_no = new JTextField();
		karne_no.setForeground(new Color(176, 224, 230));
		karne_no.setBackground(new Color(0, 139, 139));
		karne_no.setColumns(10);
		karne_no.setBounds(140, 52, 160, 35);
		karne_no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		karne_no.setVisible(false);
		panel.add(karne_no);
		
		sira_no = new JTextField();
		sira_no.setForeground(new Color(176, 224, 230));
		sira_no.setBackground(new Color(0, 139, 139));
		sira_no.setColumns(10);
		sira_no.setBounds(140, 98, 160, 35);
		sira_no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		sira_no.setVisible(false);
		panel.add(sira_no);
	
		JComboBox il = new JComboBox();
		il.setForeground(new Color(176, 224, 230));
		il.setBackground(new Color(0, 139, 139));
		JComboBox ilce = new JComboBox();
		ilce.setForeground(new Color(176, 224, 230));
		ilce.setBackground(new Color(0, 139, 139));
		JComboBox mahalle = new JComboBox();
		mahalle.setForeground(new Color(176, 224, 230));
		mahalle.setBackground(new Color(0, 139, 139));
		il.setBounds(140, 144, 160, 35);
		String il_sorgu="Select isim from iller";
		il.addItem("Seçiniz...");
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
				ilce.removeAllItems();
				ilce.addItem("Seçiniz...");
				ilce.setSelectedIndex(0);
				ilce.setEnabled(true);
				mahalle.setEnabled(false);
				mahalle.removeAllItems();
				mahalle.addItem("Seçiniz...");
				mahalle.setSelectedIndex(0);
				
			}
		});
		il.setVisible(false);
		panel.add(il);
		
		ilce.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String il_adi=il.getSelectedItem().toString();
				uyari.setVisible(false);
				ilce.removeAllItems();
				ilce.addItem("Seçiniz...");
				ilce.setSelectedIndex(0);
				mahalle.removeAllItems();
				mahalle.addItem("Seçiniz...");
				mahalle.setSelectedIndex(0);
				ilceleriListele(il_adi, ilce,  mahalle,conn);
			}

		});
		ilce.setBounds(140, 190, 160, 35);
		ilce.setVisible(false);
		panel.add(ilce);

		mahalle.setBounds(140, 236, 160, 35);
		mahalle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ilce_adi= ilce.getSelectedItem().toString();
				uyari.setVisible(false);
				mahalle.removeAllItems();
				mahalle.addItem("Seçiniz...");
				mahalle.setSelectedIndex(0);
				mahalleleriListele(ilce_adi, mahalle, conn);
				mahalle.setMaximumRowCount(15);
			}
		});
		mahalle.setVisible(false);
		panel.add(mahalle);
		
		JComboBox tarife = new JComboBox();
		tarife.setForeground(new Color(176, 224, 230));
		tarife.setBackground(new Color(0, 139, 139));
		tarife.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "Mesken", "Ticari", "Sanayi", "Ayd\u0131nlatma", "Tar\u0131msal Sulama"}));
		tarife.setSelectedIndex(0);
		tarife.setBounds(140, 282, 160, 35);
		tarife.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		tarife.setVisible(false);
		panel.add(tarife);
		
		kurulu_guc = new JTextField();
		kurulu_guc.setForeground(new Color(176, 224, 230));
		kurulu_guc.setBackground(new Color(0, 139, 139));
		kurulu_guc.setColumns(10);
		kurulu_guc.setBounds(140, 328, 160, 35);
		kurulu_guc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		kurulu_guc.setVisible(false);
		panel.add(kurulu_guc);
		
		og_dur = new JTextField();
		og_dur.setForeground(new Color(176, 224, 230));
		og_dur.setBackground(new Color(0, 139, 139));
		og_dur.setColumns(10);
		og_dur.setBounds(140, 374, 160, 35);
		og_dur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		og_dur.setVisible(false);
		panel.add(og_dur);
		
		abone_no = new JTextField();
		abone_no.setForeground(new Color(176, 224, 230));
		abone_no.setBackground(new Color(0, 139, 139));
		abone_no.setColumns(10);
		abone_no.setBounds(140, 420, 160, 35);
		abone_no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				uyari.setVisible(false);
			}
		});
		abone_no.setVisible(false);
		panel.add(abone_no);
		
		JButton arama = new JButton("Ara");
		arama.setBackground(new Color(0, 139, 139));
		arama.setForeground(new Color(176, 224, 230));
		arama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tesisat_no.getText().isEmpty()) {
					uyari.setText("Lütfen Tesisat No Giriniz !!!");
					uyari.setForeground(Color.red);
					uyari.setVisible(true);
				}else {
					Tesisat sonuc=new Tesisat().Tesisat_Arama(conn, Integer.parseInt(tesisat_no.getText()));
					if(sonuc != null) {
						tesisat_no.setText(""+sonuc.getTesisat_no());
						karne_no.setText(""+sonuc.getKarne_id());
						sira_no.setText("");
						il.setSelectedIndex(sonuc.getIl_kodu());
						ilceleriListele(il.getSelectedItem().toString(), ilce,  mahalle,conn);
						ilce.setSelectedItem(sonuc.getIlce());
						mahalleleriListele(ilce.getSelectedItem().toString(), mahalle , conn);
						mahalle.setSelectedItem(sonuc.getMahalle());
						tarife.setSelectedIndex(sonuc.getTarife_kodu());
						kurulu_guc.setText(""+sonuc.getKurulu_guc());
						og_dur.setText(""+sonuc.getOg_dur());
						abone_no.setText(""+sonuc.getAbone_no());
						karne_no.setText(""+sonuc.getKarne_id());;
						sira_no.setText(""+sonuc.getSira_no());;
						il.setVisible(true);
						ilce.setVisible(true);
						mahalle.setVisible(true);
						tarife.setVisible(true);
						kurulu_guc.setVisible(true);
						og_dur.setVisible(true);
						abone_no.setVisible(true);
						karne_no.setVisible(true);
						sira_no.setVisible(true);
						lbl_KarneNo.setVisible(true);
						lbl_SiraNo.setVisible(true);
						lbl_il.setVisible(true);
						lbl_ilce.setVisible(true);
						lbl_mahalle.setVisible(true);
						lbl_tarife.setVisible(true);
						lbl_kuruluguc.setVisible(true);
						lbl_ogdur.setVisible(true);
						lbl_aboneno.setVisible(true);
						kaydet.setVisible(true);
						
					}else {
						uyari.setText(tesisat_no.getText()+" NO'lu Tesisat Bulunamadi");
						uyari.setForeground(Color.RED);
						uyari.setVisible(true);
					}	
				}
				
			}
		});
		
		arama.setBounds(310, 6, 64, 23);
		panel.add(arama);
		
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
								Integer.parseInt(abone_no.getText()), 1);
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
						karne_no.setVisible(false);
						sira_no.setVisible(false);
						il.setVisible(false);
						ilce.setVisible(false);;
						mahalle.setVisible(false);
						tarife.setVisible(false);
						ilce.setVisible(false);
						mahalle.setVisible(false);
						kurulu_guc.setVisible(false);
						og_dur.setVisible(false);
						abone_no.setVisible(false);
						lbl_KarneNo.setVisible(false);
						lbl_SiraNo.setVisible(false);
						lbl_il.setVisible(false);
						lbl_ilce.setVisible(false);
						lbl_mahalle.setVisible(false);
						lbl_tarife.setVisible(false);
						lbl_kuruluguc.setVisible(false);
						lbl_ogdur.setVisible(false);
						lbl_aboneno.setVisible(false);
						kaydet.setVisible(false);
						
					} catch (Exception e1) {
						uyari.setText("Lütfen Bütün Alanlarý Doldurunuz!!!");
						uyari.setForeground(Color.RED);
					}
				}
				uyari.setVisible(true);
			}
		});
		kaydet.setBounds(186, 497, 89, 23);
		kaydet.setVisible(false);
		panel.add(kaydet);
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.setBackground(new Color(255, 99, 71));
		geri_don.setForeground(new Color(176, 224, 230));
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tesisat_no.setText("");
				karne_no.setVisible(false);
				sira_no.setVisible(false);
				il.setVisible(false);
				ilce.setVisible(false);;
				mahalle.setVisible(false);
				tarife.setVisible(false);
				ilce.setVisible(false);
				mahalle.setVisible(false);
				kurulu_guc.setVisible(false);
				og_dur.setVisible(false);
				abone_no.setVisible(false);
				lbl_KarneNo.setVisible(false);
				lbl_SiraNo.setVisible(false);
				lbl_il.setVisible(false);
				lbl_ilce.setVisible(false);
				lbl_mahalle.setVisible(false);
				lbl_tarife.setVisible(false);
				lbl_kuruluguc.setVisible(false);
				lbl_ogdur.setVisible(false);
				lbl_aboneno.setVisible(false);
				kaydet.setVisible(false);
				uyari.setVisible(false);
				islem_ekran.setVisible(true);
				panel.setVisible(false);
			}
		});
		geri_don.setBounds(285, 497, 89, 23);
		panel.add(geri_don);
		
		
	}
	
	public void ilceleriListele(String il_adi, JComboBox ilce, JComboBox mahalle, Connection conn) {
		try {
			Statement s = conn.createStatement();
			ResultSet r ;
			String query="select distinct ilce from mahalleler where il= '"+ il_adi + "' order by ilce";
			r=s.executeQuery(query);
			while(r.next()) {
				ilce.addItem(r.getString(1));
			}
			ilce.setMaximumRowCount(10);
			mahalle.setEnabled(true);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void mahalleleriListele(String ilce_adi, JComboBox mahalle , Connection conn) {

		try {
			Statement s = conn.createStatement();
			ResultSet r ;
			String query="select mahalle from mahalleler where ilce= '"+ ilce_adi + "' order by mahalle";
			r= s.executeQuery(query);
			while(r.next()) {
				mahalle.addItem(r.getString(1));
			}
			mahalle.setMaximumRowCount(15);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public JPanel getContentPane() {
		return contentPane;
	}


	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}


	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public JTextField getTesisat_no() {
		return tesisat_no;
	}


	public void setTesisat_no(JTextField tesisat_no) {
		this.tesisat_no = tesisat_no;
	}


	public JTextField getKarne_no() {
		return karne_no;
	}


	public void setKarne_no(JTextField karne_no) {
		this.karne_no = karne_no;
	}


	public JTextField getSira_no() {
		return sira_no;
	}


	public void setSira_no(JTextField sira_no) {
		this.sira_no = sira_no;
	}


	public JLabel getLbl_KarneNo() {
		return lbl_KarneNo;
	}


	public void setLbl_KarneNo(JLabel lbl_KarneNo) {
		this.lbl_KarneNo = lbl_KarneNo;
	}


	public JLabel getLbl_SiraNo() {
		return lbl_SiraNo;
	}


	public void setLbl_SiraNo(JLabel lbl_SiraNo) {
		this.lbl_SiraNo = lbl_SiraNo;
	}


	public JTextField getKurulu_guc() {
		return kurulu_guc;
	}


	public void setKurulu_guc(JTextField kurulu_guc) {
		this.kurulu_guc = kurulu_guc;
	}


	public JTextField getOg_dur() {
		return og_dur;
	}


	public void setOg_dur(JTextField og_dur) {
		this.og_dur = og_dur;
	}


	public JTextField getAbone_no() {
		return abone_no;
	}


	public void setAbone_no(JTextField abone_no) {
		this.abone_no = abone_no;
	}
}
