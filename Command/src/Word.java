public class Word {
    private String Word_target;
    private String Word_explain;

    public String getWord_target() {
        return Word_target;
    }

    public void setWord_target(String Word_target) {
        this.Word_explain = Word_target;
    }

    public String getWord_explain() {
        return Word_explain;
    }

    public void setWord_explain(String Word_explain) {
        this.Word_explain = Word_explain;
    }

    public Word(String Word_target, String Word_explain) {
        this.Word_explain = Word_explain;
        this.Word_target = Word_target;
    }

    /**
     * print
     * 
     * @return string
     */
    public String toString() {
        return "| " + getWord_target() + "      | " + getWord_explain();
    }
}
