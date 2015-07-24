package test.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Odin on 15-07-22.
 */
public class View  extends JFrame implements ActionListener {

    private static final long serialVersionUID = 123435L;
    public ArrayList<String> titles = new ArrayList<String>();
    public ArrayList<String> description = new ArrayList<String>();
    public ArrayList<String> links = new ArrayList<String>();
    public ArrayList<Integer> prices = new ArrayList<Integer>();
    public ArrayList<Number> lengths = new ArrayList<Number>();
    public JList list;
    public JComboBox combo;
    public JTextArea textArea = new JTextArea();
    public JLabel priceLabel = new JLabel();
    public JLabel lengthLabel = new JLabel();
    public JScrollPane textScroller;

    public View() {
//        super("test");
//        setLayout(new FlowLayout());
//        JPanel panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
//        add(panel);
//        JPanel labelpanel = new JPanel();
//        labelpanel.setLayout(new BoxLayout(labelpanel, BoxLayout.LINE_AXIS));
//        labelpanel.add(priceLabel);
//        labelpanel.add(Box.createRigidArea(new Dimension(15, 0)));
//        labelpanel.add(lengthLabel);
//        labelpanel.add(Box.createRigidArea(new Dimension(15, 0)));
//        priceLabel.setText("Text");
//        lengthLabel.setText("test");
//        combo = new JComboBox(titles.toArray());
//        panel.add(combo);
//        panel.add(Box.createRigidArea(new Dimension(0, 15)));
//        textScroller = new JScrollPane(40, 5);
//        textArea.setLineWrap(true);
//        textArea.setRows(10);
//        textArea.setWrapStyleWord(true);
//        panel.add(textScroller);
//        panel.add(Box.createRigidArea(new Dimension(0, 15)));
//        panel.add(labelpanel);
//        JButton btn = new JButton("TEST");
//        labelpanel.add(btn);
//        combo.setSelectedIndex(0);

        super("test");
        setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        add(panel);
        JPanel labelpanel = new JPanel();
        labelpanel.setLayout(new BoxLayout(labelpanel, BoxLayout.LINE_AXIS));
        labelpanel.add(priceLabel);
        labelpanel.add(Box.createRigidArea(new Dimension(15, 0)));
        labelpanel.add(lengthLabel);
        labelpanel.add(Box.createRigidArea(new Dimension(15, 0)));
        priceLabel.setText("Text");
        lengthLabel.setText("test");
//        combo = new JComboBox(titles.toArray());
//        panel.add(combo);
//        panel.add(Box.createRigidArea(new Dimension(0, 15)));
//        textScroller = new JScrollPane(40, 5);
//        textArea.setLineWrap(true);
//        textArea.setRows(10);
//        textArea.setWrapStyleWord(true);
//        panel.add(textScroller);
//        panel.add(Box.createRigidArea(new Dimension(0, 15)));
//        panel.add(labelpanel);
//        JButton btn = new JButton("TEST");
//        labelpanel.add(btn);
//        combo.setSelectedIndex(0);

    }

    public void actionperformed(ActionEvent e) {

    }

    public void loadData(String xmlURL) {

    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
