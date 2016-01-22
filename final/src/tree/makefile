JJT=jjtree
JCC=javacc
JC=javac
EXEC=CParser.class

all: CParser.class
	clear

CParser.class: CParser.java 
	$(JC) CParser.java 

CParser.java: C.jj
	$(JCC) C.jj
	$(JC) ../structure/*.java ../structure/affectation/*.java ../structure/operator/*.java ../structure/terminal/*.java -d ./

C.jj: C.jjt clean
	$(JJT) C.jjt

clean:
	rm -f *.java *.jj *.class
	clear

run:
	clear
	java CParser ../../res/code.c



