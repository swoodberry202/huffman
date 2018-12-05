import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Name: sloanwoodberry
 * Lab Name: huffmanTree
 * Lab Purpose
 * Date: 12/3/18
 * Collaborators: None
 */

/*
* Java priority queue doesn't sort it as you enqueue only as you dequeue. Priority queue is partially sorted to save time
* with the put function. Put and get both take O(log(n)) time to complete. To avoid having to look at every single element
* Java priority queue stores its data in a heap, which is an array representation of a binary search tree. In a heap
* the root is the first node in the array and the children of every node are stored at 2i and 2i +1 from the node. Whenever
 * something is dequed the method reverseHeapify is called so the data can remain sorted. This is seen as more efficiant
  * than just always keeping a sorted queue.
* */
public class huffmanTree {
    PriorityQueue<HuffNode> q;
    ArrayList<HuffNode> myData;
    HuffNode root;
    String myText = "";
    public ArrayList<String> binaryInfo;
    private PrintWriter p;

    public huffmanTree(String myString) throws FileNotFoundException{
        myText=myString;
        myData=new ArrayList<>();
        root=null;
        makeItAString();

        q = new PriorityQueue<>();

        binaryInfo=new ArrayList<>();
        p=new PrintWriter("myFile.txt");

        int mySize=myData.size();

        for (int i = 0; i < mySize; mySize--) {
            if (mySize==1){root=q.poll();}
            else {
                HuffNode left=q.poll();
                HuffNode right=q.poll();
                root= new HuffNode(left.getFrequency()+right.getFrequency(),'$');
                root.pointMeLeft(left);
                root.pointMeRight(right);
                q.add(root);

            }

        }

    }

    private void makeItAString(){
        for (int i = 0; i < myText.length(); i++) {
            boolean b = true;
            if (myData.size() == 0) {
                myData.add(new HuffNode(1, myText.charAt(i)));
                b = false;
            }
            else if (!(myData.size() == 0)) {

                for (int x = 0; x < myData.size(); x++) {

                    if (myText.charAt(i) == myData.get(x).getMyChar()) {
                        myData.get(x).setFrequency(myData.get(x).getFrequency() + 1);
                        b = false;
                        x = myData.size();
                    }
                }
            }
            if (b) {
                myData.add(new HuffNode(1, myText.charAt(i)));
            }

        }

    }
    public String toString(){
        String s ="";

      ArrayList<HuffNode> myList= recursiveArrayBuilder(root,myData.size(),myData);

      for (int i=0;i<myList.size();i++){
       s+=myList.get(i)+", ";
      }
        return s;
    }

    public void binaryFileBuilder(){
        binaryInfoBuilder("",root);
    }

    private void binaryInfoBuilder(String myNum, HuffNode myNode){
   if (myNode.isLeaf()){
       binaryInfo.add(""+myNode.getMyChar()+" : "+myNum);
   }
    if (myNode.getRight()!=null) {
     binaryInfoBuilder((myNum + 1), myNode.getRight());
   }
  if (myNode.getLeft()!=null){binaryInfoBuilder((myNum + 0), myNode.getRight());}
    }



    private ArrayList<HuffNode> recursiveArrayBuilder(HuffNode h, int i, ArrayList<HuffNode> toStringArr){
        if (h.isLeaf()){toStringArr.set(i,h);
        return toStringArr;}

        if ((h.getLeft()!=null)&&(h.getRight()==null)){
            toStringArr.set(i,h);
            return recursiveArrayBuilder(h.getLeft(),((i*2)+2),toStringArr);
        }

        if ((h.getRight()!=null)&&(h.getLeft()==null)){
            toStringArr.set(i,h);
            return recursiveArrayBuilder(h.getRight(),((i*2)+2),toStringArr);
        }

        else {
            toStringArr.set(i,h);
            recursiveArrayBuilder(h.left,((i*2)+2),toStringArr);
            return recursiveArrayBuilder(h.getRight(),((i*2)+2),toStringArr);
        }
    }
}
