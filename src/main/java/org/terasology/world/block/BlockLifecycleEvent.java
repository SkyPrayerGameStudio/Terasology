/*
 * Copyright 2013 Moving Blocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.world.block;

import gnu.trove.list.TIntList;
import org.terasology.entitySystem.event.Event;
import org.terasology.math.Vector3i;
import org.terasology.world.BlockEntityRegistry;
import org.terasology.world.block.internal.BlockPositionIterator;

import java.util.Iterator;

/**
 * @author Immortius
 */
public abstract class BlockLifecycleEvent implements Event {
    private TIntList positions;
    private BlockEntityRegistry registry;

    public BlockLifecycleEvent(TIntList positions, BlockEntityRegistry registry) {
        this.registry = registry;
        this.positions = positions;
    }

    public Iterable<Vector3i> getBlockPositions() {
        return new Iterable<Vector3i>() {
            @Override
            public Iterator<Vector3i> iterator() {
                return new BlockPositionIterator(positions, registry);
            }
        };
    }

    public int blockCount() {
        return positions.size();
    }
}