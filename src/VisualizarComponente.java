import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VisualizarComponente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableComponentes;
    private JButton btnNewButton;
    private JLabel lblNewLabel;

    public VisualizarComponente(List<Componente> listaComponente, JFrame telaCRUD) {

        JFrame telaVisualizar = this;

        setTitle("Visualizar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        /*Tabela pronta*/
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 55, 466, 398);
        contentPane.add(scrollPane);

        
        String[] colunas = {"Id", "Descrição", "Preço", "Quantidade"};


        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Componente componente : listaComponente) {
            Object[] rowData = {componente.getId(), componente.getDescricao(), componente.getPrecoCusto(), componente.getQuantidade()};
            model.addRow(rowData);
        }


        tableComponentes = new JTable(model);
        tableComponentes.setFont(new Font("Arial Black", Font.PLAIN, 10));
        scrollPane.setViewportView(tableComponentes);

        /*Fim da tabela*/	
        btnNewButton = new JButton("Voltar");
        btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                telaCRUD.setVisible(true);
                telaVisualizar.setVisible(false);
            }
        });
        btnNewButton.setBounds(10, 11, 89, 23);
        contentPane.add(btnNewButton);
        
        lblNewLabel = new JLabel("Componentes Cadastrados");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 11, 466, 34);
        contentPane.add(lblNewLabel);
    }
}