package components;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ImageButton extends JButton{
	public ImageButton(String imageFileName){
		ImageIcon icon = new ImageIcon(imageFileName);
		setIcon(icon);
		
        setBorderPainted(false);
        setContentAreaFilled(false);
	}
}
