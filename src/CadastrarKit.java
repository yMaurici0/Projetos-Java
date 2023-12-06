import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CadastrarKit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDescricao;
	private JTextField txtID;
	private JTextField txtPreco;

	public CadastrarKit(JFrame telaCRUD, List<Kit> listaKits, List<Componente> listaComponente) {

		setTitle("Cadastrar Kit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JFrame telaCadastrar = this;

		JLabel lblMensagem = new JLabel("");
		lblMensagem.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setBounds(10, 370, 435, 31);
		contentPane.add(lblMensagem);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCadastrar.setVisible(false);
				telaCRUD.setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);

		textDescricao = new JTextField();
		textDescricao.setBounds(212, 191, 172, 20);
		contentPane.add(textDescricao);
		textDescricao.setColumns(10);

		txtID = new JTextField();
		txtID.setBounds(212, 147, 172, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtPreco = new JTextField();
		txtPreco.setBounds(212, 242, 172, 19);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);

		JLabel lblNewLabel = new JLabel("Descrição");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(102, 192, 89, 14);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Adicionar componetes ao kit");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String descricao = textDescricao.getText();
				String idConverter = txtID.getText();
				String precoConverter = txtPreco.getText();
				int idKIT = 0;
				float precoKIT = 0;
				int verificador = 0;

				try {
					idKIT = Integer.parseInt(idConverter);
					precoKIT = Float.parseFloat(precoConverter);
					for(Kit k: listaKits) {
						if(idKIT == k.getId()) {
							verificador = 1;
						}
					}
					if(verificador == 1) {
						lblMensagem.setText("Id já cadastrado!");
					}
					else {
						AdicionarComponentes addComponente = new AdicionarComponentes(telaCadastrar, descricao, listaKits,
								listaComponente, idKIT, precoKIT, telaCRUD);
						addComponente.setVisible(true);
						telaCadastrar.setVisible(false);
					}
					
				} catch (Exception e1) {
					System.out.println("Erro: " + e1.getMessage());
					lblMensagem.setText("Existem campos sem preencher !");
				}

			}
		});
		btnNewButton.setBounds(102, 303, 282, 57);
		contentPane.add(btnNewButton);

		JLabel lblID = new JLabel("Id");
		lblID.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblID.setBounds(102, 149, 45, 13);
		contentPane.add(lblID);

		JLabel lblNewLabel_1 = new JLabel("Preço");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(102, 244, 58, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cadastrar Kit");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 61, 466, 23);
		contentPane.add(lblNewLabel_2);

	}
}
