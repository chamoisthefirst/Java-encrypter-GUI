package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Main implements ActionListener{

    public static JLabel keyLabel;
    public static JTextField keyTextField;
    public static JLabel messageLabel;
    public static JTextField messageTextField;
    public static JButton encryptButton;
    public static JButton decryptButton;
    public static JLabel outputLabel;
    public static JTextField outputTextField;
    public static Encryptor encryptor = new Encryptor();

    public static void main(String[] args) {

        //text color if it isn't obvious enough
        Color textColor = new Color(0x888888);

        Color backgroundColor = new Color(0x212121);
        Color accentColor = new Color(0x333333);

        

        JPanel panel = new JPanel();
        panel.setBackground(backgroundColor);

        JFrame frame = new JFrame("encryptor");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //frame.setSize(525,190);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setBackground(backgroundColor);
        panel.setLayout(null);

        //showing the window
        frame.setVisible(true);

        int height = frame.getHeight();
        int yAlign = (height-190)/2;
        int width = frame.getWidth();
        int xAlign = (width-525)/2;

        //label width (also button width)
        int lW = 80;

        //text field height
        int tFW = 400+(xAlign);
        xAlign/=2;

        //height
        int h = 25;

        frame.setVisible(false);

        //key label and text field
        keyLabel = new JLabel("Key: ");
        keyLabel.setBounds(xAlign+10,yAlign+20,lW,h);
        keyLabel.setForeground(textColor);
        panel.add(keyLabel);

        keyTextField = new JTextField(20);
        keyTextField.setBounds(xAlign+100, yAlign+20, tFW, h);
        keyTextField.setForeground(textColor);
        keyTextField.setCaretColor(textColor);
        keyTextField.setBackground(accentColor);
        keyTextField.setBorder(BorderFactory.createLineBorder(backgroundColor, 2));
        panel.add(keyTextField);

        
        //message label and text field
        messageLabel = new JLabel("Message: ");
        messageLabel.setBounds(xAlign+10 ,yAlign+50 ,lW , h);
        messageLabel.setForeground(textColor);
        panel.add(messageLabel);

        messageTextField = new JTextField(20);
        messageTextField.setBounds(xAlign+100, yAlign+50, tFW, h);
        messageTextField.setForeground(textColor);
        messageTextField.setBackground(textColor);
        messageTextField.setBackground(accentColor);
        messageTextField.setBorder(BorderFactory.createLineBorder(backgroundColor, 2));
        panel.add(messageTextField);

        //output label and text field
        outputLabel = new JLabel("output");
        outputLabel.setBounds(xAlign+10, yAlign+80, 300, h);
        outputLabel.setForeground(textColor);
        panel.add(outputLabel);

        outputTextField = new JTextField();
        outputTextField.setBounds(xAlign+100, yAlign+80, tFW, h);
        outputTextField.setForeground(textColor);
        outputTextField.setCaretColor(textColor);
        outputTextField.setBackground(accentColor);
        outputTextField.setEditable(false);
        outputTextField.setBorder(BorderFactory.createLineBorder(backgroundColor, 2));
        panel.add(outputTextField);

        int sizeDiff = 15;

        //encrypt button
        encryptButton = new JButton("encrypt");
        encryptButton.setBounds(xAlign+100+tFW/(sizeDiff*2),yAlign+120,tFW*(sizeDiff/2-1)/sizeDiff,h);
        encryptButton.addActionListener(new Main());
        panel.add(encryptButton);

        //decrypt button
        decryptButton = new JButton("decrypt");
        decryptButton.setBounds(xAlign+100+tFW*(sizeDiff+1)/(sizeDiff*2),yAlign+120,tFW*(sizeDiff/2-1)/sizeDiff,h);
        decryptButton.addActionListener(new Main());
        panel.add(decryptButton);

        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        String key = keyTextField.getText();
        String input = messageTextField.getText();
        encryptor.changeKey(key);
            
        if(key.isEmpty() || input.isBlank()){
            return;
        }

        String message;

		if(e.getSource()==encryptButton) {
            message = encryptor.encrypt(input);
		} else if(e.getSource()==decryptButton){
            message = encryptor.decrypt(input);
        }else{
            return;
        }
        outputTextField.setText(message);
    }
}
