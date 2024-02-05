import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import components.*;

class NotepadFrame extends Frame implements ActionListener {
	TextArea np;
	NotepadFrame(String title) {

		//===================================================================================
		//Basic Frame
		//===================================================================================
		super(title);
		setVisible(true);
		setSize(500,500);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent We) {
					System.exit(0);
			}
		});
		//===================================================================================

		//===================================================================================
		//for adding menu(frame)
		//===================================================================================

		setVisible(true);
		setSize(400,400);
		

		MenuBar mbar = new MenuBar();

		setMenuBar(mbar);

		Menu fileMenu  = new Menu("FILE");
		Menu editMenu  = new Menu("EDIT");
		Menu formatMenu= new Menu("FORMAT");
		Menu aboutMenu = new Menu("ABOUT");
		Menu exitMenu = new Menu("EXIT");

		mbar.add(fileMenu);
		mbar.add(editMenu);
		mbar.add(formatMenu);
		mbar.add(aboutMenu);
		mbar.add(exitMenu);

		//fileMenu Items
		MenuItem new1 = new MenuItem("NEW");
		MenuItem open = new MenuItem("OPEN");
		MenuItem saveAs = new MenuItem("SAVEAS");
		MenuItem saveEncrypted = new MenuItem("SaveEncrypted");
		MenuItem save = new MenuItem("SAVE");
		MenuItem decrypt = new MenuItem("DECRYPT");

		//editMenu Items
		MenuItem find = new MenuItem("FIND");
		MenuItem replace = new MenuItem("REPLACE");

		//formatMenu Items
		Menu font = new Menu("FONT");
		MenuItem wordwrap = new MenuItem("WORDWRAP");

		// aboutMenu Items
		MenuItem about = new MenuItem("ABOUTS");

		//exitMenu Items
		MenuItem exit = new MenuItem("EXIT");

		MenuItem serif = new MenuItem("Serif");
		MenuItem sansSerif = new MenuItem("SansSerif");
		font.add(serif);
		font.add(sansSerif);

		//========================================================================

		//adding menuitems to respective menu

		fileMenu.add(new1);
		fileMenu.add(open);
		fileMenu.add(saveAs);
		fileMenu.add(saveEncrypted);
		fileMenu.add(save);
		fileMenu.add(decrypt);


		editMenu.add(find);
		editMenu.add(new MenuItem("-"));
		editMenu.add(replace);

		formatMenu.add(font);
		formatMenu.add(new MenuItem("-"));
		formatMenu.add(wordwrap);

		aboutMenu.add(about);

		exitMenu.add(exit);

		//===================================================================================

		//===================================================================================
		//TextArea
		//===================================================================================

		np = new TextArea("",30,60);
		np.setFont(new Font("Serif",Font.ITALIC,26));
		add(np);
		np.requestFocus();
		//===================================================================================
		about.addActionListener(this);
		find.addActionListener(this);
		exit.addActionListener(this);
		open.addActionListener(this);
		replace.addActionListener(this);
		saveAs.addActionListener(this);
		saveEncrypted.addActionListener(this);
		new1.addActionListener(this);
		sansSerif.addActionListener(this);
		save.addActionListener(this);
		decrypt.addActionListener(this);


	}
	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		if(str.equals("NEW")){
			np.setText(" ");
		}
		if(str.equals("ABOUTS")){
			new About(this,"about");
		}
		else if(str.equals("FIND")) {
			new FindComponent(this,"find",np);
		}
		else if(str.equals("REPLACE")) {
			new ReplaceComponent(this,"Replace",np);
		}
		else if(str.equals("OPEN")) {
			//np.scrollbars("");
			new Read(this,"OPEN",np);
		}
		else if(str.equals("EXIT")) {
			System.out.println("Thankyou for using Notepad!");
			System.exit(0);
		}
		else if(str.equals("SAVEAS")) {
			new SaveAs(this,"SaveAs",np);
		}
		else if(str.equals("SansSerif")) {
			np.setFont(new Font("SansSerif",Font.ITALIC,26));
		}
		else if(str.equals("SaveEncrypted")) {
			new SaveAsEncrpyt(this,"SaveEncrypted",np);
		}
		else if(str.equals("SAVE")) {
			new Save(this,"SAVE",np);
		}
		else if(str.equals("DECRYPT")) {
			new DecryptFile(this,"DECRYPT",np);
		}
	}
}
public class Notepad {
	public static void main(String[] args) {
		System.out.println("Notepad Started");
		new NotepadFrame("Notepad");
	}
}