package edu.isu.capstone.bookrec.android.util;

import android.net.Uri;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public class SimpleXmlUriConverter implements Converter<Uri> {
    @Override
    public Uri read(InputNode node) throws Exception {
        return Uri.parse(node.getValue());
    }

    @Override
    public void write(OutputNode node, Uri value) {
        node.setValue(value.toString());
    }
}
