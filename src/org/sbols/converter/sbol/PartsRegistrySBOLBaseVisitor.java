/*
 * Copyright (c) 2012 Clark & Parsia, LLC. <http://www.clarkparsia.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sbols.converter.sbol;

import org.sbolstandard.core.SequenceAnnotation;
import org.sbolstandard.core.util.SBOLBaseVisitor;

/**
 * Base implements of extended REgistry visitor interface.
 *
 * @author mgaldzic
 */

public class PartsRegistrySBOLBaseVisitor<T extends Throwable>
        extends SBOLBaseVisitor<T>
        implements PartsRegistrySBOLVisitor<T>
{

    @Override
    public void visit(PartsRegistryDnaComponent component) throws T {
        component.accept(this);
        for (SequenceAnnotation sequenceAnnotation : component.getAnnotations()) {
            visit(sequenceAnnotation);
        }
        if (component.getDnaSequence() != null) {
            visit(component.getDnaSequence());
        }


    }
}
