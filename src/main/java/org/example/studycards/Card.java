package org.example.studycards;

public class Card {
    private String question;
    private String answer;

    public Card(String question, String answer) {
        validateInput(question, answer);
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        if (question == null || question.isBlank()) {
            throw new IllegalArgumentException("Question cannot be null or blank.");
        }
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        if (answer == null || answer.isBlank()) {
            throw new IllegalArgumentException("Answer cannot be null or blank.");
        }
        this.answer = answer;
    }

    public void edit(String question, String answer) {
        validateInput(question, answer);
        this.question = question;
        this.answer = answer;
    }

    private void validateInput(String question, String answer) {
        if (question == null || question.isBlank()) {
            throw new IllegalArgumentException("Question cannot be null or blank.");
        }
        if (answer == null || answer.isBlank()) {
            throw new IllegalArgumentException("Answer cannot be null or blank.");
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) return false;
        Card other = (Card) obj;
        return question.equals(other.question) && answer.equals(other.answer);
    }

    @Override
    public int hashCode() {
        return question.hashCode() * 31 + answer.hashCode();
    }
}
