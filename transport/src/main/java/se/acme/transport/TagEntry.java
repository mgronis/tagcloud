package se.acme.transport;

import java.io.Serializable;

public class TagEntry implements Serializable {

    public static final long serialVersionUID = 1L;

    private long rank;
    private String tagStr;

    public TagEntry() {
    }

    public TagEntry(long rank, String tagStr) {

        this.rank = rank;
        this.tagStr = tagStr;
    }

    public long getRank() {
        return rank;
    }

    public String getTagStr() {
        return tagStr;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof TagEntry)) return false;
        final TagEntry other = (TagEntry) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getRank() != other.getRank()) return false;
        final Object this$tagStr = this.getTagStr();
        final Object other$tagStr = other.getTagStr();
        if (this$tagStr == null ? other$tagStr != null : !this$tagStr.equals(other$tagStr)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $rank = this.getRank();
        result = result * PRIME + (int) ($rank >>> 32 ^ $rank);
        final Object $tagStr = this.getTagStr();
        result = result * PRIME + ($tagStr == null ? 43 : $tagStr.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof TagEntry;
    }

    public String toString() {
        return "TagEntry(rank=" + this.getRank() + ", tagStr=" + this.getTagStr() + ")";
    }
}
