public class DictionaryCommandline {
    /*
     * dictionaryBasic // goi ham InsertFromCommandLine vs showAllWord
     * dictionartAdvenced// goi ham InsetFromFile, showAllWords, dictionaryLookup
     * dictionarySearcher
     */

    DictionaryManagement DicMana = new DictionaryManagement();
    Dictionary dictionary = new Dictionary();

    public void showAllWords(Dictionary dict) {
        dict.printDictionary();
    }

    /**
     * goi ham InsertFromCommandLine va ham showAllWords
     */
    public void dictionaryBasic() {
        DicMana.insertFromCommandLine();
        showAllWords(dictionary);
    }
}
