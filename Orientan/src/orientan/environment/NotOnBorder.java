/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orientan.environment;
import java.awt.Point;
/**
 *
 * @author zp
 */
public class NotOnBorder implements Border {

	public static final NotOnBorder INSTANCE = new NotOnBorder();

	private NotOnBorder() {

	}

	@Override
	public boolean isOn(final Point location) {
		return false;
	}

	@Override
	public Point move(final Point location) {
		return location;
	}
}

