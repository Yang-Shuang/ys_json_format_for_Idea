package com.yang.action;

import com.intellij.notification.EventLog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;

/**
 * Created by Yang
 * on 2017/3/20.
 */
public class JsonFormatAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
       Editor editor = e.getData(PlatformDataKeys.EDITOR);
       if(editor == null){
            System.out.print("Editor 是空的，别问我Editor是啥，自己查。");
       }else {
           SelectionModel model = editor.getSelectionModel();
           String selecttext = model.getSelectedText();
           if(selecttext == null || selecttext.length() == 0){
                System.out.print("你逗我呢？ 没有选中内容我格式化个屁！");
           }else {
               System.out.print("----"+selecttext);
           }
       }
    }
}
