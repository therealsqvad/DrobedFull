package romanow;

import java.util.ArrayList;

/**
 * Created by User on 04.03.2019.
 */
public class GUIBote implements I_CtrlCommands {
    private ArrayList<Card> myCards = new ArrayList<>();
    private Model model;
    public GUIBote(){}
    @Override
    public void startPlay(int nPlayer) {
        System.out.println("Играют "+nPlayer);
    }

    @Override
    public void ourGo() {

    }

    @Override
    public void clearTable() {

    }

    @Override
    public void takeTable(ArrayList<CardPair> table) {

    }

    @Override
    public void takeAnswer(Card card) {

    }


    @Override
    public void canAdd(ArrayList<CardPair> table) {

    }

    @Override
    public void stopPlay(int nPlayer) {
        model.noMoreCards(this);
    }

    @Override
    public void takeCard(Card card) {
        System.out.println(card);
        myCards.add(card);
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

    }

    @Override
    public void takePair(CardPair pair) {

    }
}
