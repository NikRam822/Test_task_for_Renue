import filesHandlers.Configuration;
import dataHandler.KMP;

public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        KMP KMP = new KMP(configuration.getProperties());
        KMP.viewDataOfAlgorithm();
    }
}


