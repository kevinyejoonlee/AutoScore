package cp317;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class AutoScore {

    public static void runProcesses(Student teacher, Student[] students, int numStudents, String[] tasks,
            double[] weights) {
        int numTasks;
        int teacherTaskID, studentTaskID;
        numTasks = tasks.length;

        for (int i = 0; i < numStudents; i++) {
            try {
                students[i].setID(process.findID(students[i].getTesting()));
            } catch (FileNotFoundException e) { // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        for (int i = 0; i < numTasks; i++) {

            teacherTaskID = findTask(teacher, tasks[i]);

            if (teacherTaskID != -1) {
                try {
                    process.RunCode(teacher.getDirectoryID(teacherTaskID), "correct_test.txt");

                    for (int j = 0; j < numStudents; j++) {
                        studentTaskID = findTask(students[j], tasks[i]);
                        if (studentTaskID != -1) {
                            try {
                                process.RunCode(students[j].getDirectoryID(studentTaskID), "test.txt");
                                grade(students[j], weights[i]);
                            } catch (FileNotFoundException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return;
    }

    private static void grade(Student student, double taskWeight) {
        double thisGrade = 0;

        boolean correct = grade_aux();

        if (correct == true) {
            thisGrade = student.getGrade() + taskWeight;
            student.setGrade(thisGrade);
        }

        return;
    }

    private static boolean grade_aux() {
        try {
            BufferedReader studentReader = new BufferedReader(new FileReader("test.txt"));
            BufferedReader teacherReader = new BufferedReader(new FileReader("correct_test.txt"));
            String studentLine, teacherLine;
            while ((studentLine = studentReader.readLine()) != null
                    && (teacherLine = teacherReader.readLine()) != null) {
                if (!studentLine.equals(teacherLine)) {
                    studentReader.close();
                    teacherReader.close();
                    return false;
                }
            }
            studentReader.close();
            teacherReader.close();
            return true;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    private static int findTask(Student student, String task) {
        int taskID = -1;

        int count = 0;

        while (student.getTaskID(count) != 0 && taskID == -1) {
            if (student.getDirectoryID(student.getTaskID(count)).endsWith(task)) {
                taskID = student.getTaskID(count);

            }
            count++;
        }

        return taskID;
    }

    public static void createCsv(Student[] students, String assignmentName, int numStudents) {
        FileOutputStream f;
        try {
            f = new FileOutputStream("grades.csv");
            System.setOut(new PrintStream(f));
            System.out.println("OrgDefinedId," + assignmentName + " Points Grade" + ",End-of-Line Indicator");
            for (int i = 0; i < numStudents; i++) {
                System.out.println(students[i].toString());
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return;
    }
}