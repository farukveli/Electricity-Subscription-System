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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class KarneDuzenle extends JFrame {

	private JPanel contentPane;
	private JTextField karne_no;
	private JTextField adres;
	private JComboBox sayfiye;
	private Connection conn;
	/**
	 * Create the frame.
	 */
	public KarneDuzenle(Connection conn) {
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
		adres.setVisible(false);
		contentPane.add(adres);
		
		JComboBox koy = new JComboBox();
		koy.setBackground(Color.WHITE);
		koy.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "K\u00F6y De\u011Fil", "K\u00F6y"}));
		koy.setSelectedIndex(0);
		koy.setBounds(140, 127, 160, 35);
		koy.setVisible(false);
		contentPane.add(koy);
		
		
		sayfiye = new JComboBox();
		sayfiye.setBackground(Color.WHITE);
		sayfiye.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "Sayfiye De\u011Fil", "Sayfiye"}));
		sayfiye.setSelectedIndex(0);
		sayfiye.setBounds(140, 173, 160, 35);
		sayfiye.setVisible(false);
		contentPane.add(sayfiye);
		
		
		
		JLabel lblNewLabel = new JLabel("Karne No");
		JLabel lblAdres = new JLabel("Adres");
		JLabel lblKyDurumu = new JLabel("K\u00F6y Durumu");
		JLabel lblSayfiyeDurumu = new JLabel("Sayfiye Durumu");		
		JLabel lblOkumaGn = new JLabel("Okuma G\u00FCn\u00FC");		
		JLabel karne_bulunamadi = new JLabel("");		
		
		
		karne_no.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				karne_bulunamadi.setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		lblNewLabel.setBounds(10, 34, 75, 25);
		contentPane.add(lblNewLabel);
		
		lblAdres.setBounds(10, 87, 75, 25);
		lblAdres.setVisible(false);
		contentPane.add(lblAdres);
		
		lblKyDurumu.setBounds(10, 137, 75, 25);
		lblKyDurumu.setVisible(false);
		contentPane.add(lblKyDurumu);
		

		lblSayfiyeDurumu.setBounds(10, 183, 93, 25);
		lblSayfiyeDurumu.setVisible(false);
		contentPane.add(lblSayfiyeDurumu);
		

		lblOkumaGn.setBounds(10, 235, 75, 25);
		lblOkumaGn.setVisible(false);
		contentPane.add(lblOkumaGn);
		

		karne_bulunamadi.setHorizontalAlignment(SwingConstants.LEFT);
		karne_bulunamadi.setBounds(140, 63, 234, 25);
		karne_bulunamadi.setForeground(Color.red);
		karne_bulunamadi.setVisible(false);
		contentPane.add(karne_bulunamadi);
		
		
		JComboBox okuma_gunu = new JComboBox();
		okuma_gunu.setModel(new DefaultComboBoxModel(new String[] {"Se\u00E7iniz...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
		okuma_gunu.setSelectedIndex(0);
		okuma_gunu.setBackground(Color.WHITE);
		okuma_gunu.setBounds(140, 230, 160, 35);
		okuma_gunu.setVisible(false);
		contentPane.add(okuma_gunu);

		JButton kaydet = new JButton("Kaydet");
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
		kaydet.setBounds(189, 406, 89, 23);
		kaydet.setVisible(false);
		contentPane.add(kaydet);
		
		JButton arama = new JButton("Ara");
		arama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					karne_bulunamadi.setText(karne_no.getText()+" NO'lu Karne Bulunamadư!!!");
					karne_no.setText("");
					karne_bulunamadi.setVisible(true);
				}
				
			}
		});
		
		arama.setBounds(310, 35, 64, 23);
		contentPane.add(arama);
		
		JButton geri_don = new JButton("Geri D\u00F6n");
		geri_don.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KarneIslem karne = new KarneIslem(conn);
				setVisible(false);
				karne.setVisible(true);
			}
		});
		geri_don.setBounds(285, 406, 89, 23);
		contentPane.add(geri_don);
		
		
	}
}
