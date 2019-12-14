package bib.parser.inputHandler;

import bib.parser.documentStorage.Document;
import bib.parser.parser.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to handle program arguments
 */
public class InputHandler {

    /**
     * Method that prints help when user hasn't entered any arguments
     */
    public static void help() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---------------------------------------------------------------");
        stringBuilder.append("\nBibTeX Parser Help");
        stringBuilder.append("\nYou haven't provided any arguments.\nRead an instruction how to do it.");
        stringBuilder.append("\nFirst argument: filePath  -  You have to specify the path to your .bib file.");
        stringBuilder.append("\nFlags you can enter: ");
        stringBuilder.append("\n-c categoryName  -   filter the output by category.");
        stringBuilder.append("\n-n  authorName authorSurname -   find only publications that belongs to specified author.");
        stringBuilder.append("\nIf you want to provide two strings as one argument please use \" \" ");
        stringBuilder.append("\n---------------------------------------------------------------");
        System.out.println(stringBuilder);
    }

    /**
     * Handle program arguments
     *
     * @param args program arguments
     * @throws Exception when parser throws Exception
     */
    public static void handle(String[] args) throws Exception {
        if (args.length == 0) {
            help();
            return;
        }

        List<String> authors = new ArrayList<>();
        List<String> categories = new ArrayList<>();

        for (int i = 1; i < args.length; i++) {
            if (i < args.length && args[i].equals("-c")) {
                i++;
                while (i < args.length && !args[i].equals("-n")) {
                    categories.add(args[i].trim());
                    i++;
                }
            }
            if (i < args.length && args[i].equals("-n")) {
                i++;
                while (i < args.length && !args[i].equals("-c")) {
                    authors.add(args[i].toUpperCase().trim());
                    i++;
                }
            }
            if (i < args.length && args[i].equals("-c")) {
                i++;
                while (i < args.length && !args[i].equals("-n")) {
                    categories.add(args[i].trim());
                    i++;
                }
            }

            if (i == args.length - 1) break;
        }
        parseStart(args[0], authors, categories);

    }

    /**
     * Method that calls parser and decide what should be displayed
     *
     * @param filename First program argument - path to the file
     * @param authors list of program arguments that are of type Author
     * @param categories list of program arguments that are of type Category
     * @throws Exception when parser throws Exception
     */
    private static void parseStart(String filename, List<String> authors, List<String> categories) throws Exception {
        Parser parser = new Parser();
        Document document = parser.parse(filename);
        if (!(categories.size() > 0) && !(authors.size() > 0)) {
            document.print();
        } else {
            if (categories.size() > 0) {
                document.findByCategories(categories);

            }
            if (authors.size() > 0) {
                document.findByAuthor(authors);

            }
            document.print();
        }
    }


}
