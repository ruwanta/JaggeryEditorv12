package org.wso2.fileType;

import com.intellij.lang.javascript.library.JSPredefinedLibraryProvider;


import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.webcore.libraries.ScriptingLibraryModel;


import java.net.URL;
import java.util.HashSet;
import java.util.Set;


public class JagPredefinedLibrary extends  JSPredefinedLibraryProvider  {

    private   String NAME = "JaggeryLib";

    private   String JSFILES[] ={ "/resource/jaggery-hint-api.js"};


    @Override
    public ScriptingLibraryModel[] getPredefinedLibraries() {


        Set<VirtualFile> virtualFiles = getVirtualFiles();


      //  ScriptingLibraryModel scriptingLibraryModel1 = new ScriptingLibraryModel(NAME, virtualFiles.toArray(new VirtualFile[virtualFiles.size()]), VirtualFile.EMPTY_ARRAY, ArrayUtil.EMPTY_STRING_ARRAY, true);

          ScriptingLibraryModel scriptingLibraryModel1 =  ScriptingLibraryModel.createPredefinedLibrary(NAME, virtualFiles.toArray(new VirtualFile[virtualFiles.size()]),true);

        return new ScriptingLibraryModel[]{scriptingLibraryModel1};

    }

    private Set<VirtualFile> getVirtualFiles() {

        Set<VirtualFile> virtualFiles = new HashSet<VirtualFile>();

        for (String libFileName : JSFILES) {

            URL fileUrl = JagPredefinedLibrary.class.getResource(libFileName);
            virtualFiles.add(VfsUtil.findFileByURL(fileUrl));

        }
        return virtualFiles;


    }


    @Override
    public Set<VirtualFile> getPredefinedLibraryFiles() {

        return getVirtualFiles();
    }






}
