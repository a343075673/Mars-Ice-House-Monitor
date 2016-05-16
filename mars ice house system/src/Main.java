

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.invokeLater(new Runnable(){
			
			@Override
			public void run() {
				ImageHelper.getInstance();
			};
		});
		MainWindow mainWindow=new MainWindow();
		mainWindow.setTitle("Alert");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setBounds(10, 10, 800, 600);
		mainWindow.setVisible(true);
	}
}
