import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class KarneKayit extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField karne_no;
	private JTextField adres;
	private JComboBox sayfiye;
	private Connection conn;
	/**
	 * Create the frame.
	 */
	public KarneKayit(Connection conn, JPanel karne_islem) {
		this.conn=conn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 384, 531);
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 384, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel kayit_uyari = new JLabel("");
		kayit_uyari.setFont(new Font("Ubuntu", Font.PLAIN, 16));
		kayit_uyari.setHorizontalAlignment(SwingConstants.CENTER);
		kayit_uyari.setBounds(10, 287, 364, 43);
		panel.add(kayit_uyari);
		
		JLabel lblNewLabel = new JLabel("Karne No");
		lblNewLabel.setBounds(10, 34, 75, 25);
		panel.add(lblNewLabel);
		
		JLabel lblAdres = new JLabel("Adres");
		lblAdres.setBounds(10, 87, 75, 25);
		panel.add(lblAdres);
		
		JLabel lblKyDurumu = new JLabel("K\u00F6y Durumu");
		lblKyDurumu.setBounds(10, 137, 75, 25);
		panel.add(lblKyDurumu);
		
		JLabel lblSayfiyeDurumu = new JLabel("Sayfiye Durumu");
		lblSayfiyeDurumu.setBounds(10, 183, 93, 25);
		panel.add(lblSayfiyeDurumu);
		
		JLabel lblOkumaGn = new JLabel("Okuma G\u00FCn\u00FC");
		lblOkumaGn.setBounds(10, 235, 75, 25);
		panel.add(lblOkumaGn);
		
		
		karne_no = new JTextField();
		karne_no.setBounds(140, 29, 160, 35);
		karne_no.setColumns(10);
		karne_no.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kayit_uyari.setVisible(false);
			}
		});
		panel.add(karne_no);
		
		adres = new JTextField();
		adres.setColumns(10);
		adres.setBounds(140, 81, 160, 35);
		adres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kayit_uyari.setVisible(false);
			}
		});
		panel.add(adres);
		
		JComboBox koy = new JComboBox();
		koy.setBackground(Color.WHITE);
		koy.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "K\u00F6y De\u011Fil", "K\u00F6y"}));
		koy.setSelectedIndex(0);
		koy.setBounds(140, 127, 160, 35);
		koy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kayit_uyari.setVisible(false);
			}
		});
		panel.add(koy);
		
		
		sayfiye = new JComboBox();
		sayfiye.setBackground(Color.WHITE);
		sayfiye.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "Sayfiye De\u011Fil", "Sayfiye"}));
		sayfiye.setSelectedIndex(0);
		sayfiye.setBounds(140, 178, 160, 35);
		sayfiye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kayit_uyari.setVisible(false);
			}
		});
		panel.add(sayfiye);
		

		
		JComboBox okuma_gunu = new JComboBox();
		okuma_gunu.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		okuma_gunu.setSelectedIndex(0);
		okuma_gunu.setBackground(Color.WHITE);
		okuma_gunu.setBounds(140, 230, 160, 35);
		okuma_gunu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kayit_uyari.setVisible(false);
			}
		});
		panel.add(okuma_gunu);

		JButton kaydet = new JButton("Kaydet");
		kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int durum= new Karneler().Karne_Ekle_Duzenle(conn,Integer.parseInt(karne_no.getText()),adres.getText(), okuma_gunu.getSelectedIndex()+1,
						koy.getSelectedIndex()-1, sayfiye.getSelectedIndex()-1,0);
				if (durum==-1) {
					kayit_uyari.setText(karne_no.getText()+" NO'lu Karne Kayýtlý !!!");
					kayit_uyari.setForeground(Color.RED);
					kayit_uyari.setVisible(true);
				}else if(durum == -2) {
					kayit_uyari.setText("Hata!!");
					kayit_uyari.setForeground(Color.RED);
					kayit_uyari.setVisible(true);
				}else {
					kayit_uyari.setText(karne_no.getText()+" NO'lu Karne Kaydedildi !!!");
					kayit_uyari.setForeground(Color.GREEN);
					kayit_uyari.setVisible(true);
				}
				karne_no.setText("");
				adres.setText("");
				okuma_gunu.setSelectedIndex(0);
				koy.setSelectedIndex(0);
				sayfiye.setSelectedIndex(0);
			}
		});
		kaydet.setBounds(186, 497, 89, 23);
		panel.add(kaydet);
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				karne_islem.setVisible(true);
				panel.setVisible(false);
			}
		});
		geri_don.setBounds(285, 497, 89, 23);
		panel.add(geri_don);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kayit_uyari.setVisible(false);
			}
		});
		
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JPanel getContentPane() {
		return contentPane;
	}
	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
	public JTextField getKarne_no() {
		return karne_no;
	}
	public void setKarne_no(JTextField karne_no) {
		this.karne_no = karne_no;
	}
	public JTextField getAdres() {
		return adres;
	}
	public void setAdres(JTextField adres) {
		this.adres = adres;
	}
	public JComboBox getSayfiye() {
		return sayfiye;
	}
	public void setSayfiye(JComboBox sayfiye) {
		this.sayfiye = sayfiye;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
