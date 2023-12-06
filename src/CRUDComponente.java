import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class CRUDComponente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public CRUDComponente(List<Componente> listaComponentes, JFrame telaPrincipal) {
		setTitle("Gerenciar Componente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFrame telaCRUD = this;
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCRUD.setVisible(false);
				CadastrarComponente telaCadastrar = new CadastrarComponente(listaComponentes, telaCRUD);
				telaCadastrar.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(125, 120, 200, 51);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCRUD.setVisible(false);
				telaPrincipal.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Visualizar");
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCRUD.setVisible(false);
				VisualizarComponente telaVisualizar = new VisualizarComponente(listaComponentes, telaCRUD);
				telaVisualizar.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(125, 187, 200, 55);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Excluir");
		btnNewButton_3.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCRUD.setVisible(false);
				ExcluirComponente telaExcluir = new ExcluirComponente(telaCRUD, listaComponentes);
				telaExcluir.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(125, 263, 200, 51);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Atualizar");
		btnNewButton_4.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCRUD.setVisible(false);
				AtualizarComponente telaAtualizar = new AtualizarComponente(listaComponentes, telaCRUD);
				telaAtualizar.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(125, 324, 200, 51);
		contentPane.add(btnNewButton_4);
	}
}
