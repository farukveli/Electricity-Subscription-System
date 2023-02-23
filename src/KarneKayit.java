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
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class KarneKayit extends JFrame {

	private JPanel contentPane;
	private JTextField karne_no;
	private JTextField adres;
	private JComboBox sayfiye;
	private Connection conn;
	/**
	 * Create the frame.
	 */
	public KarneKayit(Connection conn) {
		this.conn=conn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		karne_no = new JTextField();
		karne_no.setBounds(140, 29, 160, 35);
		contentPane.add(karne_no);
		karne_no.setColumns(10);
		
		adres = new JTextField();
		adres.setColumns(10);
		adres.setBounds(140, 81, 160, 35);
		contentPane.add(adres);
		
		JComboBox koy = new JComboBox();
		koy.setBackground(Color.WHITE);
		koy.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "K\u00F6y De\u011Fil", "K\u00F6y"}));
		koy.setSelectedIndex(0);
		koy.setBounds(140, 127, 160, 35);
		contentPane.add(koy);
		
		
		sayfiye = new JComboBox();
		sayfiye.setBackground(Color.WHITE);
		sayfiye.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "Sayfiye De\u011Fil", "Sayfiye"}));
		sayfiye.setSelectedIndex(0);
		sayfiye.setBounds(140, 173, 160, 35);
		contentPane.add(sayfiye);
		
		
		
		JLabel lblNewLabel = new JLabel("Karne No");
		lblNewLabel.setBounds(10, 34, 75, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdres = new JLabel("Adres");
		lblAdres.setBounds(10, 87, 75, 25);
		contentPane.add(lblAdres);
		
		JLabel lblKyDurumu = new JLabel("K\u00F6y Durumu");
		lblKyDurumu.setBounds(10, 137, 75, 25);
		contentPane.add(lblKyDurumu);
		
		JLabel lblSayfiyeDurumu = new JLabel("Sayfiye Durumu");
		lblSayfiyeDurumu.setBounds(10, 183, 93, 25);
		contentPane.add(lblSayfiyeDurumu);
		
		JLabel lblOkumaGn = new JLabel("Okuma G\u00FCn\u00FC");
		lblOkumaGn.setBounds(10, 235, 75, 25);
		contentPane.add(lblOkumaGn);
		
		
		JComboBox okuma_gunu = new JComboBox();
		okuma_gunu.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		okuma_gunu.setSelectedIndex(0);
		okuma_gunu.setBackground(Color.WHITE);
		okuma_gunu.setBounds(140, 230, 160, 35);
		contentPane.add(okuma_gunu);

		JButton kaydet = new JButton("Kaydet");
		kaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Karneler().Karne_Ekle_Duzenle(conn,Integer.parseInt(karne_no.getText()),adres.getText(), okuma_gunu.getSelectedIndex()+1,
						koy.getSelectedIndex()-1, sayfiye.getSelectedIndex()-1,0);
				
			}
		});
		kaydet.setBounds(186, 415, 89, 23);
		contentPane.add(kaydet);
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KarneIslem karne = new KarneIslem(conn);
				setVisible(false);
				karne.setVisible(true);
			}
		});
		geri_don.setBounds(285, 415, 89, 23);
		contentPane.add(geri_don);
		
	}
}
