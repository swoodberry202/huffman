import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * Name: sloanwoodberry
 * Lab Name: HuffmanTreeTesting
 * Lab Purpose
 * Date: 11/27/18
 * Collaborators: None
 */
public class HuffmanTreeTesting {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("myFile.txt"));
        PriorityQueue<HuffNode> q = new PriorityQueue<>();

        HuffNode root = null;
        ArrayList<HuffNode> myData = new ArrayList<>();
        String myText = "";

        while (s.hasNextLine()) {
            myText += "\n" + s.nextLine();
        }

    huffmanTree myTree= new huffmanTree(myText);
       System.out.println(myTree.toString());
    }

}
