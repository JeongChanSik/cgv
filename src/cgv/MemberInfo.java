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
		
		// 제목
		setTitle("회원 가입");
		JLabel title = new JLabel("CGV 회원가입", JLabel.CENTER);
		
		// 배경 및 글꼴 색깔, 크기
		title.setForeground(Color.RED);
		title.setFont(new Font("맑은고딕", Font.BOLD, 30));
		title.setBounds(350, 500, 180, 100);
		
		// 회원 가입 및 취소 버튼 생성
		JButton join = new JButton("회원 가입");
		JButton cancel = new JButton("취\n소");
		
		// 가입 정보 글자 박스 크기
		JTextField id = new JTextField(15);
		JPasswordField pw = new JPasswordField(15);
		JTextField name = new JTextField(15);
		JTextField tel = new JTextField(15);
		JTextArea ta = new JTextArea();
		
		
		// form 패널
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idPanel.add(new JLabel("아  이  디   "));
		idPanel.add(id);
		idPanel.setBounds(350, 400, 180, 100);
		
		JPanel pwPanel = new JPanel();
		pwPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwPanel.add(new JLabel("비 밀 번 호  "));
		pwPanel.add(pw);
		pwPanel.setBounds(350, 300, 180, 100);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(new JLabel(" 이      름    "));
		namePanel.add(name);
		namePanel.setBounds(350, 200, 180, 100);
		
		JPanel telPanel = new JPanel();
		telPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		telPanel.add(new JLabel("연  락  처   "));
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
		setLocationRelativeTo(null); // 가운데 정렬
		
		
		// 회원가입 이벤트 처리
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String myId = id.getText();
				String myPw = new String(pw.getPassword());
				String myName = name.getText();
				String myTel = tel.getText();
				
				//JOptionPane.showMessageDialog
				//(null, "아이디 : " + myId + ", 비밀번호 : " + myPw + ", 이 름 : " + myName + ", 연락처 : " + myTel + " 로 계정이 생성되었습니다.");
				boolean idtest = true;
		        try {
		            File file = new File("C:\\eclipse\\java\\work\\CGV_PJ\\src\\cgv\\UserData.txt");
		            
		            // 파일이 존재하면 해당 파일을 읽어서 이미 존재하는 아이디 또는 계정인지 검사
		            if (file.exists()) {
		                FileReader fr = new FileReader(file);
		                BufferedReader br = new BufferedReader(fr);

		                String line;
		                
		                while ((line = br.readLine()) != null) {
			                String[] userInfo = new String[4];
			                String[] data = new String[4];
			                
			                // 파일에서 읽어온 아이디와 입력된 아이디가 일치하는 경우
			                for (int i = 0; i < 4; i++) {
			                    data[i] = line.split("/")[i];
			                }

			                userInfo[0] = data[0]; // id
			                userInfo[1] = data[1]; // pw

			                if (myId.equals(userInfo[0])) {
			                	JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다.");
		                        br.close();
		                        return;
			                }
			            } // while
		                
		            }
		            if(idtest) {
		            	// 파일이 존재하지 않거나, 파일에 존재하지 않는 아이디인 경우 데이터를 파일에 추가
		                FileWriter fw = new FileWriter(file, true);
		                
		                
		                if(!myId.isEmpty() && !myPw.isEmpty() &&!myName.isEmpty() && !myTel.isEmpty()) {
		                	fw.write("\n" + myId + "/" + myPw + "/" + myName + "/" + myTel);		                	
		                	JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
		                } else {
		                	JOptionPane.showMessageDialog(null, "공백 없이 입력해주세요");                	
		                }
		                
		                fw.close();
		            }
		            
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
				
				
			}
		});
		
		// 취소를 했을 때 이벤트 처리
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
	}
	
}