

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame implements ActionListener {

	private Random random=new Random();
	private DataPanel dataPanel=new DataPanel();
	private JButton buttonCheck=new JButton("Check");
	private JButton buttonReset=new JButton("Reset");
	private JButton buttonCamera=new JButton("Camera");
	
	public MainWindow() {
		JPanel buttonPanel=new JPanel();
		buttonReset.addActionListener(this);
		buttonPanel.add(buttonReset);
		
		buttonCamera.addActionListener(this);
		buttonPanel.add(buttonCamera);
		
		buttonCheck.addActionListener(this);
		buttonPanel.add(buttonCheck);
		add(buttonPanel,BorderLayout.SOUTH);
		add(dataPanel,BorderLayout.CENTER);
		
		reset();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source=e.getSource();
		if(source==buttonCheck){
			check();
		}else if(source==buttonReset){
			reset();
		}else if(source==buttonCamera){
			showCamera();
		}
	}

	private void check(){
		dataPanel.setOuterTemperature(random.nextDouble()*50+50);		
		dataPanel.setInnerTemperature(random.nextDouble()*20+70);
		dataPanel.setHumidity(random.nextDouble()*30+30);
		dataPanel.setOxygen(random.nextDouble()*5+25);
	}
	private void reset(){
		dataPanel.setOuterTemperature(50);
		dataPanel.setInnerTemperature(70);
		dataPanel.setHumidity(30);
		dataPanel.setOxygen(30);
	}

	private void showCamera() {
		new CameraWindow(this).setVisible(true);
	}

}
