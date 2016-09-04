package se.acme.transport;

import java.util.Collection;

public class TestTO {

    private Collection<TagEntry> entries;

    public TestTO(Collection<TagEntry> entries) {
        this.entries = entries;
    }

    public Collection<TagEntry> getEntries() {
        return entries;
    }
}
