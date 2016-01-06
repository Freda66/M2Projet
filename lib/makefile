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
	$(JC) ../Expression/src/structure/*.java ../Expression/src/structure/affectation/*.java ../Expression/src/structure/operator/*.java ../Expression/src/structure/terminal/*.java -d ./

C.jj: C.jjt clean
	$(JJT) C.jjt

clean:
	rm -f *.java *.jj *.class
	rm -f -r ./structure
	clear

run:
	clear
	java CParser code.c



