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

public class KarneDuzenle extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private Connection conn;
	private JTextField karne_no;
	private JTextField adres;
	private JComboBox sayfiye;
	private JComboBox koy;
	private JComboBox okuma_gunu;
	private JLabel lblNewLabel;
	private JLabel lblAdres;
	private JLabel lblKyDurumu;
	private JLabel lblSayfiyeDurumu;		
	private JLabel lblOkumaGn;		
	private JLabel uyari;		
	
	
	/**
	 * Create the frame.
	 */
	public KarneDuzenle(Connection conn,JPanel karne_islem) {
		this.conn=conn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 384, 531);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setForeground(new Color(0, 139, 139));
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(0, 0, 384, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		karne_no = new JTextField();
		karne_no.setForeground(new Color(176, 224, 230));
		karne_no.setBackground(new Color(0, 139, 139));
		karne_no.setBounds(140, 29, 160, 35);
		panel.add(karne_no);
		karne_no.setColumns(10);
		
		adres = new JTextField();
		adres.setForeground(new Color(176, 224, 230));
		adres.setBackground(new Color(0, 139, 139));
		adres.setColumns(10);
		adres.setBounds(140, 81, 160, 35);
		adres.setVisible(false);
		panel.add(adres);
		
		koy = new JComboBox();
		koy.setForeground(new Color(176, 224, 230));
		koy.setBackground(new Color(0, 139, 139));
		koy.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "K\u00F6y De\u011Fil", "K\u00F6y"}));
		koy.setSelectedIndex(0);
		koy.setBounds(140, 127, 160, 35);
		koy.setVisible(false);
		panel.add(koy);
		
		
		sayfiye = new JComboBox();
		sayfiye.setForeground(new Color(176, 224, 230));
		sayfiye.setBackground(new Color(0, 139, 139));
		sayfiye.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "Sayfiye De\u011Fil", "Sayfiye"}));
		sayfiye.setSelectedIndex(0);
		sayfiye.setBounds(140, 173, 160, 35);
		sayfiye.setVisible(false);
		panel.add(sayfiye);
		
		
		
		lblNewLabel = new JLabel("Karne No");
		lblNewLabel.setForeground(new Color(0, 139, 139));
		lblAdres = new JLabel("Adres");
		lblAdres.setForeground(new Color(0, 139, 139));
		lblKyDurumu = new JLabel("K\u00F6y Durumu");
		lblKyDurumu.setForeground(new Color(0, 139, 139));
		lblSayfiyeDurumu = new JLabel("Sayfiye Durumu");		
		lblSayfiyeDurumu.setForeground(new Color(0, 139, 139));
		lblOkumaGn = new JLabel("Okuma G\u00FCn\u00FC");		
		lblOkumaGn.setForeground(new Color(0, 139, 139));
		uyari = new JLabel("");		
		
		
		karne_no.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				uyari.setVisible(false);
			}
		});
		
		lblNewLabel.setBounds(10, 34, 75, 25);
		panel.add(lblNewLabel);
		
		lblAdres.setBounds(10, 87, 75, 25);
		lblAdres.setVisible(false);
		panel.add(lblAdres);
		
		lblKyDurumu.setBounds(10, 137, 75, 25);
		lblKyDurumu.setVisible(false);
		panel.add(lblKyDurumu);
		

		lblSayfiyeDurumu.setBounds(10, 183, 93, 25);
		lblSayfiyeDurumu.setVisible(false);
		panel.add(lblSayfiyeDurumu);
		

		lblOkumaGn.setBounds(10, 235, 75, 25);
		lblOkumaGn.setVisible(false);
		panel.add(lblOkumaGn);
		

		uyari.setHorizontalAlignment(SwingConstants.LEFT);
		uyari.setBounds(140, 63, 234, 25);
		uyari.setForeground(Color.red);
		uyari.setVisible(false);
		panel.add(uyari);
		
		okuma_gunu = new JComboBox();
		okuma_gunu.setForeground(new Color(176, 224, 230));
		okuma_gunu.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		okuma_gunu.setSelectedIndex(0);
		okuma_gunu.setBackground(new Color(0, 139, 139));
		okuma_gunu.setBounds(140, 230, 160, 35);
		okuma_gunu.setVisible(false);
		panel.add(okuma_gunu);

		JButton kaydet = new JButton("Kaydet");
		kaydet.setBackground(new Color(0, 128, 0));
		kaydet.setForeground(new Color(176, 224, 230));
		kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Karneler().Karne_Ekle_Duzenle(conn, Integer.parseInt(karne_no.getText()),adres.getText(), okuma_gunu.getSelectedIndex()+1,
						koy.getSelectedIndex()-1, sayfiye.getSelectedIndex()-1,1);
				karne_no.setText("");
				adres.setVisible(false);
				koy.setVisible(false);
				sayfiye.setVisible(false);
				okuma_gunu.setVisible(false);
				lblAdres.setVisible(false);
				lblKyDurumu.setVisible(false);
				lblSayfiyeDurumu.setVisible(false);
				lblOkumaGn.setVisible(false);
				kaydet.setVisible(false);
			}
		});
		kaydet.setBounds(186, 497, 89, 23);
		kaydet.setVisible(false);
		panel.add(kaydet);
		
		JButton arama = new JButton("Ara");
		arama.setBackground(new Color(0, 139, 139));
		arama.setForeground(new Color(176, 224, 230));
		arama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(karne_no.getText().isEmpty()) {
					uyari.setText("L�tfen Karne No Giriniz");
					uyari.setVisible(true);
					uyari.setForeground(Color.red);
				}else {
					Karneler sonuc=new Karneler().Karne_Arama(conn, Integer.parseInt(karne_no.getText()));
					if(sonuc != null) {
						karne_no.setText(""+sonuc.getKarne_no());
						adres.setText(sonuc.getAdres());
						koy.setSelectedIndex(sonuc.getKoy_dur()+1);
						sayfiye.setSelectedIndex(sonuc.getSayfiye_dur()+1);
						okuma_gunu.setSelectedIndex(sonuc.getOkuma_gunu());
						adres.setVisible(true);
						koy.setVisible(true);
						sayfiye.setVisible(true);
						okuma_gunu.setVisible(true);
						lblAdres.setVisible(true);
						lblKyDurumu.setVisible(true);
						lblSayfiyeDurumu.setVisible(true);
						lblOkumaGn.setVisible(true);
						kaydet.setVisible(true);	
					}else {
						uyari.setText(karne_no.getText()+" NO'lu Karne Bulunamad�!!!");
						karne_no.setText("");
						uyari.setVisible(true);
					}
				}
			}
		});
		
		arama.setBounds(310, 35, 64, 23);
		panel.add(arama);
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.setBackground(new Color(255, 99, 71));
		geri_don.setForeground(new Color(176, 224, 230));
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				karne_no.setText("");
				adres.setVisible(false);
				koy.setVisible(false);
				sayfiye.setVisible(false);
				okuma_gunu.setVisible(false);
				lblAdres.setVisible(false);
				lblKyDurumu.setVisible(false);
				lblSayfiyeDurumu.setVisible(false);
				lblOkumaGn.setVisible(false);
				kaydet.setVisible(false);
				uyari.setVisible(false);
				karne_islem.setVisible(true);
				panel.setVisible(false);
			}
		});
		geri_don.setBounds(285, 497, 89, 23);
		panel.add(geri_don);
		
		
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
