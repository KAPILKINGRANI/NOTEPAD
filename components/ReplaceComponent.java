//replace component
package components;
import java.awt.*;
import java.awt.event.*;
public class ReplaceComponent extends Dialog implements ActionListener {
		TextArea notepadArea;

		String notepadString="";
		String findString="";
		String replaceString="";

		int len,index,endIndex;

		TextArea fa,ra;

		Button find,replace;

	public ReplaceComponent(Frame parent,String title,TextArea notepadArea) {
		super(parent,title,false);
		setLayout(new FlowLayout());
		setSize(400,400);
		setVisible(true);

		//important we make a copy
		this.notepadArea = notepadArea;
		
		fa = new TextArea("",10,0);
		ra = new TextArea("",20,10);
		find = new Button("Find");
		replace = new Button("Replace");

		add(fa);
		add(ra);

		add(find);
		add(replace);


		find.addActionListener(this);
		replace.addActionListener(this);
			
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}
	public void actionPerformed(ActionEvent ae) {
			String str = ae.getActionCommand();
			if(str.equals("Find")) {
				notepadString = notepadArea.getText();
				findString = fa.getText();
				len = findString.length();
				index = notepadString.indexOf(findString);
				endIndex = index+len;
				if(index!=-1) {
					notepadArea.select(index,endIndex);
					notepadArea.requestFocus();
				}
			}
			else if(str.equals("Replace")) {
				notepadString = notepadArea.getText();
				replaceString = ra.getText();
				notepadArea.replaceRange(replaceString,index,index+len);
			}
	    	
		}

}
