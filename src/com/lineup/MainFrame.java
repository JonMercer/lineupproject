import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        JTextArea textArea = new JTextArea();
        JButton button = new JButton("Click Me");


        detailsPanel = new DetailsPanel();


        // Add swing components to content panel

        Container c = getContentPane();

        c.add(textArea, BorderLayout.CENTER);
        c.add(button, BorderLayout.SOUTH);
        c.add(detailsPanel, BorderLayout.WEST);



        //behaviour
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Called when button is clicked

            }
        });

    }
}
