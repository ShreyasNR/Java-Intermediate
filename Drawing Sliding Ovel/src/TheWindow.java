import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class TheWindow extends JFrame{
	
	private JSlider slider;
	private DrawOvel myPanel;
	
	public TheWindow(){
		
		super("The Title");
		myPanel = new DrawOvel();
		myPanel.setBackground(Color.ORANGE);
		
		slider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		
		slider.addChangeListener(
			new ChangeListener(){
				public void stateChanged(ChangeEvent e){
					myPanel.setD(slider.getValue());
				}
			}
				
		);
		
		add(slider, BorderLayout.SOUTH);
		add(myPanel, BorderLayout.CENTER);
	}

}
