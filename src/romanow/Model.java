package romanow;

import java.util.ArrayList;

/**
 * Created by User on 04.03.2019.
 */
public class Model implements I_PlayerEvents{    //Логика всей игры
    private int currentPlayer=0;    //Текущий игрок
    private int currentState=0;     //
    private ArrayList<Card> coloda=new ArrayList<>();   //колода
    private Card kosir=new Card();                      //козырь объявление
    private ArrayList<CardPair> table=new ArrayList<>();
    private ArrayList<I_CtrlCommands> players=new ArrayList<>();
    private  void create(){
        coloda.clear();
        int zz = 4*(Values.MaxValue-Values.MinValue+1);
        Card xx[]= new Card[zz];
        int k=0;
        for(int i=0;i<4;i++)
            for(int j=Values.MinValue;j<=Values.MaxValue;j++,k++){
                Card cc = new Card(i,j);
                xx[k] = cc;
                }
        for(int i=0;i<100000;i++){
            int i1= (int)(Math.random()*zz);
            int i2= (int)(Math.random()*zz);
            Card mm = xx[i1];
            xx[i1]=xx[i2];
            xx[i2]=mm;
            }
        for(int i=0;i<zz-1;i++)
             coloda.add(xx[i]);
        kosir = xx[zz-1];
        }
    private void startPlay(){
        for(int i=0;i<6;i++)
            for(I_CtrlCommands zz : players)
                zz.takeCard(coloda.remove(0));
        for(I_CtrlCommands zz : players){
            zz.setKosir(kosir);
            zz.startPlay(players.size());
            }
        play();
        }
    private void addFufu(){
        FufuBote bote = new FufuBote();
        bote.setModel(this);
        addPlayer(bote);
        }
    private  void addPlayer(I_CtrlCommands bb){
        players.add(bb);
        bb.setModel(this);
        }
    private void play(){
        players.get(currentPlayer).ourGo();
        }
    //--------------------------------------------------------------------------
    public static void main(String ss[]){ //вход, основная программа
        Model model = new Model();
        model.addFufu();
        model.addFufu();
        model.create();
        model.startPlay();
        }
    //-------------------------------------------------------------------------------------------------------------------
    @Override
    public boolean iTakeAll(I_CtrlCommands from) {
        return false;
    }

    @Override
    public boolean iAddToTable(I_CtrlCommands from, Card card) {
        int idx = players.indexOf(from);
        if (idx==-1) {
            System.out.println("Нету игрока????????????");
            return false;
            }
        if (idx!=currentPlayer){
            System.out.println("Не твоя очередь ходить!!!!!!!!");
            return false;
            }
        table.add(new CardPair(card));
        int idxNext = (idx+1)% players.size();
        System.out.println("Бейся "+idxNext+" "+card+"!!!!!!!!");
        players.get(idxNext).takeAnswer(card);
        from.takeTable(table);
        return false;
    }

    @Override
    public boolean iGo(I_CtrlCommands from, Card card) {
        return false;
    }

    @Override
    public boolean iAnswer(I_CtrlCommands from, Card my, Card other) {
        CardPair two = new CardPair(other,my);
        table.add(two);
        for(I_CtrlCommands cc : players)
            cc.takePair(two);
        System.out.println("Отбился "+currentPlayer+" "+two+"!!!!!!!!");
        return false;
    }

    @Override
    public ArrayList<CardPair> getCurrentTable(I_CtrlCommands from) {
        return null;
    }

    @Override
    public void noMoreCards(I_CtrlCommands from) {

    }
}
