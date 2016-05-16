import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class CameraControl extends JPanel implements ActionListener {

	private CameraPanel cameraPanel;
	private JButton buttonUp=new JButton("↑");
	private JButton buttonDown=new JButton("↓");
	private JButton buttonLeft=new JButton("←");
	private JButton buttonRight=new JButton("→");
	private JButton buttonZoomIn=new JButton("+");
	private JButton buttonZoomOut=new JButton("-");
	public CameraControl(CameraPanel cameraPanel){
		this.cameraPanel=cameraPanel;
		setLayout(new GridLayout(6, 1));
		
		buttonUp.addActionListener(this);
		add(buttonUp);

		buttonDown.addActionListener(this);
		add(buttonDown);

		buttonLeft.addActionListener(this);
		add(buttonLeft);

		buttonRight.addActionListener(this);
		add(buttonRight);

		buttonZoomIn.addActionListener(this);
		add(buttonZoomIn);

		buttonZoomOut.addActionListener(this);
		add(buttonZoomOut);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		if(source==buttonZoomIn){
			cameraPanel.zoomIn();
		}else if(source==buttonZoomOut){
			cameraPanel.zoomOut();
		}else if(source==buttonUp){
			cameraPanel.moveUp();
		}else if(source==buttonDown){
			cameraPanel.moveDown();
		}else if(source==buttonLeft){
			cameraPanel.moveLeft();
		}else if(source==buttonRight){
			cameraPanel.moveRight();
		}
	}
}
