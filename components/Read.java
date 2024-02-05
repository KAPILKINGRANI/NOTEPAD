package components;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Read extends Dialog {
	public Read(Frame parent,String title,TextArea notepadArea) {
		super(parent,title);
		setLayout(new FlowLayout());
		setSize(400,400);
		// setVisible(true);
		FileDialog fd = new FileDialog(parent,"fileDialog",FileDialog.LOAD);
		fd.setVisible(true);
		

		if(fd.getDirectory()!= null && fd.getFile()!= null) {
			try 
			{
				FileInputStream fis = new FileInputStream(fd.getDirectory()+fd.getFile());
				BufferedReader  br = new BufferedReader(new InputStreamReader(fis));
				String line;
				while((line=br.readLine())!= null) {
				notepadArea.append(line);
				notepadArea.append("\n");
				}
				br.close();
				fis.close();

			}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found Exception");
		}
		catch(IOException e) {
			System.out.println("IOException Caught!!!!");
		}
		
	}
	addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}
}