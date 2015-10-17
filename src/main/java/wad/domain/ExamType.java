package wad.domain;

/**
 *
 * @author sc
 */
public enum ExamType {
    Normal("Normaali"), 
    Retry("Uusintakoe"), 
    Separate("Erilliskoe");
    
    private final String name;
    
    private ExamType(final String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}
