package org.wso2.fileType;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;


public class JaggeryFileTypeFactory extends FileTypeFactory {

    /*registered at fileTypeFactory extension*/
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {

        fileTypeConsumer.consume(JaggeryFileType.Jaggery_FILE_TYPE, JaggeryFileType.DEFAULT_EXTENSION);

    }


}
