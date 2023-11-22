default:
	javac cpsc2150/extendedConnects/GameScreen.java cpsc2150/extendedConnectX/models/*.java

run:
	java cpsc2150.extendedConnects.GameScreen

test:
	javac -cp .:/usr/share/java/junit4.jar cpsc2150/extendedConnectX/models/*.java cpsc2150/extendedConnectX/tests/*.java

testGB:
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.extendedConnectX.tests.TestGameBoard

testGBmem:
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.extendedConnectX.tests.TestGameBoardMem

clean:
	rm -f cpsc2150/extendedConnects/*.class
	rm -f cpsc2150/extendedConnectX/models/*.class
	rm -f cpsc2150/extendedConnectX/tests/*.class