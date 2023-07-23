package cgv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MemberService implements ActionListener{ 
	
	boolean idCheck = false;
	JTextField id;
	JPasswordField pw;
	String check_id;
	
    public void getMembers() {
    	
        try {
            File file = new File("C:\\Users\\82107\\Desktop\\학원\\back-end\\work\\CGV_PJ\\src\\cgv\\UserData.txt");
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                String line;

                while ((line = br.readLine()) != null) {
                	
                    String[] memberInfo = new String[4]; //메모장에서 읽어온 회원정보를 저장하는 배열
                    String[] info = new String[4];// '/'를 기준으로 각각의 방에 id,pw,name,tel 
                    for(int i=0; i<6; i++) {
                    	info[i] = line.split("/")[i];
                    }
                    
                    memberInfo[0] = info[0]; // id
                    memberInfo[1] = info[1]; // pw
                   
                    
                    if(id.getText().equals(memberInfo[0]) && pw.getText().equals(memberInfo[0])){
                    	idCheck=true;
                    	String key = memberInfo[0]; // 아이디를 키값으로 저장
                    	break;
                    }else {
                    	 JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호를 다시 입력해주세요!");
                    }
                }
               
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
    
    public MemberService(JTextField id, JPasswordField pw) {
		this.id = id;
		this.pw = pw;
	}
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	getMembers();
    	
    }     
}
   
