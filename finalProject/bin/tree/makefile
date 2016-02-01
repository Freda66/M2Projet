JJT=jjtree
JCC=javacc
JC=javac
EXEC=CParser.class

all: $(EXEC)
	clear

CParser.class: CParser.java 
	$(JC) CParser.java 

CParser.java: C.jj
	$(JCC) C.jj
	$(JC) ../structure/*.java ../structure/affectation/*.java ../structure/operator/*.java ../structure/terminal/*.java ../structure/comparator/*.java -d ./

C.jj: C.jjt clean
	$(JJT) C.jjt

clean:
	rm -f *.java *.jj *.class
	rm -f -r ./structure
	clear

run:
	clear
	java CParser ../../res/code.c
