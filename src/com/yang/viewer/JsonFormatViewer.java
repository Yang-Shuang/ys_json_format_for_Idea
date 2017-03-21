package com.yang.viewer;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.ui.components.JBList;
import com.yang.action.JsonFormatAction;
import com.yang.utils.ImageListCellRenderer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Vector;

/**
 * Created by YangShuang
 * on 2017/3/21.
 */
public class JsonFormatViewer extends SimpleToolWindowPanel {
    public JsonFormatViewer(boolean vertical) {
        super(vertical);
    }

    public JsonFormatViewer(boolean vertical, boolean borderless) {
        super(vertical, borderless);
    }

    public JsonFormatViewer(Project project) {
        super(true, true);
        setToolbar(createToolbarPanel());
        setContent(createContentPanel());
    }

    private JComponent createToolbarPanel() {
        final DefaultActionGroup actionGroup = new DefaultActionGroup();
        actionGroup.add(new JsonFormatAction());
        final ActionToolbar actionToolbar = ActionManager.getInstance().createActionToolbar("JsonFormater", actionGroup, true);
        return actionToolbar.getComponent();
    }

    private JComponent createContentPanel() {

        Vector<JPanel> panels = new Vector<JPanel>(10);
        for (int i = 0; i < 10; i++) {

            JPanel itemPanel = new JPanel();
            JLabel iconLabel = new JLabel();
            GridLayout layout = new GridLayout(1, 1, 0, 4);
            itemPanel.setLayout(layout);
            itemPanel.setBorder(new EmptyBorder(10, 20, 10, 20));


            iconLabel.setText("-----" + i);
            iconLabel.setHorizontalAlignment(JLabel.LEFT);
            iconLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
            itemPanel.add(iconLabel);
            panels.add(itemPanel);

        }
        JBList itemList = new JBList(panels);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        itemList.setLayoutOrientation(JList.VERTICAL);
        itemList.setCellRenderer(new ImageListCellRenderer());
//        itemList.addMouseListener(mouseListener);
//        itemList.addKeyListener(keyListener);


        return ScrollPaneFactory.createScrollPane(itemList);
    }
}
