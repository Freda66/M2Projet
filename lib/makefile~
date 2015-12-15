JJT=jjtree
JCC=javacc
JC=javac
EXEC=CParser.class

all: $(EXEC)

CParser.class: CParser.java
	$(JC) CParser.java

CParser.java: C.jj
	$(JCC) C.jj

C.jj: C.jjt clean
	$(JJT) C.jjt

clean:
	rm -f *.java *.jj *.class
	clear

run:
	clear
	java CParser code.c
