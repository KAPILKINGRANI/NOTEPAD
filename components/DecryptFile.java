package components;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class DecryptFile extends Dialog {					 
	static String fileName;//static isliye banaya taaki har object ke amongs share ho
	public DecryptFile(Frame parent,String title,TextArea NotepadArea) {
			super(parent,title);
			setLayout(new FlowLayout());
			setSize(300,300);
			// setVisible(true);
				FileDialog fd = new FileDialog(parent,"fileDialog",FileDialog.SAVE);
				fd.setVisible(true);
				fileName = fd.getDirectory()+fd.getFile();
				System.out.println();
			
		try {
			File f = new File(fileName);//file declaration
			FileOutputStream fout = new FileOutputStream(f);//declared file mai content jaane ke liye
			PrintWriter pw = new PrintWriter(fout,true);//declared file mai content likhne ke liye
			String line = NotepadArea.getText();//declared file mai notepad ka content daalne ke liye
			String decryptedLine = "";
			for(int i=0;i<line.length();i++) {
				char ch = (char)(line.charAt(i)-4);
				decryptedLine = decryptedLine + ch;
			}
			pw.print(decryptedLine);
			pw.close();
			fout.close();

		}
		catch(IOException e) {
			System.out.println("Io caught");
		}
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}	
}
