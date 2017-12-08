grammar RobotProgrammingLanguage;


/*Rules for the Parser*/

file : (line | comment)+ EOF ;

line : multipleCommand NEWLINE ;


/*multple commands in one line are called at the same time for the time arguement*/
multipleCommand : command+ INTEGER ;


/*command plus the value for the command, which is optional*/
command : WORD WHITESPACE (DECIMAL | INTEGER)? ;



/*define comments*/
comment : singleComment | multiComment ;
singleComment : '//' .* NEWLINE ;
multiComment : '/*' .* '*/' ;


/*Rules for the Lexer*/

fragment UPPER : [A-Z] ;
fragment LOWER : [a-z] ;
fragment NUMBER : [0-9] ;



INTEGER : (NUMBER)+ ;
DECIMAL : ((NUMBER)* '.' (NUMBER)+) ;
WORD : (UPPER | LOWER)+ ;


WHITESPACE : (' ' | '\t') ;
NEWLINE : ('\r'? '\n' | '\r') ;


