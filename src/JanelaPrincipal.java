import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JTextField codigo;
	private JTextField nome;
	private JTextField telefone;
	private int registros;
	JList list_Cad = new JList();
	DefaultListModel model = new DefaultListModel();

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		setTitle("Cadastramento de Usu\u00E1rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 250);
		contentPane.add(tabbedPane);
		
		JPanel cad = new JPanel();
		cad.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Cadastro", null, cad, null);
		cad.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel.setBounds(22, 11, 96, 32);
		cad.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNome.setBounds(22, 54, 96, 32);
		cad.add(lblNome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTelefone.setBounds(22, 97, 96, 32);
		cad.add(lblTelefone);
		
		JLabel lblRegistros = new JLabel(registros + " - registros");
		lblRegistros.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblRegistros.setBounds(32, 124, 96, 32);
		cad.add(lblRegistros);
		
		codigo = new JTextField();
		codigo.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		codigo.setBounds(103, 19, 86, 20);
		cad.add(codigo);
		codigo.setColumns(10);
		
		nome = new JTextField();
		nome.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		nome.setBounds(103, 62, 86, 20);
		cad.add(nome);
		nome.setColumns(10);
		
		telefone = new JTextField();
		telefone.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		telefone.setBounds(103, 105, 86, 20);
		cad.add(telefone);
		telefone.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list_Cad.setModel(model);
				model.addElement(codigo.getText() + " " + nome.getText() + " " + telefone.getText());
				registros = registros + 1;
				lblRegistros.setText(registros + " - registros");
			}
		});
		btnSalvar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnSalvar.setBounds(10, 158, 108, 32);
		cad.add(btnSalvar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigo.setText("");
				nome.setText("");
				telefone.setText("");
			}
		});
		btnLimpar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnLimpar.setBounds(141, 158, 108, 32);
		cad.add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnSair.setBounds(280, 158, 108, 32);
		cad.add(btnSair);
		
		JPanel list = new JPanel();
		list.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Lista", null, list, null);
		list.setLayout(null);
		
	
		list_Cad.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		list_Cad.setBounds(10, 11, 389, 170);
		list.add(list_Cad);
		
		JButton btnRemove = new JButton("Remover");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resp = JOptionPane.showInputDialog("Certeza que deseja remover o elemento?");
				if (resp.equalsIgnoreCase("Sim")) {
				model.removeElement(list_Cad.getSelectedValue());
				}
				list_Cad.setModel(model);
			}
		});
		btnRemove.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnRemove.setBounds(20, 184, 128, 27);
		list.add(btnRemove);
		
		JButton btnRemoverTodos = new JButton("Remover todos");
		btnRemoverTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resp = JOptionPane.showInputDialog("Certeza que deseja remover todos os elementos?");
				if (resp.equalsIgnoreCase("Sim")) {
				model.removeAllElements();
				}
				list_Cad.setModel(model);
			}
		});
		btnRemoverTodos.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnRemoverTodos.setBounds(233, 184, 143, 27);
		list.add(btnRemoverTodos);
	}
}
