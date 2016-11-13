/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orientan.image;
import java.util.Hashtable;
import orientan.image.MascotImage;
/**
 *
 * @author zp
 */
public class ImagePairs {

	public static Hashtable<String,ImagePair> imagepairs = new Hashtable<String,ImagePair>(); 

	public static void load(final String filename, final ImagePair imagepair) {
		if( !imagepairs.containsKey( filename ) )
			imagepairs.put( filename, imagepair );
	}

	public static ImagePair getImagePair( String filename ) {
		if( !imagepairs.containsKey( filename ) )
			return null;
		ImagePair ip = imagepairs.get( filename );
		return ip;
	}	
	
	public static boolean contains( String filename ) {
		return imagepairs.containsKey( filename );
	}
	
	public static MascotImage getImage( String filename, boolean isLookRight ) {
		if( !imagepairs.containsKey( filename ) )
			return null;
		return imagepairs.get( filename ).getImage( isLookRight );
	}
}