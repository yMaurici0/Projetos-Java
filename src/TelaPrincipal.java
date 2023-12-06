import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Componente> listaComponentes = new ArrayList<>();
	private ArrayList<Kit> kits = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		/*Declaração das variaveis*/
		JButton btnComponente = new JButton("Gerenciar Componente");
		btnComponente.setFont(new Font("Arial Black", Font.PLAIN, 14));
		
		
		
		JFrame telaPrincipal = this;
		
		setTitle("Tela Principal");
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gerenciar kit");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUDkits telaCRUD = new CRUDkits(kits, listaComponentes, telaPrincipal);
				telaCRUD.setVisible(true);
				telaPrincipal.setVisible(false);
			}
		});
		btnNewButton.setBounds(91, 337, 277, 57);
		contentPane.add(btnNewButton);
		
		
	
		btnComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUDComponente telaCRUD = new CRUDComponente(listaComponentes, telaPrincipal);
				telaCRUD.setVisible(true);
				telaPrincipal.setVisible(false);
			}
		});
		btnComponente.setBounds(91, 219, 277, 57);
		contentPane.add(btnComponente);
	}
}
