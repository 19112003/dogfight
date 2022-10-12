package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.
 * @author client
 * @author Aifa-Boulder-Dash
 * @version 2021
 */

/**
 * The Class View.
 *
 */
public final class View implements IView, Runnable {

	private static final ControllerOrder ControllerOrder = null;
	/** The frame. */
	public final ViewFrame viewFrame;

	
	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_UP:
				return ControllerOrder.Top;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.Right;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.Bottom;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.Left;
			case KeyEvent.VK_1:
				return ControllerOrder.lab1;
			case KeyEvent.VK_2:
				return ControllerOrder.lab2;
			case KeyEvent.VK_3:
				return ControllerOrder.lab3;
			case KeyEvent.VK_4:
				return ControllerOrder.lab4;
			case KeyEvent.VK_5:
				return ControllerOrder.lab5;
				
			default:
				return null;
		}
	}


	/**
	 * Sets the Message.
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
		this.viewFrame.getGraphics().drawString(message, 200, 200);
	}

	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}

	
	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}


	/**
	 * Resetting the Frame used.
	 */
	public void actualiser() {
		this.viewFrame.repaint();
	}
	
	
}
