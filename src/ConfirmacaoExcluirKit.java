import java.awt.EventQueue;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ConfirmacaoExcluirKit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ConfirmacaoExcluirKit(int id, String descricao, float preco, List<Componente> listaRemoverComponeteKIT, 
			List<Kit> listaKit, JFrame telaExcluir, JLabel txtMensagem) {
		
		JFrame telaConfirmacao = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Componentes");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(115, 103, 105, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Preço");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(115, 80, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descrição");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(115, 57, 85, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Id");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(115, 34, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblID = new JLabel("");
		lblID.setFont(new Font("Arial", Font.PLAIN, 12));
		lblID.setBounds(242, 35, 45, 13);
		contentPane.add(lblID);
		
		JLabel lblDescricao = new JLabel("");
		lblDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescricao.setBounds(242, 57, 45, 13);
		contentPane.add(lblDescricao);
		
		JLabel lblPreco = new JLabel("");
		lblPreco.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPreco.setBounds(242, 81, 45, 13);
		contentPane.add(lblPreco);
		
		JLabel lblComponentes = new JLabel("");
		lblComponentes.setFont(new Font("Arial", Font.PLAIN, 12));
		lblComponentes.setBounds(230, 103, 235, 13);
		contentPane.add(lblComponentes);
		
		JLabel lblNewLabel_4 = new JLabel("Deseja realmente Excluir o kit");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 126, 466, 13);
		contentPane.add(lblNewLabel_4);
		
		lblID.setText(""+id);
		lblDescricao.setText(descricao);
		lblPreco.setText(""+preco);
		StringBuilder componentesStr = new StringBuilder();
		for (Componente c : listaRemoverComponeteKIT) {
		    componentesStr.append(c.getDescricao()).append(", ");
		}
		// Remover a última vírgula e espaço adicionados no loop acima
		if (componentesStr.length() > 0) {
		    componentesStr.setLength(componentesStr.length() - 2);
		}

		lblComponentes.setText(componentesStr.toString());
		
		JButton btnSIM = new JButton("Sim");
		btnSIM.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnSIM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Iterator<Kit> iterator = listaKit.iterator();
		        while (iterator.hasNext()) {
		            Kit k = iterator.next();
		            if (k.getId() == id) {
		                iterator.remove(); // Remove o elemento usando o iterador
		                telaExcluir.setVisible(true);
		                lblID.setText("");
		                lblDescricao.setText("");
		                lblPreco.setText("");
		                telaConfirmacao.setVisible(false);
		                txtMensagem.setText("Kit Removido");
		            }
		        }
				telaConfirmacao.setVisible(false);
				telaExcluir.setVisible(true);
			}
		});
		btnSIM.setBounds(75, 149, 85, 21);
		contentPane.add(btnSIM);
		
		JButton btnNAO = new JButton("Não");
		btnNAO.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNAO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaConfirmacao.setVisible(false);
	            telaExcluir.setVisible(true);
			}
		});
		btnNAO.setBounds(320, 149, 85, 21);
		contentPane.add(btnNAO);
	}

}
