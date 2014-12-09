/**
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.mixin.impl;

import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.world.World;

import org.spongepowered.api.entity.living.animal.Sheep;
import org.spongepowered.api.util.annotation.NonnullByDefault;
import org.spongepowered.mod.mixin.Implements;
import org.spongepowered.mod.mixin.Interface;
import org.spongepowered.mod.mixin.Mixin;
import org.spongepowered.mod.mixin.Shadow;

@NonnullByDefault
@Mixin(EntitySheep.class)
@Implements(@Interface(iface = Sheep.class, prefix = "sheep$"))
public abstract class MixinEntitySheep extends EntityAnimal {

    @Shadow
    public abstract boolean getSheared();

    @Shadow
    public abstract void setSheared(boolean sheared);

    public MixinEntitySheep(World worldIn) {
        super(worldIn);
    }

    public boolean sheep$isSheared() {
        return this.getSheared();
    }

    public void sheep$setSheared(boolean sheared) {
        this.setSheared(sheared);
    }

}
