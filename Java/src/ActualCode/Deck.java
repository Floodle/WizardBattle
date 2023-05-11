package ActualCode;

import DesignedCards.Arcane_Bolt;
import DesignedCards.Card;
import DesignedCards.Generic_Protection;

import java.util.*;

public class Deck{

 List<Card> hand = new ArrayList<>();
 List<Card> deck = new ArrayList<>();
 List<Card> discard = new ArrayList<>();
 public List<Card> field = new ArrayList<>();
// generic deck
 Deck(){
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  deck.add(new Arcane_Bolt());
  shuffle();

 }

 Deck(int decknum){
  if(decknum==1){

   deck.add(new Arcane_Bolt());
   deck.add(new Arcane_Bolt());
   deck.add(new Arcane_Bolt());
   deck.add(new Arcane_Bolt());
   deck.add(new Arcane_Bolt());
   deck.add(new Arcane_Bolt());
   deck.add(new Arcane_Bolt());
   deck.add(new Arcane_Bolt());
   deck.add(new Arcane_Bolt());
   deck.add(new Arcane_Bolt());
   deck.add(new Arcane_Bolt());
   deck.add(new Arcane_Bolt());
   deck.add(new Arcane_Bolt());
   deck.add(new Arcane_Bolt());

  } else {

   deck.add(new Generic_Protection());
   deck.add(new Generic_Protection());
   deck.add(new Generic_Protection());
   deck.add(new Generic_Protection());
   deck.add(new Generic_Protection());
   deck.add(new Generic_Protection());
   deck.add(new Generic_Protection());
   deck.add(new Generic_Protection());
   deck.add(new Generic_Protection());
   deck.add(new Generic_Protection());
   deck.add(new Generic_Protection());
   deck.add(new Generic_Protection());

  }
  shuffle();

 }

 public void field_to_discard(int index){
  discard.add(field.remove(index));
 }

 public void play_from_hand(int index){
  Card temp = hand.remove(index);

  temp.currentCounters=temp.cost;

  field.add(temp);
 }

 public void draw(){
  if(deck.size()>0) {
   hand.add(deck.remove(0));
  }else {
   reshuffle();
   hand.add(deck.remove(0));
  }
 }

 public void draw(int num_of_cards){
  for(int i = 0; i<num_of_cards; i++){
   draw();
  }

 }

 //shuffles deck
 public void shuffle(){
  //implement seed here if needed
  Random r = new Random(System.nanoTime());
  for(int i = deck.size()-1; i >=0; i--){
    Card temp = deck.get(i);
    int randSpot = r.nextInt(i+1);
    deck.set(i, deck.get(randSpot));
    deck.set(randSpot, temp);
  }

 }

 //shuffles GY into deck
 public void reshuffle(){
  while(discard.size()>0){
   deck.add(discard.remove(0));
  }
  shuffle();

 }

 //discard a card from hand to gy
 public void discard(int index){
  discard.add(hand.remove(index));
 }

}

