/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageSetChooser;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author zp
 */
public class ImageSetChooser {

    // Top Level Directory
    private final String topDir = "./img";
    //存放多個角色名字的String list
    private ArrayList<String> imageSets = new ArrayList<String>();
    //角色名字
    public String imageSet = "";
    //總共多少個角色資料夾
    protected int character_number = 0;
    ArrayList<ImageSetChooserPanel> data=new ArrayList<ImageSetChooserPanel>();
    public void ImageSetChooser() {
        //準備好視窗內的各種物件
        initChooserLayout();
    }

    //init a new window to select character
    private void initChooserLayout() {
        /*stage,scene 設定*/
        Stage stage_chooser = new Stage();
        BorderPane root_chooser = new BorderPane();
        Scene scene_chooser = new Scene(root_chooser, 900, 600);
        stage_chooser.setScene(scene_chooser);
        stage_chooser.setTitle("Character Chooser");
        /**/
        LoadImageSets(imageSets);
        //ScrollPane
        root_chooser.setCenter(addScrollPane(character_number,imageSets));
        stage_chooser.show();

    }
/*
    private ListView addListView( ObservableList<ImageSetChooserPanel> data) {
        ListView<ImageSetChooserPanel> List = new ListView<>();
        List.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        List.setOrientation(Orientation.VERTICAL);
        List.setItems(data);
        List.setCellFactory((ListView<ImageSetChooserPanel> l) -> new ImageSetChooserPanel("asa","asas"));
        
        return List;
    }
*/
    private ScrollPane addScrollPane(int character_number,ArrayList<String> imageSets)
    {
        VBox vb=new VBox();
        ScrollPane sp= new ScrollPane(vb);
        String[] imageSetArray=new String[imageSets.size()];
        imageSets.toArray(imageSetArray);
        for(int i=0;i<character_number;i++)
        {
          vb.getChildren().add(new ImageSetChooserPanel(imageSetArray[i],"./img/"+imageSetArray[i]+"/shime1.png"));  
        }
        
        return sp;
    }
    //讀取角色圖包資料夾個數，並存角色名稱到imageSets內
    private void LoadImageSets(ArrayList<String> imageSets) {
        FilenameFilter fileFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                if (name.equals("unused") || name.equals(".svn")) {
                    return false;
                }
                return new File(dir + "/" + name).isDirectory();
            }
        };
        File dir = new File(topDir);
        String[] dirChildren = dir.list(fileFilter);
        for(String imagetmp:dirChildren)
        {
            imageSets.add(imagetmp);
            character_number++;
        }
    }

}
