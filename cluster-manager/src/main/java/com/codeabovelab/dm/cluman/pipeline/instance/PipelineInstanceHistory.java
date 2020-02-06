
package com.codeabovelab.dm.cluman.pipeline.instance;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Data
@NoArgsConstructor
public class PipelineInstanceHistory {

    private List<String> comments = new CopyOnWriteArrayList<>();
    private String stage;
    /**
     * image tag
     */
    private String tag;

    public PipelineInstanceHistory(String stage) {
        this.stage = stage;
    }

    public void addComments(String comment) {
        comments.add(comment);
    }
}
