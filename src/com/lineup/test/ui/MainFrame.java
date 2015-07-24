package test.ui;

import javax.swing.*;
import java.awt.*;


//https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
//Most People Use GridBagLayout

//http://da2i.univ-lille1.fr/doc/tutorial-java/ui/features/components.html


///https://www.youtube.com/watch?v=DJqlT1d67jI
/**
 * Created by Odin on 15-07-22.
 */
public class MainFrame extends JFrame {

    private DetailsPanel detailsPanel;
    public MainFrame(String title) {
        super(title);


        //Set Layout manager
        //lets you add layout on top bottom and left right of frame
        setLayout(new BorderLayout());


        //Create swing Component
        final JTextArea textArea = new JTextArea();


        detailsPanel = new DetailsPanel();

        detailsPanel.addDetailListener(new DetailListener(){
            public void detailEventOccured(DetailEvent event) {

                String text = event.getText();

                textArea.append(text);
            }
        });


        // Add swing components to content panel

        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        c.add(detailsPanel, BorderLayout.WEST);


    }
}
