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

package com.uwsoft.editor.view.ui.followers;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kotcrab.vis.ui.VisUI;
import com.uwsoft.editor.renderer.components.particle.ParticleComponent;
import com.uwsoft.editor.renderer.utils.ComponentRetriever;

/**
 * Created by azakhary on 5/20/2015.
 */
public class ParticleFollower extends BasicFollower {

    public ParticleFollower(Entity entity) {
        super(entity);
    }

    @Override
    public void create() {
        Image icon = new Image(VisUI.getSkin().getDrawable("icon-particle-over"));
        icon.setTouchable(Touchable.disabled);
        icon.setX(-icon.getWidth() / 2);
        icon.setY(-icon.getHeight() / 2);
        icon.getColor().a = 0.3f;
        addActor(icon);
    }

    @Override
    public void update() {
        super.update();
        ParticleComponent particleComponent = ComponentRetriever.get(entity, ParticleComponent.class);
        if (particleComponent != null) {
            particleComponent.scaleEffect(transformComponent.scaleX);
        }
    }

    @Override
    public void hide() {
        // Particle followers can't be hidden.
    }
}
