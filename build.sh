cd Exam1;
mvn compile;
mvn clean package;
java -cp target/Exam1.jar com.hand.App;
cd ..;

cd Exam2;
mvn compile;
mvn clean package;
java -cp target/Exam2.jar com.hand.Server &
java -cp target/Exam2.jar com.hand.Client;
cd ..;

cd Exam3;
mvn compile;
mvn clean package;
java -cp target/Exam3.jar com.hand.App;
                                     