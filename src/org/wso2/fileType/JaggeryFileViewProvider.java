package org.wso2.fileType;

import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.module.ModifiableModuleModel;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.*;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.vfs.JarFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.psi.LanguageSubstitutors;
import com.intellij.psi.MultiplePsiFilesPerDocumentFileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.source.PsiFileImpl;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import com.intellij.psi.templateLanguages.TemplateLanguageFileViewProvider;
import gnu.trove.THashSet;
import org.jetbrains.annotations.NotNull;
import org.wso2.JaggeryTokenTypes;

import java.util.Arrays;
import java.util.Set;


/* This class is based on managing multiple psi trees with template language.
* javascript is chosen as the template language where as in background(out of the control characters)
* html will be visible.*/

public class JaggeryFileViewProvider extends MultiplePsiFilesPerDocumentFileViewProvider implements TemplateLanguageFileViewProvider {

    private Language myTemplateDataLanguage1;
    private String path;
    private String jarUrl;
    private VirtualFile jarVirtualFile;
    private ModifiableModuleModel modifiableModel;
    private Module theModule;
    private ModuleRootManager rootManager;
    private ModifiableRootModel rootModel;
    private Module module;
    private Module module0;
    private String pathvirtualfile;
    private VirtualFile virtualFile2;
    private Project p;
    private Project project;
    private static boolean libraryLoaded = false;
    private String librariesList;
    private LibraryOrderEntry libraryEntry;
    private String libName;
    private Module module1;
    private ModalityState Modala;
    private String pathrelative;
    private PsiManager psiManager;
    private VirtualFile virtualFile;
    private boolean physical;


    public JaggeryFileViewProvider(final PsiManager psiManager, final VirtualFile virtualFile, boolean physical) {


        super(psiManager, virtualFile, physical);


        this.psiManager =psiManager;
        this.virtualFile = virtualFile;
        this.physical = physical;


     /*   loadResource( psiManager, virtualFile);      *//*load the jar file with the javascript file containing. Resource should be loaded only when
                                                       .jag file is created. That is why this method is called in fileViewProvider*//*
*/



        Language dataLang = TemplateDataLanguageMappings.getInstance(psiManager.getProject()).getMapping(virtualFile); //get the language mappings
        if (dataLang == null)


        {

            dataLang = StdFileTypes.JS.getLanguage();//StdFileTypes.HTML.getLanguage();      //assign HTML language initially


        }


        if (dataLang instanceof TemplateLanguage) {

            myTemplateDataLanguage1 = StdFileTypes.HTML.getLanguage();//StdFileTypes.JS.getLanguage();

        } else {
            myTemplateDataLanguage1 = LanguageSubstitutors.INSTANCE.substituteLanguage(dataLang, virtualFile, psiManager.getProject());  //substitute javascript
        }


    }

    private void loadResource(final PsiManager psiManager,final  VirtualFile virtualFile) {

        pathrelative = getClass().getResource("/resource/jaggery-hint-api.js").getPath();


        pathrelative=  pathrelative.substring(5);    //remove 'file:' part

        pathrelative=  pathrelative.substring(0,pathrelative.indexOf("!"));// get the path until the jar file root. This is the plugin itself. Otherwise getclass().getResource won't work

        ApplicationManager.getApplication().invokeLater(        //Transfer control from background thread to UI thread

                new Runnable() {

                    public void run() {

                        ApplicationManager.getApplication().runWriteAction(         //Initialize write actions in an UI thread.

                                new Runnable() {
                                    @Override
                                    public void run() {




                                        if(ModuleUtil.findModuleForFile(virtualFile, psiManager.getProject()) !=null)  {

                                            module1 = ModuleUtil.findModuleForFile(virtualFile, psiManager.getProject());  //get the module

                                            OrderEntry[] orderEntries = ModuleRootManager.getInstance(module1).getOrderEntries();
                                            // Select libraries if any

                                            for (int i = 0; i <= orderEntries.length - 1; i++) {
                                                if ((orderEntries[i] instanceof LibraryOrderEntry)) {

                                                    libName = orderEntries[i].getPresentableName();

                                                    if ("JaggeryLibrary".equals(libName)) {

                                                        libraryLoaded = true;
                                                    } else libraryLoaded = false;


                                                    libraryEntry = (LibraryOrderEntry) orderEntries[i];
                                                    librariesList += orderEntries[i].getPresentableName() + " | library level: " +
                                                            libraryEntry.getLibraryLevel() +
                                                            "\n";

                                                }  else libraryLoaded = false;
                                            }

                                            //load the library only if no JaggeryLibrary library is loaded
                                            if (!libraryLoaded) {

                                                try {


                                                    path = pathrelative + JarFileSystem.JAR_SEPARATOR;
                                                    jarUrl = VirtualFileManager.constructUrl(JarFileSystem.PROTOCOL, path);
                                                    jarVirtualFile = VirtualFileManager.getInstance().findFileByUrl(jarUrl);
                                                    project = psiManager.getProject();



                                                    module = ProjectRootManager.getInstance(project).getFileIndex().getModuleForFile(virtualFile);
                                                    rootManager = ModuleRootManager.getInstance(module1);
                                                    rootModel = rootManager.getModifiableModel();



                                                    Library myLibrary = rootModel.getModuleLibraryTable().createLibrary("JaggeryLibrary");      //set the name as JaggeryLibrary and create the library
                                                    Library.ModifiableModel libraryModel = myLibrary.getModifiableModel();
                                                    libraryModel.addRoot(jarVirtualFile, OrderRootType.CLASSES);
                                                    libraryModel.commit();

                                                    rootModel.commit();      //commit to root model
                                                    libraryLoaded = true;
                                                } catch (Exception e) {

                                                    libraryLoaded = false;

                                                }


                                            }   }
                                    }
                                }


                        );

                    }
                }

        );



    }


    public JaggeryFileViewProvider(PsiManager manager, VirtualFile virtualFile, boolean physical, Language language) {

        super(manager, virtualFile, physical);
        this.myTemplateDataLanguage1 = language;        //returns template language

    }

    @NotNull
    @Override
    public Language getBaseLanguage() {
        return JaggeryLanguage.INSTANCE;  // Base language is set as Jaggery language where it extends TemplatingLanguage.
    }

    @NotNull
    @Override
    public Language getTemplateDataLanguage() {

        return myTemplateDataLanguage1;  // get template language.

    }

    @Override
    protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(VirtualFile virtualFile) {
        return new JaggeryFileViewProvider(getManager(), virtualFile, false, myTemplateDataLanguage1);  // customized constructor
    }


    @NotNull
    @Override
    public Set<Language> getLanguages() {
        return new THashSet<Language>(Arrays.asList(new Language[]{JaggeryLanguage.INSTANCE, myTemplateDataLanguage1,StdFileTypes.HTML.getLanguage()}));      //returns the set of languages as an array
    }

    @Override
    protected PsiFile createFile(Language lang) {

        if (lang == myTemplateDataLanguage1) {

            PsiFileImpl file = (PsiFileImpl) LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);     //Sets the tokentype of which the lexer returns as block of code
            file.setContentElementType(JaggeryTokenTypes.TEMPLATE_DATA);
            return file;


        } else if (lang == StdFileTypes.HTML.getLanguage() ){

            PsiFileImpl file = (PsiFileImpl) LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);
            file.setContentElementType(JaggeryTokenTypes.HTML_TEXT);
            return LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);

        }
            else {

            return  LanguageParserDefinitions.INSTANCE.forLanguage(JaggeryLanguage.INSTANCE).createFile(this);

        }


    }
}
