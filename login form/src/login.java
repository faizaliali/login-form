import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

class SignUp extends JFrame{
    JLabel l,l1,l2;
    JTextField t1,t2;
    JButton b1;
    SignUp(){
        
                setVisible(true);
                setLayout(null);
                setTitle("Register Form");
                setLocationRelativeTo(null);
                setSize(400,300);
                setVisible(true);

        l=new JLabel();
        l.setText("SignUp");
        l.setForeground(Color.BLUE);
        l.setFont(new Font("Serif", Font.BOLD, 30));

         l1=new JLabel();
        l1.setText("Enter Username");
        t1=new JTextField(60);

        l2=new JLabel();
        l2.setText("Enter Password");
        t2=new JPasswordField(60);

        b1=new JButton("Submit");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.white);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                FileWriter myfile=new FileWriter("filename.java",true);
                myfile.write(t1.getText()+"\t"+t2.getText());
                 myfile.close();
                JFrame f=new JFrame();
                JOptionPane.showMessageDialog(f,"Registration Successfully");
                dispose();
                }
                catch(Exception e){

                }
            }
        });
        
         l.setBounds(120,10, 300, 30);  
         l1.setBounds(10,55,100, 30);
         l2.setBounds(10,100,100, 30);
         t1.setBounds(120, 55, 120, 30);
         t2.setBounds(120, 100, 120, 30);
         b1.setBounds(120,150,90,30);

        add(l);
        add(l1);
        add(l2);
        add(t1);
        add(t2);
        add(b1);

    }
}

class Login extends JFrame {
    JLabel l,l1,l2;
    JTextField t1,t2;
    JButton b1,b2;
        Login(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login Form");
        setSize(400,300);
        setLocationRelativeTo(null);
        //setVisible(true);
        
        
        l=new JLabel();
        l.setText("Login Form");
        l.setForeground(Color.BLUE);
        l.setFont(new Font("Serif",Font.BOLD,30));  
        
        l1=new JLabel();
        l1.setText("Enter Email");
        t1=new JTextField(60);

        l2=new JLabel();
        l2.setText("Enter Password");
        t2=new JPasswordField(60);

        b1=new JButton("Login");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.white);
         
        b2=new JButton("SignUp");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.white);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
              boolean matched=false;
              String email=t1.getText().toString();
              String password=t2.getText().toString();
              
              try{
              FileReader myread=new FileReader("filename.java");
              BufferedReader br=new BufferedReader(myread);
               String data;
              while((data=br.readLine())!=null){
                if(data.equals(email+"\t"+password)){
                   matched=true;
                }
              }
              myread.close();
            }
              catch(Exception e){}
            if(matched){
              JFrame succ=new JFrame();
              JOptionPane.showMessageDialog(succ,"Success");
              dispose();
            }else{
                JFrame fail=new JFrame();
                JOptionPane.showMessageDialog(fail, "Invalid email or password");
              
            }
        }});

            b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae){
                SignUp signup=new SignUp();
            }
        });

         l.setBounds(120,5, 300, 30);  
         l1.setBounds(10,55,100, 30);
         l2.setBounds(10,100,100, 30);
         t1.setBounds(120, 55, 120, 30);
         t2.setBounds(120, 100, 120, 30);
         b1.setBounds(120,150,90,30);
         b2.setBounds(120,180,90,30);

        add(l);
        add(l1);
        add(l2);
        add(t1);
        add(t2);
        add(b1);
        add(b2);

        setVisible(true);
    }
    public static void main(String[] args) {
        Login l=new Login();
    }
}
