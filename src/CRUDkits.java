import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class CRUDkits extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public CRUDkits(List<Kit> kits, List<Componente> listaComponente, JFrame telaPrincipal) {
		setTitle("Gerenciar Kit");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JFrame telaCRUD = this;
		
		JButton btnCadastrarKit = new JButton("Cadastrar");
		btnCadastrarKit.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnCadastrarKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarKit cadastrarKit = new CadastrarKit(telaCRUD, kits, listaComponente);
				cadastrarKit.setVisible(true);
				telaCRUD.setVisible(false);
				
			}
		});
		btnCadastrarKit.setBounds(164, 99, 173, 57);
		contentPane.add(btnCadastrarKit);
		
		JButton btnVisualizarKit = new JButton("Visualizar");
		btnVisualizarKit.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnVisualizarKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisualizarKit telaVisualizar = new VisualizarKit(telaCRUD, kits);
				telaVisualizar.setVisible(true);
				telaCRUD.setVisible(false);
			}
		});
		btnVisualizarKit.setBounds(164, 185, 173, 57);
		contentPane.add(btnVisualizarKit);
		
		JButton btnExcluirKit = new JButton("Excluir");
		btnExcluirKit.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnExcluirKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirKit telaExcluir = new ExcluirKit(telaCRUD, kits);
				telaExcluir.setVisible(true);
				telaCRUD.setVisible(false);
			}
		});
		btnExcluirKit.setBounds(164, 264, 173, 57);
		contentPane.add(btnExcluirKit);
		
		JButton btnAtualizarKit = new JButton("Atualizar");
		btnAtualizarKit.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnAtualizarKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarKit telaAtualizar = new AtualizarKit(telaCRUD, kits, listaComponente);
				telaAtualizar.setVisible(true);
				telaCRUD.setVisible(false);
			}
		});
		btnAtualizarKit.setBounds(164, 335, 173, 71);
		contentPane.add(btnAtualizarKit);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaPrincipal.setVisible(true);
				telaCRUD.setVisible(false);
			}
		});
		btnVoltar.setBounds(10, 11, 89, 23);
		contentPane.add(btnVoltar);
	}
}
