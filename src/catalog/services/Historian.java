package catalog.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Historian {

    private FileWriter historianWriter;

    private Historian () throws IOException {
<<<<<<< HEAD
        File historyFile     = new File("history.csv");
        boolean fileExists   = historyFile.exists ();
        this.historianWriter = new FileWriter("history.csv", true);

        if (!fileExists) {
            this.historianWriter.write ("timestamp,command\n");
        }
=======
        this.historianWriter = new FileWriter("history.csv", true);
>>>>>>> b143c6e0b11dbe7da7c2cccf88afba388988f0cf
    }

    private static Historian instance = null;

    public static Historian getInstance () throws IOException {
        if (instance == null)
        {
            instance = new Historian();
        }

        return instance;
    }

    public void add (String command) throws IOException {
        Date date = new Date();

        this.historianWriter.write (command + "," + new Timestamp(date.getTime()) + "\n");
    }

    public void close () throws IOException {
        this.historianWriter.close ();
    }

    public Vector <Vector <String>> getHistory () throws IOException {
        Vector <Vector <String>> retValues = new Vector<> ();

        this.historianWriter.close ();

        File historyFile      = new File("history.csv");
        Scanner historyReader = new Scanner(historyFile);
<<<<<<< HEAD
        historyReader.nextLine (); // skip header
=======
>>>>>>> b143c6e0b11dbe7da7c2cccf88afba388988f0cf

        while (historyReader.hasNextLine ())
        {
            String line             = historyReader.nextLine ();
            String[] values         = line.split (",");
            Vector<String> newLine  = new Vector <> (Arrays.asList (values));
            retValues.add (newLine);
        }

        this.historianWriter = new FileWriter("history.csv", true);

        return (retValues);
    }

    public void clearHistory () throws IOException {
        this.historianWriter.close ();
        this.historianWriter = new FileWriter("history.csv", false);
        this.historianWriter.close ();
        this.historianWriter = new FileWriter("history.csv", true);
    }
}
