package SoundCork;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener, KeyListener {
	// Clicking mouse draws the screen.

	int width = 300;
	int height = 200;

	Image[] imageAr;

	Thread thread;
	Image image;
	Graphics g;

	// Vars for gLoop Above

	public Panel() {
		super();

		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		requestFocus();

		addKeyListener(this);
		addMouseListener(this);

		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		this.setSize(new Dimension(width, height));

		pStart();
	}

	/**
	 * Methods go below here.
	 * 
	 */

	Sound sound = new Sound();

	public void pStart() {
		imageInit();
		initButts();
		sound.initSounds();
	}

	float[][] butts;

	void initButts() {
		butts = new float[4][5];
		// [x][0] = x
		// [x][1] = y
		// [x][2] = width
		// [x][3] = height
		// [x][4] = do#
		butts[0] = new float[] { 20, 20, 20, 26, 0 };
		butts[1] = new float[] { 54, 20, 20, 26, 1 };
		butts[2] = new float[] { 88, 20, 20, 26, 2 };
		butts[3] = new float[] { 124, 20, 20, 26, 3 };
	}

	void checkButts(float[] clickLoc) {
		for (int b = 0; b < butts.length; b++) {
			float[] veUp = VeMa.vectSub(clickLoc, new float[] { butts[b][0],
					butts[b][1] });
			float[] veDown = VeMa.vectSub(clickLoc, VeMa.vectAdd(new float[] {
					butts[b][0], butts[b][1] }, new float[] { butts[b][2],
					butts[b][3] }));
			if (veUp[0] >= 0 && veUp[1] >= 0) {
				if (veDown[0] < 0 && veDown[1] < 0) {
					// hit
					pushButt((int) butts[b][4]);
				}
			}
		}
	}

	void pushButt(int buttNum) {
		System.out.println("pushButt: " + buttNum);
		if (buttNum == 0) {
			// sound.test2();
			sound.playSound(0);
		} else if (buttNum == 1) {
			// sound.dedWam();
			sound.playSound(1);
		} else if (buttNum == 2) {
			// sound.dedWam();
			sound.playSound(2);
		} else if (buttNum == 3) {
			// sound.dedWam();
			sound.playSound(3);
		}
	}

	void drawButts() {

		for (int b = 0; b < butts.length; b++) {
			if (b == 0 || b == 2) {
				g.setColor(Color.GREEN);
			} else {
				g.setColor(Color.RED);
			}
			g.fillRect((int) butts[b][0], (int) butts[b][1], (int) butts[b][2],
					(int) butts[b][3]);
		}
	}

	/**
	 * Methods go above here.
	 * 
	 */

	public void drwGm() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}

	public void imageInit() {
		/**
		 * imageAr = new Image[1]; ImageIcon ie = new
		 * ImageIcon(this.getClass().getResource( "res/image.png")); imageAr[0]
		 * = ie.getImage();
		 */

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		drwGm();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent me) {
		drawButts();
		checkButts(new float[] { me.getX(), me.getY() });
		drwGm();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent ke) {

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
