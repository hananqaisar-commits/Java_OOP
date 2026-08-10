    package src.smart_student_ranking_system;

    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Scene;
    import javafx.stage.Stage;

    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.Collections;

    import static src.smart_student_ranking_system.Student.byName;
    import static src.smart_student_ranking_system.Student.byrollNO;

    public class Main extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            ArrayList<Student> students_list = new ArrayList<>();


            Student s1 = new Student("Hanan", 187, 3.14);
            Student s2 = new Student("Waqar", 143, 2.47);
            Student s3 = new Student("Aftab", 165, 3.6);
            Student s4 = new Student("Hassan", 244, 2.41);

            students_list.add(s1);
            students_list.add(s2);
            students_list.add(s3);
            students_list.add(s4);


            Collections.sort(students_list,byName);
            System.out.println("Sorting ... by name");{
                for(Student s : students_list){
                    s.detail();
                }
            }
            Collections.sort(students_list,byrollNO);
            System.out.println("Sorting ... by roll no");{
                for(Student s : students_list){
                    s.detail();
                }
            }
            Collections.sort(students_list);

            System.out.println("Sorting ... Natural CGPA");{
                for(Student s : students_list){
                    s.detail();
                }
            }

            launch();
        }
    }