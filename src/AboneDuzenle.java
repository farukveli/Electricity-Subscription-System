import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboneDuzenle extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private Connection conn;
	private JTextField tesisat_no;
	private JTextField sozlesme_no;
	private JTextField unvan;
	private JTextField telefon;
	private JTextField ePosta;
	private JTextField sozlesme_gucu;
	/**
	 * Create the frame.
	 */
	public AboneDuzenle(Connection conn, JPanel abone_islem) {
		this.conn=conn;
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
		
		JLabel lbl_TesisatNo = new JLabel("Tesisat No");
		lbl_TesisatNo.setForeground(new Color(0, 139, 139));
		lbl_TesisatNo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TesisatNo.setBounds(10, 22, 103, 25);
		lbl_TesisatNo.setVisible(false);
		panel.add(lbl_TesisatNo);
		
		JLabel lbl_SozlesmeNo = new JLabel("S\u00F6zle\u015Fme No");
		lbl_SozlesmeNo.setForeground(new Color(0, 139, 139));
		lbl_SozlesmeNo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SozlesmeNo.setBounds(10, 58, 103, 25);
		panel.add(lbl_SozlesmeNo);
		
		JLabel lbl_UnvanNo = new JLabel("\u00DCnvan");
		lbl_UnvanNo.setForeground(new Color(0, 139, 139));
		lbl_UnvanNo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_UnvanNo.setBounds(10, 94, 103, 25);
		lbl_UnvanNo.setVisible(false);
		panel.add(lbl_UnvanNo);
		
		JLabel lbl_Sahis = new JLabel("\u015Eah\u0131s/T\u00FCzel");
		lbl_Sahis.setForeground(new Color(0, 139, 139));
		lbl_Sahis.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Sahis.setBounds(10, 130, 103, 25);
		lbl_Sahis.setVisible(false);
		panel.add(lbl_Sahis);
		
		JLabel lbl_Telefon = new JLabel("Telefon No");
		lbl_Telefon.setForeground(new Color(0, 139, 139));
		lbl_Telefon.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Telefon.setBounds(10, 166, 103, 25);
		lbl_Telefon.setVisible(false);
		panel.add(lbl_Telefon);
		
		JLabel lbl_ePosta = new JLabel("e-Posta");
		lbl_ePosta.setForeground(new Color(0, 139, 139));
		lbl_ePosta.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ePosta.setBounds(10, 202, 103, 25);
		lbl_ePosta.setVisible(false);
		panel.add(lbl_ePosta);
		
		JLabel lbl_sozlesmeTarihi = new JLabel("S\u00F6zle\u015Fme Tarihi");
		lbl_sozlesmeTarihi.setForeground(new Color(0, 139, 139));
		lbl_sozlesmeTarihi.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sozlesmeTarihi.setBounds(10, 238, 103, 25);
		lbl_sozlesmeTarihi.setVisible(false);
		panel.add(lbl_sozlesmeTarihi);
		
		JLabel lbl_tahliyeTarihi = new JLabel("Tahliye Tarihi");
		lbl_tahliyeTarihi.setForeground(new Color(0, 139, 139));
		lbl_tahliyeTarihi.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tahliyeTarihi.setBounds(10, 274, 103, 25);
		lbl_tahliyeTarihi.setVisible(false);
		panel.add(lbl_tahliyeTarihi);
		
		JLabel lbl_tarife = new JLabel("Tarife");
		lbl_tarife.setForeground(new Color(0, 139, 139));
		lbl_tarife.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tarife.setBounds(10, 310, 103, 25);
		lbl_tarife.setVisible(false);
		panel.add(lbl_tarife);
		
		JLabel lbl_puant = new JLabel("Puant");
		lbl_puant.setForeground(new Color(0, 139, 139));
		lbl_puant.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_puant.setBounds(10, 346, 103, 25);
		lbl_puant.setVisible(false);
		panel.add(lbl_puant);
		
		JLabel lbl_sozlesmeGucu = new JLabel("S\u00F6zle\u015Fme G\u00FCc\u00FC");
		lbl_sozlesmeGucu.setForeground(new Color(0, 139, 139));
		lbl_sozlesmeGucu.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sozlesmeGucu.setBounds(10, 382, 103, 25);
		lbl_sozlesmeGucu.setVisible(false);
		panel.add(lbl_sozlesmeGucu);
		
		JLabel lbl_kayitTarihi = new JLabel("Kay\u0131t Tarihi");
		lbl_kayitTarihi.setForeground(new Color(0, 139, 139));
		lbl_kayitTarihi.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_kayitTarihi.setBounds(10, 418, 103, 25);
		lbl_kayitTarihi.setVisible(false);
		panel.add(lbl_kayitTarihi);
		
		tesisat_no = new JTextField();
		tesisat_no.setForeground(new Color(176, 224, 230));
		tesisat_no.setBackground(new Color(0, 139, 139));
		tesisat_no.setColumns(10);
		tesisat_no.setBounds(135, 22, 160, 25);
		tesisat_no.setVisible(false);
		panel.add(tesisat_no);
		
		sozlesme_no = new JTextField();
		sozlesme_no.setForeground(new Color(176, 224, 230));
		sozlesme_no.setBackground(new Color(0, 139, 139));
		sozlesme_no.setColumns(10);
		sozlesme_no.setBounds(135, 58, 160, 25);
		panel.add(sozlesme_no);
		
		unvan = new JTextField();
		unvan.setForeground(new Color(176, 224, 230));
		unvan.setBackground(new Color(0, 139, 139));
		unvan.setColumns(10);
		unvan.setBounds(135, 94, 160, 25);
		unvan.setVisible(false);
		panel.add(unvan);
		
		telefon = new JTextField();
		telefon.setForeground(new Color(176, 224, 230));
		telefon.setBackground(new Color(0, 139, 139));
		telefon.setColumns(10);
		telefon.setBounds(135, 168, 160, 25);
		telefon.setVisible(false);
		panel.add(telefon);
		
		ePosta = new JTextField();
		ePosta.setForeground(new Color(176, 224, 230));
		ePosta.setBackground(new Color(0, 139, 139));
		ePosta.setColumns(10);
		ePosta.setBounds(135, 204, 160, 25);
		ePosta.setVisible(false);
		panel.add(ePosta);
		
		sozlesme_gucu = new JTextField();
		sozlesme_gucu.setForeground(new Color(176, 224, 230));
		sozlesme_gucu.setBackground(new Color(0, 139, 139));
		sozlesme_gucu.setColumns(10);
		sozlesme_gucu.setBounds(135, 386, 160, 25);
		sozlesme_gucu.setVisible(false);
		panel.add(sozlesme_gucu);
		
		JComboBox sahis = new JComboBox();
		sahis.setForeground(new Color(176, 224, 230));
		sahis.setBackground(new Color(0, 139, 139));
		sahis.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "\u015Eah\u0131s", "T\u00FCzel"}));
		sahis.setSelectedIndex(0);
		sahis.setBounds(135, 130, 160, 25);
		sahis.setVisible(false);
		panel.add(sahis);
		
		JComboBox tarife = new JComboBox();
		tarife.setForeground(new Color(176, 224, 230));
		tarife.setBackground(new Color(0, 139, 139));
		tarife.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "Mesken", "Ticari", "Sanayi", "Ayd\u0131nlatma", "Tar\u0131msal Sulama"}));
		tarife.setSelectedIndex(0);
		tarife.setBounds(135, 313, 160, 25);
		tarife.setVisible(false);
		panel.add(tarife);
		
		JComboBox puant = new JComboBox();
		puant.setForeground(new Color(176, 224, 230));
		puant.setBackground(new Color(0, 139, 139));
		puant.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "G\u00FCnd\u00FCz", "Ak\u015Fam", "Gece"}));
		puant.setSelectedIndex(0);
		puant.setBounds(135, 349, 160, 25);
		puant.setVisible(false);
		panel.add(puant);
		
		JDateChooser tahliye_tarihi = new JDateChooser();
		tahliye_tarihi.setDateFormatString("yyyy-MM-dd");
		tahliye_tarihi.setBounds(135, 276, 160, 25);
		tahliye_tarihi.setVisible(false);
		tahliye_tarihi.getDateEditor().getUiComponent().setBackground(new Color(0, 139, 139));
		tahliye_tarihi.getDateEditor().getUiComponent().setForeground(new Color(176, 224, 230));
		panel.add(tahliye_tarihi);
		
		JDateChooser sozlesme_tarihi = new JDateChooser();
		sozlesme_tarihi.setDateFormatString("yyyy-MM-dd");
		sozlesme_tarihi.setBounds(135, 240, 160, 25);
		sozlesme_tarihi.setVisible(false);
		sozlesme_tarihi.getDateEditor().getUiComponent().setBackground(new Color(0, 139, 139));
		sozlesme_tarihi.getDateEditor().getUiComponent().setForeground(new Color(176, 224, 230));
		panel.add(sozlesme_tarihi);
		
		JDateChooser kayit_tarihi = new JDateChooser();
		kayit_tarihi.setDateFormatString("yyyy-MM-dd");
		kayit_tarihi.setBounds(135, 420, 160, 25);
		kayit_tarihi.setVisible(false);
		kayit_tarihi.getDateEditor().getUiComponent().setBackground(new Color(0, 139, 139));
		kayit_tarihi.getDateEditor().getUiComponent().setForeground(new Color(176, 224, 230));
		panel.add(kayit_tarihi);
		
		JLabel uyari = new JLabel("");
		uyari.setHorizontalAlignment(SwingConstants.CENTER);
		uyari.setFont(new Font("Ubuntu", Font.BOLD, 14));
		uyari.setBounds(10, 454, 364, 23);
		uyari.setVisible(false);
		panel.add(uyari);
		
		JButton kaydet = new JButton("Kaydet");
		kaydet.setBackground(new Color(0, 128, 0));
		kaydet.setForeground(new Color(176, 224, 230));
		kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					int durum= new Abone().Abone_Ekle_Duzenle(conn, Integer.parseInt(sozlesme_no.getText()), Integer.parseInt(tesisat_no.getText()),
							unvan.getText(),sahis.getSelectedIndex(), Integer.parseInt(telefon.getText()), ePosta.getText(),
							df.format(sozlesme_tarihi.getDate()),df.format(tahliye_tarihi.getDate()), tarife.getSelectedIndex(),
							puant.getSelectedIndex(), Integer.parseInt(sozlesme_gucu.getText()),
							df.format(kayit_tarihi.getDate()), 1);
					if(durum==0) {
						uyari.setText(sozlesme_no.getText()+" NO'lu Abone Kaydedildi");
						uyari.setForeground(Color.CYAN);
						uyari.setVisible(true);
					}else {
						System.out.println(durum);
					}
				} catch (Exception e1 ) {
					uyari.setText("Lütfen Bütün Alanlarý Doldurunuz!!!");
					uyari.setForeground(Color.RED);
				}
				
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
				abone_islem.setVisible(true);
				panel.setVisible(false);
				sozlesme_no.setText("");
				tesisat_no.setVisible(false);
				unvan.setVisible(false);
				sahis.setVisible(false);
				telefon.setVisible(false);
				ePosta.setVisible(false);
				sozlesme_tarihi.setVisible(false);
				tahliye_tarihi.setVisible(false);
				tarife.setVisible(false);
				puant.setVisible(false);
				sozlesme_gucu.setVisible(false);
				kayit_tarihi.setVisible(false);
				kaydet.setVisible(false);
				lbl_TesisatNo.setVisible(false);
				lbl_kayitTarihi.setVisible(false);
				lbl_UnvanNo.setVisible(false);
				lbl_Sahis.setVisible(false);
				lbl_Telefon.setVisible(false);
				lbl_ePosta.setVisible(false);
				lbl_sozlesmeTarihi.setVisible(false);
				lbl_tahliyeTarihi.setVisible(false);
				lbl_tarife.setVisible(false);
				lbl_puant.setVisible(false);
				lbl_sozlesmeGucu.setVisible(false);
				lbl_kayitTarihi.setVisible(false);
				uyari.setVisible(false);
			}
		});
		geri_don.setBounds(285, 497, 89, 23);
		panel.add(geri_don);
		
		JButton arama = new JButton("Ara");
		arama.setBackground(new Color(0, 139, 139));
		arama.setForeground(new Color(176, 224, 230));
		arama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sozlesme_no.getText().isEmpty()) {
					uyari.setText("Lütfen Sozlesme No Giriniz !!!");
					uyari.setForeground(Color.red);
					uyari.setVisible(true);
				}else {
					Abone sonuc=new Abone().Abone_Ara(conn, Integer.parseInt(sozlesme_no.getText()));
					if(sonuc != null) {
						sozlesme_no.setText(""+sonuc.getSozlesme_no());
						tesisat_no.setText(""+sonuc.getTesisat_no());
						unvan.setText(sonuc.getUnvan());
						sahis.setSelectedIndex(sonuc.getSahis_durum());
						telefon.setText(""+sonuc.getTelefon_no());
						ePosta.setText(sonuc.getE_posta());
						sozlesme_tarihi.getDateEditor().setDate(sonuc.getSozlesme_tarihi());
						tahliye_tarihi.getDateEditor().setDate(sonuc.getTahliye_tarihi());
						tarife.setSelectedIndex(sonuc.getTarife_kodu());
						puant.setSelectedIndex(sonuc.getPuant());
						sozlesme_gucu.setText(""+sonuc.getSozlesme_gucu());
						kayit_tarihi.getDateEditor().setDate(sonuc.getKayit_tarihi());
						tesisat_no.setVisible(true);
						unvan.setVisible(true);
						sahis.setVisible(true);
						telefon.setVisible(true);
						ePosta.setVisible(true);
						sozlesme_tarihi.setVisible(true);
						tahliye_tarihi.setVisible(true);
						tarife.setVisible(true);
						puant.setVisible(true);
						sozlesme_gucu.setVisible(true);
						kayit_tarihi.setVisible(true);
						kaydet.setVisible(true);
						lbl_TesisatNo.setVisible(true);
						lbl_kayitTarihi.setVisible(true);
						lbl_UnvanNo.setVisible(true);
						lbl_Sahis.setVisible(true);
						lbl_Telefon.setVisible(true);
						lbl_ePosta.setVisible(true);
						lbl_sozlesmeTarihi.setVisible(true);
						lbl_tahliyeTarihi.setVisible(true);
						lbl_tarife.setVisible(true);
						lbl_puant.setVisible(true);
						lbl_sozlesmeGucu.setVisible(true);
						lbl_kayitTarihi.setVisible(true);
						uyari.setVisible(false);
					}else {
						uyari.setText(sozlesme_no.getText()+" NO'lu Abone Bulunamadi");
						uyari.setForeground(Color.RED);
						uyari.setVisible(true);
					}	
				}
			}
		});
		arama.setBounds(305, 59, 64, 23);
		panel.add(arama);
		
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public JTextField getTesisat_no() {
		return tesisat_no;
	}
	public void setTesisat_no(JTextField tesisat_no) {
		this.tesisat_no = tesisat_no;
	}
	public JTextField getSozlesme_no() {
		return sozlesme_no;
	}
	public void setSozlesme_no(JTextField sozlesme_no) {
		this.sozlesme_no = sozlesme_no;
	}
	public JTextField getUnvan() {
		return unvan;
	}
	public void setUnvan(JTextField unvan) {
		this.unvan = unvan;
	}
	public JTextField getTelefon() {
		return telefon;
	}
	public void setTelefon(JTextField telefon) {
		this.telefon = telefon;
	}
	public JTextField getePosta() {
		return ePosta;
	}
	public void setePosta(JTextField ePosta) {
		this.ePosta = ePosta;
	}
	public JTextField getSozlesme_gucu() {
		return sozlesme_gucu;
	}
	public void setSozlesme_gucu(JTextField sozlesme_gucu) {
		this.sozlesme_gucu = sozlesme_gucu;
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
}
