package se.acme.transport;

public class TagEntry {

    private final int rank;
    private final String tagStr;

    public TagEntry(int rank, String tagStr) {

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
