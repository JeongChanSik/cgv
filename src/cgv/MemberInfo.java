package cgv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberInfo extends JFrame{
	String choice = null;
	
	public MemberInfo() {
		
		// ����
		setTitle("ȸ�� ����");
		JLabel title = new JLabel("CGV ȸ������", JLabel.CENTER);
		
		// ��� �� �۲� ����, ũ��
		title.setForeground(Color.RED);
		title.setFont(new Font("�������", Font.BOLD, 30));
		title.setBounds(350, 500, 180, 100);
		
		// ȸ�� ���� �� ��� ��ư ����
		JButton join = new JButton("ȸ�� ����");
		JButton cancel = new JButton("��\n��");
		
		// ���� ���� ���� �ڽ� ũ��
		JTextField id = new JTextField(15);
		JPasswordField pw = new JPasswordField(15);
		JTextField name = new JTextField(15);
		JTextField tel = new JTextField(15);
		JTextArea ta = new JTextArea();
		
		
		// form �г�
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idPanel.add(new JLabel("��  ��  ��   "));
		idPanel.add(id);
		idPanel.setBounds(350, 400, 180, 100);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwPanel.add(new JLabel("�� �� �� ȣ  "));
		pwPanel.add(pw);
		pwPanel.setBounds(350, 300, 180, 100);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(new JLabel(" ��      ��    "));
		namePanel.add(name);
		namePanel.setBounds(350, 200, 180, 100);
		
		JPanel telPanel = new JPanel();
		telPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		telPanel.add(new JLabel("��  ��  ó   "));
		telPanel.add(tel);
		telPanel.setBounds(350, 100, 180, 100);
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(4, 2));
		formPanel.add(idPanel);
		formPanel.add(pwPanel);
		formPanel.add(namePanel);
		formPanel.add(telPanel);
		formPanel.setBounds(20,200,300,100);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(null);
		contentPanel.add(formPanel);
		
		
		JPanel panel = new JPanel();
		panel.add(join);
		panel.add(cancel);
		
		add(title, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		setBounds(700, 200, 460, 690);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null); // ��� ����
		
		
		// ȸ������ �̺�Ʈ ó��
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String myId = id.getText();
				String myPw = new String(pw.getPassword());
				String myName = name.getText();
				String myTel = tel.getText();
				
				//JOptionPane.showMessageDialog
				//(null, "���̵� : " + myId + ", ��й�ȣ : " + myPw + ", �� �� : " + myName + ", ����ó : " + myTel + " �� ������ �����Ǿ����ϴ�.");
				boolean idtest = true;
		        try {
		            File file = new File("C:\\eclipse\\java\\work\\CGV_PJ\\src\\cgv\\UserData.txt");
		            
		            // ������ �����ϸ� �ش� ������ �о �̹� �����ϴ� ���̵� �Ǵ� �������� �˻�
		            if (file.exists()) {
		                FileReader fr = new FileReader(file);
		                BufferedReader br = new BufferedReader(fr);

		                String line;
		                
		                while ((line = br.readLine()) != null) {
			                String[] userInfo = new String[4];
			                String[] data = new String[4];
			                
			                // ���Ͽ��� �о�� ���̵�� �Էµ� ���̵� ��ġ�ϴ� ���
			                for (int i = 0; i < 4; i++) {
			                    data[i] = line.split("/")[i];
			                }

			                userInfo[0] = data[0]; // id
			                userInfo[1] = data[1]; // pw

			                if (myId.equals(userInfo[0])) {
			                	JOptionPane.showMessageDialog(null, "�̹� �����ϴ� ���̵��Դϴ�.");
		                        br.close();
		                        return;
			                }
			            } // while
		                
		            }
		            if(idtest) {
		            	// ������ �������� �ʰų�, ���Ͽ� �������� �ʴ� ���̵��� ��� �����͸� ���Ͽ� �߰�
		                FileWriter fw = new FileWriter(file, true);
		                
		                
		                if(!myId.isEmpty() && !myPw.isEmpty() &&!myName.isEmpty() && !myTel.isEmpty()) {
		                	fw.write("\n" + myId + "/" + myPw + "/" + myName + "/" + myTel);		                	
		                	JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.");
		                } else {
		                	JOptionPane.showMessageDialog(null, "���� ���� �Է����ּ���");                	
		                }
		                
		                fw.close();
		            }
		            
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
				
				
			}
		});
		
		// ��Ҹ� ���� �� �̺�Ʈ ó��
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
	}
	
}