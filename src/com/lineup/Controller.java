import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jon on 15-07-15.
 */
public class Controller {

    private static final int LOWEST_NUMBER = 1;
    private final AtomicInteger currentNumber = new AtomicInteger();
    ScreenOutput screen;
    View view;


    Controller() {
        screen = new ScreenOutputImpl();
//        view = new View();
    }

    public static void main(String[] args) {
        System.out.println("hello world");

        Controller controller = new Controller();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new MainFrame("LineUp");
                frame.setSize(500,500);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });


    }

    public void increment() {

        //this should not happen
        if (currentNumber.get() == Integer.MAX_VALUE) {
            currentNumber.set(LOWEST_NUMBER);
        }

        int incrementedNumber = currentNumber.incrementAndGet();

//        screen
        //output.outputNumber(incrementedNumber);
    }

    public void decrement() throws Exception {

        if(currentNumber.get() < LOWEST_NUMBER) {
            throw new Exception("number cannot be negative");
        }

        if(currentNumber.get() == LOWEST_NUMBER) {
            //output.outputNumber(currentNumber.get());
        } else {
            int decrementedNumber = currentNumber.decrementAndGet();
            //output.outputNumber(decrementedNumber);
        }
    }

    public void reset() {
        currentNumber.set(LOWEST_NUMBER);
    }

    private void newScreen() {

    }
}
