SHELL := /bin/bash
JJT=jjtree
JCC=javacc
JC=javac
EXEC=CParser.class
MAIN=TestMain.class

all: $(EXEC) $(MAIN)
	clear

$(MAIN): TestMain.java
	$(JC) TestMain.java 

$(EXEC): CParser.java 
	$(JC) CParser.java 

CParser.java: C.jj
	$(JCC) C.jj
	$(JC) ../structure/*.java ../structure/affectation/*.java ../structure/operator/*.java ../structure/terminal/*.java ../structure/comparator/*.java -d ./

C.jj: C.jjt clean
	$(JJT) C.jjt

clean:
	cp TestMain.java ../
	rm -f *.java *.jj *.class
	rm -f -r ./structure
	cp ../TestMain.java ./
	rm ../TestMain.java
	clear

run:
	clear
	java TestMain ../../res/code.c

add:
	git add -A ./
	git commit