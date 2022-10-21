import java.util.List;
import java.util.*;
import java.util.ArrayList;

/**
 * Write a description of class War here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class War
{
    public static void main(String[] args) {
        List<Integer> list0 = new ArrayList<Integer>();
        int k = 1;
        for (int i = 0; i < 52; i++) {
            if (k < 14) {
                list0.add(k);
                k++;
            } else {
                k = 1;
            }
        }
        Collections.shuffle(list0);
        List<Integer> list1 = new ArrayList<Integer>(list0.subList(0,25));  
        List<Integer> list2 = new ArrayList<Integer>(list0.subList(24,49));        
        for (int i = 0; i < 300; i++) {
            if (list1.isEmpty() == true) {
                System.out.println("Player 2 wins");
                break;
            } else if (list2.isEmpty() == true){
                System.out.println("Player 1 wins");
                break;
            }
            int card1 = list1.get(0);
            int card2 = list2.get(0);
            String cards1 = new String();
            String cards2 = new String();
            System.out.println("Player 1 had a deck of " +list1.size()+".");
            System.out.println("Player 2 had a deck of " +list2.size()+".");
            System.out.println("Player 1 has drawn a " +type(card1)+".");
            System.out.println("Player 2 has drawn a " +type(card2)+".");
            if (card1 > card2) {
                System.out.println("Player 1 has won the draw and will now get Player 2s card.");
                list1.remove(0);
                list2.remove(0);
                list1.add(card1);
                list1.add(card2);
            } else if (card2 > card1 ) {
                System.out.println("Player 2 has won the draw and will now get Player 1s card cards.");
                list1.remove(0);
                list2.remove(0);
                list2.add(card1);
                list2.add(card2);
            } else if (card2 == card1) {
                int c = 1;
                int h = 0;
                while (c == 1) {
                    System.out.println("The cards are a tie and now there will be war.");
                    int a = war(list1,1,h);
                    int b = war(list2,2,h);
                    if ( a>b) {
                        System.out.println("Player 1 has won the war and will now get all 12 cards");
                        for (int l = 0; l < 6 && l+1 < list1.size(); l++) {
                            int o = list1.get(0);
                            list1.remove(0);
                            list1.add(o);
                            c = 0;
                        }
                        for ( int l = 0; l < 6 && l+1 < list2.size(); l++) {
                            int p = list2.get(0);
                            list2.remove(0);
                            list1.add(p);
                        }
                    } else if ( b>a) {
                        System.out.println("Player 2 has won the war and will now get all 12 cards");
                        for (int l = 0; l < 6 && l < list2.size(); l++) {
                            int p = list2.get(0);
                            list2.remove(0);
                            list2.add(p);
                            c=0;
                        }
                        for ( int l = 0; l < 6 && l+1 < list1.size(); l++) {
                            int p = list1.get(0);
                            list1.remove(0);
                            list2.add(p);
                        }
                    } else if (b!=a) {
                        System.out.print("error");
                    } else if (b == a) {
                        h = h +1;
                    }
                }
            }
        }
        System.out.print("The game has ended."); 
    }

    public static String type(int a) {
        String cards = new String();
        if (a == 1) {
            cards = "One";
        } else if (a == 2) {
            cards = "Two";
        } else if (a == 3) {
            cards = "Three";
        } else if (a == 4) {
            cards = "Four";
        } else if (a == 5) {
            cards = "Five";
        } else if (a == 6) {
            cards = "Six";
        } else if (a == 7) {
            cards = "Seven";
        } else if (a == 8) {
            cards = "Eight";
        } else if (a == 9) {
            cards = "Nine";
        } else if (a == 10) {
            cards = "Ten";
        } else if (a == 11) {
            cards = "Jack";
        } else if (a == 12) {
            cards = "Queen";
        } else if (a == 13) {
            cards = "King";
        }
        return cards;
    }

    public static void pause() {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }
    }

    public static int war(List<Integer> list, int a, int x) {
        int g = 0;
        int u = 0;
        if ( x == 1) {
            u = u + 5;
        } else if( x == 2) {
            u = u + 10;
        } else if ( x == 3) {
            u = u + 15;
        }
        if ( list.size() == 2+u) {  
            g = list.get(1+u);
            System.out.println("Player "+a+" has drawn a "+type(g));
        } else if ( list.size() == 3+u) {
            int r = list.get(1+u);
            g = list.get(2+u);
            System.out.println("Player "+a+" has drawn a "+type(r)+ ", and a " +type(g));
        } else if ( list.size() == 4+u) {
            int r = list.get(1+u);
            int b = list.get(2+u);
            g = list.get(3+u);
            System.out.println("Player "+a+" has drawn a "+type(r)+ ", " +type(b)+", and a " +type(g));
        } else if ( list.size() == 5+u) {
            int r = list.get(1+u);
            int b = list.get(2+u);
            int c = list.get(3+u);
            g = list.get(4+u);
            System.out.println("Player "+a+" has drawn a "+type(r)+ ", " +type(b)+", " +type(c)+", and a "+type(g));
        } else if (list.size() > 5+u) {
            int r = list.get(1+u);
            int b = list.get(2+u);
            int c = list.get(3+u);
            int d = list.get(4+u);
            g = list.get(5+u);
            System.out.println("Player "+a+" has drawn a "+type(r)+ ", " +type(b)+", " +type(c)+", "+type(d)+", and finally "+type(g));
        } else {
            System.out.println("Player "+a+" can not draw any cards");
            g = list.get(0);
        }
        return g;
    }
}

