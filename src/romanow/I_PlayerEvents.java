package romanow;

import java.util.ArrayList;

/**
 * Created by User on 04.03.2019.
 */
public interface I_PlayerEvents {
    public boolean iTakeAll(I_CtrlCommands from);                   // Забираю все
    public boolean iAddToTable(I_CtrlCommands from,Card card);      // Кидаю карту
    public boolean iGo(I_CtrlCommands from,Card card);              // Делаю заход
    public boolean iAnswer(I_CtrlCommands from,Card my, Card other);// Бьюсь
    public ArrayList<CardPair> getCurrentTable(I_CtrlCommands from);
    public void noMoreCards(I_CtrlCommands from);                  // Не подкидываю больше
}
