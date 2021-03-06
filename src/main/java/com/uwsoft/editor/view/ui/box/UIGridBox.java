/*
 * ******************************************************************************
 *  * Copyright 2015 See AUTHORS file.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  *****************************************************************************
 */

package com.uwsoft.editor.view.ui.box;


import com.badlogic.gdx.Gdx;
import com.kotcrab.vis.ui.VisUI;
import com.kotcrab.vis.ui.util.Validators;
import com.kotcrab.vis.ui.widget.VisCheckBox;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTextField;
import com.kotcrab.vis.ui.widget.VisValidatableTextField;
import com.uwsoft.editor.event.CheckBoxChangeListener;
import com.uwsoft.editor.event.KeyboardListener;

/**
 * Created by azakhary on 4/15/2015.
 */
public class UIGridBox extends UIBaseBox {

    private static final String TAG = "UIGridBox";
    private static final String GRID_BOX_PREFIX = "com.uwsoft.editor.view.ui.box.UIGridBox";
    public static final String GRID_SIZE_TEXT_FIELD_UPDATED = GRID_BOX_PREFIX + ".GRID_SIZE_TEXT_FIELD_UPDATED";
    public static final String LOCK_LINES_CHECKBOX_FIELD_UPDATED = GRID_BOX_PREFIX + ".LOCK_LINES_CHECKBOX_FIELD_UPDATED";
    private VisValidatableTextField gridSizeTextField;
    private VisCheckBox lockLinesCheckBox;

    public UIGridBox() {
        super();
        init();
        setVisible(false);
    }

    @Override
    public void update() {
        setVisible(true);
    }

    private void init() {
        lockLinesCheckBox = new VisCheckBox("Lock lines");
        lockLinesCheckBox.addListener(new CheckBoxChangeListener(LOCK_LINES_CHECKBOX_FIELD_UPDATED));
        add(lockLinesCheckBox).width(100).padRight(4);

        VisLabel lbl = new VisLabel("Grid Size:");
        add(lbl).padRight(4);
        gridSizeTextField = new VisValidatableTextField(new Validators.IntegerValidator());
        gridSizeTextField.setStyle(VisUI.getSkin().get("light", VisTextField.VisTextFieldStyle.class));
        //gridSizeTextField.setRightAligned(true);
        gridSizeTextField.addListener(new KeyboardListener(GRID_SIZE_TEXT_FIELD_UPDATED));
        add(gridSizeTextField).width(60);
    }

    public void setGridSize(int gridSize) {
        gridSizeTextField.setText(gridSize + "");
    }

    public void setLockLines(boolean lockLines) {
        if (lockLines) {
            Gdx.app.log(TAG, "Lines locked");
        } else {
            Gdx.app.log(TAG, "Lines unlocked");
        }
    }

    public void hide() {
        setVisible(false);
    }

    public void show() {
        setVisible(true);
    }
}
