
import java.util.*;

public class Deck{

 List<Card> hand = new ArrayList<>();
 List<Card> deck = new ArrayList<>();
 List<Card> discard = new ArrayList<>();
 List<Card> field = new ArrayList<>();
// generic deck
 Deck(){
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  shuffle();

 }

 void field_to_discard(int index){
  discard.add(field.remove(index));
 }

 void play_from_hand(int index){
  Card temp = hand.remove(index);

  temp.currentCounters=temp.cost;

  field.add(temp);
 }

 void draw(){
  if(deck.size()>0) {
   hand.add(deck.remove(0));
  }else {
   reshuffle();
   hand.add(deck.remove(0));
  }
 }

 void draw(int num_of_cards){
  for(int i = 0; i<num_of_cards; i++){
   draw();
  }

 }

 //shuffles deck
 void shuffle(){
  Random r = new Random(System.nanoTime());
  for(int i = deck.size(); i >0; i--){
    Card temp = deck.get(i);
    int randSpot = r.nextInt(i+1);
    deck.set(i, deck.get(randSpot));
    deck.set(randSpot, temp);

  }

 }

 //shuffles GY into deck
 void reshuffle(){
  while(discard.size()>0){
   deck.add(discard.remove(0));
  }
  shuffle();

 }

 //discard a card from hand to gy
 void discard(int index){
  discard.add(hand.remove(index));
 }

}

