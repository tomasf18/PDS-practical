package ImprovedVersion;

import java.util.HashMap;

public class ReadGeneratorArguments {

    public HashMap<String, String> readArguments(String[] args) {
        HashMap<String, String> options = new HashMap<String, String>();
        
        boolean inputFound = false;
        boolean sizeFound = false;

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "-i":
                    if (inputFound) {
                        System.out.println("Option -i appears more than once.");
                        System.exit(1);
                    }
                    readNextArgument(args, arg, i);

                    options.put("-i", args[i + 1]);
                    inputFound = true;
                    i++; // Incrementa o índice para ignorar o argumento associado a '-i'
                    break;
                case "-s":
                    if (sizeFound) {
                        System.out.println("Option -s appears more than once.");
                        System.exit(1);
                    }
                    readNextArgument(args, arg, i);

                    options.put("-s", args[i + 1]);
                    sizeFound = true;
                    i++; // Incrementa o índice para ignorar o argumento associado a '-s'
                    break;
                case "-o":
                    readNextArgument(args, arg, i);
                    
                    options.put("-o", args[i + 1]);
                    i++; // Incrementa o índice para ignorar o argumento associado a '-o'
                    break;
                default:
                    System.out.println("Invalid option: " + arg);
                    System.exit(1);
            }
        }

        if (!inputFound || !sizeFound) {
            System.out.println("Options -i and -s are mandatory.");
            System.exit(1);
        }

        return options;

    }

    private void readNextArgument(String[] args, String arg, int i) {
        if (i + 1 >= args.length || args[i + 1].startsWith("-")) {
            System.out.println("Missing argument for option " + arg + ".");
            System.exit(1);
        }
    }
}
