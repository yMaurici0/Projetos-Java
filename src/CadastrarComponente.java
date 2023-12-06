import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CadastrarComponente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDescricao;
	private JTextField txtPreco;
	private JTextField txtID;
	private JTextField txtQuantidade;
	
	public CadastrarComponente(List<Componente> listaComponentes, JFrame telaCRUD) {
		
		JFrame telaCadastrar = this;
		
		setTitle("Cadastrar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(218, 190, 121, 20);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descrição");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(123, 192, 111, 14);
		contentPane.add(lblNewLabel);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(218, 221, 121, 20);
		contentPane.add(txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Preço Custo");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(123, 222, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(218, 252, 121, 20);
		contentPane.add(txtQuantidade);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblMensagem.setBounds(10, 393, 466, 35);
		contentPane.add(lblMensagem);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addID = txtID.getText();
				String addDescricao = txtDescricao.getText();
				String addPreco = txtPreco.getText();
				String addQuantidade = txtQuantidade.getText();
				float numeroConvertidoFloat = 0;
				int numeroConvertidoInt = 0;
				int numeroCheckPoint = 0;
				int quantidadeConvert = 0;
				
				if(addDescricao.isEmpty()) {
					lblMensagem.setText("Descrição vazia !");
				}else if(addPreco.isEmpty()) {
						lblMensagem.setText("Preço vazio !");
					}else {
						try {
							numeroConvertidoFloat = Float.parseFloat(addPreco);
							numeroConvertidoInt = Integer.parseInt(addID);
							quantidadeConvert = Integer.parseInt(addQuantidade);
							
							for(Componente c: listaComponentes) {
								if(numeroConvertidoInt == c.getId()) {
									numeroCheckPoint = 1 ;
								}
							}
							if(numeroCheckPoint == 0) {
								Componente c1 = new Componente(numeroConvertidoInt,addDescricao,numeroConvertidoFloat, quantidadeConvert);
								listaComponentes.add(c1);
								txtPreco.setText("");
								txtDescricao.setText("");
								txtID.setText("");
								txtQuantidade.setText("");
								lblMensagem.setText("Cadastrado!");
							}
							else {
								lblMensagem.setText("Id ja existe, por favor digite outro!");
								txtID.setText("");
								
							}
							
				        } catch (NumberFormatException e1) {
				        	lblMensagem.setText("Erro de conversão: " + e1.getMessage());
				        }
						}
						}	
			
		});
		btnNewButton.setBounds(185, 337, 111, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCRUD.setVisible(true);
				telaCadastrar.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Id");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(123, 163, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		txtID = new JTextField();
		txtID.setBounds(218, 161, 121, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cadastrar Componente");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 71, 466, 49);
		contentPane.add(lblNewLabel_3);
		
		
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblQuantidade.setBounds(123, 255, 95, 14);
		contentPane.add(lblQuantidade);
		
		
	}
}
