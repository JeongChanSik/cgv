package cgv;

import java.awt.*;

import javax.swing.*;

public class LoginView{
	
	public void login() {
		
		// �α���
		// �α���â�� ��� O
		// ���̵�, �н����� �Է� ���� O
		// ���̵� && �н����� ��ġ�ϴ��� Ȯ��
		// T: ���̵� ���� �������������� ����
		// F: �ٽ� �Է� �ȳ���
		
		// �α��� â
		JFrame frame = new JFrame("Login");
		
		JLabel logo = new JLabel("CGV");
		logo.setBounds(201, 100, 60, 30);
		logo.setForeground(Color.red); // �����۾�
		logo.setFont(new Font("Serif", Font.BOLD, 11)); // ���� �۾�
		frame.add(logo);
		
		// ���̵�
		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(211, 175, 60, 30); // 130, 200, 60, 30
		frame.add(idLabel);
		JTextField idBox = new JTextField(10);
		idBox.setBounds(35, 210, 370, 50); // 180, 200, 120, 30
		frame.add(idBox);
		
		// ��й�ȣ
		JLabel pwLabel = new JLabel("PW");
		pwLabel.setBounds(205, 275, 60, 30); // 116, 300, 60, 30
		frame.add(pwLabel);
		JPasswordField pwBox = new JPasswordField(10);
		pwBox.setBounds(35, 310, 370, 50); // 180, 300, 120, 30
//		pwBox.setEchoChar('*');
//		pwBox.size(TextField.);
		frame.add(pwBox);
//		pwBox.setToolTipText("��������");
		
		// �α��� ��ư
		JButton loginBtn = new JButton("�α���");
		loginBtn.setBounds(35, 450, 370, 60); // 160, 550, 120, 30
		frame.add(loginBtn);
		
		loginBtn.addActionListener(new LoginService(idBox, pwBox));  // �����ӿ� �Էµ� ���� �Ѱ���
		
		// ������
		frame.setBounds(700, 200, 450, 690); // ������ ũ��
//		frame.setBounds(  x,  y, width, height);
		frame.setLocationRelativeTo(null); // ��� ����
		frame.setLayout(null);
		frame.setVisible(true); // ������ ���̱�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}