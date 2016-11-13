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
public interface Border {

	public boolean isOn(Point location);

	public Point move(Point location);
}

