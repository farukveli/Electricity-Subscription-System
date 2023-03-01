import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

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

public class AboneKayit extends JFrame {

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
	public AboneKayit(Connection c, JPanel abone_islem) {
		this.conn=conn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 384, 531);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 384, 531);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_TesisatNo = new JLabel("Tesisat No");
		lbl_TesisatNo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TesisatNo.setBounds(10, 22, 103, 25);
		panel.add(lbl_TesisatNo);
		
		JLabel lbl_SozlesmeNo = new JLabel("S\u00F6zle\u015Fme No");
		lbl_SozlesmeNo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_SozlesmeNo.setBounds(10, 58, 103, 25);
		panel.add(lbl_SozlesmeNo);
		
		JLabel lbl_UnvanNo = new JLabel("\u00DCnvan");
		lbl_UnvanNo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_UnvanNo.setBounds(10, 94, 103, 25);
		panel.add(lbl_UnvanNo);
		
		JLabel lbl_Sahis = new JLabel("\u015Eah\u0131s/T\u00FCzel");
		lbl_Sahis.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Sahis.setBounds(10, 130, 103, 25);
		panel.add(lbl_Sahis);
		
		JLabel lbl_Telefon = new JLabel("Telefon No");
		lbl_Telefon.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Telefon.setBounds(10, 166, 103, 25);
		panel.add(lbl_Telefon);
		
		JLabel lbl_ePosta = new JLabel("e-Posta");
		lbl_ePosta.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ePosta.setBounds(10, 202, 103, 25);
		panel.add(lbl_ePosta);
		
		JLabel lbl_sozlesmeTarihi = new JLabel("S\u00F6zle\u015Fme Tarihi");
		lbl_sozlesmeTarihi.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sozlesmeTarihi.setBounds(10, 238, 103, 25);
		panel.add(lbl_sozlesmeTarihi);
		
		JLabel lbl_tahliyeTarihi = new JLabel("Tahliye Tarihi");
		lbl_tahliyeTarihi.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tahliyeTarihi.setBounds(10, 274, 103, 25);
		panel.add(lbl_tahliyeTarihi);
		
		JLabel lbl_tarife = new JLabel("Tarife");
		lbl_tarife.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tarife.setBounds(10, 310, 103, 25);
		panel.add(lbl_tarife);
		
		JLabel lbl_puant = new JLabel("Puant");
		lbl_puant.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_puant.setBounds(10, 346, 103, 25);
		panel.add(lbl_puant);
		
		JLabel lbl_sozlesmeGucu = new JLabel("S\u00F6zle\u015Fme G\u00FCc\u00FC");
		lbl_sozlesmeGucu.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sozlesmeGucu.setBounds(10, 382, 103, 25);
		panel.add(lbl_sozlesmeGucu);
		
		JLabel lbl_kayitTarihi = new JLabel("Kay\u0131t Tarihi");
		lbl_kayitTarihi.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_kayitTarihi.setBounds(10, 418, 103, 25);
		panel.add(lbl_kayitTarihi);
		
		JButton kaydet = new JButton("Kaydet");
		kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		kaydet.setBounds(186, 497, 89, 23);
		panel.add(kaydet);
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.setBounds(285, 497, 89, 23);
		panel.add(geri_don);
		
		tesisat_no = new JTextField();
		tesisat_no.setColumns(10);
		tesisat_no.setBounds(158, 24, 160, 25);
		panel.add(tesisat_no);
		
		sozlesme_no = new JTextField();
		sozlesme_no.setColumns(10);
		sozlesme_no.setBounds(158, 60, 160, 25);
		panel.add(sozlesme_no);
		
		unvan = new JTextField();
		unvan.setColumns(10);
		unvan.setBounds(158, 96, 160, 25);
		panel.add(unvan);
		
		telefon = new JTextField();
		telefon.setColumns(10);
		telefon.setBounds(158, 168, 160, 25);
		panel.add(telefon);
		
		ePosta = new JTextField();
		ePosta.setColumns(10);
		ePosta.setBounds(158, 204, 160, 25);
		panel.add(ePosta);
		
		sozlesme_gucu = new JTextField();
		sozlesme_gucu.setColumns(10);
		sozlesme_gucu.setBounds(158, 384, 160, 25);
		panel.add(sozlesme_gucu);
		
		JComboBox sahis = new JComboBox();
		sahis.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "\u015Eah\u0131s", "T\u00FCzel"}));
		sahis.setSelectedIndex(0);
		sahis.setBounds(158, 130, 160, 25);
		panel.add(sahis);
		
		JComboBox tarife = new JComboBox();
		tarife.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "Mesken", "Ticari", "Sanayi", "Ayd\u0131nlatma", "Tar\u0131msal Sulama"}));
		tarife.setSelectedIndex(0);
		tarife.setBounds(158, 311, 160, 25);
		panel.add(tarife);
		
		JComboBox puant = new JComboBox();
		puant.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "G\u00FCnd\u00FCz", "Ak\u015Fam", "Gece"}));
		puant.setSelectedIndex(0);
		puant.setBounds(158, 347, 160, 25);
		panel.add(puant);
		
		JDateChooser tahliye_tarihi = new JDateChooser();
		tahliye_tarihi.setBounds(158, 274, 160, 25);
		panel.add(tahliye_tarihi);
		
		JDateChooser sozlesme_tarihi = new JDateChooser();
		sozlesme_tarihi.setBounds(158, 238, 160, 25);
		panel.add(sozlesme_tarihi);
		
		JDateChooser kayit_tarihi = new JDateChooser();
		kayit_tarihi.setBounds(158, 418, 160, 25);
		panel.add(kayit_tarihi);
		
		JLabel uyari = new JLabel("");
		uyari.setHorizontalAlignment(SwingConstants.CENTER);
		uyari.setFont(new Font("Ubuntu", Font.BOLD, 14));
		uyari.setBounds(10, 454, 364, 23);
		panel.add(uyari);
		
		
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
