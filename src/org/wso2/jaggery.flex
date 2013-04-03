package wso2.org;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import java.util.Stack;

%%



%public
%class _jaggery2
%implements FlexLexer
%unicode
%function advance
%type IElementType

%eof{


 return;
%eof}


%{

private  CharSequence content;


    private Stack<Integer> stack = new Stack<Integer>();
   // private StringBuffer javascriptContent= new StringBuffer(); 
    public void yypushState(int newState) {
      stack.push(yystate());
      yybegin(newState);
    }

    public void yypopState() {
      yybegin(stack.pop());
    }


%}





/*line terminators */

  InputCharacter = [^\r\n]
  LineTerminator = \r|\n|\r\n

  WhiteSpace = {LineTerminator} | [ \t\f]+
  
    /* comments */

   
/* string and character literals */
StringCharacter  = [^\r\n\"\\]
SStringCharacter = [^\r\n\'\\]

%state STRING SSTRING
%state TAG_STARTED
%state MORE
%state BRACE_STARTED
%state JAGGERY_TAG_STARTED
%state JAGGERY_TAG_CLOSSING
%state HTML_TAG_STARTED
%state BRACE_EQUAL_STARTED

%%

 
<YYINITIAL>{
     
    {LineTerminator}     {return JaggeryTokenTypes.LINE_TERMINATOR;}
    {WhiteSpace}         {return JaggeryTokenTypes.WHITE_SPACE;}

   "%"   {return JaggeryTokenTypes.OUTERBRACKETS;}


   [^%]*    { 

content = yytext();

System.out.println("Content length :"+content.length());
System.out.println("Last character :"+content.charAt(content.length()-1));


if(content.charAt(content.length()-1) != '>')

yypushback(1);

yybegin(BRACE_STARTED);

System.out.println("BRACE_STARTED-HTML_TEXT"+yytext());

return JaggeryTokenTypes.HTML_TEXT;


}


 
}

<BRACE_STARTED>{

"<%="      {
yybegin(JAGGERY_TAG_STARTED);
System.out.println("JAGGERY_TAG_STARTED-OUTERBRACKETS"+yytext());
return JaggeryTokenTypes.OUTERBRACKETS;


}


  "<%"     {

yybegin(JAGGERY_TAG_STARTED);
System.out.println("JAGGERY_TAG_STARTED-OUTERBRACKETS"+yytext());
return JaggeryTokenTypes.OUTERBRACKETS;
            }  


}



 <JAGGERY_TAG_STARTED> {

"="   {       
	      System.out.println("EQUAL SIGN MET.JAGGERY_TAG_STARTED-OUTERBRACKETS"+yytext());
	      return JaggeryTokenTypes.OUTERBRACKETS;

      }



[^%]*   { yybegin(JAGGERY_TAG_CLOSSING);System.out.println("JAGGERY_TAG_CLOSSING-JAVASCRIPT_TEXT"+yytext());return JaggeryTokenTypes.JAVASCRIPT_TEXT;

        }






} 

<JAGGERY_TAG_CLOSSING> {


"%>"  { yybegin(YYINITIAL);System.out.println("YYINITIAL-OUTERBRACKETS"+yytext());return JaggeryTokenTypes.OUTERBRACKETS;}
 
                       } 




.  { yybegin(YYINITIAL);return JaggeryTokenTypes.BAD_CHARACTER;}














