package se.acme.transport;

import java.io.Serializable;

public class TagEntry implements Serializable {

    public static final long serialVersionUID = 1L;

    private int rank;
    private String tagStr;

    public TagEntry() {
    }

    public TagEntry(long rank, String tagStr) {

        this.rank = rank;
        this.tagStr = tagStr;
    }

    public int getRank() {
        return rank;
    }

    public String getTagStr() {
        return tagStr;
    }

}
