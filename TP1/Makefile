JAVAC = javac
JAVA = java
SRC = src/
TEST_FOLDER = tests/
BIN = bin/

all: compile

compile:
	$(JAVAC) -d $(BIN) $(SRC)*.java

run: compile
	$(JAVA) -cp $(BIN) JeuBataille

TestCarte: compile
	$(JAVAC) -cp $(BIN) -d $(BIN) $(TEST_FOLDER)TestCarte.java
	@echo "Vérification de la compilation de TestCarte..."
	ls $(BIN) | grep TestCarte.class
	$(JAVA) -cp $(BIN) TestCarte

TestJoueur: compile
	$(JAVAC) -cp $(BIN) -d $(BIN) $(TEST_FOLDER)TestJoueur.java
	$(JAVA) -cp $(BIN) TestJoueur

TestPaquetCartes: compile
	$(JAVAC) -cp $(BIN) -d $(BIN) $(TEST_FOLDER)TestPaquetCartes.java
	$(JAVA) -cp $(BIN) TestPaquetCartes

TestJeuBataille: compile
	$(JAVAC) -cp $(BIN) -d $(BIN) $(TEST_FOLDER)TestJeuBataille.java
	$(JAVA) -cp $(BIN) TestJeuBataille

clean:
	rm -rf $(BIN)*.class

.TestALL: all compile run clean TestCarte TestJoueur TestPaquetCartes TestJeuBataille
