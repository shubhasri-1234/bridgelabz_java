import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public static void main(String[] args) {
        List<String> deck = generateDeck();
        shuffleDeck(deck);

        String[][] playersCards = distributeCards(deck, 4, 9);
        printPlayerCards(playersCards);
    }

    private static List<String> generateDeck() {
        List<String> deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck.add(rank + " of " + suit);
            }
        }
        return deck;
    }

    private static void shuffleDeck(List<String> deck) {
        Collections.shuffle(deck, new Random());
    }

    private static String[][] distributeCards(List<String> deck, int numPlayers, int cardsPerPlayer) {
        String[][] playersCards = new String[numPlayers][cardsPerPlayer];

        for (int player = 0; player < numPlayers; player++) {
            for (int card = 0; card < cardsPerPlayer; card++) {
                playersCards[player][card] = deck.remove(0);
            }
        }

        return playersCards;
    }

    private static void printPlayerCards(String[][] playersCards) {
        for (int player = 0; player < playersCards.length; player++) {
            System.out.println("Player " + (player + 1) + " Cards: " + Arrays.toString(playersCards[player]));
        }
    }
}

