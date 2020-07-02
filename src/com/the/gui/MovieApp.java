package com.the.gui;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.the.model.movie.MovieService;

public class MovieApp extends JFrame{
	
	Choice ch;
	Button bt;
	MovieService service = new MovieService();
	
	public MovieApp() {
		ch = new Choice();
		bt = new Button("result");
		
		ch.add("parasite");
		ch.add("starwars");
		ch.add("007");
		
		setLayout(new FlowLayout());
		add(ch);
		add(bt);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,150);
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg =service.getAdvice(ch.getSelectedItem());
				JOptionPane.showMessageDialog(MovieApp.this, msg);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new MovieApp();
	}
}


















