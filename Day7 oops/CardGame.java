class Node {
    Card data;
    Node next;

    public Node(Card card) {
        this.data = card;
        this.next = null;
    }
}

class LinkedList {
    Node front, rear;

    public LinkedList() {
        this.front = this.rear = null;
    }

    public void enqueue(Card card) {
        Node newNode = new Node(card);

        if (this.rear == null) {
            this.front = this.rear = newNode;
            return;
        }

        this.rear.next = newNode;
        this.rear = newNode;
    }

    public Card dequeue() {
        if (this.front == null)
            return null;

        Node temp = this.front;
        this.front = this.front.next;

        if (this.front == null)
            this.rear = null;

        return temp.data;
    }

    public boolean isEmpty() {
        return this.front == null;
    }
}

class Card {
    String rank;
    String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class Player {
    String name;
    LinkedList cards;

    public Player(String name) {
        this.name = name;
        this.cards = new LinkedList();
    }

    public void receiveCard(Card card) {
        this.cards.enqueue(card);
    }

    public void sortCardsByRank() {
        // Bubble sort for simplicity. You may choose a more efficient algorithm.
        Node current = cards.front;
        Node index = null;
        Card temp;

        while (current != null) {
            index = current.next;

            while (index != null) {
                if (current.data.rank.compareTo(index.data.rank) > 0) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }

                index = index.next;
            }
            current = current.next;
        }
    }

    public void printCards() {
        System.out.println("Player: " + name);
        while (!cards.isEmpty()) {
            Card card = cards.dequeue();
            System.out.println(card);
        }
        System.out.println();
    }
}

public class CardGame {
    public static void main(String[] args) {
        // Create Players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Create Deck of Cards
        DeckOfCards deck = new DeckOfCards();

        // Shuffle and distribute cards to players
        deck.shuffle();
        while (deck.hasNext()) {
            player1.receiveCard(deck.drawCard());
            player2.receiveCard(deck.drawCard());
        }

        // Sort player cards by rank
        player1.sortCardsByRank();
        player2.sortCardsByRank();

        // Print players and cards
        player1.printCards();
        player2.printCards();
    }
}

class DeckOfCards {
    LinkedList cards;

    public DeckOfCards() {
        this.cards = new LinkedList();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (String rank : ranks) {
            for (String suit : suits) {
                cards.enqueue(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Node current = cards.front;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        Card[] cardArray = new Card[count];
        current = cards.front;
        int i = 0;
        while (current != null) {
            cardArray[i++] = current.data;
            current = current.next;
        }

        // Fisher-Yates shuffle algorithm
        for (i = count - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Card temp = cardArray[i];
            cardArray[i] = cardArray[j];
            cardArray[j] = temp;
        }

        // Rebuild the linked list with shuffled cards
        cards = new LinkedList();
        for (i = 0; i < count; i++) {
            cards.enqueue(cardArray[i]);
        }
    }

    public Card drawCard() {
        return cards.dequeue();
    }

    public boolean hasNext() {
        return !cards.isEmpty();
    }
}
