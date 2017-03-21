package com.yang.action;

import com.intellij.icons.AllIcons;
import com.intellij.notification.EventLog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.DialogWrapperDialog;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by Yang
 * on 2017/3/20.
 */
public class JsonFormatAction extends AnAction {

    public JsonFormatAction(){
        super("Input Json", "Input the json data which want to format", AllIcons.General.Settings);
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        Project project = anActionEvent.getProject();
        DialogWrapper dialog = new DialogWrapper(project) {
            @Nullable
            @Override
            protected JComponent createCenterPanel() {
                return null;
            }
        };
        dialog.show();
    }

    @Override
    public void update(AnActionEvent e) {
        super.update(e);
    }
}
