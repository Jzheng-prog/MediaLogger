import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver extends JFrame implements ActionListener {

	private JButton movie;
	private JButton show;
	private JButton anime;
	private JButton manga;
	private JLabel message;
	private JPanel panel = new JPanel();
	private byte check;
	private String type;

	public static void main(String[] args) {
		new Driver();
	}

	public Driver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		panel.setLayout(new GridBagLayout());
		movie = new JButton("Movie"); // Initializes
		show = new JButton("Show");
		anime = new JButton("Anime");
		manga = new JButton("Manga");
		message = new JLabel("Choose what you would like to log.");
		check = 6;
		
		movie.addActionListener(this); // Adds listener to movie
		show.addActionListener(this);
		anime.addActionListener(this);
		manga.addActionListener(this);
		
		
		panel.add(message, new GridBagConstraints());
		panel.add(anime, new GridBagConstraints());
		panel.add(manga, new GridBagConstraints());
		panel.add(show, new GridBagConstraints());
		panel.add(movie, new GridBagConstraints());

		add(panel); // Adds the panel
		setVisible(true); // Lets person see panel
		setResizable(false); // Cannot resize window

		if (checkType().equals("Movie") ) {
			clearScreen();
		}
	}
	
	public JButton buttonGetter(JButton value) {
		return value;
	}

	public byte getCheck() {
		return check;
	}
	// Checks what has been clicked by user
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == movie) {
			check = 1;
		} else if (e.getSource() == show) {
			check = 2;
		} else if (e.getSource() == anime) {
			check = 3;
		} else if (e.getSource() == manga) {
			check = 4;
		}
	}

	/* Method is used to clear screen after a choice has been made, allowing the
	 * user to enter the name of the show, movie, etc..
	 */
	public void clearScreen() {
		panel.removeAll();
		revalidate();
		repaint();
	}

	public String checkType() {

		switch (check) {
		case 0:
			type = "Movie";
			clearScreen();
			break;
		case 1:
			type = "Show";
			clearScreen();
			break;
		case 2:
			type = "Anime";
			clearScreen();
			break;
		case 3:
			type = "Manga";
			clearScreen();
			break;
		}

		return type;
	}

}
