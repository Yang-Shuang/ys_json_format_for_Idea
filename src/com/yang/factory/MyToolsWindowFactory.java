package com.yang.factory;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import com.yang.viewer.JsonFormatViewer;
import org.jetbrains.annotations.NotNull;

/**
 * Created by YangShuang
 * on 2017/3/21.
 */
public class MyToolsWindowFactory implements ToolWindowFactory{
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        JsonFormatViewer viewer = new JsonFormatViewer(project);
        final ContentManager contentManager = toolWindow.getContentManager();
        final Content content = contentManager.getFactory().createContent(viewer, null, false);
        contentManager.addContent(content);
    }
}
