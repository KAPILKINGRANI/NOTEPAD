//find component
package components;
import java.awt.*;
import java.awt.event.*;
public class FindComponent extends Dialog implements ActionListener {
		TextArea notepadArea;
		String notepadString="";
		String findString="";
		int len,index,endIndex,indexN;
		TextArea fa;
		Button find,findNext,replace;

	public FindComponent(Frame parent,String title,TextArea notepadArea) {
		super(parent,title,false);
		setLayout(new FlowLayout());
		setSize(400,400);
		setVisible(true);

		//important we make a copy
		this.notepadArea = notepadArea;
		
		fa = new TextArea("",10,0);
		find = new Button("Find");
		findNext = new Button("FindNext");
		replace = new Button("Replace");

		add(fa);

		add(find);
		add(findNext);


		find.addActionListener(this);
		findNext.addActionListener(this);
			
		

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
			else if(str.equals("FindNext")) {
				indexN = notepadString.indexOf(findString,index+1);
				//this is for if word nahi mila toh
				if(indexN!=-1)
				{
					notepadArea.select(indexN,indexN+len);
					notepadArea.requestFocus();
				}
				index = indexN;
			}
	    	
		}

}
