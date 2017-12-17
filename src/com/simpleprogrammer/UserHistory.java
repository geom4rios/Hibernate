package com.simpleprogrammer;

import java.util.Date;

public class UserHistory {

    //Hibernate needs the default contructor to work.
    public UserHistory() {}

    private Date entryTime;
    private String entry;

    public UserHistory(Date entryTime, String entry) {
        super();
        this.entryTime = entryTime;
        this.entry = entry;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserHistory)) return false;

        UserHistory that = (UserHistory) o;

        if (!entryTime.equals(that.entryTime)) return false;
        return entry.equals(that.entry);
    }

    @Override
    public int hashCode() {
        int result = entryTime.hashCode();
        result = 31 * result + entry.hashCode();
        return result;
    }
}
