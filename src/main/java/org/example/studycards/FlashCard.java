package org.example.studycards;

import java.util.List;
import java.util.Random;

public class FlashCard extends StudyMethod {

    public FlashCard(String methodName) {
        super(methodName);
    }

    @Override
    public String getMethodName() {
        return this.methodName;
    }

    @Override
    void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * Picks a random card ID from the card manager's map keys.
     * @return the randomly selected card ID, or -1 if none found
     */
    public int randomFlashCard() {
        List<Integer> ids = cardManager.getCardIds();
        if (ids.isEmpty()) {
            return -1;
        }
        Random random = new Random();
        return ids.get(random.nextInt(ids.size()));
    }

    /**
     * Returns a formatted string of a random flashcard.
     * @return formatted card info or a warning message
     */
    public String getFormattedRandomCard() {
        int id = randomFlashCard();
        if (id == -1) {
            return "No flashcard found.";
        }
        Card card = cardManager.getCard(id);
        return String.format("[%d] FlashCard: %s | Answer: %s",
                id, card.getQuestion(), card.getAnswer());
    }
}
