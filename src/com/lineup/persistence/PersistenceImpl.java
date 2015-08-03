package persistence;

import controller.Pair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Created by Jon Mercer on 15-08-03.
 */
public class PersistenceImpl implements Persistence {

    private static final String PATH = "/Users/Odin/lineupproject/persistence.txt";

    @Override
    public boolean accidentalReboot() {


        File file = new File(PATH);

        if (!file.exists()) {
            return false;
        } else {
            String line = readFromFile();
            //TODO: figure out a better solution than line length
            if (line.length() < 10) {
                return false;
            } else {
                return true;
            }
        }


    }

    @Override
    public void saveState(State state) {
        writeToFile(stateToString(state));
    }

    @Override
    public State loadState() {
        return stringToState(readFromFile());
    }

    private String readFromFile() {
        BufferedReader br = null;
        String lastKnownLine = null;
        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(PATH));

            while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine != null) {
                    lastKnownLine = sCurrentLine;
                }
                System.out.println(sCurrentLine);
            }

            return lastKnownLine;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    private void writeToFile(String content) {
        try {

//            String content = "This is the content to write into file";

            File file = new File("/Users/Odin/lineupproject/persistence.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String stateToString(State state) {
        String string = "";

        string = string + state.getScreenNum() + "," + state.getPrintNum() + ",";

        Iterator<Pair> iterator = state.getDeque().iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            string = string + pair.getLeft() + "," + pair.getRight() + ",";
        }

        return string;
    }

    private State stringToState(String string) {
        Deque<Pair> deque = new ArrayDeque<Pair>();
        int screenNum = 0;
        int printNum = 0;

        String[] split = string.split(",");
        for (int i = 0; i < split.length; i=i+2) {
            if (i == 0) {
                screenNum = Integer.parseInt(split[i]);
                printNum = Integer.parseInt(split[i + 1]);
            } else {
                Integer queueNumber = Integer.parseInt(split[i]);
                Integer roomNumber = Integer.parseInt(split[i+1]);

                Pair<Integer, Integer> pair = new Pair<Integer, Integer>(queueNumber, roomNumber);

                deque.addLast(pair);
            }
        }

        State state = new State(screenNum, printNum, deque);
        return state;

    }
}
