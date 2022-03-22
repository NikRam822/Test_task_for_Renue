import filesHandlers.Configuration;
import dataHandler.KMP;

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


