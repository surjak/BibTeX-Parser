package bib.parser.inputHandler;

public class InputHandler {

    public static void help(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("---------------------------------------------------------------");
        stringBuilder.append("\nBibTeX Parser Help");
        stringBuilder.append("\nYou haven't provided any arguments.\nRead an instruction how to do it.");
        stringBuilder.append("\nFirst argument: filePath  -  You have to specify the path to your .bib file.");
        stringBuilder.append("\nFlags you can enter: ");
        stringBuilder.append("\n-c categoryName  -   filter the output by category.");
        stringBuilder.append("\n-n  userName userSurname -   find only publications that belongs to specified user.");
        stringBuilder.append("\n---------------------------------------------------------------");
        System.out.println(stringBuilder);
    }
}
