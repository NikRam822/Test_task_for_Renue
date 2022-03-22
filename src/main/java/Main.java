import filesHandlers.Configuration;
import dataHandler.KMP;

import java.io.File;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        if (args.length == 1) {
            configuration = new Configuration(Integer.parseInt(args[0]));
        }

        KMP KMP = new KMP(configuration.getProperties());
        KMP.viewDataOfAlgorithm();
    }
}


