package com.yang.viewer;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.ui.ScrollPaneFactory;
import com.intellij.ui.components.JBList;
import com.yang.action.JsonFormatAction;
import com.yang.utils.DataUtils;
import com.yang.utils.ImageListCellRenderer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
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

        String json = "{\"statusCode\":\"0\",\"statusMessage\":\"SUCCESS\",\"msgtimestamp\":\"20170322142746601\",\"msgeps\":\"\",\"page\":\"1\",\"totalPage\":\"1\",\"itemList\":[{\"data\":\"[{\\\"id\\\":100029,\\\"imgUrl\\\":\\\"http://zplantest.s3.seed.meme2c.com/0caa52bda69c408e93b7678695fb8677-ad-750x380.jpg\\\",\\\"linkUrl\\\":\\\"http://10.143.36.52:8080/superGood/main?sessionId=&platformType=&shareType=inviteRegister\\\",\\\"unknownFields\\\":{\\\"serializedSize\\\":0}},{\\\"id\\\":100030,\\\"imgUrl\\\":\\\"http://zplantest.s3.seed.meme2c.com/b65ee98841914642bab33ad97fd146ce-ad-750x380.jpg\\\",\\\"linkUrl\\\":\\\"http://app-test.seed.meme2c.com/superGood/main?sessionId=&platformType=&shareType=inviteRegister\\\",\\\"unknownFields\\\":{\\\"serializedSize\\\":0}},{\\\"id\\\":100041,\\\"imgUrl\\\":\\\"http://zplantest.s3.seed.meme2c.com/803dc414496e4dc099ad239c1d8b4573-ad-750x380.jpg\\\",\\\"unknownFields\\\":{\\\"serializedSize\\\":0}}]\",\"type\":\"banners\"},{\"data\":\"{\\\"id\\\":100102,\\\"imgUrl\\\":\\\"http://zplantest.s3.seed.meme2c.com/3ee31cd7a795487b970ebe55628be043-ad-750x320.jpg\\\",\\\"type\\\":\\\"yearly\\\",\\\"unknownFields\\\":{\\\"serializedSize\\\":0}}\",\"type\":\"yearly\"},{\"data\":\"{\\\"id\\\":100101,\\\"imgUrl\\\":\\\"http://zplantest.s3.seed.meme2c.com/f38cac9ebb6643a6b4a6739f8e6d0b55-ad-750x320.jpg\\\",\\\"type\\\":\\\"mall\\\",\\\"unknownFields\\\":{\\\"serializedSize\\\":0}}\",\"type\":\"mall\"},{\"data\":\"{\\\"description\\\":\\\"随心购买享受生活\\\",\\\"id\\\":100001,\\\"imgUrl\\\":\\\"http://zplantest.s3.seed.meme2c.com/ddce51adec3c460a97a02fd63d12e30d-planType-750x320.jpg\\\",\\\"name\\\":\\\"购物\\\",\\\"subTitle\\\":\\\"随心购买\\\",\\\"title\\\":\\\"购物计划\\\",\\\"type\\\":\\\"category\\\",\\\"unknownFields\\\":{\\\"serializedSize\\\":0}}\",\"type\":\"category\"},{\"data\":\"{\\\"description\\\":\\\"默认文案默认文案默\\\",\\\"id\\\":100080,\\\"imgUrl\\\":\\\"http://zplantest.s3.seed.meme2c.com/de3f423f92474380baf5989c4b512a64-planType-750x320.jpg\\\",\\\"name\\\":\\\"购物购物\\\",\\\"subTitle\\\":\\\"购物是一种乐趣，是快乐生活的\\\",\\\"title\\\":\\\"享受生活享受购物付\\\",\\\"type\\\":\\\"category\\\",\\\"unknownFields\\\":{\\\"serializedSize\\\":0}}\",\"type\":\"category\"}]}";
        String fjson = DataUtils.formatJson(json);
        String[] strs = fjson.split("\\n");
//        ArrayList<String> strings = new ArrayList<>();
//        for (String j:strs){
//            strings.add(j);
//        }
        Vector<JPanel> panels = new Vector<JPanel>(10);
        for (int i = 0; i < strs.length; i++) {

            JPanel itemPanel = new JPanel();
            JLabel iconLabel = new JLabel();
            GridLayout layout = new GridLayout(1, 1, 0, 4);
            itemPanel.setLayout(layout);
            itemPanel.setBorder(new EmptyBorder(5, 20, 5, 20));


            iconLabel.setText(strs[i]);
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
