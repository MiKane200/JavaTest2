cd Exam1;
mvn assembly:assembly;
java -cp target/Exam1-1.0-SNAPSHOT-jar-with-dependencies.jar com.hand.App;
cd ..;

cd Exam2;
mvn assembly:assembly;
java -cp target/Exam2-1.0-SNAPSHOT-jar-with-dependencies.jar com.hand.Server &
java -cp target/Exam2-1.0-SNAPSHOT-jar-with-dependencies.jar com.hand.Client;
cd ..;

cd Exam3;
mvn assembly:assembly;
java -cp target/Exam3-1.0-SNAPSHOT-jar-with-dependencies.jar com.hand.App;
                                     