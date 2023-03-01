import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AnaMenu extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private Connection conn;
	private JTextField baslik;
	private JButton tesisatIslemleri;
	private JButton karneIslemleri;
	private KarneIslem karne_islemleri;
	private KarneKayit karne_kayit;
	private KarneDuzenle karne_duzenle;
	private KarneSil karne_sil;
	private TesisatIslem tesisat_islemleri;
	private TesisatKayit tesisat_kayit;
	private TesisatDuzenle tesisat_duzenle;
	private TesisatSil tesisat_sil;
	private AboneIslem abone_islemleri;
	private AboneKayit abone_kayit;
	private AboneDuzenle abone_duzenle;
	private AboneSil abone_sil;

	/**
	 * Create the frame.
	 */
	public AnaMenu(Connection conn) {
		this.conn=conn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 384, 531);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 384, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		karne_islemleri = new KarneIslem(conn,panel);
		contentPane.add(karne_islemleri.getPanel());
		karne_islemleri.getPanel().setLayout(null);
		karne_islemleri.getPanel().setVisible(false);
		
		karne_kayit = karne_islemleri.getKarne_kayit();
		contentPane.add(karne_kayit.getPanel());
		karne_kayit.getContentPane().setLayout(null);
		karne_kayit.setVisible(false);
		
		karne_duzenle = karne_islemleri.getKarne_duzenle();
		contentPane.add(karne_duzenle.getPanel());
		karne_duzenle.setVisible(false);
		karne_duzenle.getContentPane().setLayout(null);
		
		karne_sil = karne_islemleri.getKarne_sil();
		contentPane.add(karne_sil.getPanel());
		karne_sil.setVisible(false);
		karne_sil.getContentPane().setLayout(null);
		
			
		tesisat_islemleri = new TesisatIslem(conn,panel);
		contentPane.add(tesisat_islemleri.getPanel());
		tesisat_islemleri.getPanel().setLayout(null);
		tesisat_islemleri.getPanel().setVisible(false);
		
		tesisat_kayit = tesisat_islemleri.getTesisat_kayit();
		contentPane.add(tesisat_kayit.getPanel());
		tesisat_kayit.setVisible(false);
		tesisat_kayit.getContentPane().setLayout(null);
		
		tesisat_duzenle = tesisat_islemleri.getTesisat_duzenle();
		contentPane.add(tesisat_duzenle.getPanel());
		tesisat_duzenle.setVisible(false);
		tesisat_duzenle.getContentPane().setLayout(null);
		
		tesisat_sil = tesisat_islemleri.getTesisat_sil();
		contentPane.add(tesisat_sil.getPanel());
		tesisat_sil.setVisible(false);
		tesisat_sil.getContentPane().setLayout(null);
	
		abone_islemleri = new AboneIslem(conn,panel);
		contentPane.add(abone_islemleri.getPanel());
		abone_islemleri.getPanel().setLayout(null);
		abone_islemleri.getPanel().setVisible(false);
		
		abone_kayit = abone_islemleri.getAbone_kayit();
		contentPane.add(abone_kayit.getPanel());
		abone_kayit.setVisible(false);
		abone_kayit.getContentPane().setLayout(null);
		
		abone_duzenle = abone_islemleri.getAbone_duzenle();
		contentPane.add(abone_duzenle.getPanel());
		abone_duzenle.setVisible(false);
		abone_duzenle.getContentPane().setLayout(null);
		
		abone_sil = abone_islemleri.getAbone_sil();
		contentPane.add(abone_sil.getPanel());
		abone_sil.setVisible(false);
		abone_sil.getContentPane().setLayout(null);
/*	*/		
		baslik = new JTextField();
		baslik.setEditable(false);
		baslik.setFont(new Font("Ubuntu", Font.BOLD, 22));
		baslik.setHorizontalAlignment(SwingConstants.CENTER);
		baslik.setText("ELEKTR\u0130K DA\u011EITIM S\u0130STEM\u0130");
		baslik.setBounds(10, 11, 364, 66);
		panel.add(baslik);
		baslik.setColumns(10);
		
		karneIslemleri = new JButton("Karne \u0130\u015Flemleri");
		karneIslemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				karne_islemleri.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		karneIslemleri.setFont(new Font("Ubuntu", Font.PLAIN, 11));
		karneIslemleri.setBounds(110, 123, 150, 50);
		panel.add(karneIslemleri);
		
		
		tesisatIslemleri = new JButton("Tesisat \u0130\u015Flemleri");
		tesisatIslemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tesisat_islemleri.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		tesisatIslemleri.setFont(new Font("Ubuntu", Font.PLAIN, 11));
		tesisatIslemleri.setBounds(110, 184, 150, 50);
		panel.add(tesisatIslemleri);
		
		JButton aboneIslemleri = new JButton("Abone \u0130\u015Flemleri");
		aboneIslemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abone_islemleri.getPanel().setVisible(true);
				panel.setVisible(false);
			}
		});
		aboneIslemleri.setFont(new Font("Ubuntu", Font.PLAIN, 11));
		aboneIslemleri.setBounds(110, 245, 150, 50);
		panel.add(aboneIslemleri);
	}
}
