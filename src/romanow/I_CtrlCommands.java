package romanow;

import java.util.ArrayList;

/**
 * Created by User on 04.03.2019.
 */
public interface I_CtrlCommands {
    public void startPlay(int nPlayer);
    public void ourGo();                                //Делай ход
    public void clearTable();
    public void takeTable(ArrayList<CardPair> table);
    public void takeAnswer(Card card);                  // Отбивайся
    public void canAdd(ArrayList<CardPair> table);      // можешь подбрасывать
    public void stopPlay(int nPlayer);
    public void takeCard(Card card);
    public void haveMore();                             // будешь подбрасывать?
    public void setModel(Model model);
    public void setKosir(Card card);
    public void takePair(CardPair pair);
}
