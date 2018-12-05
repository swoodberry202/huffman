import java.util.ArrayList;

/**
 * Name: sloanwoodberry
 * Lab Name: HuffNode
 * Lab Purpose
 * Date: 11/27/18
 * Collaborators: None
 */

public class HuffNode implements Comparable<HuffNode>{
    int frequency;
    char myChar;
    HuffNode right;
    HuffNode left;

    public HuffNode(int myfrequency,char Char){
    frequency=myfrequency;
    myChar=Char;
    left=null;
    right=null;
    }

    public int compareTo(HuffNode h) {
        HuffNode q= h;
        if (frequency>q.getFrequency()){return 1;}
        else if (frequency<q.getFrequency()){return -1;}
            return 0;
    }

    public boolean isLeaf(){
     if (right==null&&left==null){return true;}
       return false;
    }
    public String toString(){
        String q= ""+frequency+":"+myChar;
        return q;
    }

    public char getMyChar() { return myChar; }

    public void setFrequency(int frequency) { this.frequency = frequency; }

    public int getFrequency() { return frequency; }

    public void pointMeLeft(HuffNode h){ left=h; }
    public HuffNode getLeft() { return left; }

    public void pointMeRight(HuffNode h){right=h;}
    public HuffNode getRight() {return right; }


}
