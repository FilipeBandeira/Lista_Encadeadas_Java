JAVAC = javac
JAVA = java
SOURCES = $(wildcard *.java)

.PHONY: all test clean
all:
	mkdir -p build
	$(JAVAC) -encoding UTF-8 -d build $(SOURCES) tests/EstruturasTest.java

test: all
	$(JAVA) -cp build EstruturasTest

clean:
	rm -rf build
