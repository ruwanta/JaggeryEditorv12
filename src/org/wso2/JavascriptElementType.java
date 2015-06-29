/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2;

import com.intellij.lang.*;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.ILazyParseableElementType;
import org.wso2.fileType.JaggeryLanguage;
import org.wso2.fileType.JavascriptLanguage;

public class JavascriptElementType extends ILazyParseableElementType {

    public JavascriptElementType(
            @org.jetbrains.annotations.NotNull @org.jetbrains.annotations.NonNls String debugName,
            @org.jetbrains.annotations.Nullable Language language) {
        super(debugName, language);
    }

    public ASTNode parseContents(ASTNode chameleon) {
        ParserDefinition parserDefinition = ((ParserDefinition)LanguageParserDefinitions.INSTANCE.forLanguage(getLanguage()));
        if(parserDefinition == null) {
            return chameleon;
        }
        return super.parseContents(chameleon);
    }
}
