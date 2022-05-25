public class Plot {
	public int x, y, depth, width;
	
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.depth = 1;
		this.width = 1;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.width = width;
	}
	
	public boolean overlaps(Plot plot) {
		boolean overlaps = false;
		int counter = 0;
		
		//See if the x & width overlap with the two plots
		if(x < plot.getX() + plot.getWidth()) {
			counter++;
		}
		if(x + width > plot.getX()) {
			counter++;
		}
		
		//See if the y & depth overlap with the two plots
		if(y < plot.getY() + plot.getDepth()) {
			counter++;
		}
		if(y + depth > plot.getY()) {
			counter++;
		}
		
		//If every previous loop was right then the plots haven't overlaped
		if(counter == 4) {
			overlaps = true;
		}
		return overlaps;
	}
	
	public boolean encompasses(Plot plot) {
		boolean encompass = false;
		int counter = 0;
		
		//See if plot's x is between the main's x
		if(x <= plot.getX()) {
			counter++;
		}
		if(plot.getX()+plot.getWidth() <= (x + width)) {
			counter++;
		}
		
		//See if plot's y is between the main's y
		if(y <= plot.getY()) {
			counter++;
		}
		if(plot.getX()+plot.getWidth() <= (x + width)) {
			counter++;
		}
		
		//If every previous loop was right then the plots haven't left the one plots space
		if(counter == 4) {
			encompass = true;
		}
		return encompass;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}
}
