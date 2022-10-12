package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.IBlock;
import contract.IPlayer;
import model.Block;

/**
 * The Class Controller.
 * @author client
 * @author Aifa-Boulder-Dash
 * @version 2021
 */

/**
 * The Class ViewPanel.
 *
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	
	private ArrayList<IBlock> map;
	
	private IPlayer player;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		this.map = viewFrame.getModel().getMap().getGeneratedMap();
		this.player = viewFrame.getModel().getPlayer();
	}

	public ViewPanel(String string) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	public ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}


	@Override
	protected void paintComponent(final Graphics graphics) {
		for (int i=0; i<this.map.size(); i++) {
			Block block = (Block) this.map.get(i);
			graphics.drawImage(block.getSprite(), block.getPosX(), block.getPosY(), this);
		}
		graphics.drawImage(this.player.getSprite(), this.player.getPosX(), this.player.getPosY(), this);
		graphics.setColor(Color.green);
		graphics.fillRect(16, 0, 55, 16);
		graphics.setColor(Color.black);
		graphics.drawString("Score : " + this.player.getScore(), 18, 12);
	}
}
