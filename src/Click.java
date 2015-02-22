import java.applet.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class Click extends JApplet implements MouseMotionListener,MouseListener,ActionListener,Runnable{
	JButton b,ply,stp;
	int score=0;
	JLabel lb;
	AudioClip clip;
	Thread t1,t2;
	public void init(){
		setLayout(null);
		ImageIcon ii=new ImageIcon("fig1.png");
		b=new JButton("Click Me",ii);
		ply=new JButton("Play");
		stp=new JButton("Stop");
		
		ply.setBounds(400, 50, 100, 40);
		stp.setBounds(400, 100, 100, 40);
		b.setBounds(50, 50, 200, 150);
		add(b);add(ply);add(stp);
		lb=new JLabel("Score:" +score);
		lb.setBounds(500, 50, 80, 40);
		add(lb);
		
		t1=new Thread("one");
		t1.start();
		System.out.println("1)"+Thread.currentThread().getId());
		System.out.println("2)"+t1.getId());
		
		b.addMouseListener(this);
		b.addMouseMotionListener(this);
		ply.addActionListener(this);
		stp.addActionListener(this);
	}


	public void run(){
		System.out.println("Great");
		System.out.println(Thread.currentThread().getId()+"Great");
		return;
	}
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		ImageIcon ii=new ImageIcon("fig2.png");
		b.setIcon(ii);
		score=score+100;
		lb.setText("Score:"+score);
		t1.notify();
		int x=(int)(400*Math.random());
		int y=(int)(600*Math.random());
		b.setBounds(x, y, 200, 150);
	}
	public void mouseEntered(MouseEvent arg0){
		// TODO Auto-generated method stub
		int x=(int)(400*Math.random());
		int y=(int)(600*Math.random());
		b.setBounds(x,y,200,150);
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		ImageIcon ii=new ImageIcon("fig1.png");
		b.setIcon(ii);
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x=(int)(400*Math.random());
		int y=(int)(600*Math.random());
		b.setBounds(x, y, 200, 150);
	}

	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x=(int)(400*Math.random());
		int y=(int)(600*Math.random());
		b.setBounds(x, y, 200, 150);
	}
	

	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==ply){
			clip=getAudioClip(getDocumentBase(),"Song.wav");
			clip.play();
		}
		if(ae.getSource()==stp){
			clip.stop();
		}
	}

}
