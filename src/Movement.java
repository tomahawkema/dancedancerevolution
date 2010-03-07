import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Movement extends Applet implements Runnable {
    int squareSize;
    int frameNumber;
    int delay;
    Thread animatorThread;
    boolean fillColumnTop = true;
    Dimension offDimension;
    Image offImage;
    Graphics offGraphics;

    public void init() {
	String str;

	// How many milliseconds between frames?
	str = getParameter("fps");
	int fps = (str != null) ? Integer.parseInt(str) : 10;
	delay = (fps > 0) ? (1000 / fps) : 100;

	// How many pixels wide is each square?
	str = getParameter("squareWidth");
	squareSize = (str != null) ? Integer.parseInt(str) : 20;
    }

    public void start() {
	if (animatorThread == null) {
	    animatorThread = new Thread(this);
	    animatorThread.start();
	}
    }

    public void stop() {
	animatorThread = null;
	offImage = null;
	offGraphics = null;
    }

    public boolean mouseDown(Event e, int x, int y) {
	if (animatorThread == null) {
	    start();
	}
	else {
	    stop();
	}
	return false;
    }

    public void run() {
	// Remember the starting time
	long startTime = System.currentTimeMillis();

	while (Thread.currentThread() == animatorThread) {
	    // Display the next frame of animation.
	    repaint();

	    // Delay depending on how far we are behind.
	    try {
		startTime += delay;
		Thread.sleep(Math.max(0, 
				      startTime-System.currentTimeMillis()));
	    } catch (InterruptedException e) {
		break;
	    }

	    frameNumber++;
	}
    }

    // Paint the previous frame (if any).
    public void paint(Graphics g) {
        if (offImage != null) {
	    g.drawImage(offImage, 0, 0, this);
        }
    }

    public void update(Graphics g) {
	Dimension d = size();
	boolean fillSquare;
	boolean fillNextFrame;
	int rowWidth = 0;
	int x = 0, y = 0;
	int w, h;
	int tmp;

        // Create the offscreen graphics context, if no good one exists.
        if ( (offGraphics == null)
          || (d.width != offDimension.width)
          || (d.height != offDimension.height) ) {
            offDimension = d;
            offImage = createImage(d.width, d.height);
            offGraphics = offImage.getGraphics();
        }

	// Erase the previous image.
        offGraphics.setColor(getBackground());
        offGraphics.fillRect(0, 0, d.width, d.height);
        offGraphics.setColor(Color.black);

	// Set width of first "square". Decide whether to fill it.
	fillSquare = fillColumnTop;
	fillColumnTop = !fillColumnTop;
	tmp = frameNumber % squareSize;
	if (tmp == 0) {
	    w = squareSize;
	    fillNextFrame = !fillSquare;
	} else {
	    w = tmp;
	    fillNextFrame = fillSquare;
	}

	// Draw from left to right.
	while (x < d.width) {
	    int colHeight = 0;

	    //Draw the column.
	    while (y < d.height) {
		colHeight += squareSize;

		// If we don't have room for a full square, cut if off.
		if (colHeight > d.height) {
		    h = d.height - y;
		} else {
		    h = squareSize;
		}

		// Draw the rectangle if necessary.
		if (fillSquare) {
		    offGraphics.fillRect(x, y, w, h);
		    fillSquare = false;
		} else {
		    fillSquare = true;
		} 

		y += h;
	    } // while y

	    // Determine x, y, and w for the next go around.
	    x += w;
	    y = 0;
	    w = squareSize;
	    rowWidth += w;
	    if (rowWidth > d.width) {
		w = d.width - x;
	    }
	    fillSquare = fillColumnTop;
	    fillColumnTop = !fillColumnTop;
	} // while x
	fillColumnTop = fillNextFrame;
	
	// Paint the image onto the screen.
	g.drawImage(offImage, 0, 0, this);
    }
}