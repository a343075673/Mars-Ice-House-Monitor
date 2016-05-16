import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DataPanel extends JPanel {
	
	private JLabel labelOuterTemperature=new JLabel("",JLabel.CENTER);
	private JLabel labelInnerTemperature=new JLabel("",JLabel.CENTER);
	private JLabel labelHumidity=new JLabel("",JLabel.CENTER);
	private JLabel labelOxygen=new JLabel("",JLabel.CENTER);
	private Font dataFont;
	
	private double outerTemperature;
	private double innerTemperature;
	private double humidity;
	private double oxygen;
	
	public DataPanel(){
		setLayout(new GridLayout(2, 2));
		dataFont=getFont().deriveFont(80f);
		labelOuterTemperature.setBorder(BorderFactory.createTitledBorder("Outer temperature (unit: F)"));
		labelOuterTemperature.setFont(dataFont);
		add(labelOuterTemperature);
		
		labelInnerTemperature.setBorder(BorderFactory.createTitledBorder("Inner temperature (unit: F)"));
		labelInnerTemperature.setFont(dataFont);
		add(labelInnerTemperature);
		
		labelHumidity.setBorder(BorderFactory.createTitledBorder("Humidity (unit: %)"));
		labelHumidity.setFont(dataFont);
		add(labelHumidity);
		
		labelOxygen.setBorder(BorderFactory.createTitledBorder("Oxygen (unit: %)"));
		labelOxygen.setFont(dataFont);
		add(labelOxygen);
	}
	
	public double getOuterTemperature() {
		return outerTemperature;
	}

	public double getInnerTemperature() {
		return innerTemperature;
	}
	
	public double getHumidity() {
		return humidity;
	}
	
	public double getOxygen() {
		return oxygen;
	}
	
	public void setOuterTemperature(double outerTemperature){
		this.outerTemperature=outerTemperature;
		labelOuterTemperature.setText(String.format("%1.2f°", outerTemperature));
	}

	public void setInnerTemperature(double innerTemperature){
		this.innerTemperature=innerTemperature;
		labelInnerTemperature.setText(String.format("%1.2f°", innerTemperature));
		if(innerTemperature>=85){
			labelInnerTemperature.setForeground(Color.RED);
		}else{
			labelInnerTemperature.setForeground(Color.BLACK);			
		}
	}

	public void setHumidity(double humidity){
		this.humidity=humidity;
		labelHumidity.setText(String.format("%1.2f%%", humidity));
		if(humidity>=50){
			labelHumidity.setForeground(Color.RED);
		}else{
			labelHumidity.setForeground(Color.BLACK);			
		}
	}

	public void setOxygen(double oxygen){
		this.oxygen=oxygen;
		labelOxygen.setText(String.format("%1.2f%%", oxygen));
		if(oxygen<=27){
			labelOxygen.setForeground(Color.RED);
		}else{
			labelOxygen.setForeground(Color.BLACK);			
		}
	}
}
