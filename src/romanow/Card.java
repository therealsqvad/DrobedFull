package romanow;

/**
 * Created by User on 04.03.2019.
 */
public class Card {
    private int mast=0;
    private int val=0;          // 6,7,8,9,10,11-валет, 12-дама, 13- король, 14-туз
    public Card(int mast, int val)  {
        this.mast = mast;
        this.val = val;
        }
    public Card(){}
    public int getMast() {
        return mast;
        }
    public void setMast(int mast) {
        this.mast = mast;
        }
    public int getVal() {
        return val;
        }
    public void setVal(int val) {
        this.val = val;
        }
    public String toString(){ return Values.CardTypes[mast]+":"+Values.CardNames[val]; }
    //------------ Текущая - которую бьют -------------------------------------------------------------
    public boolean canGo(Card my, Card kosir){
        if (getMast()==my.getMast() && my.getVal()>getVal())
            return  true;
        if (getMast()!=kosir.getMast() && my.getMast()==kosir.getMast())
            return true;
        if (getMast()==kosir.getMast() && my.getMast()==kosir.getMast() && my.getVal()>getVal())
            return  true;
        return false;
    }
}
