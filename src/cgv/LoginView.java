package cgv;

import java.awt.*;

import javax.swing.*;

public class LoginView{
	
	public void login() {
		
		// 로그인
		// 로그인창을 띄움 O
		// 아이디, 패스워드 입력 받음 O
		// 아이디 && 패스워드 일치하는지 확인
		// T: 아이디 값을 마이페이지에게 보냄
		// F: 다시 입력 안내문
		
		// 로그인 창
		JFrame frame = new JFrame("Login");
		
		JLabel logo = new JLabel("CGV");
		logo.setBounds(201, 100, 60, 30);
		logo.setForeground(Color.red); // 빨간글씨
		logo.setFont(new Font("Serif", Font.BOLD, 11)); // 굵은 글씨
		frame.add(logo);
		
		// 아이디
		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(211, 175, 60, 30); // 130, 200, 60, 30
		frame.add(idLabel);
		JTextField idBox = new JTextField(10);
		idBox.setBounds(35, 210, 370, 50); // 180, 200, 120, 30
		frame.add(idBox);
		
		// 비밀번호
		JLabel pwLabel = new JLabel("PW");
		pwLabel.setBounds(205, 275, 60, 30); // 116, 300, 60, 30
		frame.add(pwLabel);
		JPasswordField pwBox = new JPasswordField(10);
		pwBox.setBounds(35, 310, 370, 50); // 180, 300, 120, 30
//		pwBox.setEchoChar('*');
//		pwBox.size(TextField.);
		frame.add(pwBox);
//		pwBox.setToolTipText("ㅁㄴㅇㄹ");
		
		// 로그인 버튼
		JButton loginBtn = new JButton("로그인");
		loginBtn.setBounds(35, 450, 370, 60); // 160, 550, 120, 30
		frame.add(loginBtn);
		
		loginBtn.addActionListener(new LoginService(idBox, pwBox));  // 프레임에 입력된 값을 넘겨줌
		
		// 프레임
		frame.setBounds(700, 200, 450, 690); // 프레임 크기
//		frame.setBounds(  x,  y, width, height);
		frame.setLocationRelativeTo(null); // 가운데 정렬
		frame.setLayout(null);
		frame.setVisible(true); // 프레임 보이기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}