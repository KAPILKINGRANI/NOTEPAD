//about component
package components;
import java.awt.*;
import java.awt.event.*;
public class About extends Dialog {
	public About(Frame parent,String title) {
		super(parent,title);
		setLayout(new BorderLayout(10,10));
		setVisible(true);
		setSize(500,500);
		Label AboutLabel1 = new Label("This Notepad is built using Java AWT");
		AboutLabel1.setFont(new Font("Serif",Font.ITALIC,20));	
		add(AboutLabel1,BorderLayout.NORTH);

		Label AboutLabel2 = new Label("Made By Kapil Kingrani");
		AboutLabel2.setFont(new Font("Serif",Font.ITALIC,20));	
		add(AboutLabel2,BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}
}
