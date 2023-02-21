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

public class KarneIslem extends JFrame {

	private JPanel contentPane;
	private JTextField karne_no;
	private JTextField adres;
	private JComboBox sayfiye;
	private Connection conn;
	/**
	 * Create the frame.
	 */
	public KarneIslem(Connection conn) {
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
		koy.setModel(new DefaultComboBoxModel(new String[] {"", "K\u00F6y", "K\u00F6y De\u011Fil"}));
		koy.setSelectedIndex(0);
		koy.setBounds(140, 127, 160, 35);
		contentPane.add(koy);
		
		
		sayfiye = new JComboBox();
		sayfiye.setBackground(Color.WHITE);
		sayfiye.setModel(new DefaultComboBoxModel(new String[] {"", "Sayfiye", "Sayfiye De\u011Fil"}));
		sayfiye.setSelectedIndex(0);
		sayfiye.setBounds(140, 173, 160, 35);
		contentPane.add(sayfiye);
		
		JDateChooser okuma = new JDateChooser();
		okuma.getDateEditor().setEnabled(false);
		okuma.getDateEditor().getUiComponent().setBackground(Color.WHITE);
		okuma.getJCalendar().getMonthChooser().getComboBox().setBackground(Color.WHITE);
		okuma.setDateFormatString("y-MM-d");
		okuma.setBounds(140, 219, 160, 35);
		
		contentPane.add(okuma);
		
		JButton btnNewButton = new JButton("Ara");
		btnNewButton.setBounds(310, 35, 64, 23);
		contentPane.add(btnNewButton);
		
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
		lblOkumaGn.setBounds(10, 229, 75, 25);
		contentPane.add(lblOkumaGn);
		
		/*TARÝH BÝLGÝSÝNÝ STRÝNG OLARAK ÇEKEMÝYORUM*/
		
		JButton btnNewButton_1 = new JButton("Kaydet");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Karneler().Karne_Ekle(conn, 1, Integer.parseInt(karne_no.getText()),adres.getText(), "2019-03-12", 0, 0);
				System.out.println(okuma.getDate());
			}
		});
		btnNewButton_1.setBounds(285, 299, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
