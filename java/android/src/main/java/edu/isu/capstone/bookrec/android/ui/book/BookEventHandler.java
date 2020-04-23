package edu.isu.capstone.bookrec.android.ui.book;

import android.view.View;
import edu.isu.capstone.bookrec.android.services.LibreVox;

import javax.inject.Inject;

public class BookEventHandler {
    private final LibreVox libreVox;

    @Inject
    public BookEventHandler(LibreVox libreVox) {
        this.libreVox = libreVox;
    }

    public void onDownloadLibraVox(@SuppressWarnings("unused") View unused) {
        libreVox.open();
    }
}
