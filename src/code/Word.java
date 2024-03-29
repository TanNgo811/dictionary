package code;

public class Word {
    private String wordTarget;
    private String wordExplain;

    public String getWordTarget() {
        return wordTarget;
    }

    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }

    public String getWordExplain() {
        return wordExplain;
    }

    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    public Word() {

    }

    public Word(String wordTarget, String wordExplain) {
        this.wordExplain = wordExplain;
        this.wordTarget = wordTarget;
    }

    public int compareTo(Word word)
    {
        String wordTarget = word.getWordTarget().toLowerCase();
        return this.wordTarget.toLowerCase().compareTo(wordTarget);
    }

    public String toString()
    {
        return "[wordTarget: " + this.wordTarget + ", wordExplain: " + this.wordExplain + "]";
    }


}

