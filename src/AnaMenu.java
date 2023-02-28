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
	//private TesisatSil tesisat_sil;

	/**
	 * Create the frame.
	 */
	public AnaMenu(Connection conn) {
		this.conn=conn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 570);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		karne_kayit.setLayout(null);
		karne_kayit.setVisible(false);
		
		karne_duzenle = karne_islemleri.getKarne_duzenle();
		contentPane.add(karne_duzenle.getPanel());
		karne_duzenle.setVisible(false);
		karne_duzenle.setLayout(null);
		
		karne_sil = karne_islemleri.getKarne_sil();
		contentPane.add(karne_sil.getPanel());
		karne_sil.setVisible(false);
		karne_sil.setLayout(null);
		
			
		tesisat_islemleri = new TesisatIslem(conn,panel);
		contentPane.add(tesisat_islemleri.getPanel());
		tesisat_islemleri.getPanel().setLayout(null);
		tesisat_islemleri.getPanel().setVisible(false);
		
		tesisat_kayit = tesisat_islemleri.getTesisat_kayit();
		contentPane.add(tesisat_kayit.getPanel());
		tesisat_kayit.setVisible(false);
		tesisat_kayit.setLayout(null);
		
		tesisat_duzenle = tesisat_islemleri.getTesisat_duzenle();
		contentPane.add(tesisat_duzenle.getPanel());
		tesisat_duzenle.setVisible(false);
		tesisat_duzenle.setLayout(null);
		
		
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
	}
}
