

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class CameraWindow extends JDialog{

	private JButton buttonAddCamera=new JButton("<html><center>Add<br>Camera</center></html>");
	public CameraWindow(Frame owner) {
		super(owner,true);
		setTitle("Camera");
		setLocation(10,10);
		setResizable(false);
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		addCamera(panel,"North Facing",0);
		addCamera(panel,"South Facing",1);
		addCamera(panel,"Entrance",2);
		addCamera(panel,"External",3);
		add(panel,BorderLayout.CENTER);
		panel=new JPanel();
		panel.add(buttonAddCamera);
		add(panel,BorderLayout.SOUTH);
		pack();
	}

	private void addCamera(JPanel parent, String title,int index){
		CameraPanel cameraPanel=new CameraPanel(index);
		JPanel panel=new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(title));
		panel.setLayout(new BorderLayout());
		panel.add(cameraPanel,BorderLayout.CENTER);
		panel.add(new CameraControl(cameraPanel),BorderLayout.EAST);
		parent.add(panel);
	}
}
