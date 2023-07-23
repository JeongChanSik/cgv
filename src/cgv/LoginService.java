package cgv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginService implements ActionListener{
	
	boolean login = false;
	String key; 
	JTextField id;
	JPasswordField pw;
	
	public void loginPage() {

	    try {
	        File file = new File("C:\\eclipse\\java\\work\\CGV_PJ\\src\\cgv\\UserData.txt");
	        if (file.exists()) {
	            FileReader fr = new FileReader(file);
	            BufferedReader br = new BufferedReader(fr);

	            String line;

	            while ((line = br.readLine()) != null) {
	                String[] userInfo = new String[4];
	                String[] data = new String[4];
	                for (int i = 0; i < 4; i++) {
	                    data[i] = line.split("/")[i];
	                }

	                userInfo[0] = data[0]; // id
	                userInfo[1] = data[1]; // pw

	                if (id.getText().equals(userInfo[0]) && Arrays.equals(pw.getPassword(), userInfo[1].toCharArray())) {
	                    login = true;
	                    key = userInfo[0];
	                    JOptionPane.showMessageDialog(null, "로그인 성공");
	                    break;
	                }
	            }
	            
	            if (!login) {
	                JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호를 다시 입력해주세요");
	            }

	            br.close();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public LoginService(JTextField id, JPasswordField pw) {
		this.id = id;
		this.pw = pw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		loginPage();
	}


	
}
