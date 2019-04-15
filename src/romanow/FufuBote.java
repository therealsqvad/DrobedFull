package romanow;

import java.util.ArrayList;

/**
 * Created by User on 04.03.2019.
 */
public class FufuBote implements I_CtrlCommands {
    private ArrayList<Card> myCards = new ArrayList<>();
    private Model model;
    private ArrayList<CardPair> table = new ArrayList<>();
    private boolean iGo=false;
    private Card kosir;
    public FufuBote(){ }
    @Override
    public void startPlay(int nPlayer) {
        System.out.println("Играют "+nPlayer);
        }
    @Override
    public void ourGo() {
        iGo=true;
        model.iAddToTable(this,myCards.remove(0));
        }
    @Override
    public void clearTable() {
        table.clear();
        }
    @Override
    public void takeTable(ArrayList<CardPair> table) {
        this.table = table;
        }
    @Override
    public void takeAnswer(Card card) {
        System.out.println("Щас пойду !!!!!!!!");
        // TODO - синхронизация = как определить, что карта уже билась....= фиксировать, что уже побили....
        for(int i=0;i<myCards.size();i++){
            Card cc = myCards.get(i);
            if (card.canGo(cc,kosir)){      // CC МОЖЕТ ПОБИТЬ CARD
                model.iAnswer(this,cc,card);
                return;
                }
            }
        model.iTakeAll(this);
        }

    @Override
    public void canAdd(ArrayList<CardPair> table) {

    }

    @Override
    public void stopPlay(int nPlayer) {

    }

    @Override
    public void takeCard(Card card) {
        System.out.println(card);
        myCards.add(card);
        if(iGo)
            return;                     // Отбиваюсь
        //---TODO-ПОДКИДЫВАТЬ------------------------------------------
    }

    @Override
    public void haveMore() {

    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void setKosir(Card card) {
        kosir = card;
    }

    @Override
    public void takePair(CardPair pair) {
        table.add(pair);
    }
}
