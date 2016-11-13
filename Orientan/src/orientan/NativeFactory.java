/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orientan;
import java.awt.image.BufferedImage;
import orientan.environment.Environment;
import orientan.image.NativeImage;
import orientan.image.TranslucentWindow;
//import com.sun.jna.Platform;
/**
 *
 * @author zp
 */
public abstract class NativeFactory {

	private static final NativeFactory instance;

	static {
		String subpkg = "generic";
                /*
		if ( Platform.isWindows() ) {
			subpkg = "win";
		}
                */
		String basepkg = NativeFactory.class.getName();
		// Remove a class name
		basepkg = basepkg.substring(0, basepkg.lastIndexOf('.'));

		try {
			@SuppressWarnings("unchecked")
			final Class<? extends NativeFactory> impl = (Class<? extends NativeFactory>)Class.forName(basepkg+"."+subpkg+".NativeFactoryImpl");

			instance = impl.newInstance();

		} catch (final ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (final InstantiationException e) {
			throw new RuntimeException(e);
		} catch (final IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	public static NativeFactory getInstance() {
		return instance;
	}

	public abstract Environment getEnvironment();

	public abstract NativeImage newNativeImage(BufferedImage src);

	public abstract TranslucentWindow newTransparentWindow();
}
