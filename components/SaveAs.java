package components;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class SaveAs extends Dialog {
	public SaveAs(Frame parent,String title,TextArea NotepadArea) {
		super(parent,title);
		setLayout(new FlowLayout());
		setSize(300,300);
		// setVisible(true);
		FileDialog fd = new FileDialog(parent,"fileDialog",FileDialog.SAVE);
		fd.setVisible(true);
		try {
			File f = new File(fd.getDirectory()+fd.getFile());//file declaration
			FileOutputStream fout = new FileOutputStream(f);//declared file mai content jaane ke liye
			PrintWriter pw = new PrintWriter(fout,true);//declared file mai content likhne ke liye
			String line = NotepadArea.getText();//declared file mai notepad ka content daalne ke liye
			pw.println(line);
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

