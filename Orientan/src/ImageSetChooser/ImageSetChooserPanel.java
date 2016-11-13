/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageSetChooser;


import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author zp
 */
//scrollPane內包含checkbox,text,imageview的容器class
public class ImageSetChooserPanel extends javafx.scene.layout.AnchorPane{
    /*
    public ImageSetChooserPanel() {
        
    }
*/
    public ImageSetChooserPanel(String name,String imageLocation)
    {
       CheckBox cb= new CheckBox();
       Label name_Label=new Label();
       name_Label.setText(name);
       ImageView img=new ImageView(imageLocation);     
       setTopAnchor(cb, 5.0);
       setLeftAnchor(name_Label,10.0);
       setRightAnchor(img,8.0);
    }

}
