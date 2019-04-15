package romanow;

/**
 * Created by User on 04.03.2019.
 */
public class CardPair {
    private Card one=new Card();
    private Card two=null;
    public CardPair(Card one) {
        this.one = one;
        }
    public CardPair(Card one,Card two) {
        this.one = one;
        this.two = two;
    }
    public boolean isOne(){ return two==null; }
    public boolean addTwo(Card cc){
        if (two!=null) return false;
        two=cc;
        return true;
        }
    public String toString(){ return "["+one+","+two+"]"; }
    public boolean canGo(Card my, Card kosir){
        if (one.getMast()==my.getMast() && my.getVal()>one.getVal())
            return  true;
        if (one.getMast()!=kosir.getMast() && my.getMast()==kosir.getMast())
            return true;
        if (one.getMast()==kosir.getMast() && my.getMast()==kosir.getMast() && my.getVal()>one.getVal())
            return  true;
        return false;
        }
}
