import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ConfirmacaoExcluir extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ConfirmacaoExcluir(int id, String descricao, float preco, int quantidade,List<Componente> listaComponentes, int converterInt, 
			JFrame telaExclusao, JLabel lblMensagem) {
		setTitle("Confirmação");
		
		JFrame telaConfirmar = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String idTemp = String.valueOf(id);
		JLabel lblid = new JLabel("");
		lblid.setFont(new Font("Arial", Font.PLAIN, 12));
		lblid.setBounds(294, 31, 29, 13);
		contentPane.add(lblid);
		lblid.setText(idTemp);;
		
		String QtdTemp = String.valueOf(quantidade);
		JLabel lblQtd = new JLabel("");
		lblQtd.setFont(new Font("Arial", Font.PLAIN, 12));
		lblQtd.setBounds(294, 101, 79, 13);
		contentPane.add(lblQtd);
		lblQtd.setText(QtdTemp);
		
		JLabel lblDescricao = new JLabel("");
		lblDescricao.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDescricao.setBounds(294, 54, 59, 13);
		contentPane.add(lblDescricao);
		lblDescricao.setText(descricao);
		
		
		String precoTemp = String.valueOf(preco);
		JLabel lblPreco = new JLabel("");
		lblPreco.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPreco.setBounds(294, 77, 79, 13);
		contentPane.add(lblPreco);
		lblPreco.setText(precoTemp);
		
		
		JLabel lblRemovido = new JLabel("");
		lblRemovido.setBounds(181, 240, 45, 13);
		contentPane.add(lblRemovido);
		
		JButton btnSim = new JButton("Sim");
		btnSim.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnSim.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Iterator<Componente> iterator = listaComponentes.iterator();
		        while (iterator.hasNext()) {
		            Componente c = iterator.next();
		            if (c.getId() == converterInt) {
		                iterator.remove(); 
		                telaExclusao.setVisible(true);
		                lblid.setText("");
		                lblDescricao.setText("");
		                lblPreco.setText("");
		                lblQtd.setText("");
		                telaConfirmar.setVisible(false);
		                lblMensagem.setText("Item Removido");
		            }
		        }
		    }
		});
		btnSim.setBounds(108, 173, 85, 21);
		contentPane.add(btnSim);
		
		JButton btnNao = new JButton("Não");
		btnNao.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMensagem.setText("Item não removido");
				telaConfirmar.setVisible(false);
				telaExclusao.setVisible(true);
			}
		});
		btnNao.setBounds(307, 173, 85, 21);
		contentPane.add(btnNao);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel.setBounds(141, 30, 62, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Descrição");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(141, 53, 86, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblPrecoCusto = new JLabel("Preço Custo");
		lblPrecoCusto.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblPrecoCusto.setBounds(141, 76, 85, 13);
		contentPane.add(lblPrecoCusto);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Deseja realmente excluir");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 150, 466, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblQuantidade.setBounds(141, 100, 85, 13);
		contentPane.add(lblQuantidade);
		
		
		
		
	}
	
	
}
