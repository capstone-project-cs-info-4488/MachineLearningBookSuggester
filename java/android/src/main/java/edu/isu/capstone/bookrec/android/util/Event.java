package edu.isu.capstone.bookrec.android.util;

public class Event<T> {
    private final T content;
    private boolean handled = false;

    public Event(T content) {
        this.content = content;
    }

    public T getContent() {
        handled = true;
        return content;
    }

    public boolean isHandled() {
        return handled;
    }
}
