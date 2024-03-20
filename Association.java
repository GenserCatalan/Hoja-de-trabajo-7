class Association  implements Comparable<Association > {
    private  String englishWord; 
    private  String spanishTranslation; 

    /**
     * Constructor de la clase Association .
     * @param englishWord 
     * @param spanishTranslation 
     */
    public Association (String englishWord, String spanishTranslation) {
        this.englishWord = englishWord;
        this.spanishTranslation = spanishTranslation;
    }

    /**
     * Método para obtener la palabra en inglés.
     * @return 
     */
    public String getEnglishWord() {
        return englishWord;
    }

    /**
     * Método para obtener el equivalente en español.
     * @return 
     */
    public String getSpanishTranslation() {
        return spanishTranslation;
    }

    @Override
    public int compareTo(Association  other) {
        return this.englishWord.compareTo(other.englishWord);
    }

    @Override
    public String toString() {
        return "(" + englishWord + ", " + spanishTranslation + ")";
    }
}
